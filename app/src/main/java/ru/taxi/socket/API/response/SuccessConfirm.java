
package ru.taxi.socket.API.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SuccessConfirm {

    @SerializedName("session_id")
    @Expose
    private String sessionId;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("user_info")
    @Expose
    private UserInfo userInfo;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

}
