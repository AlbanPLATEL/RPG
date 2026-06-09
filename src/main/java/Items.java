
import java.io.*;
import java.util.*;

/**
 * 
 */
public abstract class Items {

    /**
     * Default constructor
     */
    public Items() {
    }

    /**
     * 
     */
    protected UUID id;

    /**
     * 
     */
    protected String nom;

    /**
     * 
     */
    protected String description;

    /**
     * 
     */
    protected int valeur;

    /**
     * 
     */
    protected Rareté rareté;



    /**
     * @param c
     */
    public void utiliserConsommables(Consommables c) {
        // TODO implement here
    }

    /**
     * @param c
     */
    public void utiliserNonConsommables(Non Consommables c) {
        // TODO implement here
    }

    /**
     * 
     */
    public void utiliser() {
        // TODO implement here
    }

}