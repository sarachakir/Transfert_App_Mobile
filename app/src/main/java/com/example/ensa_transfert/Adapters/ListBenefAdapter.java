package com.example.ensa_transfert.Adapters;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
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

    /*
    public class BenifHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        //Dialog dialog = new Dialog(context);
        TextView name, number;


        public BenifHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            name = itemView.findViewById(R.id.NameB);
            number = itemView.findViewById(R.id.number);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            Beneficiary item = items.get(position);
            System.out.println(item);
            //Intent i = new Intent(Intent.ACTION_DIAL);
            //i.setData(Uri.parse("tel:"+item.getPhone()));
            //context.startActivity(i);
        }


    }*/
}
