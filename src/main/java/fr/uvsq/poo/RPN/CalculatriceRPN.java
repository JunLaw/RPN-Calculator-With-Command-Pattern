package fr.uvsq.poo.RPN;

public class CalculatriceRPN {
    public static void main(String[] args){
        Invoker in = new Invoker();
        MoteurRPN motRPN = new MoteurRPN(in);
        Command apOP = new apOP(motRPN);
        Command retOP = new retOP(motRPN);
        Command regOP = new regOP(motRPN);
        Command exit = new Exit(motRPN);

        in.register("apOP",apOP);
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
