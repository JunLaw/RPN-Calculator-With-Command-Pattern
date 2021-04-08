package fr.uvsq.poo.RPN;

public class Exit implements Command{
    private MoteurRPN mot;

    public Exit(MoteurRPN inter){
        this.mot = inter;
    }

    @Override
    public void execute() {
        this.mot.exit();
    }



    public void undo(){}

    @Override
    public void modify(String avr) {


    }
}
