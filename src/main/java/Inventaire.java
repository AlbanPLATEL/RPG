import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class Inventaire {
    private final List<Items> slots;

    public Inventaire() {
        this.slots = new ArrayList<>();
    }

    public void ouvrirInventaire(Scanner scanner) {
        boolean ouvrir = true;
        scanner.nextLine();
        String text = "";

        while (ouvrir) {
            System.out.println("===== INVENTAIRE =====");
            if (slots.isEmpty()) {
                System.out.println("Votre inventaire est vide.");
            } else {
                for (int i = 0; i < slots.size(); i++) {
                    System.out.println(i + " : " + slots.get(i).getNom());
                }
            }
            try {
                text = scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Entrée invalide.");
            }
            if (text.equals("\nFIN") || text.equals("\nFin") || text.equals("\nfin")) {
                ouvrir = false;
            }
        }
    }

    public void ajouterItem(Items item) {
        if (slots.size() < 20) {
            slots.add(item);
        }
    }

    public void retirerItem(int index) {
        if (index >= 0 && index < slots.size()) {
            slots.remove(index);
        }
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