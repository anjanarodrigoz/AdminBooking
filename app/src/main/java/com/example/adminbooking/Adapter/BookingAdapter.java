package com.example.adminbooking.Adapter;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;


import com.example.adminbooking.JavaMail.JavaMailAPI;
import com.example.adminbooking.JavaMail.MailTemplate;
import com.example.adminbooking.Models.BookingDetails;
import com.example.adminbooking.Models.UserDetails;
import com.example.adminbooking.R;
import com.example.adminbooking.SessionManeger.UserManager;
import com.example.adminbooking.UI.Booking;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class BookingAdapter extends RecyclerView.Adapter<BookingAdapter.ViewHolder> {

    private Context context;
    List<BookingDetails> bookingDetails;
    private ArrayAdapter<String> adapterDetails;
    String mNumber = "000000";
    ArrayList<String> driversName = new ArrayList<>();
    ArrayList<String> driversMobile = new ArrayList<>();

    public BookingAdapter(Context context, List<BookingDetails> bookingDetails) {

        this.context = context;
        this.bookingDetails = bookingDetails;


        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("DRIVERS");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {

                    UserDetails driver = dataSnapshot.getValue(UserDetails.class);
                    driversName.add(driver.getName());
                    driversMobile.add(driver.getMobileNumber());
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    @NonNull

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.single_order, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        BookingDetails order = bookingDetails.get(position);
        String userId = UserManager.getInstance(context).getUserId();
        holder.id.setText(order.getOrderId());
        holder.truckSize.setText(order.getmTruck());
        holder.userName.setText(order.getUserId());
        if (order.isSend()) {
            holder.send.setVisibility(View.VISIBLE);
        }
        if (order.isEdited()) {
            holder.edit.setVisibility(View.VISIBLE);
        }


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                itemView(order);
            }
        });

    }


    @Override
    public int getItemCount() {
        return bookingDetails.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        TextView truckSize, id, userName;
        ImageView send, edit;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            truckSize = itemView.findViewById(R.id.truckSize);
            send = itemView.findViewById(R.id.delivery);
            id = itemView.findViewById(R.id.orderId);
            edit = itemView.findViewById(R.id.edit);
            userName = itemView.findViewById(R.id.userName);

        }
    }


    public void itemView(BookingDetails order) {


        String userId = order.getUserId();

        ListView detailsList = new ListView(context);
        List<String> details = new ArrayList<>();

        setData(details, detailsList, order);

        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView(detailsList);
        builder.setTitle("Customer Details");


        builder.setNegativeButton("Complete", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String name = order.getmName();
                String mail = order.getmEmail();
                String mobileNumber = order.getmMobileNumber();
                String fromAddress = order.getmFromAddress();
                String toAddress = order.getmToAddress();
                String date = order.getmDate();
                String time = order.getmTime();
                String time2 = order.getmTime2();
                String price = order.getmPrice();
                String deposit = order.getmDeposite();
                String truck = order.getmTruck();
                String note = order.getmNote();
                String num = order.getmNum();
                String pack = order.getmPack();
                String move = order.getmMove();
                String extra = order.getmExtra();
                String item = order.getmItem();
                String orderId = order.getOrderId();
                String card = order.getCard();
                boolean isSend = order.isSend();
                boolean edited = order.isEdited();

                BookingDetails booking = new BookingDetails(name, mail, mobileNumber, fromAddress, toAddress, date, time, price, deposit,
                        truck, time2, num, pack, move, note, extra, item, orderId, card, userId, userId + date, isSend, edited);

                DatabaseReference ref = FirebaseDatabase.getInstance().getReference();

                ref.child("COMPLETE").child(orderId).setValue(booking);
                ref.child("BOOKING").child(orderId).removeValue();

            }
        });


        builder.setNeutralButton("Send", new DialogInterface.OnClickListener() {


            @Override
            public void onClick(DialogInterface dialog, int which) {


                SharedPreferences shf = context.getSharedPreferences("BOOKING_MELBOURNE", MODE_PRIVATE);

                String pdfPath = shf.getString("PATH", null);
                String orderId = order.getOrderId();
                String name = order.getmName();
                String mail = order.getmEmail();
                String mobileNumber = order.getmMobileNumber();
                String fromAddress = order.getmFromAddress();
                String toAddress = order.getmToAddress();
                String date = order.getmDate();
                String time = order.getmTime();
                String truck = order.getmTruck();
                String price = order.getmPrice();
                String deposit = order.getmDeposite();
                String move = order.getmMove();
                String note = order.getmNote();
                String extra = order.getmExtra();
                String item = order.getmItem();
                String pack = order.getmPack();
                String num = order.getmNum();
                String time2 = order.getmTime2();
                String capacity = order.getCapacity();
                String select = order.getSelect();


                AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
                builder1.setCancelable(true);

                builder1.setTitle("Send SMS");

                View mView = LayoutInflater.from(context).inflate(R.layout.sms_layout, null);
                Spinner spinner = mView.findViewById(R.id.number);
                EditText sms = mView.findViewById(R.id.message);
                Button send = mView.findViewById(R.id.send);
                Button sendEmail = mView.findViewById(R.id.sendEmail);
                Button sendDriver = mView.findViewById(R.id.sendDriver);
                RelativeLayout rLayout = mView.findViewById(R.id.rLayout);
                LinearLayout lLayout = mView.findViewById(R.id.lLayout);

                builder1.setView(mView);

                AlertDialog mainDialog = builder1.create();


                ArrayAdapter<String> adapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, driversName);
                spinner.setAdapter(adapter);

                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                        mNumber = driversMobile.get(position);

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {


                    }
                });


                sendDriver.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        lLayout.setVisibility(View.GONE);
                        rLayout.setVisibility(View.VISIBLE);
                    }
                });

                sendEmail.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        BookingDetails bookingDetails_01 = new BookingDetails(name, mail, mobileNumber, fromAddress, toAddress, date, time, price, deposit, truck, time2,
                                num, pack, extra, orderId, capacity, select);

                        String template = MailTemplate.getInstance().getTemplate(bookingDetails_01);
                        JavaMailAPI javaMailAPI = new JavaMailAPI(context, mail, template, pdfPath);
                        javaMailAPI.execute();

                    }
                });

                send.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        String message = sms.getText().toString();


                        String SMS =

                                "Order ID : " + orderId + "\n" +
                                        "Cutomer Name : " + name + "\n" +
                                        "Mobile Number : " + mobileNumber + "\n" +
                                        "Pickup Location : " + fromAddress + "\n" +
                                        "Drop-off Location : " + toAddress + "\n" +
                                        "Date : " + date + "\n" +
                                        "Time : " + time + time2 + "\n" +
                                        "Truck Size : " + truck + "\n" +
                                        "Price : " + price + "\n" +
                                        "Deposite : " + deposit + "\n" +
                                        "Extra Charges : " + extra + "\n" +
                                        "Itemize Special : " + item + "\n" +
                                        "Move Type : " + move + "\n" +
                                        "Packing Material : " + pack + "\n" +
                                        "Removalists : " + num + "\n" +
                                        "Note : " + note + "\n" +

                                        message;

                        try {
                            SmsManager smsManager = SmsManager.getDefault();
                            ArrayList<String> parts = smsManager.divideMessage(SMS);
                            smsManager.sendMultipartTextMessage(mNumber, null, parts, null, null);
                            DatabaseReference ref = FirebaseDatabase.getInstance().getReference("BOOKING");
                            ref.child(order.getOrderId()).child("send").setValue(true);
                            Toast.makeText(context, "sent", Toast.LENGTH_SHORT).show();


                        } catch (Exception e) {
                            e.printStackTrace();
                            Toast.makeText(context, "fail", Toast.LENGTH_SHORT).show();

                        }


                        mainDialog.dismiss();
                    }


                });


                mainDialog.show();

            }

        });


        builder.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                builder.setCancelable(true);


            }
        });


        detailsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 5) {

                    String[] currentDate = order.getmDate().split("/");


                    final int year = Integer.parseInt(currentDate[2]);
                    final int month = Integer.parseInt(currentDate[1])-1;
                    final int day = Integer.parseInt(currentDate[0]);

                    DatePickerDialog datePickerDialog = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int day) {
                            month= month+1;
                            String date = day + "/" + month + "/" + year;
                            order.setmDate(date);
                            order.setSearch(order.getUserId() + order.getmDate());
                            adapterDetails.clear();
                            setData(details, detailsList, order);
                            DatabaseReference ref = FirebaseDatabase.getInstance().getReference("BOOKING").child(order.getOrderId());
                            ref.setValue(order);
                            ref.child("edited").setValue(true);
                        }
                    }, year, month, day);
                    datePickerDialog.show();




                } else {

                    AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
                    View view1 = LayoutInflater.from(context).inflate(R.layout.single_view, parent, false);
                    builder1.setView(view1);


                    EditText text = view1.findViewById(R.id.text);
                    ImageView img = view1.findViewById(R.id.close);
                    Button save = view1.findViewById(R.id.btnSave);

                    editDetails(text, false, order, position);

                    AlertDialog dialog = builder1.create();

                    img.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            dialog.dismiss();
                        }
                    });

                    save.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            editDetails(text, true, order, position);
                            adapterDetails.clear();
                            setData(details, detailsList, order);
                            dialog.dismiss();


                        }
                    });
                    dialog.show();
                }


            }
        });
        builder.show();
    }

    private void setData(List<String> details, ListView detailsList, BookingDetails order) {

        details.add("Name : " + order.getmName());
        details.add("Mobile Number : " + order.getmMobileNumber());
        details.add("E-mail : " + order.getmEmail());
        details.add("F Address : " + order.getmFromAddress());
        details.add("T Address : " + order.getmToAddress());
        details.add("Date : " + order.getmDate());
        details.add("Time : " + order.getmTime() + order.getmTime2());
        details.add("Price : " + order.getmPrice());
        details.add("Deposite : " + order.getmDeposite());
        details.add("Extra Charges : " + order.getmExtra());
        details.add("Removelistner : " + order.getmNum());
        details.add("Packing Material : " + order.getmPack());
        details.add("Move Type : " + order.getmMove());
        details.add("Note : " + order.getmNote());
        details.add("Itemize Special : " + order.getmItem());
        details.add("Card Details : " + order.getCard());


        adapterDetails = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, details);
        detailsList.setAdapter(adapterDetails);

    }

    private void editDetails(EditText text, boolean b, BookingDetails order, int position) {

        switch (position) {

            case 0:
                if (b) {
                    order.setmName(text.getText().toString());
                } else {
                    text.setText(order.getmName());
                }
                break;
            case 1:
                if (b) {
                    order.setmMobileNumber(text.getText().toString());
                } else {
                    text.setText(order.getmMobileNumber());
                }
                break;
            case 2:
                if (b) {
                    order.setmEmail(text.getText().toString());
                } else {
                    text.setText(order.getmEmail());
                }
                break;
            case 3:
                if (b) {
                    order.setmFromAddress(text.getText().toString());
                } else {
                    text.setText(order.getmFromAddress());
                }
                break;
            case 4:
                if (b) {
                    order.setmToAddress(text.getText().toString());
                } else {
                    text.setText(order.getmToAddress());
                }
                break;
            case 5:
                if (b) {


                }
                break;
            case 6:
                if (b) {

                    String a[] = text.getText().toString().split("-");
                    if (a.length == 2) {
                        order.setmTime(a[0].trim());
                        order.setmTime2("-" + a[1].trim());
                    } else {
                        order.setmTime(a[0].trim());
                        order.setmTime2("");
                    }

                } else {
                    text.setText(order.getmTime() + order.getmTime2());
                }
                break;
            case 7:
                if (b) {
                    order.setmPrice(text.getText().toString());
                } else {
                    text.setText(order.getmPrice());
                }
                break;
            case 8:
                if (b) {
                    order.setmDeposite(text.getText().toString());
                } else {
                    text.setText(order.getmDeposite());
                }
                break;
            case 9:
                if (b) {
                    order.setmExtra(text.getText().toString());
                } else {
                    text.setText(order.getmExtra());
                }
                break;
            case 10:
                if (b) {
                    order.setmNum(text.getText().toString());
                } else {
                    text.setText(order.getmNum());
                }
                break;
            case 11:
                if (b) {
                    order.setmPack(text.getText().toString());
                } else {
                    text.setText(order.getmPack());
                }
                break;
            case 12:
                if (b) {
                    order.setmMove(text.getText().toString());
                } else {
                    text.setText(order.getmMove());
                }
                break;
            case 13:
                if (b) {
                    order.setmNote(text.getText().toString());
                } else {
                    text.setText(order.getmNote());
                }
                break;
            case 14:
                if (b) {
                    order.setmItem(text.getText().toString());
                } else {
                    text.setText(order.getmItem());
                }
                break;
            case 15:
                if (b) {
                    order.setCard(text.getText().toString());
                } else {
                    text.setText(order.getCard());
                }
                break;

        }

        if (b) {
            DatabaseReference ref = FirebaseDatabase.getInstance().getReference("BOOKING").child(order.getOrderId());
            ref.setValue(order);
            ref.child("edited").setValue(true);
        }
    }
}

