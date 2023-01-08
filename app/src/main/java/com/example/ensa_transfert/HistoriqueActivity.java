package com.example.ensa_transfert;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class HistoriqueActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.historique);
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
    }
