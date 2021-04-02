package fr.uvsq.poo.RPN;

public class regOP implements Command {
    private MoteurRPN mot;
    private int num;
    public regOP(MoteurRPN mot,int num){
        this.mot = mot;
        this.num = num;
    }
    public regOP(MoteurRPN mot){
        this.mot = mot;
    }

    public void setNum(int num) {
        this.num = num;
    }
    @Override
    public void execute() {
        this.mot.regOP(num);
    }

    @Override
    public void modify(String avr) {
        setNum(Integer.parseInt(avr));
    }

    public void undo(){
        mot.regOPUndo();
    }

    public int getNum() {
        return num;
    }
}
