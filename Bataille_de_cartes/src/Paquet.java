import java.util.ArrayList;

public class Paquet {
    private ArrayList<Carte> paquet = new ArrayList();

    public Paquet() {
        String[] couleursListe;
        int nbCouleurs = (couleursListe = Carte.couleurList).length;

        for (int i = 0; i < nbCouleurs; ++i) {
            String couleur = couleursListe[i];
            String[] valeursListe;
            int nbValeurs = (valeursListe = Carte.valeurList).length;

            for (int j = 0; j < nbValeurs; ++j) {
                String valeur = valeursListe[j];
                Carte carte = new Carte(couleur, valeur);
                this.paquet.add(carte);
            }
        }
    }

    public ArrayList<Carte> getPaquet() {
        return this.paquet;
    }
}
