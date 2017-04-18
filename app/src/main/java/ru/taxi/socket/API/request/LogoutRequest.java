package ru.taxi.socket.API.request;

/**
 * Created by kislitsin on 03.03.2017.
 */

public class LogoutRequest extends PrivateRequest {
    private String device_id;

    public LogoutRequest(String sessionId, String deviceId) {
        super(sessionId);
        this.device_id = deviceId;
    }
}

