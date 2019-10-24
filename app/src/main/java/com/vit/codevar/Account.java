package com.vit.codevar;

import com.google.gson.annotations.SerializedName;

public class Account {

    @SerializedName("code")
    public String code;

    @SerializedName("message")
    public String message;

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
