import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Joueur {
    private ArrayList<Carte> paquetDuJoueur = new ArrayList();
    private int points = 0; // Ajout du compteur de points

    public Joueur() {
    }

    public ArrayList<Carte> getCarteDuJoueur() {
        return this.paquetDuJoueur;
    }

    public int getPoints() {
        return points++; // Méthode pour récupérer les points du joueur
    }

    public ArrayList<Carte> melanger(Paquet paquetAMelanger, Joueur paquetDuJoueur) {
        ArrayList<Carte> paquetAdistribuer = new ArrayList();
        Iterator var5 = paquetAMelanger.getPaquet().iterator();

        while(var5.hasNext()) {
            Carte carte = (Carte)var5.next();
            paquetAdistribuer.add(carte);
        }

        Collections.shuffle(paquetAdistribuer);
        paquetDuJoueur.getCarteDuJoueur().addAll(paquetAdistribuer);
        return paquetDuJoueur.getCarteDuJoueur();
    }

    // Méthode pour comparer les cartes et mettre à jour le compteur de points
    public void comparerCartes(Carte a, Carte b) {
        String resultat = a.compare(a, b);
        if (resultat.equals("Joueur 1 gagne") || resultat.equals("Joueur 2 gagne")) {

            System.out.println("Le joueur a gagné !");
        }
    }

    // Méthode pour afficher le nombre de points du joueur
    @Override
    public String toString() {
        return "Points du joueur : " + points;
    }
}
