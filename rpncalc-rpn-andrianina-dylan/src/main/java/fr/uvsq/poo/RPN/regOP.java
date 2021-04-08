package fr.uvsq.poo.RPN;

public class regOP implements Command,Cloneable {
    private MoteurRPN mot;
    private int num;
    public regOP(MoteurRPN mot,int num){
        this.mot = mot;
        this.num = num;
    }
    public regOP(MoteurRPN mot){
        this.mot = mot;
    }

    @Override
    public void execute() {
        this.mot.regOP(num);
    }

    public void undo(){
        mot.regOPUndo();
    }

    @Override
    public void modify(String avr) {

    }

    public int getNum() {
        return num;
    }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
