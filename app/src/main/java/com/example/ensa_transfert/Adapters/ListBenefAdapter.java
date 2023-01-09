package com.example.ensa_transfert.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ensa_transfert.Models.ActivitiesModels.BenefItem;
import com.example.ensa_transfert.Models.Beneficiary;
import com.example.ensa_transfert.R;

import java.util.List;

public class ListBenefAdapter extends RecyclerView.Adapter<ListBenefHolder>{

    Context context;
    List<Beneficiary> items;

    public ListBenefAdapter(Context context, List<Beneficiary> items){
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ListBenefHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ListBenefHolder(
                LayoutInflater.from(context)
                        .inflate(R.layout.list_item_benef, parent,false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ListBenefHolder holder, int position) {
        holder.name.setText(items.get(position).getFirstName() + items.get(position).getLastName());
        holder.number.setText(items.get(position).getPhoneNumber());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
