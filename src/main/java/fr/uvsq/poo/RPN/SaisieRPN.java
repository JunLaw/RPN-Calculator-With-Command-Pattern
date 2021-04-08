package fr.uvsq.poo.RPN;

import java.util.Scanner;

public class SaisieRPN {
    MoteurRPN rpn;
    Scanner scan = new Scanner(System.in);
    Invoker in;

    public SaisieRPN(Invoker in,MoteurRPN rpn){
        this.rpn = rpn;
        this.in = in;
    }

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}
