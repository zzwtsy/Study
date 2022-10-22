package cn.zzwtsy.sqlite;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class test {
    public static void main(String[] args) {
        String str = "#dkalsdkasl:JSESSIONID=4C8E3E7D5ECF970315AA26B8FC6143DD";
        String reg = "JSESSIONID=([0-9a-zA-Z]{32})";
        Matcher matcher = Pattern.compile(reg).matcher(str);
        if (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}