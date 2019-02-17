package ru.itpark.graduate.pb.commons;

public class ParamUtils {

    private ParamUtils(){}

    public static boolean isEmpty(Object ob){
        if(ob == null){
            return true;
        } else if (ob instanceof String && ob.toString().trim().equalsIgnoreCase("")){
            return true;
        }
        return false;
    }
}
