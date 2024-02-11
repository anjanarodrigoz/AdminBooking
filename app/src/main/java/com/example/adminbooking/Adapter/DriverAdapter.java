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

public class DriverAdapter extends RecyclerView.Adapter<DriverAdapter.ViewHolder> {

    private Context mContext;
    private List<UserDetails> drivers;
    String[] driverDetails, driverUpdateDetails;
    EditText name, email, moblieNumber, password;

    public DriverAdapter(Context mContext, List<UserDetails> users) {
        this.mContext = mContext;
        this.drivers = users;
    }


    @NonNull

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(mContext).inflate(R.layout.single_user, parent, false);
        return new ViewHolder(row);
    }

    @Override
    public void onBindViewHolder(@NonNull DriverAdapter.ViewHolder holder, int position) {

        UserDetails driver = drivers.get(position);
        holder.driverName.setText(driver.getMobileNumber());
        holder.driverMobile.setText(driver.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                clickUser(driver);
            }
        });

    }

    @Override
    public int getItemCount() {
        return drivers.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView driverName, driverMobile;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            driverName = itemView.findViewById(R.id.userName);
            driverMobile = itemView.findViewById(R.id.userId);

        }
    }


    private void clickUser(UserDetails driver) {



        AlertDialog.Builder dialog = new AlertDialog.Builder(mContext);
        View mView = LayoutInflater.from(mContext).inflate(R.layout.driver_view, null);
        dialog.setView(mView);

        String driverId = driver.getUserName();
        Button edit, update, delete;
        TextView idText;
        driverDetails = new String[2];
        driverUpdateDetails = new String[2];

        update = mView.findViewById(R.id.btnUpdate);
        edit = mView.findViewById(R.id.btnEdit);
        name = mView.findViewById(R.id.driverName);
        moblieNumber = mView.findViewById(R.id.driverMobile);
        idText = mView.findViewById(R.id.driverId);

        name.setText(driver.getName());
        moblieNumber.setText(driver.getMobileNumber());


        idText.setText(driverId);

        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference("DRIVERS");

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

                    driverUpdateDetails[0] = name.getText().toString();
                    driverUpdateDetails[1] = moblieNumber.getText().toString();


                    for (int i = 0; i <= 1; i++) {

                        if (driverDetails[i].equals(driverUpdateDetails[i])) {

                            if (i == 1) {
                                Toast.makeText(mContext, "Same Data", Toast.LENGTH_SHORT).show();
                            }

                        } else {

                            UserDetails driverDetails = new UserDetails(driverId, driverUpdateDetails[0], driverUpdateDetails[1]);


                            myRef.child(driverId).setValue(driverDetails);


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

        driverDetails[0] = name.getText().toString().trim();
        driverDetails[1] = moblieNumber.getText().toString().trim();



    }


    private void enableField(boolean b) {

        name.setEnabled(b);
        moblieNumber.setEnabled(b);



    }


}
