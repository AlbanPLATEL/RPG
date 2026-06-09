import java.io.*;
import java.util.*;


public class Player extends Entité implements Combattable, Saveable {
    private int age;
    private int HP;
    private int XP;
    private int PM;
    private int défense;
    private int or;
    private int niveau;
    private Statistique statistiques;
    private Equipement équipement;
    private List<Effet> effetsActifs;
    private int pointsCompétence;

    public Player() {
    }

    public void ouvrirInterface(Interface o) {
        // TODO implement here
    }

    public void attaquerEnnemi(Ennemi e) {
        // TODO implement here
    }

    public void accepterQuete(Quête q) {
        // TODO implement here
    }

    public void récupérerButin() {
        // TODO implement here
    }

    public void gagnerXP() {
        // TODO implement here
    }

    public void choisirClasse(Classe c) {
        // TODO implement here
    }

    public void choisirArchétype(Archétype c) {
        // TODO implement here
    }

    public void choisirRace(Race c) {
        // TODO implement here
    }

    public void lancerSorts(Sorts s) {
        // TODO implement here
    }

    public int getNiveau() {
        // TODO
        return 0; implement here
    }

    public int getExperience() {
        // TODO
        return 0; implement here
    }

    public Statistique getStatistiques() {
        // TODO
        return null; implement here
    }

    public void appliquerEffet() {
        // TODO implement here
    }

    public void acheter() {
        // TODO implement here
    }

    public void vendre() {
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

    public void sauvegarder() {
        // TODO implement Saveable.sauvegarder() here
    }

    public void charger() {
        // TODO implement Saveable.charger() here
    }
}