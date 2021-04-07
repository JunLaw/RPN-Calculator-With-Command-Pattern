package fr.uvsq.poo.RPN;

import static org.junit.Assert.*;
import java.util.Stack;
import org.junit.Before;


public class RPN_Test {

    @Before
    public void setup(){
        Invoker in = new Invoker();
        MoteurRPN moteur = new MoteurRPN(in);
    }
}
