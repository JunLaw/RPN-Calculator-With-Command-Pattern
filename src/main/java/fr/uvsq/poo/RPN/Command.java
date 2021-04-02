package fr.uvsq.poo.RPN;



public interface Command{
    void execute();
    void modify(String avr);
    void undo();
}
