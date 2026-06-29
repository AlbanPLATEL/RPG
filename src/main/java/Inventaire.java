import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class Inventaire {
    private final ArrayList<Items> slots;
    private final int maxInventaire;

    public Inventaire() {
        slots = new ArrayList<>();
        maxInventaire = 20;
    }

    public void ouvrirInventaire(Scanner scanner, Player player) {
        boolean ouvrir = true;
        String text = " ";
        String choix = " ";

        while (ouvrir) {
            System.out.println("===== INVENTAIRE =====");
            if (slots.isEmpty()) {
                System.out.println("Votre inventaire est vide.");
                System.out.println("===== FIN INVENTAIRE =====");
                System.out.println("\nÉcrire 'fin' pour fermer le sac.");
            } else {
                for (int i = 0; i < slots.size(); i++) {
                    Items item = slots.get(i);
                    System.out.println((i + 1) + ". " + item.getNom() + " (" + item.getDescription() + ")" + " x" + item.quantite);
                }
                System.out.println("===== FIN INVENTAIRE =====");
                System.out.println("\n1. Utiliser un item");
                System.out.println("2. Jeter un item");
                System.out.println("3. Équiper un item");
                System.out.println("4. Déséquiper un item");
                System.out.println("5. Trier l’inventaire");
                System.out.println("6. Chercher un item");
                System.out.println("\nÉcrire 'fin' pour fermer le sac.");
                System.out.print("\nVotre choix : ");
                try {
                    text = scanner.nextLine().toLowerCase();
                } catch (Exception e) {
                    System.out.println("Entrée invalide.");
                }
                if (text.equals("fin")) {
                    ouvrir = false;
                }
            }

            try {
                choix = scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Entrée invalide.");
            }
            switch (choix) {
                case "1":
                    //Utiliser un item
                    System.out.println("Quel item voulez-vous utiliser : ");

                    for (Items items : new ArrayList<>(slots)){
                        if(items.getNom().equals(items.nom)){
                            appliquerEffetItem(items, player);
                            retirerItem(items.nom);
                            System.out.println("Vous avez consommé : " + items.getNom());
                        }
                    }

                    break;
                case "2":
                    //Jeter un item
                    retirerItem(this.toString());
                    break;
                case "3":
                    //Équiper un item
                    break;
                case "4":
                    //Déséquiper un item
                    break;
                case "5":
                    //Trier l'inventaire
                    trierPar();
                    break;
                case "6":
                    //Chercher un item
                    chercherItem(this.toString());
                    break;
            }
        }
    }

    public void appliquerEffetItem(Items items, Player player) {
        switch (items.getCategorie().toLowerCase())
        {
            case "potion":
                player.setHP(player.getHP() + 30);
                System.out.println("Potion utiliser. HP: " + player.getHP());
                break;
            case "arme":
                player.degats += 5;
                System.out.println("Arme équiper. Dégâts:" + player.degats);
                break;
            case "armure":
                player.setArmure(player.getArmure() + 3);
                System.out.println("Armure équiper. DEF:" + player.getArmure());
                break;
            default:
                System.out.println("Utiliser " + items.getNom());
                break;
        }
    }

    public void ajouterItem(Items item) {
        if (slots.size() < maxInventaire) {
            slots.add(item);
        } else if (maxInventaire == 20) {
            System.out.println("Votre inventaire est plein.");
        }
    }

    public void retirerItem(String nom) {
        slots.removeIf(i -> i.getNom().equals(nom));
    }

    public void trierPar() {
        // TODO implement here
    }

    public void chercherItem(String nom) {
        // TODO implement here
    }

    public List<Items> getContenu() {
        return slots;
    }

}