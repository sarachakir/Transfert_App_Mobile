package com.example.ensa_transfert;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
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
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EnterOTPActivity extends AppCompatActivity {

    private EditText otp;
    private Button verify, validate;
    BottomNavigationView bottomNavigationView;


    MTransfert mTransfert;
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
    ClientAPI clientAPI = retrofitService.getRetrofit().create(ClientAPI.class);
    Client connected_user = getIntent().getParcelableExtra("connected_user");
    Beneficiary choosen_benef = new Beneficiary(
            "fred",
            "Faya",
            "0638743853",
            client
    );
    Transfert transfert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_otp);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {


            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        openHomeActivity() ;
                        return true;
                    case R.id.navigation_transfer:
                        openTransactionActivity();
                        return true;
                    case R.id.navigation_history:
                        openHistoryActivity();
                        return true;

                }
                return false;
            }
        });

        mTransfert = getIntent().getParcelableExtra("mTransfert");
        otp = findViewById(R.id.otp);
        verify = findViewById(R.id.next1);
        validate = findViewById(R.id.validate);
        /*verify.setOnClickListener(view -> {

            String otpEntered=otp.getText().toString();


            String phoneClient = client.getPhoneNumber();

            // .enqueue c'est pour faire le save de facon asynchrone afin de l'appli ne se bloque pas et continue de tourner
           /* clientAPI.verifyOTP(phoneClient,otpEntered)
                    .enqueue(new Callback<Client>() {
                        @Override
                        public void onResponse(Call<Client> call, Response<Client> response) {
                            Toast.makeText(EnterOTPActivity.this, "TCorrect OTP !", Toast.LENGTH_LONG).show();
                            validate.setVisibility(View.VISIBLE);
                        }

                        @Override
                        public void onFailure(Call<Client> call, Throwable t) {
                            Toast.makeText(EnterOTPActivity.this, "TCorrect OTP !", Toast.LENGTH_LONG).show();

                            Toast.makeText(E.this, "The save has failed !", Toast.LENGTH_LONG).show();
                           // Logger.getLogger(AddBenefActivity.class.getName()).log(Level.SEVERE, "An error has occured !", t);
                        }
                    });

        });$*/

    }


    public void openHomeActivity(){
        Intent intent=new Intent(this , HomeActivity.class);
        intent.putExtra("username",connected_user.getUserName());
        startActivity(intent);
    }
    public void openTransactionActivity(){
        Intent intent=new Intent(this , TransactionActivity.class);
        intent.putExtra("username", connected_user.getUserName());
        startActivity(intent);
    }
    public void openHistoryActivity(){
        Intent intent=new Intent(this , HistoriqueActivity.class);
        intent.putExtra("username", connected_user.getUserName());
        startActivity(intent);
    }
}