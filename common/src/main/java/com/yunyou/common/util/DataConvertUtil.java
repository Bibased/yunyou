package com.yunyou.common.util;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by lds on 2017/4/13.
 */
public class DataConvertUtil {
    public static final String BORDER_CHAR = "\255";
    public static List<String> toList(String src){
        List<String> ret =  Arrays.asList(src.split(BORDER_CHAR));
        return ret;
    }
    public static String fromList(List<String> src){
        return src.stream().reduce("",(a,b)->a+b+BORDER_CHAR);
    }
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello-world","-bagas");
        String str = fromList(list);
        System.out.println(str);
        list = toList(str);
        System.out.println();
    }
    public static String fromDate(Date date){
        SimpleDateFormat format = new SimpleDateFormat("MM/dd HH:mm");
        return format.format(date);
    }
}
