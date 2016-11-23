/*
 * Decompiled with CFR 0_118.
 * 
 * Could not load the following classes:
 *  javax.servlet.ServletRequest
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpSession
 */
package com.qq.connect.oauth;

import com.qq.connect.QQConnect;
import com.qq.connect.QQConnectException;
import com.qq.connect.javabeans.AccessToken;
import com.qq.connect.utils.QQConnectConfig;
import com.qq.connect.utils.RandomStatusGenerator;
import com.qq.connect.utils.http.HttpClient;
import com.qq.connect.utils.http.PostParameter;
import com.qq.connect.utils.http.Response;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Oauth
extends QQConnect {
    private static final long serialVersionUID = -7860508274941797293L;

    private String[] extractionAuthCodeFromUrl(String url) throws QQConnectException {
        if (url == null) {
            throw new QQConnectException("you pass a null String object");
        }
        Matcher m = Pattern.compile("code=(\\w+)&state=(\\w+)&?").matcher(url);
        String authCode = "";
        String state = "";
        if (m.find()) {
            authCode = m.group(1);
            state = m.group(2);
        }
        return new String[]{authCode, state};
    }

    public AccessToken getAccessTokenByRequest(ServletRequest request) throws QQConnectException {
        String queryString = ((HttpServletRequest)request).getQueryString();
        if (queryString == null) {
            return new AccessToken();
        }
        String state = (String)((HttpServletRequest)request).getSession().getAttribute("qq_connect_state");
        if (state == null || state.equals("")) {
            return new AccessToken();
        }
        String[] authCodeAndState = this.extractionAuthCodeFromUrl(queryString);
        String returnState = authCodeAndState[1];
        String returnAuthCode = authCodeAndState[0];
        AccessToken accessTokenObj = null;
        accessTokenObj = returnState.equals("") || returnAuthCode.equals("") ? new AccessToken() : (!state.equals(returnState) ? new AccessToken() : new AccessToken(this.client.post(QQConnectConfig.getValue("accessTokenURL"), new PostParameter[]{new PostParameter("client_id", QQConnectConfig.getValue("app_ID")), new PostParameter("client_secret", QQConnectConfig.getValue("app_KEY")), new PostParameter("grant_type", "authorization_code"), new PostParameter("code", returnAuthCode), new PostParameter("redirect_uri", QQConnectConfig.getValue("redirect_URI"))}, false)));
        return accessTokenObj;
    }

    public AccessToken getAccessTokenByQueryString(String queryString, String state) throws QQConnectException {
        if (queryString == null) {
            return new AccessToken();
        }
        String[] authCodeAndState = this.extractionAuthCodeFromUrl(queryString);
        String returnState = authCodeAndState[1];
        String returnAuthCode = authCodeAndState[0];
        AccessToken accessTokenObj = null;
        accessTokenObj = returnState.equals("") || returnAuthCode.equals("") ? new AccessToken() : (!state.equals(returnState) ? new AccessToken() : new AccessToken(this.client.post(QQConnectConfig.getValue("accessTokenURL"), new PostParameter[]{new PostParameter("client_id", QQConnectConfig.getValue("app_ID")), new PostParameter("client_secret", QQConnectConfig.getValue("app_KEY")), new PostParameter("grant_type", "authorization_code"), new PostParameter("code", returnAuthCode), new PostParameter("redirect_uri", QQConnectConfig.getValue("redirect_URI"))}, false)));
        return accessTokenObj;
    }

    public String getAuthorizeURL(String scope, String state) throws QQConnectException {
        return QQConnectConfig.getValue("authorizeURL").trim() + "?client_id=" + QQConnectConfig.getValue("app_ID").trim() + "&redirect_uri=" + QQConnectConfig.getValue("redirect_URI").trim() + "&response_type=" + "code" + "&state=" + state + "&scope=" + scope;
    }

    public String getAuthorizeURL(String state) throws QQConnectException {
        String scope = QQConnectConfig.getValue("scope");
        if (scope != null && !scope.equals("")) {
            return this.getAuthorizeURL("code", state, scope);
        }
        return QQConnectConfig.getValue("authorizeURL").trim() + "?client_id=" + QQConnectConfig.getValue("app_ID").trim() + "&redirect_uri=" + QQConnectConfig.getValue("redirect_URI").trim() + "&response_type=" + "code" + "&state=" + state;
    }

    public String getAuthorizeURLByScope(String scope, ServletRequest request) throws QQConnectException {
        String state = RandomStatusGenerator.getUniqueState();
        ((HttpServletRequest)request).setAttribute("qq_connect_state", (Object)state);
        return QQConnectConfig.getValue("authorizeURL").trim() + "?client_id=" + QQConnectConfig.getValue("app_ID").trim() + "&redirect_uri=" + QQConnectConfig.getValue("redirect_URI").trim() + "&response_type=" + "code" + "&state=" + state + "&scope=" + scope;
    }

    public String getAuthorizeURL(ServletRequest request) throws QQConnectException {
        String state = RandomStatusGenerator.getUniqueState();
        ((HttpServletRequest)request).getSession().setAttribute("qq_connect_state", (Object)state);
        String scope = QQConnectConfig.getValue("scope");
        if (scope != null && !scope.equals("")) {
            return this.getAuthorizeURL("code", state, scope);
        }
        return QQConnectConfig.getValue("authorizeURL").trim() + "?client_id=" + QQConnectConfig.getValue("app_ID").trim() + "&redirect_uri=" + QQConnectConfig.getValue("redirect_URI").trim() + "&response_type=" + "code" + "&state=" + state;
    }

    public String getAuthorizeURL(String response_type, String state, String scope) throws QQConnectException {
        return QQConnectConfig.getValue("authorizeURL").trim() + "?client_id=" + QQConnectConfig.getValue("app_ID").trim() + "&redirect_uri=" + QQConnectConfig.getValue("redirect_URI").trim() + "&response_type=" + response_type + "&state=" + state + "&scope=" + scope;
    }
}

