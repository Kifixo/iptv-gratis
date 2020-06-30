package com.company;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class TempMail {
    public static final String URL_OBTENERDOMINIOS = "https://privatix-temp-mail-v1.p.rapidapi.com/request/domains/";

    public static Response contactarApi(String urlPeticion) throws JSONException {
        System.out.println("Contactando con la API de TempMail...");

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(urlPeticion)
                .get()
                .addHeader("x-rapidapi-host", "privatix-temp-mail-v1.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "91c7ef88d2msh66c9f70bac60183p15e2dfjsnfc61e7b1adb9")
                .build();

        try {
             Response response = client.newCall(request).execute();

             return response;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
