package com.example.wskpoliceapplication;

import android.content.Context;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class CriminalCaseAdapter extends ArrayAdapter<Criminal> {
    private LayoutInflater inflater;
    private int layout;
    private ArrayList criminals;
    public CriminalCaseAdapter(@NonNull Context context, int resource, ArrayList<Criminal> criminals) {
        super(context, resource);
        this.criminals = criminals;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }
}
