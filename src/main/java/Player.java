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
    private final Inventaire inventaire;
    int monstresMort;

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
        monstresMort = 0;
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

    public boolean jouerTour(Ennemi ennemi, Scanner scanner) {
        boolean combatEnCours = true;
        System.out.print("\nVotre choix : ");
        String choix = " ";
        try {
            choix = scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Entrée invalide.");
        }
        switch (choix) {
            case "1":
                //Logique d'attaque
                this.setBouclier(0);
                attaquerEnnemi(ennemi);
                break;
            case "2":
                // Logique du bouclier
                defendreEnnemi(ennemi);
                break;
            case "3":
                //Ouverture de l'inventaire
                ouvrirInventaire(scanner);
                break;

            case "4":
                Random random = new Random();
                int number = random.nextInt(100)+1;
                if (number < 50) {
                    System.out.println("Par chance, vous avez réussi à fuir.");
                    return combatEnCours = false;
                }
                else{
                    System.out.println("Malheureusement vous n'avez pas réussi à fuir.");
                }
                break;
        }
        return true;
    }

    public void ouvrirInventaire(Scanner scanner) {
        this.inventaire.ouvrirInventaire(scanner);
    }

    public void parlerPNJ(PNJ pnj, Scanner scanner) {
        pnj.parlerJoueur(this, scanner);
    }

    public void consulterQuete(PNJ pnj, Scanner scanner) {
        if (pnj.accepterquete){
            System.out.println("==========================");
            System.out.println("   Tableau de Quêtes    ");
            System.out.println("==========================");
            System.out.println("Quête en cours : Tuez 5 monstres");
            System.out.println("Monstres tués : " + monstresMort + " / 5");
            if (monstresMort >= 5) {
                System.out.println("Bravo ! Vous avez terminé votre quête.");
                System.out.println("Retournez voir le PNJ pour récupérer votre récompense.");
            } else {
                System.out.println("Retournez au front, vous n'avez pas tué suffisamment de monstres.");
            }
        } else {
            System.out.println("Vous n'avez pas de quête en cours.");
        }
    }

    public void accepterQuete(PNJ pnj) {
        if(pnj.accepterquete = true){
            System.out.println("Vous avez accepter une quête !");
        }
    }

    public void recupererButin() {
        this.XP += PNJ.getXP();
        this.OR += PNJ.getOR();
    }

    public void gagnerLoot(Ennemi ennemi) {
       this.XP += ennemi.getXP();
       this.OR += ennemi.getOR();
    }

    public void niveau(){
        if (XP >= 100){
         niveau++;
         System.out.println("Félicitation ! Vous avez gagner un niveau.");
        }
    }

    public void utiliserItem() {
        //todo
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

    public Inventaire getInventaire() {
        return inventaire;
    }

    @Override
    public String getNom() {
        return (this.nom == null || this.nom.isEmpty()) ? "Aventurier" : this.nom;
    }
}