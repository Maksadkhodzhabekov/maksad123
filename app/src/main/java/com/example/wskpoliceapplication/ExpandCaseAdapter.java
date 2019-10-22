package com.example.wskpoliceapplication;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class ExpandCaseAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<String>expListTitle;
    private HashMap<String, List<String>> expListDetail;

    public ExpandCaseAdapter(Context context, List<String> expListTitle, HashMap<String, List<String>> expListDetail){
        this.context = context;
        this.expListTitle = expListTitle;
        this.expListDetail = expListDetail;
    }
    @Override
    public int getGroupCount() {
        return expListTitle.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return expListDetail.get(expListTitle.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return expListTitle.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return expListDetail.get(expListTitle.get(i)).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        String listTitle = (String)getGroup(i);
        if(view == null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.category_list, null);
        }
        TextView listTitleText = (TextView)view.findViewById(R.id.catlist);
        listTitleText.setTypeface(null, Typeface.BOLD);
        listTitleText.setText(listTitle);
        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String expListText = (String)getChild(groupPosition, childPosition);
        if(convertView== null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView= inflater.inflate(R.layout.category_list, null);
        }
        TextView expText = (TextView)convertView.findViewById(R.id.catlist);
        expText.setText(expListText);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
