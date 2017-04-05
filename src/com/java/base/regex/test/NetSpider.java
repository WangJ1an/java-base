package com.java.base.regex.test;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 1 on 2017/4/2.
 */
public class NetSpider {
    /*
    * 网络爬虫：其实就是一个应用程序，获取网络中的指定信息（符合指定规则的信息）
    *
    * 网络中的邮件地址
    *
    * */

    public static void main(String[] args) throws Exception {
        String url = "http://bbs.tianya.cn/post-enterprise-401802-5.shtml";
        String regex = "\\w+@\\w+(\\.\\w+)+";
        List<String> list = getMailByNet(url,regex);
        for (String mail :
                list) {
            System.out.println(mail);
        }
    }
    //基于网络
    public static List<String> getMailByNet(String str_url,String regex) throws Exception {

        List<String> list = new ArrayList<>();

        URL url = new URL(str_url);

        URLConnection conn = url.openConnection();

        InputStream in = conn.getInputStream();
        BufferedReader bufin = new BufferedReader(new InputStreamReader(in));

        Pattern p = Pattern.compile(regex);

        String line = null;
        while ((line = bufin.readLine()) != null) {
            Matcher m = p.matcher(line);
            while (m.find()) {
                list.add(m.group());
            }
        }
        return list;
    }

    //基于文件
    public static List<String> getMails(File file, String regex) throws Exception {

        List<String> list = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(file));

        Pattern p = Pattern.compile(regex);
        String line = null;
        while ((line = br.readLine()) != null) {
            Matcher m = p.matcher(line);
            while (m.find()) {
                list.add(m.group());
            }
        }
        return list;
    }
}
