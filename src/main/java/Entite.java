import java.util.*;

public abstract class Entite {

    protected UUID id;
    protected String nom;
    protected Position position;

    public Entite() {
        this.id = UUID.randomUUID();
        this.nom = "";
        this.position = new Position();
    }

    public UUID getId() {
        return this.id;
    }

    public String getNom() {
        return this.nom;
    }

    public Position getPosition() {
        return this.position;
    }

}