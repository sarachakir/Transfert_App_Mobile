package com.example.ensa_transfert.Retrofit;

import com.example.ensa_transfert.Models.Beneficiary;
import com.example.ensa_transfert.Models.Client;
import com.example.ensa_transfert.Models.MTransfert;
import com.example.ensa_transfert.Models.Transfert;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ClientAPI {

    @GET("/api/v0/client_transfer_service_api/client/transfers/all/{phone}")
    Call<List<Transfert>> geTransfersDoneByClient(@Path("phone") String phone);

    @POST("/api/v0/client_transfer_service_api/client/transfer")
    Call<Resource> createMultitransfer(@Body MTransfert mTransfert);

    @GET("/api/v0/client_service_api/clients/{username}")
    Call<Client> getClientByUsername(@Path("username") String username);


    @GET("/api/v0/client_transfer_service_api/client/transfer/{cin}/{amountOfTransfer}")
    Call<String> verifyClientBalance(@Path("cin") String cin, @Path("amountOfTransfer") Double amountOfTransfer);

    @POST("/api/v0/client_transfer_service_api/client/verifyOTP")
    Call<String> verifyOTP(@Query("phone") String phone,
                           @Query("otp") String otp);









}
