package com.example.wskpoliceapplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CriminalData {
    public static HashMap<String, List<String>> LoadData(ArrayList<String> criminals){
        HashMap<String, List<String>> nameExp = new HashMap<>();

        List<String> categories = new ArrayList<>();
        categories.add("Detectives");
        categories.add("Date");
        List<String> paraments = new ArrayList<>();

        nameExp.put("Order", criminals);
        nameExp.put("Parametr", paraments);
        nameExp.put("Category", categories);

        return nameExp;
    }
}
