
package ru.taxi.socket.API.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserInfo {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("email")
    @Expose
    private Object email;
    @SerializedName("birth")
    @Expose
    private Object birth;
    @SerializedName("rN")
    @Expose
    private String rN;
    @SerializedName("rF")
    @Expose
    private String rF;
    @SerializedName("referer")
    @Expose
    private Object referer;
    @SerializedName("mycode")
    @Expose
    private Object mycode;
    @SerializedName("phone2")
    @Expose
    private Object phone2;
    @SerializedName("perID")
    @Expose
    private Boolean perID;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getEmail() {
        return email;
    }

    public void setEmail(Object email) {
        this.email = email;
    }

    public Object getBirth() {
        return birth;
    }

    public void setBirth(Object birth) {
        this.birth = birth;
    }

    public String getRN() {
        return rN;
    }

    public void setRN(String rN) {
        this.rN = rN;
    }

    public String getRF() {
        return rF;
    }

    public void setRF(String rF) {
        this.rF = rF;
    }

    public Object getReferer() {
        return referer;
    }

    public void setReferer(Object referer) {
        this.referer = referer;
    }

    public Object getMycode() {
        return mycode;
    }

    public void setMycode(Object mycode) {
        this.mycode = mycode;
    }

    public Object getPhone2() {
        return phone2;
    }

    public void setPhone2(Object phone2) {
        this.phone2 = phone2;
    }

    public Boolean getPerID() {
        return perID;
    }

    public void setPerID(Boolean perID) {
        this.perID = perID;
    }

}
