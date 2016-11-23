//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.qq.connect.javabeans;

import com.qq.connect.QQConnectException;
import com.qq.connect.QQConnectResponse;
import com.qq.connect.utils.http.Response;
import com.qq.connect.utils.json.JSONException;
import com.qq.connect.utils.json.JSONObject;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccessToken extends QQConnectResponse implements Serializable {
    private static final long serialVersionUID = -5499186506535919974L;
    private String accessToken = "";
    private String expireIn = "";
    private String refreshToken = "";
    private String openid;

    public AccessToken() {
    }

    public AccessToken(Response res) throws QQConnectException {
        super(res);
        JSONObject json = null;
        String result = "";

        try {
            json = res.asJSONObject();

            try {
                this.accessToken = json.getString("access_token");
                this.expireIn = json.getString("expires_in");
                this.refreshToken = json.getString("refresh_token");
                this.openid = json.getString("openid");
            } catch (JSONException var7) {
                throw new QQConnectException(var7.getMessage() + ":" + json.toString(), var7);
            }
        } catch (Exception var8) {
            result = res.asString();
            Matcher m = Pattern.compile("^access_token=(\\w+)&expires_in=(\\w+)&refresh_token=(\\w+)$").matcher(result);
            if(m.find()) {
                this.accessToken = m.group(1);
                this.expireIn = m.group(2);
                this.refreshToken = m.group(3);
            } else {
                Matcher m2 = Pattern.compile("^access_token=(\\w+)&expires_in=(\\w+)$").matcher(result);
                if(m2.find()) {
                    this.accessToken = m2.group(1);
                    this.expireIn = m2.group(2);
                }
            }
        }

    }

    AccessToken(String res) throws QQConnectException, JSONException {
        JSONObject json = new JSONObject(res);
        this.accessToken = json.getString("access_token");
        this.expireIn = json.getString("expires_in");
        this.refreshToken = json.getString("refresh_token");
        this.openid = json.getString("openid");
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public long getExpireIn() {
        return Long.valueOf(this.expireIn).longValue();
    }

    public int hashCode() {
        boolean prime = true;
        byte result = 1;
        int result1 = 31 * result + (this.accessToken == null?0:this.accessToken.hashCode());
        result1 = 31 * result1 + (this.expireIn == null?0:this.expireIn.hashCode());
        result1 = 31 * result1 + (this.refreshToken == null?0:this.refreshToken.hashCode());
        return result1;
    }

    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        } else if(obj == null) {
            return false;
        } else if(this.getClass() != obj.getClass()) {
            return false;
        } else {
            AccessToken other = (AccessToken)obj;
            if(this.accessToken == null) {
                if(other.accessToken != null) {
                    return false;
                }
            } else if(!this.accessToken.equals(other.accessToken)) {
                return false;
            }

            if(this.expireIn == null) {
                if(other.expireIn != null) {
                    return false;
                }
            } else if(!this.expireIn.equals(other.expireIn)) {
                return false;
            }

            if(this.refreshToken == null) {
                if(other.refreshToken != null) {
                    return false;
                }
            } else if(!this.refreshToken.equals(other.refreshToken)) {
                return false;
            }

            return true;
        }
    }

    public String toString() {
        return "AccessToken [accessToken=" + this.accessToken + ", expireIn=" + this.expireIn + "]";
    }
}
