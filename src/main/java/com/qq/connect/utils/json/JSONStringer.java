/*
 * Decompiled with CFR 0_118.
 */
package com.qq.connect.utils.json;

import com.qq.connect.utils.json.JSONWriter;
import java.io.StringWriter;
import java.io.Writer;

public class JSONStringer
extends JSONWriter {
    public JSONStringer() {
        super(new StringWriter());
    }

    public String toString() {
        return this.mode == 'd' ? this.writer.toString() : null;
    }
}

