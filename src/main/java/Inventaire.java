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

    public void ouvrirInventaire(Scanner scanner) {
        boolean ouvrir = true;
        String text = " ";

        while (ouvrir) {
            System.out.println("===== INVENTAIRE =====");
            if (slots.isEmpty()) {
                System.out.println("Votre inventaire est vide.");
                System.out.println("Écrire 'fin' pour fermer le sac.");
            } else {
                for (int i = 0; i < slots.size(); i++) {
                    Items item = slots.get(i);
                    System.out.println((i + 1) + ". " + item.getNom() + " (" + item.getDescription() + ")");
                }
                System.out.println("\nTapez le numéro d'un objet pour l'utiliser, ou 'fin' pour quitter.");
            }
            try {
                text = scanner.nextLine().toLowerCase();
            } catch (Exception e) {
                System.out.println("Entrée invalide.");
            }
            if (text.equals("fin")) {
                ouvrir = false;
            }
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