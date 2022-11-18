package fr.sdv.def.automates;

import java.util.Random;

public class Grille {
    private final boolean[][] tableau;
    private final int lignes;
    private final int colonnes;

    private static final int RANDOM_INTERVAL = 4;
    private static final int RANDOM_CHECK = 3;

    /**
     * Constructeur de la grille
     *
     * @param lignes   int
     * @param colonnes int
     */
    public Grille(int lignes, int colonnes) {
        this.lignes = lignes;
        this.colonnes = colonnes;
        this.tableau = new boolean[lignes][colonnes];
    }

    /**
     * Genere un nombre aleatoire entre 0 et l'intervalle defini dans la classe
     *
     * @return int
     */
    public int genererNombreRandom() {
        Random rand = new Random();
        return rand.nextInt(RANDOM_INTERVAL);
    }

    /**
     * Remplit la grille aleatoirement
     */
    public void init() {
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < colonnes; j++) {
                int nombreRandom = genererNombreRandom();
                //Creation aléatoire d'une cellule
                tableau[i][j] = RANDOM_CHECK == nombreRandom;
            }
        }
    }

    /**
     * Retourne le nombre de voisins d'une cellule
     *
     * @param x coordonnee ligne
     * @param y coordonee colonne
     * @return int nbVoisins
     */
    public int nombreDeVoisins(int x, int y) {
        int nbVoisins = 0;
        for(int dx = -1; dx <= 1; dx++) {
            for(int dy = -1; dy <= 1; dy++) {
                if ( dx != 0 && dy !=0 ) {
                    int vx = x + dx;
                    int vy = y + dy;
                    if ( vy >= 0 && vy < lignes  && vx >= 0 && vx < colonnes ) {
                        if (tableau[vy][vx]) {
                            nbVoisins++; //
                        }
                    }
                }
            }
        }
        return nbVoisins;
    }

    /**
     * Determine si une cellule donnee doit survivre
     * @param i coordonnee ligne
     * @param j coordonee colonne
     * @return true si elle vit, false sinon
     */
    public boolean doCellSurvive ( int i, int j){
        return nombreDeVoisins(i, j) >= 2;
    }

    /**
     * Check si les voisins d'une cellule sont dans la grille
     * @param i coordonnee ligne
     * @param j coordonee colonne
     * @return true si oui, false sinon
     */
    public boolean areAllNeighborsInsideBounds ( int i, int j){
        return (i - 1 >= 0 && i + 1 <= lignes - 1)
                && (j - 1 >= 0 && j + 1 <= colonnes - 1);
    }

    public boolean canMoveDown ( int i){
        return i - 1 >= 0;
    }

    public boolean canMoveUp ( int i){
        return i + 1 <= lignes - 1;
    }

    public boolean canMoveLeft ( int j){
        return j - 1 >= 0;
    }

    public boolean canMoveRight ( int j){
        return j + 1 <= colonnes - 1;
    }


    /**
     * Surcharge de la methode toString
     * @return String
     */
    @Override
    public String toString () {
        StringBuilder res = new StringBuilder();
        for (boolean[] strings : tableau) {
            for (boolean string : strings) {
                res.append("|").append(string ? "X" : " ");
            }
            res.append("|\n");
        }
        return res.toString();
    }

    /**
     * Retourne la grille
     * @return String[][]
     */
    public boolean[][] getTableau () {
        return tableau;
    }

    /**
     * Retourne le nombre de lignes
     * @return int
     */
    public int getLignes () {
        return lignes;
    }

    /**
     * Retourne le nombre de colonnes
     * @return int
     */
    public int getColonnes () {
        return colonnes;
    }
    /**
     * Modifie le contenu d'une cellule
     * @param i coordonee ligne
     * @param j coordonee colonne
     * @param tab tableau cible
     * @param newValue valeur a inserer
     */
    public void setCell ( int i, int j, boolean[][] tab, boolean newValue){
        tab[i][j] = newValue;
    }
    public void setTableau (boolean[][] tab){
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < colonnes; j++) {
                tableau[i][j] = tab[i][j];
            }
        }
    }
}
