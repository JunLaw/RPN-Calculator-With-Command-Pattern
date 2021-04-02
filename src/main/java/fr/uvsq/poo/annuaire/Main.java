package fr.uvsq.poo.annuaire;

import java.time.LocalDate;
import java.util.HashMap;

public class Main {
    public static void main( String[] args ) {
        HashMap<String,Integer> num = new HashMap<String,Integer>();
        num.put("tel", Integer.valueOf("0633891267"));
        num.put("dom", Integer.valueOf("0633891268"));
        num.put("pro", Integer.valueOf("0633891269"));
        HashMap<String,Integer> num1 = new HashMap<String,Integer>();
        num1.put("tel", Integer.valueOf("0633891263"));
        num1.put("dom", Integer.valueOf("0633891264"));
        num1.put("pro", Integer.valueOf("0633891265"));
        HashMap<String,Integer> num2 = new HashMap<String,Integer>();
        num2.put("tel", Integer.valueOf("0633891270"));
        num2.put("dom", Integer.valueOf("0633891271"));
        num2.put("pro", Integer.valueOf("0633891272"));
        Personnel p = new Personnel.Builder("dupont","jean","directeur", LocalDate.of(1989,2,27)).numTels(num).build();
        Personnel p1 = new Personnel.Builder("lin","lina","marketing", LocalDate.of(1929,4,17)).numTels(num1).build();
        Personnel p2 = new Personnel.Builder("emma","fila","chargé", LocalDate.of(1997,1,12)).numTels(num2).build();
        Personnel p3 = new Personnel.Builder("nicolas","paris","rh", LocalDate.of(2000,7,19)).numTels(num).build();
        Personnel p4 = new Personnel.Builder("raymond","claude","informatique", LocalDate.of(1967,8,27)).numTels(num1).build();
        Personnel p5 = new Personnel.Builder("emie","baki","avocat", LocalDate.of(1995,3,9)).numTels(num2).build();

        CompositeGroup g = new CompositeGroup();
        CompositeGroup g1 = new CompositeGroup();
        CompositeGroup g2 = new CompositeGroup();
        CompositeGroup g3 = new CompositeGroup();

        g1.add(p);
        g1.add(p1);
        g2.add(p2);
        g2.add(p3);
        g3.add(p4);
        g3.add(p5);

        g.add(g1);
        g.add(g2);
        g1.add(g3);

        String str = "oui";

        System.out.println(Integer.parseInt(str));

        //g.print();
        //g.printD();

    }

}
