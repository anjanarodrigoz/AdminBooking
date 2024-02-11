package com.example.adminbooking.Adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;


import com.example.adminbooking.Models.BookingDetails;
import com.example.adminbooking.R;

import java.util.ArrayList;
import java.util.List;

public class BookingCompleteAdapter extends RecyclerView.Adapter<BookingCompleteAdapter.ViewHolder> {

    private Context mContext;
    List<BookingDetails> mBookingDetails;

    public BookingCompleteAdapter(Context context, List<BookingDetails> bookingDetails){

        this.mContext = context;
        this.mBookingDetails = bookingDetails;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.single_order,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  ViewHolder holder, int position) {

        BookingDetails order = mBookingDetails.get(position);
        holder.id.setText(order.getOrderId());
        holder.truckSize.setText(order.getmTruck());
        holder.userName.setText(order.getUserId());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                itemView(order);
            }
        });
    }



    @Override
    public int getItemCount() {
        return mBookingDetails.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{


        TextView truckSize, userName, id;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            truckSize = itemView.findViewById(R.id.truckSize);
            id = itemView.findViewById(R.id.orderId);
            userName = itemView.findViewById(R.id.userName);

        }
    }



    private void itemView(BookingDetails order) {

        ListView detailsList = new ListView(mContext);
        List<String> details = new ArrayList<>();


        details.add("Name : "+order.getmName());
        details.add("Mobile Number : "+order.getmMobileNumber());
        details.add("E-mail : "+order.getmEmail());
        details.add("F Address : "+order.getmFromAddress());
        details.add("T Address : "+order.getmToAddress());
        details.add("Date : "+order.getmDate());
        details.add("Time : "+order.getmTime()+order.getmTime2());
        details.add("Price : "+order.getmPrice());
        details.add("Deposite : "+order.getmDeposite());
        details.add("Extra Charges : "+order.getmExtra());
        details.add("Removelistner : "+order.getmNum());
        details.add("Packing Material : "+order.getmPack());
        details.add("Move Type : "+order.getmMove());
        details.add("Note : "+order.getmNote());
        details.add("Itemize Special : "+order.getmItem());
        details.add("Card details : "+order.getCard());




        ArrayAdapter<String> adapterDetails = new ArrayAdapter<>(mContext,android.R.layout.simple_list_item_1,details);
        detailsList.setAdapter(adapterDetails);

        final AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setCancelable(true);
        builder.setView(detailsList);
        builder.setTitle("Customer Details");



        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

               builder.setCancelable(true);

            }
        });

        builder.show();
    }
}

