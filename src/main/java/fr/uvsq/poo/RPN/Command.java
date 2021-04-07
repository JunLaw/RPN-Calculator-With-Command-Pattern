package fr.uvsq.poo.RPN;

public interface Command {
    void execute();
    void undo();
    void modify(String avr);
}
