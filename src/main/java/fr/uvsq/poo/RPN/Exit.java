package fr.uvsq.poo.RPN;

public class Exit implements Command{
    private MoteurRPN inter;

    public Exit(MoteurRPN inter){
        this.inter = inter;
    }

    @Override
    public void execute() {
        this.inter.exit();
    }

    @Override
    public void modify(String avr) {
    }

    public void undo(){}
}
