package com.xima.data_structure.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class 四则运算 {
    private Map<String, Integer> operatorLevelMap = Map.of("+", 1, "-", 1, "*", 2, "/", 2, "tail", 0);

    private Stack<String> operatorStack = new Stack();
    private Stack<Integer> dataStack = new Stack();

    private List<String> buildData(String publicity) {
        List<String> operationPublicityList = new ArrayList<>();
        int i = 0;
        StringBuilder data = new StringBuilder();
        while (i < publicity.length()) {
            char c = publicity.charAt(i);
            if (operatorLevelMap.get(String.valueOf(c)) != null) {
                operationPublicityList.add(data.toString());
                operationPublicityList.add(String.valueOf(c));

                data = new StringBuilder();
            } else {
                data = data.append(c);
            }
            i++;
        }

        if(data.length()>0){
            operationPublicityList.add(data.toString());
        }

        return operationPublicityList;
    }


    private void operate(String c) {
        if (operatorLevelMap.get(String.valueOf(c)) != null) {
            if(operatorStack.size() ==0){
                operatorStack.push(c);
                return;
            }

            String lastOperator = operatorStack.peek();

            //操作符号优先级高于栈头符号优先级 则入栈
            if (operatorLevelMap.get(String.valueOf(c))> operatorLevelMap.get(lastOperator)) {
                if (c != "tail") {
                    operatorStack.push(c);
                }
            } else {
                //否则取出操作数栈头前两个数，进行计算 并且入栈
                if(dataStack.size()>=2) {
                    Integer num2 = dataStack.pop();
                    Integer num1 = dataStack.pop();

                    String lastOperator2 = operatorStack.pop();
                    Integer result = calc(num1, num2, lastOperator2);
                    dataStack.push(result);
                }
                if (c != "tail") {
                    operatorStack.push(c);
                }
            }
        } else {
            dataStack.push(Integer.valueOf(c));
        }
    }

    private Integer calc(Integer num1, Integer num2, String operator) {
        Integer result = 0;
        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            default:
                result = 0;
        }
        return result;
    }


    public static void main(String[] args) {
        String operationPublicity = "25*32-1+2/1";
        四则运算 s = new 四则运算();


        List<String> dataList = s.buildData(operationPublicity);
        System.out.println(dataList);
        for (String c : dataList) {
            s.operate(c);
        }

        //计算剩余数据
        while(s.operatorStack.size()>0){
            s.operate("tail");
        }
        System.out.println(s.dataStack.pop());
    }

}
