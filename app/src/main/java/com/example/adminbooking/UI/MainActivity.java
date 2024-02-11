package com.example.adminbooking.UI;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;


import com.example.adminbooking.DbHandler;
import com.example.adminbooking.R;
import com.example.adminbooking.SessionManeger.UserManager;
import com.google.android.material.card.MaterialCardView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Date;

import static android.os.Build.VERSION.SDK_INT;


public class MainActivity extends AppCompatActivity {

    MaterialCardView cardBook, cardBookingComplete, cardBookingProccess,userProfile,driverProfile;
    TextView txtAllBooking, txtTodayBooking,employ,driver;
    Context context = this;
    DbHandler dbHandler;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (ContextCompat.checkSelfPermission(context,
                Manifest.permission.READ_EXTERNAL_STORAGE) +
                ContextCompat.checkSelfPermission(context,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) +
                ContextCompat.checkSelfPermission(context,
                        Manifest.permission.SEND_SMS) !=
                PackageManager.PERMISSION_GRANTED)

            if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) context,
                    Manifest.permission.READ_EXTERNAL_STORAGE) ||
                    ActivityCompat.shouldShowRequestPermissionRationale((Activity) context,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE) ||
                    ActivityCompat.shouldShowRequestPermissionRationale((Activity) context,
                            Manifest.permission.SEND_SMS)) {

                AlertDialog.Builder builder = new AlertDialog.Builder(
                        context
                );
                builder.setTitle("Grant those Permission");
                builder.setMessage("Read Strorage");
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ActivityCompat.requestPermissions(
                                (Activity) context,
                                new String[]{
                                        Manifest.permission.READ_EXTERNAL_STORAGE,
                                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                        Manifest.permission.SEND_SMS
                                }, 123
                        );
                    }
                });
                builder.setNegativeButton("Cancel", null);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            } else {
                ActivityCompat.requestPermissions(
                        (Activity) context,
                        new String[]{
                                Manifest.permission.READ_EXTERNAL_STORAGE,
                                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                Manifest.permission.SEND_SMS
                        }, 123
                );

            }

        if (SDK_INT >= Build.VERSION_CODES.R) {

            if (!Environment.isExternalStorageManager()) {

                Intent intent = new Intent();
                intent.setAction(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
                Uri uri = Uri.fromParts("package", this.getPackageName(), null);
                intent.setData(uri);
                startActivity(intent);
            }
        }


        dbHandler = DbHandler.getInstance(context);
        cardBook = findViewById(R.id.btnBookOne);
        cardBookingComplete = findViewById(R.id.btnOrders);
        txtAllBooking = findViewById(R.id.txtAllBooking);
        txtTodayBooking = findViewById(R.id.txtTodayBooking);
        cardBookingProccess = findViewById(R.id.btnOrderComplete);
        userProfile = findViewById(R.id.userProfile);
        driverProfile = findViewById(R.id.driverProfile);
        employ = findViewById(R.id.employe);
        driver = findViewById(R.id.driver);

        SimpleDateFormat currentDate = new SimpleDateFormat("d/M/yyyy");
        Date todayDate = new Date();
        String thisDate = currentDate.format(todayDate);

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();


        ref.child("BOOKING").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.exists()) {

                    txtAllBooking.setText("Total Booking : " + snapshot.getChildrenCount());


                } else {
                    txtAllBooking.setText("Total Booking : 0");
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        ref.child("BOOKING").orderByChild("mDate").equalTo(thisDate).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.exists()) {
                    txtTodayBooking.setText("Today Booking : " + snapshot.getChildrenCount());
                    System.out.println(thisDate);
                } else {
                    txtTodayBooking.setText("Today Booking : 0");
                    System.out.println(thisDate);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        ref.child("DRIVERS").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull  DataSnapshot snapshot) {

                if(snapshot.exists()){
                    driver.setText(snapshot.getChildrenCount()+"");
                }
                else {
                    driver.setText("0");
                }

            }

            @Override
            public void onCancelled(@NonNull  DatabaseError error) {

            }
        });

        ref.child("USERS").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull  DataSnapshot snapshot) {

                if(snapshot.exists()){
                    employ.setText(snapshot.getChildrenCount()+"");
                }
                else {
                    employ.setText("0");
                }

            }

            @Override
            public void onCancelled(@NonNull  DatabaseError error) {

            }
        });


        final Intent intent = new Intent(this, Booking.class);
        final Intent intentA = new Intent(this, Orders.class);
        final Intent intentB = new Intent(this, OrderComplete.class);
        final Intent intentD = new Intent(this, UserActivity.class);
        final Intent intentC = new Intent(this, Driver.class);


        userProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(intentD);

            }
        });

        driverProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(intentC);

            }
        });


        cardBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });

        cardBookingComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentB);
            }
        });


        cardBookingProccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentA);
            }
        });




    }


    @Override
    public void onBackPressed() {

    }
}