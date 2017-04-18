
package ru.taxi.socket.API.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ConfirmResponse {

    @SerializedName("success")
    @Expose
    private SuccessConfirm success;

    public SuccessConfirm getSuccess() {
        return success;
    }

    public void setSuccessConfirm(SuccessConfirm success) {
        this.success = success;
    }

}
