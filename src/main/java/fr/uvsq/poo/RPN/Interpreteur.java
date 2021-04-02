package fr.uvsq.poo.RPN;
import java.util.Stack;


public class Interpreteur {
      private Invoker in;
        public Interpreteur(Invoker in)
        {
            this.in = in;
        }
    public void undo(String name){
            Command a = in.get(name);
            a.undo();

    }
    public void exit(){
        System.out.println("exit");
        System.exit(0);
    }
}
