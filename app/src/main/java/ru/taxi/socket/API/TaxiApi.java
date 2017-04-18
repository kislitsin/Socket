package ru.taxi.socket.API;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import ru.taxi.socket.API.request.ConfirmRequest;
import ru.taxi.socket.API.request.LogoutRequest;
import ru.taxi.socket.API.request.RegisterRequest;
import ru.taxi.socket.API.response.ConfirmResponse;
import ru.taxi.socket.API.response.RegisterResponse;

/**
 * Created by kislitsin on 03.03.2017.
 */

public interface TaxiApi {
    // Method paths
    String REGISTER = "register";
    String CONFIRM = "confirm";
    String LOGOUT = "/logout";

    @POST(REGISTER)
    Call<RegisterResponse> register(@Body RegisterRequest registerRequest);

    @POST(CONFIRM)
    Call<ConfirmResponse> confirm(@Body ConfirmRequest confirmRequest);

//    @POST(LOGOUT)
//    Call<BaseResponse> logout(@Body LogoutRequest logoutRequest);
}
