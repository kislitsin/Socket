package ru.taxi.socket.API.request;

/**
 * Created by kislitsin on 03.03.2017.
 */

public class PrivateRequest {
    private String session_id;

    public PrivateRequest(String sessionId) {
        this.session_id = sessionId;
    }
}
