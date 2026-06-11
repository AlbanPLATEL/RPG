import java.util.*;

public abstract class Items {

    protected UUID id;
    protected String nom;
    protected String description;
    protected int valeur;
    protected Rareté rareté;

    public Items() {
        this.id = UUID.randomUUID();
        this.nom = "";
        this.description = "";
        this.valeur = 0;
        this.rareté = null;
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
}