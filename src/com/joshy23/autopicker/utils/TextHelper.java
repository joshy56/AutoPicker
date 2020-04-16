package com.joshy23.autopicker.utils;

import com.joshy23.autopicker.AutoPicker;

import java.util.ArrayList;
import java.util.List;

public class TextHelper {

    public static ArrayList<String> getColorList(String[] messages){
        ArrayList<String> list = new ArrayList<>();
        for(String message:messages){
            list.add(AutoPicker.getColor(message));
        }
        return list;
    }

    public static ArrayList<String> getColorList(List<String> messages){
        ArrayList<String> list = new ArrayList<>();
        for(String message:messages){
            list.add(AutoPicker.getColor(message));
        }
        return list;
    }

}
