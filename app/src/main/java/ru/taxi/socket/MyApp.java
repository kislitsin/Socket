package ru.taxi.socket;

import android.app.Application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.taxi.socket.API.TaxiApi;

/**
 * Created by kislitsin on 03.03.2017.
 */

public class MyApp extends Application {
    private static final String API_URL = "http://ip.cbzt.ru/test/api/";
    private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss Z";

    private static TaxiApi taxiApi;
    private Retrofit retrofit;
    private static String myToken;

    @Override
    public void onCreate() {
        super.onCreate();

        retrofit = new Retrofit.Builder()
                .baseUrl(API_URL) //Базовая часть адреса
                .addConverterFactory(GsonConverterFactory.create()) //Конвертер, необходимый для преобразования JSON'а в объекты
                .build();
        taxiApi = retrofit.create(TaxiApi.class); //Создаем объект, при помощи которого будем выполнять запросы
    }

    public static TaxiApi getApi() {
        return taxiApi;
    }

    public  String getMyToken() {
        return myToken;
    }

    public  void setMyToken(String myToken) {
        this.myToken = myToken;
    }
}
