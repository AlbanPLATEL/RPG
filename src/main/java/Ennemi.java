import java.util.Random;

public class Ennemi extends Entite {
    private int HP;
    private int niveau;
    private int degatsBase;

    public Ennemi() {
        super();
        HP = 50;
        niveau = 0;
        degatsBase = 0;
    }

    public void attaquerJoueur(Player player) {
        Random random = new Random();
        if (player.estVivant()) {
            degatsBase = random.nextInt(11);
            int defenseTotale = player.getArmure() + player.getBouclier();

            System.out.println("L'ennemi vous infliges " + degatsBase + " dégâts.");

            if (player.getBouclier() > 0) {
                System.out.println("Votre bouclier et votre armure vous protèges");
            } else if (player.getArmure() > 0) {
                System.out.println("Votre armure n'a pas suffit à arrêter l'attaque.");
            }

            // Calcul des dégâts finaux
            int degatsSubis = degatsBase - defenseTotale;

            if (degatsSubis <= 0) {
                System.out.println("\nINCROYABLE ! Votre défense a totalement absorbé l'impact.");
            } else {
                player.setHP(player.getHP() - degatsSubis);
                System.out.println("Vous perdez " + degatsSubis + " PV");

            }
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
}