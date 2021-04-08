package fr.uvsq.poo.RPN;

import java.util.Stack;

public class MoteurRPN extends Interpreteur {
    private Stack<Integer> stackRPN;
    MoteurRPN(Invoker in)
    {
        super(in);
        stackRPN = new Stack<Integer>();

    }

    public Boolean apOP(apOP apOP){
        return true;
    }

    public boolean apOPUndo(int nbr1,int nbr2){
        /*pop le dernier nombre reinserer les deux derniers int */
        stackRPN.pop();
        stackRPN.push(nbr2);
        stackRPN.push(nbr1);
        return true;
    }

    public void regOP(int num){
        stackRPN.add(num);
    }

    public void regOPUndo(){
        stackRPN.pop();
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

}
