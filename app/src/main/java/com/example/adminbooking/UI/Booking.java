
package com.example.adminbooking.UI;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;


import com.example.adminbooking.FileUtils;
import com.example.adminbooking.IdGen;
import com.example.adminbooking.JavaMail.JavaMailAPI;
import com.example.adminbooking.JavaMail.MailTemplate;
import com.example.adminbooking.Models.BookingDetails;
import com.example.adminbooking.R;
import com.example.adminbooking.SessionManeger.UserManager;
import com.example.adminbooking.SingleChoiceDialogFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.FirebaseDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Booking extends AppCompatActivity implements SingleChoiceDialogFragment.SingleChoiceListener {

    private static final int REQUEST_CODE_OPEN_FILE_EXPLORER = 5501;
    ImageView buttonAttach, buttonAttach0;
    FloatingActionButton buttonSend;

    private ProgressDialog mProgressDialog;
    TextView textPath, textId, textSelect;
    String pdfPath,orderId,packing = "NO",userId;

    TextInputEditText textTruck, textPrice, textDeposit, textMove, textNote, textTime2, textItem, textExtra, textNum, textPack,
             textCapacity, textCard,textEmail, textName,textMobileNumber,textFromAddress,textToAddress,textDate,textTime;

    BookingDetails bookingDetails_01, bookingDetails_02;
    MailTemplate mailTemplate;
    int hour,minite;
    Context context = this;
    SharedPreferences shf;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);


        buttonSend = findViewById(R.id.btnSend);
        textName = findViewById(R.id.textName);
        textEmail = findViewById(R.id.textEmail);
        textMobileNumber = findViewById(R.id.textMobileNumber);
        textFromAddress = findViewById(R.id.textFromAddress);
        textToAddress = findViewById(R.id.textToAddress);
        textDate = findViewById(R.id.textDate);
        textTime = findViewById(R.id.textTime);
        textTruck = findViewById(R.id.textTruck);
        textPrice = findViewById(R.id.textPrice);
        textDeposit = findViewById(R.id.textDeposit);
        textPath = findViewById(R.id.textPath);
        buttonAttach = findViewById(R.id.btnAttach);
        buttonAttach0 = findViewById(R.id.btnAttach0);
        textPack = findViewById(R.id.textPack);
        textId = findViewById(R.id.orderId);
        textNote = findViewById(R.id.textNote);
        textNum = findViewById(R.id.textRemovelist);
        textTime2 = findViewById(R.id.textTime2);
        textExtra = findViewById(R.id.textExtra);
        textItem = findViewById(R.id.textItem);
        textMove = findViewById(R.id.textMoveType);
        textCapacity = findViewById(R.id.textCapacity);
        textNum = findViewById(R.id.textRemovelist);
        textSelect = findViewById(R.id.textSelect);
        textCard = findViewById(R.id.textCard);


        userId = "Admin";

        shf = getSharedPreferences("BOOKING_MELBOURNE",MODE_PRIVATE);
        getSavepdf();




        Calendar calendar = Calendar.getInstance();

        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);


        mailTemplate = MailTemplate.getInstance();

        buttonAttach0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("*/*");
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                startActivityForResult(intent, REQUEST_CODE_OPEN_FILE_EXPLORER);


            }
        });

        buttonAttach.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("*/*");
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                startActivityForResult(intent, REQUEST_CODE_OPEN_FILE_EXPLORER);

            }
        });


        textSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = textSelect.getText().toString();
                if (text == "P/h") {
                    textSelect.setText("Fixed");
                } else {
                    textSelect.setText("P/h");
                }
            }
        });

        textNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment singleChoiceDialog = new SingleChoiceDialogFragment("Select NUmber Of Removalists", R.array.removelist, 2);
                singleChoiceDialog.setCancelable(false);
                singleChoiceDialog.show(getSupportFragmentManager(), "");
            }
        });

        textCapacity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment singleChoiceDialog = new SingleChoiceDialogFragment("Select Truck Capacity", R.array.capacity, 1);
                singleChoiceDialog.setCancelable(false);
                singleChoiceDialog.show(getSupportFragmentManager(), "");
            }
        });


        textDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(Booking.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month = month + 1;
                        String date = day + "/" + month + "/" + year;
                        textDate.setText(date);
                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });

        textTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clock(textTime);
            }
        });

        textTime2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                clock(textTime2);
            }
        });


        buttonSend.setOnClickListener(new View.OnClickListener() {


            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {

               System.out.println(IdGen.createId());

                ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

                if (networkInfo != null && networkInfo.isConnected()) {


                    orderId = IdGen.createId();
                    sendMail();
                    textEmail.setText("");
                    textName.setText("");
                    textMobileNumber.setText("");
                    textFromAddress.setText("");
                    textToAddress.setText("");
                    textDate.setText("");
                    textTime.setText("");
                    textPrice.setText("");
                    textDeposit.setText("");
                    textTruck.setText("");
                    textPack.setText("None");
                    textNum.setText("Two");
                    textSelect.setText("P/h");
                    textCapacity.setText("24");
                    textTime2.setText("");
                    textExtra.setText("0");
                    textItem.setText("None");
                    textNote.setText("");
                    textMove.setText("");
                    textCard.setText("");

                } else {
                    new AlertDialog.Builder(context)
                            .setTitle("Connection Failure")
                            .setMessage("Please Connect to the Internet")
                            .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                }
                            })
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();
                }

            }
        });

        textTruck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DialogFragment singleChoiceDialog = new SingleChoiceDialogFragment("Select Truck", R.array.choice_Truck, 0);
                singleChoiceDialog.setCancelable(false);
                singleChoiceDialog.show(getSupportFragmentManager(), "");
            }
        });



    }

    private boolean getSavepdf() {

        pdfPath = shf.getString("PATH",null);

        if(!(pdfPath == null)){

            String[] name = pdfPath.split("/");
            textPath.setText(name[name.length-1]);
            buttonAttach0.setVisibility(View.GONE);
            buttonAttach.setVisibility(View.VISIBLE);

            return true;
        }
        else{
            return false;
        }
    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode != REQUEST_CODE_OPEN_FILE_EXPLORER) {
            return;
        }
        String path = null;
        if (resultCode == Activity.RESULT_OK) {
            Uri uri = data.getData();
            String name = FileUtils.getFileName(context,uri);
            path = FileUtils.getReadablePathFromUri(context, uri);
            if (TextUtils.isEmpty(path) || !name.endsWith(".pdf")) {
                Toast.makeText(context,"Unsupported file format",Toast.LENGTH_LONG).show();
                buttonAttach0.setVisibility(View.VISIBLE);
                buttonAttach.setVisibility(View.GONE);
                textPath.setText("Add a attachment");
            } else {

                pdfPath = path;
                textPath.setText(FileUtils.getFileName(context, uri));
                buttonAttach0.setVisibility(View.GONE);
                buttonAttach.setVisibility(View.VISIBLE);

                SharedPreferences shf = getSharedPreferences("BOOKING_MELBOURNE",MODE_PRIVATE);
                SharedPreferences.Editor editor = shf.edit();
                editor.putString("PATH",path);
                editor.commit();
            }
        }
        else {

            if(!getSavepdf()) {
                buttonAttach0.setVisibility(View.VISIBLE);
                buttonAttach.setVisibility(View.GONE);
                textPath.setText("Add a attachment");
                Toast.makeText(context, "Unsupported file format", Toast.LENGTH_LONG).show();
            }
        }
    }


    @Override
    public void onPositiveButtonClicked(String[] list, int position, int index) {
        if (index == 0) {
            textTruck.setText(list[position]);
        } else if (index == 1) {
            textCapacity.setText(list[position]);
        } else if (index == 2) {
            textNum.setText(list[position]);
        }

    }


    private void sendMail() {


        String name = textName.getText().toString().trim();
        String mail = textEmail.getText().toString().trim();
        String mobileNumber = textMobileNumber.getText().toString().trim();
        String fromAddress = textFromAddress.getText().toString().trim();
        String toAddress = textToAddress.getText().toString().trim();
        String date = textDate.getText().toString();
        String time = textTime.getText().toString().trim();
        String truck = textTruck.getText().toString().trim();
        String price = textPrice.getText().toString().trim();
        String deposit = textDeposit.getText().toString().trim();
        String move = textMove.getText().toString();
        String note = textNote.getText().toString();
        String extra = textExtra.getText().toString();
        String item = textItem.getText().toString();
        String pack = textPack.getText().toString();
        String num = textNum.getText().toString();
        String time2 = textTime2.getText().toString();
        if (time2.length() != 0) {
            time2 = " - " + time2;
        }
        String capacity = textCapacity.getText().toString();
        String select = textSelect.getText().toString();
        String card = textCard.getText().toString();


        bookingDetails_01 = new BookingDetails(name, mail, mobileNumber, fromAddress, toAddress, date, time, price+"$", deposit+"$", truck, time2,
                num, pack, extra+"$", orderId, capacity, select);

        String template = mailTemplate.getTemplate(bookingDetails_01);
        bookingDetails_02 = new BookingDetails(name, mail, mobileNumber, fromAddress, toAddress, date, time, price+"$", deposit+"$",
                truck, time2, num, pack, move, note, extra+"$", item, orderId, card,userId,userId+date,false,false);

        FirebaseDatabase.getInstance().getReference("BOOKING").child(orderId).setValue(bookingDetails_02);
        JavaMailAPI javaMailAPI = new JavaMailAPI(this, mail, template, pdfPath);
        javaMailAPI.execute();

    }


    @Override
    public void onNegativeButtonClicked(int index) {

        if (index == 0) {
            textTruck.setText("Select Truck");
        } else if (index == 1) {
            textCapacity.setText("Capacity");
        } else if (index == 2) {
            textNum.setText("Removealists");
        }

    }


    @Override
    public void onBackPressed() {
        startActivity(new Intent(context, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));

    }


    public void clock(EditText textTime) {

        final String[] finalTime = {"Select Time "};

        TimePickerDialog timePickerDialog = new TimePickerDialog(
                Booking.this,
                android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        hour = hourOfDay;
                        minite = minute;
                        String time = hour + ":" + minite;
                        SimpleDateFormat f24Hours = new SimpleDateFormat("HH:mm");
                        try {
                            Date date = f24Hours.parse(time);
                            SimpleDateFormat f12Hours = new SimpleDateFormat(
                                    "hh:mm aa");
                            textTime.setText(f12Hours.format(date));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                }, 12, 0, false
        );
        timePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        timePickerDialog.updateTime(hour, minite);
        timePickerDialog.show();


    }


}