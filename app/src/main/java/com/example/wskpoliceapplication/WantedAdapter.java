package com.example.wskpoliceapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class WantedAdapter extends ArrayAdapter<Wanted> {
    private LayoutInflater inflater;
    private int layout;
    private ArrayList wandtets;
    public WantedAdapter(@NonNull Context context, int resource, ArrayList<Wanted> wanteds) {
        super(context, resource);
        this.wandtets = wanteds;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }
}
