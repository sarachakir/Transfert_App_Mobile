package com.example.ensa_transfert.Adapters;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ensa_transfert.R;

public class ListBenefHolder extends RecyclerView.ViewHolder{
    TextView name, number;
    public ListBenefHolder(@NonNull View itemView){
        super(itemView);
        name = itemView.findViewById(R.id.NameB);
        number = itemView.findViewById(R.id.number);
    }
}