import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Player player = new Player();
        Ennemi ennemi = new Ennemi();
        Scanner scanner = new Scanner(System.in);
        int tour = 1;

        while (player.estVivant() && ennemi.estVivant()) {
            System.out.println("\nTour : " + tour);
            System.out.println("\nNom de l'Aventurier : " + player.getNom());
            System.out.println("HP du joueur : " + player.getHP() + " | Défense : " + player.getArmure() + " | Niveau : " + player.getNiveau() + " | XP : " + player.getXP() + " | OR : " + player.getOR());
            System.out.println("HP de l'ennemi : " + ennemi.getHP() + " | Niveau : " + player.getNiveau());
            System.out.println("\nChoisissez votre action : ");
            System.out.println("1. Attaquer");
            System.out.println("2. Défense");
            System.out.println("3. Inventaire");

            // Tour du joueur
            player.jouerTour(ennemi, scanner);

            // Tour de l'ennemi si encore en vie
            if (ennemi.estVivant()) {
                ennemi.attaquerJoueur(player);
                player.setBouclier(0);
            }

            tour++;
        }

        System.out.println("\n--- Fin du combat ---");
        ennemi.dropLoot();
        System.out.println("\nTour : " + tour);
        System.out.println("\nNom de l'Aventurier : " + player.getNom());
        System.out.println("HP du joueur : " + player.getHP() + " | Défense : " + player.getArmure() + " | Niveau : " + player.getNiveau() + " | XP : " + player.getXP() + " | OR : " + player.getOR());
        System.out.println("HP de l'ennemi : " + ennemi.getHP() + " | Niveau : " + player.getNiveau());
    }
}