import java.util.ArrayList;

public class Bataille {
    public Bataille() {
    }

    public static void main(String[] args) {
        Joueur joueur = new Joueur();
        Joueur joueur2 = new Joueur();
        Paquet paquet = new Paquet();
        Paquet paquet2 = new Paquet();
        Carte carte = new Carte();
        ArrayList<Carte> paquetDeJeu = joueur.melanger(paquet, joueur);
        ArrayList<Carte> paquetDeJeu2 = joueur2.melanger(paquet2, joueur2);
        Boolean win = false;
        int manche = 0;


        while (!win) {
            System.out.println("Voici la carte du joueur 1 : " + ((Carte)paquetDeJeu.get(0)).getValeur() + " de " + ((Carte)paquetDeJeu.get(0)).getCouleur() + "\n" + "Voici la carte du joueur 2 : " + ((Carte)paquetDeJeu2.get(0)).getValeur() + " de " + ((Carte)paquetDeJeu2.get(0)).getCouleur());

            String resultatManche = carte.compare((Carte)paquetDeJeu.get(0), (Carte)paquetDeJeu2.get(0));
            System.out.println(resultatManche + " la manche n°  " + manche);
            ++manche;

            if (resultatManche.equals("Joueur 1 gagne")) {
                paquetDeJeu.add((Carte)paquetDeJeu.get(0));
                paquetDeJeu2.remove(paquetDeJeu2.get(0));
                joueur.getPoints();// Incrémentez le compteur de points du joueur 1.
            } else if (resultatManche.equals("Joueur 2 gagne")) {
                paquetDeJeu2.add((Carte)paquetDeJeu2.get(0));
                paquetDeJeu.remove(paquetDeJeu.get(0));
                joueur2.getPoints(); // Incrémentez le compteur de points du joueur 2.
            } else {
                paquetDeJeu.set(paquetDeJeu.size() - 1, (Carte)paquetDeJeu.get(0));
                paquetDeJeu.remove(0);
                paquetDeJeu.add(paquetDeJeu.set(paquetDeJeu.size() - 1, paquetDeJeu.get(0)));

                System.out.println(" ");
                paquetDeJeu2.set(paquetDeJeu2.size() - 1, (Carte)paquetDeJeu2.get(0));
                paquetDeJeu2.remove(0);
                paquetDeJeu2.add((Carte)paquetDeJeu2.set(paquetDeJeu2.size() - 1, (Carte)paquetDeJeu2.get(0)));
            }
            System.out.println("Points - Joueur 1 : " + joueur.toString() + "  |  Joueur 2 : " + joueur2.toString());
            System.out.println("-------------------------------------------");

            if (paquetDeJeu.size() == 1) {
                win = true;
                System.out.println("Joueur 2 a gagné la partie avec " + joueur2.toString() + " points.");
            } else if (paquetDeJeu2.size() == 1) {
                win = true;
                System.out.println("Joueur 1 a gagné la partie avec " + joueur.toString() + " points.");
            }
        }
    }
}
