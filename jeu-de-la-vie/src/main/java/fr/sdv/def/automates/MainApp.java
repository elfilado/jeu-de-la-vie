package fr.sdv.def.automates;

public class MainApp {
    public static void main( String[] args ) throws InterruptedException {
        System.out.println("Starting the game...\n");

        Grille grille = new Grille(5,10);
        grille.init();
        JeuDeLaVie jeu = new JeuDeLaVie(grille);

        for (int i = 0; i < 5; i++) {
            System.out.println("Tour" + (i+1) + "\n");
            jeu.afficherGrille();
            jeu.passerUnTour();
            Thread.sleep(2000);
            System.out.print("");
        }

        System.out.println( "Ending the game...\n");
    }
}
