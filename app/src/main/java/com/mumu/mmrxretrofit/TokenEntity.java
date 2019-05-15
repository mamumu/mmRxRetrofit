package com.mumu.mmrxretrofit;

import java.io.Serializable;

public class TokenEntity implements Serializable {

    /**
     * access_token : 4f6c838f-7f41-46f7-8adb-a286e33f4d4a
     * token_type : bearer
     * refresh_token : 36d802d2-df99-4b06-81a2-93945ae0fd65
     * expires_in : 2573106
     * scope : app
     */

    private String access_token;
    private String token_type;
    private String refresh_token;
    private int expires_in;
    private String scope;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
