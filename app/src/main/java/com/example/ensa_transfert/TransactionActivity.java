package com.example.ensa_transfert;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;

import com.example.ensa_transfert.Models.Beneficiary;
import com.example.ensa_transfert.Models.Client;
import com.example.ensa_transfert.Models.Enumerators.IdentityPaperType;
import com.example.ensa_transfert.Retrofit.BeneficiaryAPI;
import com.example.ensa_transfert.Retrofit.RetrofitService;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TransactionActivity extends AppCompatActivity {

    private FloatingActionButton b1;
    private Button b2;
    private Button b3;

    Client client = new Client(
            1L,
            "Male",
            "Frederic",
            "fred001",
            "FAYA",
            "fredericfaya@gmail.com",
            "12345678",
            "2001-06-27",
            "ensa007",
            "0638743853",
            "Morocco",
            "40000",
            "some where",
            "Marrakech",
            80000,
            IdentityPaperType.Driver_License,
            null,
            null
    );

    RetrofitService retrofitService = new RetrofitService();
    BeneficiaryAPI beneficiaryAPI = retrofitService.getRetrofit().create(BeneficiaryAPI.class);
    List<Beneficiary> results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.transaction);
        b1=findViewById(R.id.add_fab);
        b2=findViewById(R.id.next1);
        b3 = findViewById(R.id.title_select_beneficiaire);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOTPActivity();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddBenefActivity();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                openListBenfActivity();
            }
        });
    }
    public void openAddBenefActivity(){
        Intent intent=new Intent(this , AddBenefActivity.class);
        startActivity(intent);
    }

    public void openListBenfActivity(){
        beneficiaryAPI.getAllBenificariesByClient(client.getCinNumber())
                        .enqueue(new Callback<List<Beneficiary>>() {
                            @Override
                            public void onResponse(Call<List<Beneficiary>> call, Response<List<Beneficiary>> response) {
                                results = response.body();
                                Intent intent=new Intent(getApplicationContext() , ListBenefActivity.class);
                                intent.putParcelableArrayListExtra("list", (ArrayList<? extends Parcelable>) results);
                                startActivity(intent);
                            }

                            @Override
                            public void onFailure(Call<List<Beneficiary>> call, Throwable t) {

                            }
                        });
    }

    public void openOTPActivity(){
        Intent intent=new Intent(this , EnterOTPActivity.class);
        startActivity(intent);
    }

}