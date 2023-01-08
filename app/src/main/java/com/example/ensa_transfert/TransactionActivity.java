package com.example.ensa_transfert;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class TransactionActivity extends AppCompatActivity {
   private FloatingActionButton b1;
   private Button b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transaction);
        b1=findViewById(R.id.add_fab);
        b2=findViewById(R.id.next1);
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
    }
    public void openAddBenefActivity(){
        Intent intent=new Intent(this , AddBenefActivity.class);
        startActivity(intent);
    }
    public void openOTPActivity(){
        Intent intent=new Intent(this , EnterOTPActivity.class);
        startActivity(intent);
    }
}