package com.example.ensa_transfert;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ensa_transfert.Keycloak.AccessToken;
import com.example.ensa_transfert.Keycloak.GetDataService;
import com.example.ensa_transfert.Keycloak.RetrofitClientInstance;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

   private  Button button ;
    EditText etpassword;
    EditText etusername;
    BottomNavigationView bottomNavigationView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etpassword=findViewById(R.id.user_login_registrationNo2);
        etusername=findViewById(R.id.user_login_registrationNo);
        button=findViewById(R.id.customer_login);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //getAccessToken();
                //??????
                openHomeActivity();
            }
        });
/*
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        openHomeActivity() ;
                        return true;
                    case R.id.navigation_transfer:
                        return true;
                    case R.id.navigation_history:
                        return true;

                }
                return false;
            }
        });
*/
    }

    public void openHomeActivity(){
        Intent intent=new Intent(this , HomeActivity.class);
        startActivity(intent);
    }
    public void openTransactionActivity(){
        Intent intent=new Intent(this , TransactionActivity.class);
        startActivity(intent);
    }
    public void openHistoryActivity(){
        Intent intent=new Intent(this , HistoriqueActivity.class);
        startActivity(intent);
    }

    //Keycloak
    public void getAccessToken(){
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        String password=etpassword.getText().toString();
        String username=etusername.getText().toString();

        Call<AccessToken> call=service.getAccessToken("login","password","sdsddsdsddsdds","openid",username,password);
        call.enqueue(new Callback<AccessToken>() {
            @Override
            public void onResponse(Call<AccessToken> call, Response<AccessToken> response) {
                if (response.isSuccessful()){
                    //AccessToken accessToken=response.body();
                    Intent intent=new Intent(MainActivity.this,HomeActivity.class);
                    MainActivity.this.startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this,"error",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<AccessToken> call, Throwable t) {
                Toast.makeText(MainActivity.this,"error",Toast.LENGTH_LONG).show();
            }
        });
    }

}