package com.example.adminbooking;

import android.content.Context;
import android.os.Build;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class IdGen {




    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String createId() {

        String date = java.time.Clock.systemUTC().instant().toString();

        String bookingId = date.replaceAll(":","")
        .replaceAll("-","").replace(".","");

        return bookingId;
    }



}



