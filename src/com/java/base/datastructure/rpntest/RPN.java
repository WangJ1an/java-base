package com.java.base.datastructure.rpntest;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by 1 on 2017/3/29.
 */
public class RPN {

    private static HashMap<String,LinkedList<String>> hashMap = new HashMap<>();

    // 比较operator运算符优先级
    private static boolean lessLevel(String peek, String ch) {

        String str1 = "+-";
        String str2 = "*/";

        if (str2.contains(ch) && str1.contains(peek)) {
            return true;
        }

        return false;
    }

    private static boolean isNumber(String str) {
        return str.matches("[0-9]+");
    }

    private static boolean isOperator(String str) {
        return !isNumber(str);
    }

    private static LinkedList<String> toList(String data) {
        LinkedList<String> linkedList = new LinkedList<>();
        for (int i = 0; i < data.length(); i++) {
            char ch = data.charAt(i);
            String str = String.valueOf(ch);
            if (isNumber(str)) {
                StringBuffer sbtemp = new StringBuffer();
                while (!isOperator(str)) {
                    sbtemp.append(ch);
                    if (i == data.length() - 1) {
                        break;
                    }
                    ch = data.charAt(++i);
                    str = String.valueOf(ch);
                }
                linkedList.add(sbtemp.toString());
            }
            if (isOperator(str)) {
                linkedList.add(String.valueOf(ch));
            }
        }
        return linkedList;
    }

    public static String polish(String data) {
        //采用链表解析字符串，为了支持多位运算
        LinkedList<String> list1 = toList(data);

        //存放运算符的栈
        Stack<String> stack = new Stack<>();

        //采用链表存储逆波兰式，方便后面calculate方法计算逆波兰式
        LinkedList<String> list2 = new LinkedList<>();

        //返回的字符串形式的逆波兰式
        StringBuffer sb = new StringBuffer();
        while (!list1.isEmpty()){
            String string = list1.pollFirst();
            if (isNumber(string)) {
                list2.add(string);
                sb.append(string);
            }
            if (string.equals("(")) {
                while (!string.equals(")")) {
                    if (isNumber(string)) {
                        list2.add(string);
                        sb.append(string);

                    } else {
                        stack.push(string);
                    }
                    string = list1.pollFirst();
                }
            }
            if (string.equals(")")) {
                while(!(stack.peek().equals("("))) {
                    list2.add(stack.peek());
                    sb.append(stack.pop());
                }
                stack.pop();
                continue;
            }
            if (isOperator(string)) {
                if (stack.isEmpty()) {
                    stack.push(string);
                    continue;
                }
                if (lessLevel(stack.peek(),string)) {
                    stack.push(string);
                    continue;
                }
                while (!stack.isEmpty() && !lessLevel(stack.peek(),string)) {
                    list2.add(stack.peek());
                    sb.append(stack.pop());

                }
                stack.push(string);
            }
        }
        while (!stack.isEmpty()) {
            list2.add(stack.peek());
            sb.append(stack.pop());

        }

//        HashMap存储字符串形式的逆波兰式对应的链表存储的逆波兰式
        hashMap.put(sb.toString(),list2);
        return sb.toString();
    }

    public static int calculate(String rpn) {
        LinkedList<String> list = hashMap.get(rpn);
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        while (!list.isEmpty()) {
            String str = list.pollFirst();
            if (isNumber(str)) {
                stack.push(Integer.valueOf(str));
                continue;
            }
            if (isOperator(str)) {
                int temp1 = stack.pop();
                int temp2 = stack.pop();
                result = calculate0(temp1,temp2,str);
                stack.push(result);
            }
        }
        return result;
    }

    //运算方式
    private static int calculate0(int data1, int data2, String op) {
        int result = 0;
        switch (op) {
            case "+" :
                result = data2 + data1;
                break;
            case "-" :
                result = data2 - data1;
                break;
            case "*" :
                result = data2 * data1;
                break;
            case "/" :
                result = data2 / data1;
                break;
            default :
                System.out.println("运算符错误");
        }
        return result;
    }
}


