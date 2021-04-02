package fr.uvsq.poo.RPN;

public class apOP implements Command{
    private MoteurRPN mot;
    private String str;
    private int nbr1;
    private int nbr2;
    public apOP(MoteurRPN mot,String str){
        this.mot = mot;
        this.str = str;
    }
    public apOP(MoteurRPN mot){
        this.mot = mot;

    }
    public void setStr(String str) {
        this.str = str ;
    }

    @Override
    public void execute() {
        this.mot.apOP(str);
    }

    @Override
    public void modify(String avr) {
        setStr(avr);

    }

    public void modify(int nbr1,int nbr2){
        this.nbr1 = nbr1;
        this.nbr2 = nbr2;
    }

    @Override
    public void undo() {
        this.mot.apOPUndo(nbr1,nbr2);
    }
}
