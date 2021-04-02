package fr.uvsq.poo.RPN;

import java.util.Stack;


public class MoteurRPN extends Interpreteur {
   private Stack<Integer> stackRPN;
    private Stack<Stack<Integer>> history;
    MoteurRPN(Invoker in)
    {
        super(in);
        stackRPN = new Stack<Integer>();
        history = new Stack<Stack<Integer>>();
    }

    public void regOP(int num){
        if(stackRPN != null) {
            history.add( stackRPN);
        }
       stackRPN.add(num);
    }

    public Boolean apOP(String op){
        if(stackRPN != null) {
            history.add((Stack<Integer>) stackRPN.clone());
        }
        if(stackRPN.size() < 2){
            System.out.println("not enough number in stack");
            return false;
        }
        switch(op){
            case "+":
                stackRPN.push(stackRPN.pop() + stackRPN.pop());
                break;
            case "-":
                stackRPN.push(stackRPN.pop() - stackRPN.pop());
                break;
            case "/":
                stackRPN.push(stackRPN.pop() / stackRPN.pop());
                break;
            case "*":
                stackRPN.push(stackRPN.pop() * stackRPN.pop());
                break;
            default:
                System.out.println("not an operand");
                break;
        }
    return true;
    }

    public boolean apOPUndo(int nbr1,int nbr2){
        /*pop le dernier nombre reinserer les deux derniers int */
        stackRPN.pop();
        stackRPN.push(nbr1);
        stackRPN.push(nbr2);
        return true;
    }

    public Stack<Integer> retOP(){
        Stack<Integer> cpy = new Stack<Integer>();
        cpy = (Stack<Integer>) stackRPN.clone();
        if(cpy.isEmpty()){
            System.out.println("empty");
            return stackRPN;
        }
        while(!cpy.isEmpty()){
            System.out.println(cpy.pop());
        }
        return stackRPN;
    }

    public void regOPUndo(){
            stackRPN.pop();
    }

    public Stack<Integer> getState(){
        if(history.isEmpty()){
            System.out.println("no content on stack available");
            Stack<Integer> integers = new Stack<>();

            return integers;
        }
        Stack<Integer> cpy = history.get(history.size()-1);
        for(int i = 0;i<history.size();i++){
            System.out.println(history.get(i));
        }
        history.pop();
        return cpy;
    }

    public void Switch(){
        stackRPN.clear();
        stackRPN = getState();
    }
}
