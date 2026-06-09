import java.io.*;
import java.util.*;


public class Ennemi extends Entité implements Combattable {
    private int HP;
    protected int niveau;
    protected int degatsBase;

    public Ennemi() {
    }

    public void attaquerJoueur() {
        // TODO implement here
    }

    public void attaquerFamilier() {
        // TODO implement here
    }

    public void dropLoot() {
        // TODO implement here
    }

    public void attaquer() {
        // TODO implement Combattable.attaquer() here
    }

    public void subirDegats() {
        // TODO implement Combattable.subirDegats() here
    }

    public boolean estVivant() {
        // TODO
        return false; implement Combattable.estVivant() here
    }

    public int getPuissanceAttaque() {
        // TODO
        return 0; implement Combattable.getPuissanceAttaque() here
    }
}