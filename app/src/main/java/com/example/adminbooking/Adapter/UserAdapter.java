package com.example.adminbooking.Adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adminbooking.Models.UserDetails;
import com.example.adminbooking.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private Context mContext;
    private List<UserDetails> users;
    String[] userDetails,userUpdateDetails;
    EditText name, email, moblieNumber, password;

    public UserAdapter(Context mContext, List<UserDetails> users) {
        this.mContext = mContext;
        this.users = users;
    }


    @NonNull

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(mContext).inflate(R.layout.single_user, parent, false);
        return new ViewHolder(row);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder holder, int position) {

        UserDetails user = users.get(position);
        holder.driverName.setText(user.getName());
        holder.driverMobile.setText(user.getUserName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                clickUser(user);
            }
        });

    }

    @Override
    public int getItemCount() {
        return users.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView driverName, driverMobile;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            driverName = itemView.findViewById(R.id.userName);
            driverMobile = itemView.findViewById(R.id.userId);

        }
    }


    private void clickUser(UserDetails user) {



        AlertDialog.Builder dialog = new AlertDialog.Builder(mContext);
        View mView = LayoutInflater.from(mContext).inflate(R.layout.user_view, null);
        dialog.setView(mView);

        String userId = user.getUserName();
        Button edit, update, delete;
        TextView idText;
        userDetails = new String[4];
        userUpdateDetails = new String[4];

        update = mView.findViewById(R.id.btnUpdate);
        edit = mView.findViewById(R.id.btnEdit);
        name = mView.findViewById(R.id.textName);
        email = mView.findViewById(R.id.textEmail);
        moblieNumber = mView.findViewById(R.id.textMobileNumber);
        password = mView.findViewById(R.id.textPassword);
        idText = mView.findViewById(R.id.userId);
        name.setText(user.getName());
        email.setText(user.getEmail());
        moblieNumber.setText(user.getMobileNumber());
        password.setText(user.getPassword());

        idText.setText(userId);

        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference("USERS");

        ;
        AlertDialog alertDialog = dialog.create();


        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                enableField(true);
                getUserDetails();
                update.setVisibility(View.VISIBLE);
                name.requestFocus();

            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ConnectivityManager connMgr = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

                if (networkInfo != null && networkInfo.isConnected()) {

                    userUpdateDetails[0] = name.getText().toString();
                    userUpdateDetails[1] = email.getText().toString();
                    userUpdateDetails[2] = moblieNumber.getText().toString();
                    userUpdateDetails[3] = password.getText().toString();


                    for (int i = 0; i <= 3; i++) {

                        if (userDetails[i].equals(userUpdateDetails[i])) {

                            if (i == 2) {
                                Toast.makeText(mContext, "Same Data", Toast.LENGTH_SHORT).show();
                            }

                        } else {

                            UserDetails userDetails = new UserDetails(userId, userUpdateDetails[0], userUpdateDetails[1], userUpdateDetails[2]
                                    , userUpdateDetails[3]);


                            myRef.child(userId).setValue(userDetails);


                            Toast.makeText(mContext, "Updated Successfully", Toast.LENGTH_LONG).show();
                            getUserDetails();
                            update.setVisibility(View.INVISIBLE);
                            enableField(false);
                            break;
                        }
                    }
                    // fetch data
                } else {
                    new AlertDialog.Builder(mContext)
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

        alertDialog.show();
    }



    private void getUserDetails() {

        userDetails[0] = name.getText().toString().trim();
        userDetails[1] = email.getText().toString().trim();
        userDetails[2] = moblieNumber.getText().toString().trim();
        userDetails[3] = password.getText().toString().trim();


    }


    private void enableField(boolean b) {

        name.setEnabled(b);
        email.setEnabled(b);
        moblieNumber.setEnabled(b);
        password.setEnabled(b);


    }


}
