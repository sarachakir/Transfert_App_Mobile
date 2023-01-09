package com.example.ensa_transfert.Adapters;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ensa_transfert.R;

public class ListTransactionHolder extends RecyclerView.ViewHolder{
    TextView date, fullname, amount;

    public ListTransactionHolder(@NonNull View itemView){
        super(itemView);
        date = itemView.findViewById(R.id.date);
        fullname = itemView.findViewById(R.id.tfullname);
        amount = itemView.findViewById(R.id.lamount);
    }
}
