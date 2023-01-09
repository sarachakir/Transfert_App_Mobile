package com.example.ensa_transfert;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.MenuItem;

import com.example.ensa_transfert.Adapters.ListTransactionAdapter;
import com.example.ensa_transfert.Models.Client;
import com.example.ensa_transfert.Models.Enumerators.IdentityPaperType;
import com.example.ensa_transfert.Models.Transfert;
import com.example.ensa_transfert.Retrofit.BeneficiaryAPI;
import com.example.ensa_transfert.Retrofit.ClientAPI;
import com.example.ensa_transfert.Retrofit.RetrofitService;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HistoriqueActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Transfert> items;

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
    List<Transfert> results;

    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.historique);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        items = getIntent().getParcelableArrayListExtra("list-transfert");
        System.out.println(items);

        recyclerView = findViewById(R.id.recyclerViewTransactions);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ListTransactionAdapter(getApplicationContext(), items));

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

        clientAPI.geTransfersDoneByClient(client.getPhoneNumber())
                .enqueue(new Callback<List<Transfert>>() {
                    @Override
                    public void onResponse(Call<List<Transfert>> call, Response<List<Transfert>> response) {
                        results = response.body();
                        Intent intent=new Intent(getApplicationContext() , HistoriqueActivity.class);
                        intent.putParcelableArrayListExtra("list-transfert", (ArrayList<? extends Parcelable>) results);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<List<Transfert>> call, Throwable t) {

                    }
                });
    }
}
