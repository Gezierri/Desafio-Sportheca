package com.project.desafio_sportheca;

import com.project.desafio_sportheca.models.ResponseClient;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {

    @GET("teste.json")
    Call<ResponseClient> getPlayer();
}
