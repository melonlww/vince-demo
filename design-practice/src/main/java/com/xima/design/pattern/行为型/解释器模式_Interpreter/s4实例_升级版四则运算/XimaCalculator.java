package com.xima.design.pattern.行为型.解释器模式_Interpreter.s4实例_升级版四则运算;

import java.util.Arrays;
import java.util.Stack;

public class XimaCalculator {

private Stack<ArithmeticExpression> stack = new Stack<>();

public XimaCalculator(String expression) {
    this.parse(strToArray(expression));
}

/**
 * 将字符串解析成数组
 */
public static String[] strToArray(String expression){

    String[] elements = expression.split(" ");
    System.out.println("解析成的中缀表达式：" + Arrays.toString(elements));
    return toPostOrder(elements);
}

/**
 * 解析表达式
 */
private void parse(String[] elements) {

    ArithmeticExpression leftExpr, rightExpr;
    for (int i = 0; i < elements.length ; i++) {
        String operator = elements[i];
        if (OperatorUtil.isOperator(operator)){
            rightExpr = this.stack.pop();
            leftExpr = this.stack.pop();
            System.out.println("出栈: " + leftExpr.interpret() + " 和 " + rightExpr.interpret());
            this.stack.push(OperatorUtil.getInterpreter(leftExpr, rightExpr,operator));
            System.out.println("应用运算符: " + operator);
        }
        else{
            NumExpression numInterpreter = new NumExpression(Integer.valueOf(elements[i]));
            this.stack.push(numInterpreter);
            System.out.println("入栈: " + numInterpreter.interpret());
        }
    }
}

public int calculate() {

    return this.stack.pop().interpret();
}

/*
 * 将中缀表达式转为后缀表达式,返回的是字符串数组
 */
public static String[] toPostOrder(String[] arrays){
    /*规则：
     * 1，运算数直接输出
     * 2，左括号压入堆栈
     * 3，右括号 将栈顶的运算符弹出并输出，括号出栈不输出
     * 4，运算符：
     *    若优先级大于栈顶运算符，压入栈
     *    若优先级小于或等于栈顶运算符，栈顶运算符弹出并输出，
     *       继续和新栈顶比较，直到比栈顶运算符优先级大，将它压入栈
     * 5，对象处理完毕后，将栈中运算符弹出并输出
     */
    Stack<String> operStack = new Stack();//创建了一个操作符的栈
    int arraysLength = arrays.length;
    String[] arrays2 = new String[arraysLength];//输出后的字符数组
    int tempIndex = 0;

    //将字符串数组遍历
    for(int i = 0; i < arraysLength; i++){
        //操作符入栈
        if(OperatorUtil.isOperator(arrays[i])){
            //栈为空时直接入栈
            if(operStack.isEmpty()){
                operStack.push(arrays[i]);
            }
            else{
                //操作符为"("时直接入栈
                if(OperatorUtil.isLeftParentheses(arrays[i])){
                    operStack.push(arrays[i]);
                }
                //操作符为")"时栈顶出栈并输出，直到遇到"(", "("出栈,")"不入栈
                else if(OperatorUtil.isRightParentheses(arrays[i])){
                    while(!OperatorUtil.isLeftParentheses(operStack.peek())){
                        arrays2[tempIndex] = operStack.pop();
                        tempIndex += 1;
                    }
                    operStack.pop();//"("出栈
                }
                //其他操作符需要比较与栈顶的优先级
                else{
                    //栈顶是"(", 直接入栈
                    if(OperatorUtil.isLeftParentheses(operStack.peek())){
                        operStack.push(arrays[i]);
                    }
                    else{
                        //优先级高，直接入栈
                        if(OperatorUtil.getPriority(arrays[i].charAt(0)) > OperatorUtil.getPriority(operStack.peek().charAt(0))
                                && operStack.isEmpty() == false ){
                            operStack.push(arrays[i]);
                        }
                        //优先级低或者相等，栈顶出栈并输出，直到优先级比栈顶高
                        else{
                            while(OperatorUtil.getPriority(arrays[i].charAt(0)) <= OperatorUtil.getPriority(operStack.peek().charAt(0))
                                    && operStack.isEmpty() == false){
                                arrays2[tempIndex] = operStack.pop();
                                tempIndex += 1;
                                //若栈顶全部弹出，则直接入栈
                                if(operStack.isEmpty()) {
                                    operStack.push(arrays[i]);
                                    break;
                                }
                            }
                            if(OperatorUtil.getPriority(arrays[i].charAt(0)) > OperatorUtil.getPriority(operStack.peek().charAt(0))){
                                operStack.push(arrays[i]);
                            }
                        }
                    }
                }
            }
        }
        //操作数直接添加到 字符串数组2
        else if(OperatorUtil.isNum(arrays[i])){
            arrays2[tempIndex] = arrays[i];
            tempIndex += 1;
        }
        else{
        }
    }
    while(!operStack.isEmpty()){
        arrays2[tempIndex] = operStack.pop();
        tempIndex += 1;
    }
    String[] arrays3 = new String[tempIndex];
    for(int i = 0; i < tempIndex ;i++){
        arrays3[i] = arrays2[i];
    }
    return arrays3;
}
}