public class CatalogueItems {

    public static Items creer(String identifiant) {
        switch (identifiant.toLowerCase()) {
            case "potion_soin":
                return new Items("Potion de soin", "Consommable", "Sert à redonner des PV");
            default:
                System.out.println("Vous n'avez pas de " + identifiant + "!");
        }
        return null;
    }

}
