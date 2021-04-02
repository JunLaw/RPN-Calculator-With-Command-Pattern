package fr.uvsq.poo.annuaire;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CompositeGroup implements Groupe,Iterable<Groupe>,Iterator<Groupe> {
    private List<Groupe> childG = new ArrayList<Groupe>();

    @Override
    public void print() {
        for(Groupe groupe : childG){
            groupe.print();
        }
    }

    public void add(Groupe groupe){
        childG.add(groupe);
    }

    public void remove(Groupe groupe){
        childG.remove(groupe);
    }

    @Override
    public Iterator<Groupe> iterator() {
        return childG.iterator();
    }


    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Groupe next() {
        return null;
    }
}
