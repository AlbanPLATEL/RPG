import java.util.*;

public class Items {

    protected UUID id;
    protected String nom;
    protected String description;
    protected int valeur;
    protected Rarete rarete;
    protected String type;
    protected int quantite;
    protected String categorie;

    public Items(String nom, String type, String description, int quantite) {
        this.id = UUID.randomUUID();
        this.nom = nom;
        this.type = type;
        this.description = description;
        this.valeur = 0;
        this.rarete = null;
        this.quantite = quantite;
        this.categorie = type.toLowerCase();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Rarete getRarete() {
        return rarete;
    }

    public void setRarete(Rarete rarete) {
        this.rarete = rarete;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    @Override
    public String toString() {
        return nom + " (" + categorie + " )";
    }
}