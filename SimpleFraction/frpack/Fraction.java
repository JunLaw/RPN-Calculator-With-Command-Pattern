package frpack;

public class Fraction {
    
    private int num;
    private int den;
    
    public Fraction(int a, int b){
        num = a;
        den = b;
        
    }

@Override
    public String toString() {
    return ("numerateur = "+num+" denominateur = "+den);
}
}