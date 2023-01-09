package com.example.ensa_transfert;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ensa_transfert.Models.Beneficiary;
import com.example.ensa_transfert.Models.Client;
import com.example.ensa_transfert.Models.Enumerators.IdentityPaperType;
import com.example.ensa_transfert.Retrofit.BeneficiaryAPI;
import com.example.ensa_transfert.Retrofit.RetrofitService;
import com.google.gson.Gson;

import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddBenefActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_benef);

        initializeComponents();
    }

    private void initializeComponents() {

        RetrofitService retrofitService = new RetrofitService();
        BeneficiaryAPI beneficiaryAPI = retrofitService.getRetrofit().create(BeneficiaryAPI.class);

        // On va pour le moment faire avec un client statique
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

        EditText firstName = findViewById(R.id.fname);
        EditText lastName = findViewById(R.id.lname);
        EditText phoneNumber = findViewById(R.id.tel);
        Button saveButton = findViewById(R.id.saveBenef);

        saveButton.setOnClickListener(view -> {

            String fname = firstName.getText().toString();
            String lname = lastName.getText().toString();
            String phone = phoneNumber.getText().toString();

            Beneficiary beneficiary = new Beneficiary(
                    fname,
                    lname,
                    phone,
                    client
            );

            String cin = client.getCinNumber();

            // .enqueue c'est pour faire le save de facon asynchrone afin de l'appli ne se bloque pas et continue de tourner
            beneficiaryAPI.addBenifiToClient(beneficiary, cin)
                    .enqueue(new Callback<Client>() {
                        @Override
                        public void onResponse(Call<Client> call, Response<Client> response) {
                            Toast.makeText(AddBenefActivity.this, "The beneficiary has been saved !", Toast.LENGTH_LONG);
                        }

                        @Override
                        public void onFailure(Call<Client> call, Throwable t) {
                            Toast.makeText(AddBenefActivity.this, "The save has failed !", Toast.LENGTH_LONG);
                            Logger.getLogger(AddBenefActivity.class.getName()).log(Level.SEVERE, "An error has occured !", t);
                        }
                    });

        });

    }
}