package com.example.wskpoliceapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class DepartamentAdapter extends ArrayAdapter<Departament> {
    private LayoutInflater inflater;
    private int layout;
    private ArrayList<Departament>departaments;
    public DepartamentAdapter(@NonNull Context context, int resource, ArrayList<Departament> depart) {
        super(context, resource, depart);
        this.departaments = depart;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }
    public View getView(int position, View convertView, ViewGroup parent){
        View view = inflater.inflate(this.layout, parent, false);
        TextView name = (TextView)view.findViewById(R.id.dep_name);
        TextView address = (TextView)view.findViewById(R.id.dep_address);
        Departament departament = departaments.get(position);

        name.setText(departament.name);
        address.setText(departament.address);
        return view;

    }
}
