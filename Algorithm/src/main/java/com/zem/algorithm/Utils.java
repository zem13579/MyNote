package com.zem.algorithm;

public class Utils {
    public static String transferToArr(String arr){
        return  arr.replaceAll("\\[", "{").replaceAll("\\]", "}");
    }
}
