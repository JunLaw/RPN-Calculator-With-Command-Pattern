package fr.uvsq.poo.RPN;

public class Minus extends apOP {
    public Minus(MoteurRPN mot) {
        super(mot, "-");
    }

    @Override
    protected int operate(int nbr1,int nbr2) {
        this.nbr1 = nbr1;
        this.nbr2 = nbr2;
        return nbr1 - nbr2;
    }
}

