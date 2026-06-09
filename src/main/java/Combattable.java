import java.io.*;
import java.util.*;


public interface Combattable {
    public void attaquer();
    public void subirDegats();
    public boolean estVivant();
    public int getPuissanceAttaque();
}