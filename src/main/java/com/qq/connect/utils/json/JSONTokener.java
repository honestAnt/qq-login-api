/*
 * Decompiled with CFR 0_118.
 */
package com.qq.connect.utils.json;

import com.qq.connect.utils.json.JSONArray;
import com.qq.connect.utils.json.JSONException;
import com.qq.connect.utils.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class JSONTokener {
    private int index;
    private Reader reader;
    private char lastChar;
    private boolean useLastChar;

    public JSONTokener(Reader reader) {
        this.reader = reader.markSupported() ? reader : new BufferedReader(reader);
        this.useLastChar = false;
        this.index = 0;
    }

    public JSONTokener(String s) {
        this(new StringReader(s));
    }

    public void back() throws JSONException {
        if (this.useLastChar || this.index <= 0) {
            throw new JSONException("Stepping back two steps is not supported");
        }
        --this.index;
        this.useLastChar = true;
    }

    public static int dehexchar(char c) {
        if (c >= '0' && c <= '9') {
            return c - 48;
        }
        if (c >= 'A' && c <= 'F') {
            return c - 55;
        }
        if (c >= 'a' && c <= 'f') {
            return c - 87;
        }
        return -1;
    }

    public boolean more() throws JSONException {
        char nextChar = this.next();
        if (nextChar == '\u0000') {
            return false;
        }
        this.back();
        return true;
    }

    public char next() throws JSONException {
        int c;
        if (this.useLastChar) {
            this.useLastChar = false;
            if (this.lastChar != '\u0000') {
                ++this.index;
            }
            return this.lastChar;
        }
        try {
            c = this.reader.read();
        }
        catch (IOException exc) {
            throw new JSONException(exc);
        }
        if (c <= 0) {
            this.lastChar = '\u0000';
            return '\u0000';
        }
        ++this.index;
        this.lastChar = (char)c;
        return this.lastChar;
    }

    public char next(char c) throws JSONException {
        char n = this.next();
        if (n != c) {
            throw this.syntaxError("Expected '" + c + "' and instead saw '" + n + "'");
        }
        return n;
    }

    public String next(int n) throws JSONException {
        if (n == 0) {
            return "";
        }
        char[] buffer = new char[n];
        int pos = 0;
        if (this.useLastChar) {
            this.useLastChar = false;
            buffer[0] = this.lastChar;
            pos = 1;
        }
        try {
            int len;
            while (pos < n && (len = this.reader.read(buffer, pos, n - pos)) != -1) {
                pos += len;
            }
        }
        catch (IOException exc) {
            throw new JSONException(exc);
        }
        this.index += pos;
        if (pos < n) {
            throw this.syntaxError("Substring bounds error");
        }
        this.lastChar = buffer[n - 1];
        return new String(buffer);
    }

    public char nextClean() throws JSONException {
        char c;
        while ((c = this.next()) != '\u0000' && c <= ' ') {
        }
        return c;
    }

    public String nextString(char quote) throws JSONException {
        StringBuffer sb = new StringBuffer();
        block13 : do {
            char c = this.next();
            switch (c) {
                case '\u0000': 
                case '\n': 
                case '\r': {
                    throw this.syntaxError("Unterminated string");
                }
                case '\\': {
                    c = this.next();
                    switch (c) {
                        case 'b': {
                            sb.append('\b');
                            continue block13;
                        }
                        case 't': {
                            sb.append('\t');
                            continue block13;
                        }
                        case 'n': {
                            sb.append('\n');
                            continue block13;
                        }
                        case 'f': {
                            sb.append('\f');
                            continue block13;
                        }
                        case 'r': {
                            sb.append('\r');
                            continue block13;
                        }
                        case 'u': {
                            sb.append((char)Integer.parseInt(this.next(4), 16));
                            continue block13;
                        }
                        case 'x': {
                            sb.append((char)Integer.parseInt(this.next(2), 16));
                            continue block13;
                        }
                    }
                    sb.append(c);
                    continue block13;
                }
            }
            if (c == quote) {
                return sb.toString();
            }
            sb.append(c);
        } while (true);
    }

    public String nextTo(char d) throws JSONException {
        StringBuffer sb = new StringBuffer();
        do {
            char c;
            if ((c = this.next()) == d || c == '\u0000' || c == '\n' || c == '\r') {
                if (c != '\u0000') {
                    this.back();
                }
                return sb.toString().trim();
            }
            sb.append(c);
        } while (true);
    }

    public String nextTo(String delimiters) throws JSONException {
        StringBuffer sb = new StringBuffer();
        do {
            char c;
            if (delimiters.indexOf(c = this.next()) >= 0 || c == '\u0000' || c == '\n' || c == '\r') {
                if (c != '\u0000') {
                    this.back();
                }
                return sb.toString().trim();
            }
            sb.append(c);
        } while (true);
    }

    public Object nextValue() throws JSONException {
        char c = this.nextClean();
        switch (c) {
            case '\"': 
            case '\'': {
                return this.nextString(c);
            }
            case '{': {
                this.back();
                return new JSONObject(this);
            }
            case '(': 
            case '[': {
                this.back();
                return new JSONArray(this);
            }
        }
        StringBuffer sb = new StringBuffer();
        while (c >= ' ' && ",:]}/\\\"[{;=#".indexOf(c) < 0) {
            sb.append(c);
            c = this.next();
        }
        this.back();
        String s = sb.toString().trim();
        if (s.equals("")) {
            throw this.syntaxError("Missing value");
        }
        return JSONObject.stringToValue(s);
    }

    public char skipTo(char to) throws JSONException {
        char c;
        try {
            int startIndex = this.index;
            this.reader.mark(Integer.MAX_VALUE);
            do {
                if ((c = this.next()) != '\u0000') continue;
                this.reader.reset();
                this.index = startIndex;
                return c;
            } while (c != to);
        }
        catch (IOException exc) {
            throw new JSONException(exc);
        }
        this.back();
        return c;
    }

    public JSONException syntaxError(String message) {
        return new JSONException(message + this.toString());
    }

    public String toString() {
        return " at character " + this.index;
    }
}

