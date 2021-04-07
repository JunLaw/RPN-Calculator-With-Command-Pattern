package fr.uvsq.poo.RPN;

public class retOP implements Command{
    private MoteurRPN mot;

    public retOP(MoteurRPN mot){
        this.mot = mot;
    }

    @Override
    public void execute() {
        this.mot.retOP();
    }

    public void undo(){}

    @Override
    public void modify(String avr) {
        
    }
}
