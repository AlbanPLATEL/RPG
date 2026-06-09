import java.io.*;
import java.util.*;


public interface Observable {
    public void ajouterObservateur();
    public void notifierObservateur();
}