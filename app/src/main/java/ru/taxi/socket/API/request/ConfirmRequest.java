package ru.taxi.socket.API.request;

/**
 * Created by kislitsin on 03.03.2017.
 */

public class ConfirmRequest {
    private String phone;
    private String token;
    private String code;

    public ConfirmRequest(String phone, String token, String code) {
        this.phone = phone;
        this.token = token;
        this.code = code;
    }
}
