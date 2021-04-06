package fr.uvsq.poo.RPN;

public class CalculatriceRPN {
    public static void main(String[] args){
        Invoker in = new Invoker();
        MoteurRPN motRPN = new MoteurRPN(in);
        Command apOP = new apOP(motRPN);
        Command retOP = new retOP(motRPN);
        Command regOP = new regOP(motRPN);
        Command exit = new Exit(motRPN);
        Command plus = new Plus(motRPN);
        Command minus = new Minus(motRPN);
        Command times = new Times(motRPN);
        Command divide = new Divide(motRPN);
        in.register("Plus",plus);
        in.register("Minus",minus);
        in.register("Times",times);
        in.register("Divide",divide);
        in.register("retOP",retOP);
        in.register("regOP",regOP);
        in.register("exit",exit);
        SaisieRPN saisie = new SaisieRPN(in,motRPN);
        boolean i = saisie.read();
        if(!i){
            System.out.println("operation unsuccessful");
        }else{
            System.out.println("operation successful");
        }

    }
}
