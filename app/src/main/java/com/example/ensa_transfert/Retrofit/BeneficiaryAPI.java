package com.example.ensa_transfert.Retrofit;

import com.example.ensa_transfert.Models.Beneficiary;
import com.example.ensa_transfert.Models.Client;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface BeneficiaryAPI {
    @GET("/api/v0/client_transfer_service_api/client/transfer/allBenif/{cin}")
    Call<List<Beneficiary>> getAllBenificariesByClient(@Path("cin") String cin);

    @POST("/api/v0/client_transfer_service_api/client/transfer/addBenif/{cin}")
    Call<Client> addBenifiToClient(@Body Beneficiary beneficiary, @Path("cin") String cin);
}
