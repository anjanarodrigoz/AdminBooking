package com.example.adminbooking.UI;

import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.adminbooking.Adapter.UserAdapter;
import com.example.adminbooking.Models.UserDetails;
import com.example.adminbooking.R;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class UserActivity extends AppCompatActivity {

    Button register;
    ImageButton close;
    EditText textName, textPassword;
    Context context = this;
    DatabaseReference myRef;
    TextView idText;
    RecyclerView listUser;
    List users;
    FloatingActionButton addUser;
    MaterialCardView userCard;
    boolean click = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        register = findViewById(R.id.btnRegister);
        close = findViewById(R.id.btnUserClose);
        textName = findViewById(R.id.textUserName);
        textPassword = findViewById(R.id.textUserPassword);
        idText = findViewById(R.id.textUserId);
        listUser = findViewById(R.id.listUser);
        addUser = findViewById(R.id.addUser);
        userCard = findViewById(R.id.cardUser);
        users = new ArrayList<>();

        listUser.setHasFixedSize(true);
        listUser.setLayoutManager(new LinearLayoutManager(context));


        myRef = FirebaseDatabase.getInstance().getReference();
        createUserId();

        myRef.child("USERS").addValueEventListener(new ValueEventListener() {


            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                users.clear();

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {

                    UserDetails user = dataSnapshot.getValue(UserDetails.class);
                    users.add(user);
                }

                UserAdapter adapter = new UserAdapter(context, users);
                listUser.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        addUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                click = click == true ? false : true;

                if(click == true){
                    userCard.setVisibility(View.VISIBLE) ;
                }else {
                    userCard.setVisibility(View.GONE) ;
                }



            }
        });

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                click = false;
                userCard.setVisibility(View.GONE);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

                if (networkInfo != null && networkInfo.isConnected()) {

                    String name, password, userId;

                    name = textName.getText().toString().trim();
                    password = textPassword.getText().toString().trim();
                    userId = idText.getText().toString();

                    UserDetails user = new UserDetails(userId, name, "", "", password);
                    myRef.child("USERS").child(userId).setValue(user);
                    myRef.child("USER_ID").setValue(userId);

                    textName.setText("");
                    textPassword.setText("");
                    createUserId();

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


    }

    private void createUserId() {

        myRef.child("USER_ID").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.exists()) {

                    String userId = snapshot.getValue(String.class);
                    userId = "BB" + String.format("%03d", Integer.parseInt(userId.substring(2)) + 1);
                    idText.setText(userId);

                } else {

                    idText.setText("BB000");
                    myRef.child("USER_ID").setValue("BB000");
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }


}