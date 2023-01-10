package com.example.ensa_transfert;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.ensa_transfert.Models.Beneficiary;
import com.example.ensa_transfert.Models.Client;
import com.example.ensa_transfert.Models.Enumerators.IdentityPaperType;
import com.example.ensa_transfert.Models.MTransfert;
import com.example.ensa_transfert.Models.Transfert;
import com.example.ensa_transfert.Retrofit.BeneficiaryAPI;
import com.example.ensa_transfert.Retrofit.ClientAPI;
import com.example.ensa_transfert.Retrofit.RetrofitService;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TransactionActivity extends AppCompatActivity {

    private FloatingActionButton b1;
    private Button b2;
    private Button b3;
    private EditText amount, motif;
    private CheckBox notif;
    private Spinner spinner;

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
    ClientAPI clientAPI = retrofitService.getRetrofit().create(ClientAPI.class);
    Client connected_user = getIntent().getParcelableExtra("connected_user");
    Beneficiary choosen_benef = new Beneficiary(
            "fred",
            "Faya",
            "0638743853",
            client
    );
    MTransfert mTransfert;
    Transfert transfert;
    List<Beneficiary> results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.transaction);

        b1=findViewById(R.id.add_fab);
        b2=findViewById(R.id.verifOtp);
        b3 = findViewById(R.id.title_select_beneficiaire);
        amount = findViewById(R.id.otp);
        motif = findViewById(R.id.motif);
        notif = findViewById(R.id.checkBox);
        spinner = findViewById(R.id.action_bar_spinnerCost);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            mTransfert.setProspect_client(false); // already have an account so cannot be prospect
            mTransfert.setSenderFirstName(connected_user.getFirstName());
            mTransfert.setSenderLastName(connected_user.getLastName());
            mTransfert.setSenderPhoneNumber(connected_user.getPhoneNumber());
        }


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
        intent.putExtra("connected_user", connected_user);
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

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            mTransfert.setMotif(motif.getText().toString());
            mTransfert.setTotalAmount(Double.parseDouble(amount.getText().toString()));
            mTransfert.setNotifyBeneficiary(notif.isChecked());
            /*
            String selectedSpinner = spinner.getSelectedItem().toString();
            if(selectedSpinner == "Frais à la charge du client d’donneur d’ordre"){
                mTransfert.set

            }*/
        }

        transfert.setReceiverFirstName(choosen_benef.getFirstName());
        transfert.setReceiverLastName(choosen_benef.getLastName());
        transfert.setReceiverPhoneNumber(choosen_benef.getPhoneNumber());
        transfert.setTransferAmount(Double.parseDouble(amount.getText().toString())); // supposing that for
        // the moment we can only do one transfert at once
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            mTransfert.setTransfers((List<Transfert>) transfert);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            clientAPI.verifyClientBalance(connected_user.getCinNumber(), mTransfert.getTotalAmount())
                            .enqueue(new Callback<String>() {
                                @Override
                                public void onResponse(Call<String> call, Response<String> response) {
                                    if(response.equals("true")){
                                        Intent intent=new Intent(getApplicationContext() , EnterOTPActivity.class);
                                        intent.putExtra("mTransfert", mTransfert);
                                        startActivity(intent);
                                    }
                                }

                                @Override
                                public void onFailure(Call<String> call, Throwable t) {
                                    Toast.makeText(TransactionActivity.this, "Not enough money !", Toast.LENGTH_SHORT).show();
                                }
                            });
        }

    }

}