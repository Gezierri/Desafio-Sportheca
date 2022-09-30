package com.project.desafio_sportheca;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Service INSTANCE;

    public static Service getInstance() {
        if (INSTANCE == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://sportsmatch.com.br/teste/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            INSTANCE = retrofit.create(Service.class);
        }
        return INSTANCE;
    }
}
