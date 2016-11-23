/*
 * Decompiled with CFR 0_118.
 */
package com.qq.connect.javabeans.weibo;

import com.qq.connect.QQConnectException;
import com.qq.connect.javabeans.Avatar;
import com.qq.connect.javabeans.weibo.Music;
import com.qq.connect.javabeans.weibo.SingleRepostInfo;
import com.qq.connect.javabeans.weibo.TweetSourceBean;
import com.qq.connect.javabeans.weibo.Video;
import com.qq.connect.utils.json.JSONArray;
import com.qq.connect.utils.json.JSONException;
import com.qq.connect.utils.json.JSONObject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RepostInfoBean
implements Serializable {
    private static final long serialVersionUID = 8844167881360046175L;
    private int ret = 0;
    private int errcode = 0;
    private String msg = "";
    private long timeStamp = 0;
    private ArrayList<SingleRepostInfo> sris = new ArrayList();
    private HashMap<String, String> users = new HashMap();
    private boolean next = false;

    public int getErrcode() {
        return this.errcode;
    }

    public String getMsg() {
        return this.msg;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public ArrayList<SingleRepostInfo> getRepostInfo() {
        return this.sris;
    }

    public HashMap<String, String> getUsers() {
        return this.users;
    }

    public boolean hasNext() {
        return this.next;
    }

    public RepostInfoBean() {
    }

    public RepostInfoBean(JSONObject json) throws QQConnectException {
        this.init(json);
    }

    public int getRet() {
        return this.ret;
    }

    private void init(JSONObject json) throws QQConnectException {
        block33 : {
            if (json != null) {
                try {
                    int i;
                    int j;
                    this.ret = json.getInt("ret");
                    if (0 != this.ret) {
                        this.msg = json.getString("msg");
                        this.errcode = json.getInt("errcode");
                        break block33;
                    }
                    this.msg = json.getString("msg");
                    this.errcode = 0;
                    String dataString = json.getString("data");
                    JSONObject jo = null;
                    if (dataString == null || dataString.equals("") || dataString.equals("null")) break block33;
                    jo = json.getJSONObject("data");
                    this.next = jo.getInt("hasnext") == 0;
                    this.timeStamp = jo.getLong("timestamp");
                    String userString = jo.getString("user");
                    if (userString != null && !userString.equals("") && !userString.equals("null")) {
                        JSONObject userJSONObj = jo.getJSONObject("user");
                        String[] names = JSONObject.getNames(userJSONObj);
                        j = names.length;
                        for (i = 0; i < j; ++i) {
                            this.users.put(names[i], userJSONObj.getString(names[i]));
                        }
                    }
                    String infoString = jo.getString("info");
                    JSONArray infoJSONArray = null;
                    if (infoString == null || infoString.equals("") || infoString.equals("null")) break block33;
                    infoJSONArray = jo.getJSONArray("info");
                    j = infoJSONArray.length();
                    for (i = 0; i < j; ++i) {
                        JSONObject sInfo = infoJSONArray.getJSONObject(i);
                        String imageURL = "";
                        try {
                            String imageString = sInfo.getString("image");
                            if (imageString != null && !imageString.equals("null")) {
                                Matcher m = Pattern.compile("\\[\"(\\S+)\"\\]").matcher(imageString);
                                imageURL = m.find() ? m.group(1) : "";
                            }
                        }
                        catch (Exception e4) {
                            // empty catch block
                        }
                        JSONObject mjo = null;
                        String mjoString = null;
                        String musicAuthorString = "";
                        String musicUrlString = "";
                        String musicTitleString = "";
                        try {
                            mjoString = sInfo.getString("music");
                        }
                        catch (Exception e1) {
                            mjo = sInfo.getJSONObject("music");
                            musicAuthorString = mjo.getString("author");
                            musicUrlString = mjo.getString("url");
                            musicTitleString = mjo.getString("title");
                        }
                        if (mjoString == null || mjoString.equals("null")) {
                            musicAuthorString = "";
                            musicUrlString = "";
                            musicTitleString = "";
                        } else {
                            try {
                                mjo = sInfo.getJSONObject("music");
                                musicAuthorString = mjo.getString("author");
                                musicUrlString = mjo.getString("url");
                                musicTitleString = mjo.getString("title");
                            }
                            catch (Exception e2) {
                                // empty catch block
                            }
                        }
                        String videoString = null;
                        JSONObject vjo = null;
                        String picurl = "";
                        String player = "";
                        String realurl = "";
                        String shorturl = "";
                        String title = "";
                        try {
                            videoString = sInfo.getString("video");
                        }
                        catch (Exception e3) {
                            vjo = sInfo.getJSONObject("video");
                            picurl = vjo.getString("picurl");
                            player = vjo.getString("player");
                            realurl = vjo.getString("realurl");
                            shorturl = vjo.getString("shorturl");
                            title = vjo.getString("title");
                        }
                        if (null != videoString && !videoString.equals("null")) {
                            vjo = sInfo.getJSONObject("video");
                            picurl = vjo.getString("picurl");
                            player = vjo.getString("player");
                            realurl = vjo.getString("realurl");
                            shorturl = vjo.getString("shorturl");
                            title = vjo.getString("title");
                        }
                        TweetSourceBean tsb = null;
                        String sourceInfoString = sInfo.getString("source");
                        if (sourceInfoString == null || sourceInfoString.equals("") || sourceInfoString.equals("null")) {
                            tsb = new TweetSourceBean();
                        } else {
                            JSONObject joSource = sInfo.getJSONObject("source");
                            String sourceImageURL = "";
                            try {
                                String imageString = joSource.getString("image");
                                if (imageString != null && !imageString.equals("null")) {
                                    Matcher m = Pattern.compile("\\[\"(\\S+)\"\\]").matcher(imageString);
                                    sourceImageURL = m.find() ? m.group(1) : "";
                                }
                            }
                            catch (Exception e4) {
                                // empty catch block
                            }
                            JSONObject sourcemjo = null;
                            String sourcemjoString = null;
                            String sourcemusicAuthorString = "";
                            String sourcemusicUrlString = "";
                            String sourcemusicTitleString = "";
                            try {
                                sourcemjoString = joSource.getString("music");
                            }
                            catch (Exception e1) {
                                sourcemjo = joSource.getJSONObject("music");
                                sourcemusicAuthorString = mjo.getString("author");
                                sourcemusicUrlString = mjo.getString("url");
                                sourcemusicTitleString = mjo.getString("title");
                            }
                            if (sourcemjoString == null || sourcemjoString.equals("null")) {
                                sourcemusicAuthorString = "";
                                sourcemusicUrlString = "";
                                sourcemusicTitleString = "";
                            } else {
                                try {
                                    sourcemjo = joSource.getJSONObject("music");
                                    sourcemusicAuthorString = sourcemjo.getString("author");
                                    sourcemusicUrlString = sourcemjo.getString("url");
                                    sourcemusicTitleString = sourcemjo.getString("title");
                                }
                                catch (Exception e2) {
                                    // empty catch block
                                }
                            }
                            String sourcevideoString = null;
                            JSONObject sourcevjo = null;
                            String sourcepicurl = "";
                            String sourceplayer = "";
                            String sourcerealurl = "";
                            String sourceshorturl = "";
                            String sourcetitle = "";
                            try {
                                sourcevideoString = joSource.getString("video");
                            }
                            catch (Exception e3) {
                                sourcevjo = joSource.getJSONObject("video");
                                sourcepicurl = sourcevjo.getString("picurl");
                                sourceplayer = sourcevjo.getString("player");
                                sourcerealurl = sourcevjo.getString("realurl");
                                sourceshorturl = sourcevjo.getString("shorturl");
                                sourcetitle = sourcevjo.getString("title");
                            }
                            if (null != sourcevideoString && !sourcevideoString.equals("null")) {
                                sourcevjo = joSource.getJSONObject("video");
                                sourcepicurl = sourcevjo.getString("picurl");
                                sourceplayer = sourcevjo.getString("player");
                                sourcerealurl = sourcevjo.getString("realurl");
                                sourceshorturl = sourcevjo.getString("shorturl");
                                sourcetitle = sourcevjo.getString("title");
                            }
                            tsb = new TweetSourceBean(joSource.getString("city_code"), joSource.getInt("count"), joSource.getString("country_code"), joSource.getString("from"), joSource.getString("fromurl"), joSource.getString("geo"), new Avatar(joSource.getString("head")), joSource.getString("id"), sourceImageURL, joSource.getInt("isvip") == 1, joSource.getInt("jing") == 1, joSource.getLong("latitude"), joSource.getString("location"), joSource.getLong("longitude"), joSource.getInt("mcount"), new Music(sourcemusicAuthorString, sourcemusicUrlString, sourcemusicTitleString), joSource.getString("name"), joSource.getString("nick"), joSource.getString("openid"), joSource.getString("origtext"), joSource.getString("province_code"), joSource.getInt("self") == 1, joSource.getInt("status"), joSource.getString("text"), joSource.getLong("timestamp"), joSource.getInt("type"), new Video(sourcepicurl, sourceplayer, sourcerealurl, sourceshorturl, sourcetitle));
                        }
                        this.sris.add(new SingleRepostInfo(sInfo.getString("city_code"), sInfo.getInt("count"), sInfo.getString("country_code"), sInfo.getString("emotiontype"), sInfo.getString("emotionurl"), sInfo.getString("from"), sInfo.getString("fromurl"), sInfo.getString("geo"), new Avatar(sInfo.getString("head")), sInfo.getString("id"), imageURL, sInfo.getInt("isrealname") == 1, sInfo.getInt("isvip") == 1, sInfo.getInt("jing") == 1, sInfo.getLong("latitude"), sInfo.getLong("longitude"), sInfo.getString("location"), sInfo.getInt("mcount"), new Music(musicAuthorString, musicUrlString, musicTitleString), sInfo.getString("name"), sInfo.getString("nick"), sInfo.getString("openid"), sInfo.getString("origtext"), sInfo.getString("province_code"), sInfo.getInt("self") == 1, tsb, sInfo.getInt("status"), sInfo.getString("text"), sInfo.getString("timestamp"), sInfo.getInt("type"), new Video(picurl, player, realurl, shorturl, title)));
                    }
                }
                catch (JSONException jsone) {
                    throw new QQConnectException(jsone.getMessage() + ":" + json.toString(), jsone);
                }
            }
        }
    }

    public String toString() {
        return "RepostInfoBean{ret=" + this.ret + ", errcode=" + this.errcode + ", msg='" + this.msg + '\'' + ", timeStamp=" + this.timeStamp + ", sris=" + this.sris + ", users=" + this.users + ", next=" + this.next + '}';
    }
}

