import java.util.*;

public class Player extends Entite {
    private int HP;
    private int XP;
    private int PM;
    private int armure;
    private int bouclier;
    private int OR;
    private int niveau;
    private Statistique statistiques;
    private Equipement equipement;
    private List<Effet> effetsActifs;
    private int pointsCompetence;
    private Inventaire inventaire;

    public Player() {
        super();
        Random random = new Random();
        HP = 100;
        armure = random.nextInt(4);
        this.nom = "Aventurier";
        niveau = 0;
        XP = 0;
        inventaire = new Inventaire();
        OR = 0;
    }

    public void attaquerEnnemi(Ennemi ennemi) {
        Random random = new Random();
        int degats = random.nextInt(11);
        int nouveauEnnemiHP = ennemi.getHP() - degats;
        ennemi.setHP(Math.max(0, nouveauEnnemiHP)); // Empêche les HP négatifs
        System.out.println("\nVous frappez l'ennemi et lui infligez " + degats + " dégâts !" );

        if (ennemi.getHP() <= 0){
            System.out.println("Mort de l'ennemi !");
            gagnerLoot(ennemi);
        }
    }

    public void defendreEnnemi(Ennemi ennemi) {
        Random random = new Random();
        System.out.println("Vous vous protégez avec votre bouclier.");
        int valeurBouclier = random.nextInt(6);
        this.setBouclier(valeurBouclier);
        System.out.println("Vous levez votre bouclier : " + valeurBouclier);
    }

    public void jouerTour(Ennemi ennemi, Scanner scanner) {
        System.out.print("\nVotre choix : ");
        int choix = 0;
        try {
            choix = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Entrée invalide.");
        }
        if (choix == 1) {
            //Logique d'attaque
            this.setBouclier(0);
            attaquerEnnemi(ennemi);
        }
        else if (choix == 2) {
            // Logique du bouclier
            defendreEnnemi(ennemi);
        }
        else if (choix == 3) {
            inventaire.ouvrirInventaire(scanner);
        }
    }

    public void ouvrirInventaire(Scanner scanner) {
        inventaire.ouvrirInventaire(scanner);
    }

    public void accepterQuete(Quête q) {
        // TODO implement here
    }

    public void récupérerButin() {
        // TODO implement here
    }

    public void gagnerLoot(Ennemi ennemi) {
       this.XP = ennemi.getXP();
       this.OR = ennemi.getOR();
    }

    public void niveau(){
        if (XP == 100){
         niveau++;
         System.out.println("Félicitation ! Vous avez gagner un niveau.");
        }
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

    public void appliquerEffet() {
        // TODO implement here
    }

    public void acheter() {
        // TODO implement here
    }

    public void vendre() {
        // TODO implement here
    }

    public void utiliserConsommables(Consommables c) {
        // TODO implement here
    }

    public void utiliserNonConsommables(NonConsommables c) {
        // TODO implement here
    }

    public void equiperArmes(Armes a ) {
        // TODO implement here
    }

    public void equiperArmure() {
        // TODO implement here
    }

    public void equiperBouclier() {
        // TODO implement here
    }

    public boolean estVivant() {
        return HP > 0;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public int getXP() {
        return XP;
    }

    public void setXP(int XP) {
        this.XP = XP;
    }

    public int getOR() {
        return OR;
    }

    public void setOR(int OR) {
        this.OR = OR;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getArmure() {
        return armure;
    }

    public int setArmure(int armure) {
        this.armure = armure;
        return this.armure;
    }

    public int getBouclier() {
        return bouclier;
    }

    public int setBouclier(int bouclier) {
        this.bouclier = bouclier;
        return this.bouclier;
    }

    @Override
    public String getNom() {
        return (this.nom == null || this.nom.isEmpty()) ? "Aventurier" : this.nom;
    }
}