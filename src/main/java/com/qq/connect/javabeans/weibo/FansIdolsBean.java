/*
 * Decompiled with CFR 0_118.
 */
package com.qq.connect.javabeans.weibo;

import com.qq.connect.QQConnectException;
import com.qq.connect.QQConnectResponse;
import com.qq.connect.javabeans.Avatar;
import com.qq.connect.javabeans.weibo.SimpleTweetInfo;
import com.qq.connect.javabeans.weibo.SingleFanIdolBean;
import com.qq.connect.javabeans.weibo.Tag;
import com.qq.connect.utils.json.JSONArray;
import com.qq.connect.utils.json.JSONException;
import com.qq.connect.utils.json.JSONObject;
import java.io.Serializable;
import java.util.ArrayList;

public class FansIdolsBean
extends QQConnectResponse
implements Serializable {
    private static final long serialVersionUID = 4742904673643859727L;
    private int ret = 0;
    private int errcode = 0;
    private String msg = "";
    private int curNum = 0;
    private boolean next = false;
    private long timestamp = 0;
    private int nextStartPos = 0;
    private ArrayList<SingleFanIdolBean> fanIdols = new ArrayList();

    public ArrayList<SingleFanIdolBean> getFanIdols() {
        return this.fanIdols;
    }

    public int getNextStartPos() {
        return this.nextStartPos;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public boolean hasNext() {
        return this.next;
    }

    public int getCurNum() {
        return this.curNum;
    }

    public FansIdolsBean(JSONObject json) throws QQConnectException {
        this.init(json);
    }

    public int getRet() {
        return this.ret;
    }

    public int getErrcode() {
        return this.errcode;
    }

    public String getMsg() {
        return this.msg;
    }

    private void init(JSONObject json) throws QQConnectException {
        if (json != null) {
            try {
                this.ret = json.getInt("ret");
                if (0 != this.ret) {
                    this.msg = json.getString("msg");
                    this.errcode = json.getInt("errcode");
                } else {
                    this.msg = json.getString("msg");
                    this.errcode = 0;
                    String dataString = json.getString("data");
                    if (dataString != null && !dataString.equals("") && !dataString.equals("null")) {
                        JSONObject jo = json.getJSONObject("data");
                        this.curNum = jo.getInt("curnum");
                        this.next = jo.getInt("hasnext") == 0;
                        this.timestamp = jo.getLong("timestamp");
                        this.nextStartPos = jo.getInt("nextstartpos");
                        String infoString = jo.getString("info");
                        if (infoString != null && !infoString.equals("") && !infoString.equals("null")) {
                            JSONArray infoArray = jo.getJSONArray("info");
                            int j = infoArray.length();
                            for (int i = 0; i < j; ++i) {
                                JSONObject singleInfo = infoArray.getJSONObject(i);
                                String tagsString = singleInfo.getString("tag");
                                ArrayList<Tag> tags = new ArrayList<Tag>();
                                if (tagsString != null && !tagsString.equals("") && !tagsString.equals("null")) {
                                    JSONArray tagsJA = singleInfo.getJSONArray("tag");
                                    int p = tagsJA.length();
                                    for (int k = 0; k < p; ++k) {
                                        JSONObject tagJO = tagsJA.getJSONObject(k);
                                        tags.add(new Tag(tagJO.getString("id"), tagJO.getString("name")));
                                    }
                                }
                                JSONObject tweetInfo = null;
                                String tweetInfoString = singleInfo.getString("tweet");
                                if (tweetInfoString != null && !tweetInfoString.equals("") && !tweetInfoString.equals("null")) {
                                    JSONArray tweetInfos = singleInfo.getJSONArray("tweet");
                                    tweetInfo = tweetInfos.getJSONObject(0);
                                }
                                this.fanIdols.add(new SingleFanIdolBean(singleInfo.getString("city_code"), singleInfo.getString("province_code"), singleInfo.getString("country_code"), singleInfo.getString("location"), singleInfo.getInt("fansnum"), new Avatar(singleInfo.getString("head")), singleInfo.getInt("idolnum"), singleInfo.getBoolean("isfans"), singleInfo.getBoolean("isidol"), singleInfo.getInt("isrealname") == 1, singleInfo.getInt("vip") == 1, singleInfo.getString("name"), singleInfo.getString("nick"), singleInfo.getString("openid"), singleInfo.getInt("sex") == 1 ? "\u7537" : "\u5973", tags, new SimpleTweetInfo(tweetInfo.getString("from"), tweetInfo.getString("id"), tweetInfo.getString("text"), tweetInfo.getLong("timestamp"))));
                            }
                        }
                        jo = null;
                    }
                }
            }
            catch (JSONException jsone) {
                throw new QQConnectException(jsone.getMessage() + ":" + json.toString(), jsone);
            }
        }
    }
}

