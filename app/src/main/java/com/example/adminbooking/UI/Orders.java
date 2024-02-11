package com.example.adminbooking.UI;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Environment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.adminbooking.Adapter.BookingAdapter;
import com.example.adminbooking.Adapter.BookingCompleteAdapter;
import com.example.adminbooking.DbHandler;
import com.example.adminbooking.Models.BookingDetails;
import com.example.adminbooking.Models.UserDetails;
import com.example.adminbooking.R;
import com.example.adminbooking.SessionManeger.UserManager;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Orders extends AppCompatActivity {

    ImageButton btnDate, sup, sdown;
    FloatingActionButton btnSheet;
    TextView textDate, searchDisplay, txtMOrders, txtEOrders;
    RecyclerView listView, listVieweve;
    List<BookingDetails> orders, mOrders, eOrders;
    DbHandler dbHandler;
    Context context = this;
    String selectDate = "", userId;
    String fileDefultName = "defult";
    Query firstQuery;
    boolean call = false;
    ToggleButton toggleButton;
    private BookingDetails bookingDetails;
    int d_year, d_month, d_day;
    EditText search;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);


        dbHandler = DbHandler.getInstance(this);
        btnDate = findViewById(R.id.btnDateSelect);
        sup = findViewById(R.id.sup);
        sdown = findViewById(R.id.sdown);
        search = findViewById(R.id.textSearch);
        btnSheet = findViewById(R.id.btnSheet);
        textDate = findViewById(R.id.textDate);
        listView = findViewById(R.id.lisView);
        listVieweve = findViewById(R.id.lisVieweve);
        txtMOrders = findViewById(R.id.txtMOrders);
        txtEOrders = findViewById(R.id.txtEOrders);
        toggleButton = findViewById(R.id.toggle);

        userId = "Admin";


        searchDisplay = findViewById(R.id.searchDisplay);
        orders = new ArrayList<>();
        mOrders = new ArrayList<>();
        eOrders = new ArrayList<>();

        listView.setHasFixedSize(true);
        listView.setLayoutManager(new LinearLayoutManager(context));

        listVieweve.setHasFixedSize(true);
        listVieweve.setLayoutManager(new LinearLayoutManager(context));


        firstQuery = FirebaseDatabase.getInstance().getReference("BOOKING");

        Calendar calendar = Calendar.getInstance();
        d_year = calendar.get(Calendar.YEAR);
        d_month = calendar.get(Calendar.MONTH);
        d_day = calendar.get(Calendar.DAY_OF_MONTH);

        readBooking(firstQuery);


        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkConditions();

            }
        });

        sdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sup.setVisibility(View.VISIBLE);
                sdown.setVisibility(View.GONE);
                search.setVisibility(View.GONE);
                btnDate.setVisibility(View.VISIBLE);
                if(!textDate.getText().toString().isEmpty()){
                    textDate.setVisibility(View.VISIBLE);
                }
                toggleButton.setVisibility(View.VISIBLE);
                search.setText("");
            }
        });

        sup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sup.setVisibility(View.GONE);
                sdown.setVisibility(View.VISIBLE);
                search.setVisibility(View.VISIBLE);
                btnDate.setVisibility(View.GONE);
                textDate.setVisibility(View.GONE);
                toggleButton.setVisibility(View.GONE);

            }
        });

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

        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog datePickerDialog = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {

                        d_year = year;
                        d_month = month;
                        d_day = day;

                        month = month + 1;
                        String date = day + "/" + month + "/" + year;

                        selectDate = date;
                        textDate.setVisibility(View.VISIBLE);
                        textDate.setText(date + " ");
                        checkConditions();
                    }
                }, d_year, d_month, d_day);
                datePickerDialog.show();
            }
        });

        textDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textDate.setText("");
                selectDate = "";
                textDate.setVisibility(View.GONE);
                checkConditions();
            }
        });

        btnSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                final AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("\n    Do You Want to Create A Contact Sheet?");
                builder.setTitle("Contact Sheet");
                builder.setIcon(R.drawable.sheet3);


                builder.setNegativeButton("Create", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        builder.setCancelable(false);

                        String[] header = {"Order Id", "Name ", "E-mail", "Mobile Number", "F Address", "T Address", "Date", "Time", "Price", "Deposite", "Truck Size", "Number Of Removalists", "Packing Details", "Move Type", "Note", "Extra Charges", "Items", "Card Details"};

                        Workbook workbook = new HSSFWorkbook();
                        Sheet sheet = workbook.createSheet("Contact"); //Creating a sheet


                        // Create a Row
                        Row headerRow = sheet.createRow(0);

                        for (int i = 0; i < header.length; i++) {
                            Cell cell = headerRow.createCell(i);
                            cell.setCellValue(header[i]);

                        }

                        int rowNum = 0;

                        for (int i = 0; i < mOrders.size(); i++) {
                            BookingDetails bookingDetails = mOrders.get(i);
                            rowNum = i + 2;
                            Row row = sheet.createRow(rowNum);

                            row.createCell(0).setCellValue(bookingDetails.getOrderId());
                            row.createCell(1).setCellValue(bookingDetails.getmName());
                            row.createCell(2).setCellValue(bookingDetails.getmEmail());
                            row.createCell(3).setCellValue(bookingDetails.getmMobileNumber());
                            row.createCell(4).setCellValue(bookingDetails.getmFromAddress());
                            row.createCell(5).setCellValue(bookingDetails.getmToAddress());
                            row.createCell(6).setCellValue(bookingDetails.getmDate());
                            row.createCell(7).setCellValue(bookingDetails.getmTime() + bookingDetails.getmTime2());
                            row.createCell(8).setCellValue(bookingDetails.getmPrice());
                            row.createCell(9).setCellValue(bookingDetails.getmDeposite());
                            row.createCell(10).setCellValue(bookingDetails.getmTruck());
                            row.createCell(11).setCellValue(bookingDetails.getmNum());
                            row.createCell(12).setCellValue(bookingDetails.getmPack());
                            row.createCell(13).setCellValue(bookingDetails.getmMove());
                            row.createCell(14).setCellValue(bookingDetails.getmNote());
                            row.createCell(15).setCellValue(bookingDetails.getmExtra());
                            row.createCell(16).setCellValue(bookingDetails.getmItem());
                            row.createCell(17).setCellValue(bookingDetails.getCard());


                        }

                        rowNum = rowNum + 2;


                        for (int i = 0; i < eOrders.size(); i++) {
                            BookingDetails bookingDetails = eOrders.get(i);
                            Row row = sheet.createRow(rowNum + i);
                            row.createCell(0).setCellValue(bookingDetails.getOrderId());
                            row.createCell(1).setCellValue(bookingDetails.getmName());
                            row.createCell(2).setCellValue(bookingDetails.getmEmail());
                            row.createCell(3).setCellValue(bookingDetails.getmMobileNumber());
                            row.createCell(4).setCellValue(bookingDetails.getmFromAddress());
                            row.createCell(5).setCellValue(bookingDetails.getmToAddress());
                            row.createCell(6).setCellValue(bookingDetails.getmDate());
                            row.createCell(7).setCellValue(bookingDetails.getmTime() + bookingDetails.getmTime2());
                            row.createCell(8).setCellValue(bookingDetails.getmPrice());
                            row.createCell(9).setCellValue(bookingDetails.getmDeposite());
                            row.createCell(10).setCellValue(bookingDetails.getmTruck());
                            row.createCell(11).setCellValue(bookingDetails.getmNum());
                            row.createCell(12).setCellValue(bookingDetails.getmPack());
                            row.createCell(13).setCellValue(bookingDetails.getmMove());
                            row.createCell(14).setCellValue(bookingDetails.getmNote());
                            row.createCell(15).setCellValue(bookingDetails.getmExtra());
                            row.createCell(16).setCellValue(bookingDetails.getmItem());
                            row.createCell(17).setCellValue(bookingDetails.getCard());


                        }


                        String fileName = fileDefultName + ".xlsx"; //Name of the file

                        String extStorageDirectory = Environment.getExternalStorageDirectory()
                                .toString() + "/MMContacts";

                        File folder = new File(extStorageDirectory);// Name of the folder you want to keep your file in the local storage.

                        folder.mkdir(); //creating the folder

                        File file = new File(folder, fileName);

                        try {
                            folder.createNewFile(); // creating the file inside the folder

                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }

                        try {
                            FileOutputStream fileOut = new FileOutputStream(file); //Opening the file
                            workbook.write(fileOut); //Writing all your row column inside the file
                            fileOut.close(); //closing the file and done


                            final AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
                            builder1.setMessage("\n   Your File Is Ready.....\n\n   Go To /MMContacts/ ");
                            builder1.setTitle("Contacts Sheet");
                            builder1.setIcon(R.drawable.sheet3);
                            builder1.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    builder1.setCancelable(true);
                                }
                            });

                            builder1.create();
                            builder1.show();

                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                    }
                });

                builder.setPositiveButton(
                        "Cancle", new DialogInterface.OnClickListener() {
                            @Override

                            public void onClick(DialogInterface dialog, int which) {
                                builder.setCancelable(true);

                            }
                        });
                builder.setCancelable(true);
                builder.create();
                builder.show();

            }
        });

    }


    public void searchBooking(Query query) {


        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                mOrders.clear();
                eOrders.clear();

                if (search.getText().toString().isEmpty()) {
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {

                        BookingDetails booking = dataSnapshot.getValue(BookingDetails.class);


                        String time = booking.getmTime();

                        if (time.length() == 0) {
                            mOrders.add(booking);
                        } else {
                            String last = time.substring(time.length() - 2, time.length());
                            last = last.toLowerCase();

                            if (last.equals("am")) {
                                mOrders.add(booking);
                            } else {
                                eOrders.add(booking);
                            }
                        }
                    }

                }

                searchDisplay.setText(mOrders.size() + eOrders.size() + " Bookings");

                BookingAdapter bookingAdapter = new BookingAdapter(context, mOrders);
                listView.setAdapter(bookingAdapter);
                txtMOrders.setText(mOrders.size() + " Bookings");

                BookingAdapter bookingAdapter1 = new BookingAdapter(context, eOrders);
                listVieweve.setAdapter(bookingAdapter1);
                txtEOrders.setText(eOrders.size() + " Bookings");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }

    public void checkConditions() {


        if (toggleButton.isChecked()) {

            if (selectDate.isEmpty()) {
                firstQuery = FirebaseDatabase.getInstance().getReference("BOOKING").orderByChild("userId").equalTo(userId);
            } else {
                firstQuery = FirebaseDatabase.getInstance().getReference("BOOKING").orderByChild("search").equalTo(userId + selectDate);
            }

            call = true;
            searchBooking(firstQuery);

        } else {

            if (selectDate.isEmpty()) {
                firstQuery = FirebaseDatabase.getInstance().getReference("BOOKING");
            } else {
                firstQuery = FirebaseDatabase.getInstance().getReference("BOOKING").orderByChild("mDate").equalTo(selectDate);
            }

            call = true;
            searchBooking(firstQuery);
        }


    }

    public void readBooking(Query query) {


        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                mOrders.clear();
                eOrders.clear();
                dbHandler.deleteBooking();

                if (textDate.getText().toString().isEmpty()) {


                    if (search.getText().toString().isEmpty()) {

                        for (DataSnapshot dataSnapshot : snapshot.getChildren()) {

                            BookingDetails booking = dataSnapshot.getValue(BookingDetails.class);
                            dbHandler.addBooking(booking.getOrderId(),booking.getOrderId()+ " "+booking.getCard()+" "+booking.getUserId()+" "+booking.getmMobileNumber());

                            String time = booking.getmTime();


                            if (time.length() == 0) {
                                mOrders.add(booking);
                            } else {
                                String last = time.substring(time.length() - 2, time.length());
                                last = last.toLowerCase();

                                if (last.equals("am")) {
                                    mOrders.add(booking);
                                } else {
                                    eOrders.add(booking);
                                }
                            }
                        }

                    }

                    searchDisplay.setText(mOrders.size() + eOrders.size() + " Bookings");

                    BookingAdapter bookingAdapter = new BookingAdapter(context, mOrders);
                    listView.setAdapter(bookingAdapter);
                    txtMOrders.setText(mOrders.size() + " Bookings");

                    BookingAdapter bookingAdapter1 = new BookingAdapter(context, eOrders);
                    listVieweve.setAdapter(bookingAdapter1);
                    txtEOrders.setText(eOrders.size() + " Bookings");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }


    private void searchOrders(List<String> booking_idList) {


        firstQuery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                mOrders.clear();
                eOrders.clear();


                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {


                    BookingDetails booking = dataSnapshot.getValue(BookingDetails.class);
                    if (booking_idList.contains(booking.getOrderId())) {
                        String time = booking.getmTime();

                        if (time.length() == 0) {
                            mOrders.add(booking);
                        } else {
                            String last = time.substring(time.length() - 2, time.length());
                            last = last.toLowerCase();

                            if (last.equals("am")) {
                                mOrders.add(booking);
                            } else {
                                eOrders.add(booking);
                            }
                        }
                    }


                }

                searchDisplay.setText(mOrders.size() + eOrders.size() + " Bookings");

                BookingAdapter bookingAdapter = new BookingAdapter(context, mOrders);
                listView.setAdapter(bookingAdapter);
                txtMOrders.setText(mOrders.size() + " Bookings");

                BookingAdapter bookingAdapter1 = new BookingAdapter(context, eOrders);
                listVieweve.setAdapter(bookingAdapter1);
                txtEOrders.setText(eOrders.size() + " Bookings");

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }


}