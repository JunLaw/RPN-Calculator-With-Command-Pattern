package fr.uvsq.poo.RPN;

public class Plus extends apOP {
    public Plus(MoteurRPN mot) {
        super(mot, "+");
    }

    @Override
    protected int operate(int nbr1,int nbr2) {
        super.operate(nbr1,nbr2);
        return nbr1 + nbr2;
    }
}
