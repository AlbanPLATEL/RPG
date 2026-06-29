import java.util.*;

public class Items {

    protected UUID id;
    protected String nom;
    protected String description;
    protected int valeur;
    protected Rarete rarete;
    protected String type;

    public Items(String nom, String type, String description) {
        this.id = UUID.randomUUID();
        this.nom = nom;
        this.type = type;
        this.description = description;
        this.valeur = 0;
        this.rarete = null;
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
}