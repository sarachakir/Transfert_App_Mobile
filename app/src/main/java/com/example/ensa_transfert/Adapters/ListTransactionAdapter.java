package com.example.ensa_transfert.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ensa_transfert.Models.Transfert;
import com.example.ensa_transfert.R;

import java.util.List;

public class ListTransactionAdapter extends RecyclerView.Adapter<ListTransactionHolder>{

    Context context;
    List<Transfert> items;

    public ListTransactionAdapter(Context context, List<Transfert> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ListTransactionHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ListTransactionHolder(
                LayoutInflater.from(context)
                        .inflate(R.layout.list_item_transaction, parent,false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ListTransactionHolder holder, int position) {
        holder.date.setText(items.get(position).getReceivedAt().toString());
        holder.fullname.setText(items.get(position).getReceiverFirstName() + items.get(position).getReceiverLastName());
        holder.amount.setText((int) items.get(position).getFinalAmountTransfer());
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
