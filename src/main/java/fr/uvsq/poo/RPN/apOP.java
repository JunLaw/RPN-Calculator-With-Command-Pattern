package fr.uvsq.poo.RPN;

public class apOP implements Command,Cloneable {
    protected MoteurRPN mot;
    protected String str;
    protected int nbr1;
    protected int nbr2;
    public apOP(MoteurRPN mot,String str){
        this.mot = mot;
        this.str = str;
    }
    public apOP(MoteurRPN mot){
        this.mot = mot;

    }
    @Override
    public void execute() {
        this.mot.apOP(this);
    }

    @Override
    public void undo() {
        this.mot.apOPUndo(nbr1,nbr2);
    }

    @Override
    public void modify(String avr) {
        this.str = avr;
    }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    protected int operate(int nbr1,int nbr2){
        this.nbr1 = nbr1;
        this.nbr2 = nbr2;
        return 0;}
}
