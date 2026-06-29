import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Player player = new Player();
        PNJ pnj = new PNJ();
        Ennemi ennemi = new Ennemi();
        player.getInventaire().ajouterItem(CatalogueItems.creer("potion_soin"));
        Scanner scanner = new Scanner(System.in);
        int tour = 1;

        while (player.estVivant()) {
            System.out.println("\n".repeat(5));
            System.out.println("1. Se balader");
            System.out.println("2. Discuter avec un PNJ");
            System.out.println("3. Inventaire");
            System.out.println("4. Tableau de quêtes");
            System.out.println("5. Quitter le jeu");
            System.out.print("\nVotre choix : ");
            String choix = " ";
            try {
                choix = scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Entrée invalide.");
            }
            switch (choix) {
                case "1":
                    Random random= new Random();
                    int number = random.nextInt(100)+1;
                    if (number < 50) {
                        System.out.println("Vous vous baladez tranquillement dans la forêt.");
                        System.out.println("--- Appuyez sur Entrée pour continuer à marcher ---");
                        scanner.nextLine();
                    } else{
                        System.out.println("Un buisson bouge... Un ennemi sauvage apparaît.");
                        System.out.println("Préparez-vous au combat, jeune Aventurier !");
                        ennemi = new Ennemi();
                        tour = 1;

                        while (player.estVivant() && ennemi.estVivant()) {
                            System.out.println("\nTour : " + tour);
                            System.out.println("\nNom de l'Aventurier : " + player.getNom());
                            System.out.println("HP du joueur : " + player.getHP() + " | Défense : " + player.getArmure() + " | Niveau : " + player.getNiveau() + " | XP : " + player.getXP() + " | OR : " + player.getOR());
                            System.out.println("HP de l'ennemi : " + ennemi.getHP() + " | Niveau : " + ennemi.getNiveau());
                            System.out.println("\nChoisissez votre action : ");
                            System.out.println("1. Attaquer");
                            System.out.println("2. Défense");
                            System.out.println("3. Inventaire");
                            System.out.println("4. Fuir");

                            // Tour du joueur
                            boolean combatEnCours = player.jouerTour(ennemi, scanner);

                            //Si le joueur fui, on sors de la boucle de combat
                            if(!combatEnCours){
                                System.out.println("Vous vous êtes échappé, vous ne gagnez rien.");
                                break;
                            }

                            // Tour de l'ennemi si encore en vie
                            if (ennemi.estVivant()) {
                                ennemi.attaquerJoueur(player);
                                player.setBouclier(0);
                            }

                            tour++;
                        }

                        System.out.println("\n--- Fin du combat ---");
                        if (ennemi.getHP() <= 0){
                            ennemi.dropLoot(player);
                        }

                        if (pnj.accepterquete) {
                            player.monstresMort ++;
                            System.out.println("[Quête] Un monstre de plus au compteur ! (" + player.monstresMort + "/5)");
                        }

                        System.out.println("\n--- Appuyez sur Entrée pour reprendre votre route ---");
                        scanner.nextLine();
                    }

                    break;

                case "2":
                    player.parlerPNJ(pnj,scanner);
                    break;

                case "3":
                    player.ouvrirInventaire(scanner);
                    break;

                case "4":
                    player.consulterQuete(pnj, scanner);
                    break;

                case "5":
                    return;
            }
        }

        System.out.println("\nTour : " + tour);
        System.out.println("\nNom de l'Aventurier : " + player.getNom());
        System.out.println("HP du joueur : " + player.getHP() + " | Défense : " + player.getArmure() + " | Niveau : " + player.getNiveau() + " | XP : " + player.getXP() + " | OR : " + player.getOR());
        System.out.println("HP de l'ennemi : " + ennemi.getHP() + " | Niveau : " + player.getNiveau());
    }
}