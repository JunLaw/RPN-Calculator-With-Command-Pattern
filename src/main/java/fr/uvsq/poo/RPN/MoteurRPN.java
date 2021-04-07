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
        if(stackRPN != null) {
            history.add( stackRPN);
        }
        stackRPN.add(num);
    }

    public void regOPUndo(){
        stackRPN.pop();
    }

}
