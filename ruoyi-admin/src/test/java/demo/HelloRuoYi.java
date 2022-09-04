package demo;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.HashMap;

/**
 * @author oweson
 * @date 2021/1/17 23:00
 */


public class HelloRuoYi {
    public static void main(String[] args) {
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put(1,1);
        System.out.println("前后端分离是大趋势！");

        String s1="hi";
        String s2="hi";

        System.out.println(s1);
        System.out.println(s2);

        System.out.println(s1.concat("123"));

        System.out.println(s2);

        System.out.println(StringUtils.join(s1, ',', s2));

        BigDecimal divide = new BigDecimal("96").divide(new BigDecimal("660"),2,BigDecimal.ROUND_HALF_UP);

        System.out.println(divide);


    }
}
