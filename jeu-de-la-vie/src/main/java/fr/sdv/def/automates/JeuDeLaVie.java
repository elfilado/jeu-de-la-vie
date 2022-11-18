package fr.sdv.def.automates;

import java.util.Arrays;

public class JeuDeLaVie
{
    private final Grille grille;

    public JeuDeLaVie(Grille grille){
        this.grille = grille;
    }

    public void afficherGrille() {
        System.out.println(grille);
    }

    public void passerUnTour() {
        boolean[][] copie = new boolean[grille.getLignes()][grille.getColonnes()];
        for (int i = 0; i < grille.getLignes(); i++) {
            for (int j = 0; j < grille.getColonnes(); j++) {
                if((!grille.doCellSurvive(i, j))) {
                    grille.setCell(i, j, copie, false);
                }
                else {
                    grille.setCell(i, j, copie, true);
                }
            }
            grille.setTableau(copie);
        }
    }
}
