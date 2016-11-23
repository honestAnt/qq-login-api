/*
 * Decompiled with CFR 0_118.
 */
package com.qq.connect.javabeans.tenpay;

import com.qq.connect.QQConnectException;
import com.qq.connect.javabeans.tenpay.Address;
import com.qq.connect.utils.json.JSONException;
import com.qq.connect.utils.json.JSONObject;
import java.io.Serializable;
import java.util.ArrayList;

public class TenpayAddressBean
implements Serializable {
    private static final long serialVersionUID = 4742904673643859727L;
    private int ret = 0;
    private String msg = "";
    private int retNum = 0;
    private ArrayList<Address> addresses = new ArrayList();

    public int getRet() {
        return this.ret;
    }

    public String getMsg() {
        return this.msg;
    }

    public TenpayAddressBean(JSONObject json) throws QQConnectException {
        this.init(json);
    }

    public int getRetNum() {
        return this.retNum;
    }

    public ArrayList<Address> getAddresses() {
        return this.addresses;
    }

    private void init(JSONObject json) throws QQConnectException {
        if (json != null) {
            try {
                this.ret = json.getInt("ret");
                if (0 != this.ret) {
                    this.msg = json.getString("msg");
                } else {
                    this.retNum = json.getInt("ret_num");
                    if (this.retNum != 0) {
                        for (int i = 0; i < this.retNum; ++i) {
                            this.addresses.add(new Address(json.getString("FRegionId_" + i), json.getInt("FUsedCount_" + i), json.getString("Fname_" + i), json.getString("Ftel_" + i), json.getString("Fzipcode_" + i), json.getString("Fmobile_" + i), json.getString("Faddrstreet_" + i), json.getString("Flastuse_time_" + i), json.getString("Fmod_time_" + i), json.getString("Fcreate_time_" + i), json.getString("Findex_" + i)));
                        }
                    }
                }
            }
            catch (JSONException jsone) {
                throw new QQConnectException(jsone.getMessage() + ":" + json.toString(), jsone);
            }
        }
    }
}

