package com.example.adminbooking.UI;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.adminbooking.Adapter.BookingCompleteAdapter;
import com.example.adminbooking.DbHandler;
import com.example.adminbooking.Models.BookingDetails;
import com.example.adminbooking.R;
import com.example.adminbooking.SessionManeger.UserManager;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class OrderComplete extends AppCompatActivity {

    private Context context = this;
    private DbHandler dbHandler;
    private List completeBookings;
    private RecyclerView recyclerView;
    private String orderID;
    EditText search;
    TextView display;
    Query quary;
    String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_complete);

        dbHandler = DbHandler.getInstance(this);
        search = findViewById(R.id.textSearch);
        display = findViewById(R.id.displayComplete);

        recyclerView = findViewById(R.id.lisViewComplete);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        userId = "Admin";


        completeBookings = new ArrayList<>();

        quary = FirebaseDatabase.getInstance().getReference("COMPLETE");

        viewOrders();

        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                List<String> booking_idList = dbHandler.getCompleteOrders(s.toString());
                searchOrders(booking_idList);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



    }

    private void viewOrders() {



        quary.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                completeBookings.clear();
                dbHandler.deleteBooking();

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {

                    BookingDetails booking = dataSnapshot.getValue(BookingDetails.class);
                    if(search.getText().toString().isEmpty()){
                        completeBookings.add(booking);
                    }
                    dbHandler.addBooking(booking.getOrderId(),booking.getOrderId()+ " "+booking.getCard()+" "+booking.getUserId());

                }

                BookingCompleteAdapter adapter = new BookingCompleteAdapter(context, completeBookings);
                recyclerView.setAdapter(adapter);
                display.setText(completeBookings.size() + "");

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    private void searchOrders(List<String> booking_idList) {



        quary.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                completeBookings.clear();


                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {


                    BookingDetails booking = dataSnapshot.getValue(BookingDetails.class);
                    if(booking_idList.contains(booking.getOrderId())){
                        completeBookings.add(booking);
                    }



                }

                BookingCompleteAdapter adapter = new BookingCompleteAdapter(context, completeBookings);
                recyclerView.setAdapter(adapter);
                display.setText(completeBookings.size() + "");

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

}