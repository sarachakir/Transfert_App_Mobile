package com.example.ensa_transfert;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.ensa_transfert.Models.MTransfert;

public class EnterOTPActivity extends AppCompatActivity {

    private EditText otp;
    private Button verify, validate;

    MTransfert mTransfert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_otp);

        mTransfert = getIntent().getParcelableExtra("mTransfert");
        otp = findViewById(R.id.otp);
        verify = findViewById(R.id.verifOtp);
        validate = findViewById(R.id.validation);

    }
}