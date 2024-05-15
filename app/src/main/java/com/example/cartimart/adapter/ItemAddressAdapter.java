package com.example.cartimart.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cartimart.R;
import com.example.cartimart.ShowAddress;
import com.example.cartimart.model.ItemAddress;

import java.util.List;

public class ItemAddressAdapter extends RecyclerView.Adapter<ItemAddressAdapter.AddressViewHolder> {

    private final List<ItemAddress> itemAddresses; // Use final for immutability
    private final Context context; // Context passed from the activity

    public ItemAddressAdapter(Context context, List<ItemAddress> itemAddresses) {
        this.context = context;
        this.itemAddresses = itemAddresses;
    }

    public static class AddressViewHolder extends RecyclerView.ViewHolder {

        private final TextView addressName;
        private final TextView contact;
        private final TextView block;
        private final TextView location;
        private final Button addressButtonSubmit;

        public AddressViewHolder(@NonNull View itemView) {
            super(itemView);
            addressName = itemView.findViewById(R.id.address_name_setting);
            contact = itemView.findViewById(R.id.Contact_setting);
            block = itemView.findViewById(R.id.block_setting);
            location = itemView.findViewById(R.id.location_setting);
            addressButtonSubmit = itemView.findViewById(R.id.AddressbuttonSubmit);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return -1;
    }

    @Override
    public int getItemCount() {
        return itemAddresses.size();
    }

    @NonNull
    @Override
    public AddressViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int layoutId = R.layout.activity_item_address;
        View view = LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);
        return new AddressViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AddressViewHolder holder, int position) {
        ItemAddress item = itemAddresses.get(position);
        holder.addressName.setText(item.getAddress_name());

        holder.addressButtonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ShowAddress.class);
                intent.putExtra("Address", item.getAddress_name()); // Assuming address_name is what you want to pass
                context.startActivity(intent);
            }
        });
    }
}


// Commented Kim's code
  /*  @Override
    public int getCount() {
        return InfoOfUser.size();
    }

    @Override
    public Object getItem(int position) {
        return InfoOfUser.get(position);
    }
    @Override
    public long getItemId(int position){
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.activity_item_address , parent, false);
        }
        TextView addressName = convertView.findViewById(R.id.address_name_setting);
        TextView contact = convertView.findViewById(R.id.Contact_setting);
        TextView block = convertView.findViewById(R.id.block_setting);
        TextView location = convertView.findViewById(R.id.location_setting);

        ItemAddress itemAddress = InfoOfUser.get(position);
        addressName.setText(itemAddress.getAddress_name());
        contact.setText(itemAddress.getContact_number());
        block.setText(itemAddress.getBlk_address());
        location.setText(itemAddress.getLocation());


        return convertView;*/



