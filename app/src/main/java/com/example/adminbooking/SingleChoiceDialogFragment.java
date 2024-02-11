package com.example.adminbooking;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class SingleChoiceDialogFragment extends DialogFragment {

    private static SingleChoiceDialogFragment mInstance = null;
    private String title ;
    private int value;
    private int index;

    public SingleChoiceDialogFragment(String title, int value, int index) {
        this.title = title;
        this.value = value;
        this.index = index;
    }




    int position = 0;

    public interface SingleChoiceListener{
        void onPositiveButtonClicked(String[] list, int position, int index);
        void onNegativeButtonClicked(int index);
    }

    SingleChoiceListener mListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (SingleChoiceListener) context;
        }catch (Exception e) {
            throw new ClassCastException(getActivity().toString() + "SingleChoiceListner must Implemented");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        final String[] list = getActivity().getResources().getStringArray(value);

        builder.setTitle(title);

        builder.setSingleChoiceItems(list, position, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                position = which;
            }
        });
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mListener.onPositiveButtonClicked(list,position,index);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mListener.onNegativeButtonClicked(index);

            }
        });

        return builder.create();
    }




}

