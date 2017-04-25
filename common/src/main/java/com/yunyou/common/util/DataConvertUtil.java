package com.yunyou.common.util;

import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
        if (StringUtils.isEmpty(src)) return new ArrayList<>();
        List<String> ret =  Arrays.asList(src.split(BORDER_CHAR));
        return ret;
    }
    public static String fromArray(String[] strings){
        if (null == strings) return "";
        return fromList(Arrays.asList(strings));
    }
    public static String fromList(List<String> src){
        if (null == src) return "";
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
        if (null == date) return "";
        SimpleDateFormat format = new SimpleDateFormat("MM/dd HH:mm");
        return format.format(date);
    }
}
