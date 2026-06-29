import java.util.Random;
import java.util.Scanner;

public class PNJ extends Entite {
    private Player player;
    public Boolean accepterquete;
    private static int OR;
    private static int XP;

    public PNJ() {
        Random random = new Random();
        accepterquete = false;
        OR = random.nextInt(10)+1;
        XP = random.nextInt(10)+1;
    }

    public void parlerJoueur(Player player, Scanner scanner) {
        System.out.println("\n".repeat(10));
        System.out.println("1. Discuter avec lui");
        System.out.println("2. Demander une quête");
        System.out.println("3. Réclamer votre récompense");
        System.out.print("\nVotre choix : ");
        String choix = " ";
        try {
            choix = scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Entrée invalide.");
        }
        switch (choix) {
            case "1":
                System.out.println("==========================");
                System.out.println("   L'histoire du monde    ");
                System.out.println("==========================");
                String histoire = """
                        Comptes-tu voyager jusqu'aux confins du monde, Aventurier ? Laisse-moi d’abord te conter le récit de la Citadelle Obscure…
                        Il y a un millénaire de cela, ces terres n'étaient que ruines et cendres. Un dragon de jais, dont l'envergure obscurcissait le soleil,
                        descendit du ciel et fendit les cieux, il ravagea tout ce qui se trouvait sur son passage : homme, femme, enfant, village, royaume...
                        Tout fut anéanti et brisé en l’espace de quelques jours seulement. Les armées du roi tombèrent les unes après les autres,
                        leurs boucliers fondant comme cire au soleil face au souffle incendiaire de la bête. Tout espoir semblait alors perdu.
                        """;
                System.out.println(histoire);
                System.out.println("\n--- Appuyez sur Entrée pour passer à la suite de l'histoire ---");
                scanner.nextLine();

                String suite = """
                        Mais c’est alors qu'un jeune héros, armé d'une simple fiole de givre éternel et d'un courage insensé,
                        s'introduisit de nuit dans le repaire de la bête qui semblait immortelle. Nul ne sait exactement ce qu’il se passa au cœur de la montagne,\s
                        mais un cri déchirant fit trembler la terre jusqu'à Aethelgard.\s
                        Au matin, le dragon était pétrifié, transformé en une statue d’obsidienne d’un noir tellement intense et lisse.
                       \s""";

                System.out.println(suite);
                System.out.println("\n--- Appuyez sur Entrée pour passer à la fin de l'histoire ---");
                scanner.nextLine();

                String fin = """
                        Depuis quelques temps, la statue semble s’être fissurée et la magie résiduelle de la bête s'échappe de la montagne.
                        Elle corrompt la faune locale, donnant naissance aux monstres que tu affrontes lors de tes balades.
                        On raconte que celui qui parviendra à briser le cœur de pierre du dragon héritera d'une immense fortune et se verra également accorder un vœu...
                        Mais prends garde, tout ceci n’est qu’une légende. Une longue route périlleuse t’attend Jeune Aventurier !
                        """;

                System.out.println(fin);
                System.out.println("\n--- Appuyez sur Entrée pour partir à l'aventure ---");
                scanner.nextLine();
                System.out.println("       ");
                break;

            case "2":
                System.out.println("Tuer 5 monstres");
                accepterquete = true;
                player.accepterQuete(this);
                break;

            case "3":
                if(player.monstresMort >= 5 && accepterquete == true) {
                    System.out.println("Quête terminée ! Bien joué, voici ta récompense.");
                    player.recupererButin(this);
                    player.monstresMort = 0;
                    accepterquete = false;
                } else if(accepterquete == false) {
                    System.out.println("Je n'ai aucun travail pour toi pour le moment, va me demander une quête d'abord !");
                } else {
                    System.out.println("Tu n'as pas encore abattu assez de monstres ! Reviens me voir quand tu en auras suffisamment terrassé.");
                }
                    break;

            default:
                System.out.println("Le PNJ ne comprend pas ce que vous voulez.");
                break;
        }
    }

    public int getXP() {
        return XP;
    }

    public void setXP(int XP) {
        PNJ.XP = XP;
    }

    public int getOR() {
        return OR;
    }

    public void setOR(int OR) {
        PNJ.OR = OR;
    }
}