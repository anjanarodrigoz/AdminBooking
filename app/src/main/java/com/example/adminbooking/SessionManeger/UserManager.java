package com.example.adminbooking.SessionManeger;

import android.content.Context;
import android.content.SharedPreferences;

public class UserManager {

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private static UserManager instance;
    private Context context;

    private UserManager(Context context){
        this.context = context;
        sharedPreferences = context.getSharedPreferences("LOGIN",Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.apply();
    }

    public static UserManager getInstance(Context context){

        if(instance == null){
            instance = new UserManager(context);
        }

        return instance;
    }

    public void setUserId(String id){

        editor.putString("USER_ID",id);
        editor.commit();
    }

    public String getUserId(){

        return sharedPreferences.getString("USER_ID","admin");
    }



}
