import java.util.Random;

public class Ennemi extends Entite {
    private int HP;
    private int niveau;
    private int degatsBase;
    private int OR;
    private int XP;

    public Ennemi() {
        super();
        Random random = new Random();
        HP = 50;
        niveau = 0;
        degatsBase = 0;
        OR = random.nextInt(5)+1;
        XP = random.nextInt(5)+1;
    }

    public void attaquerJoueur(Player player) {
        Random random = new Random();
        if (player.estVivant()) {
            degatsBase = random.nextInt(11);
            int defenseTotale = player.getArmure() + player.getBouclier();

            System.out.println("L'ennemi vous infliges " + degatsBase + " dégâts.");

            if (player.getBouclier() > 0) {
                System.out.println("Votre bouclier vous protèges.");
            } else if (player.getArmure() > 0) {
                System.out.println("Votre armure vous protèges.");
            }

            // Calcul des dégâts finaux
            int degatsSubis = degatsBase - defenseTotale;

            if (degatsSubis <= 0) {
                System.out.println("\nHeureusement que votre bouclier a totalement absorbé l'impact.");
            } else {
                player.setHP(player.getHP() - degatsSubis);
                System.out.println("Vous perdez " + degatsSubis + " PV");

            }
        }
    }

    public void dropLoot() {
        Random random = new Random();
        if (!estVivant()) {
            System.out.println("VICTOIRE ! Vous avez vaincu le monstre.");
            System.out.println("Vous avez gagné " + getXP() + " xp et " + getOR() + " or.");
        } else {
            System.out.println("DEFAITE... Votre quête s'achève ici, Aventurier.");
        }
    }

    public boolean estVivant() {
        return HP > 0;
    }

    public void recevoirDegats(Player attaquerEnnemi) {
        this.HP -= attaquerEnnemi.getHP();
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public int getOR() {
        return OR;
    }
    public void setOR(int OR) {
        this.OR = OR;
    }

    public int getXP() {
        return XP;
    }

    public void setXP(int XP) {
        this.XP = XP;
    }
}