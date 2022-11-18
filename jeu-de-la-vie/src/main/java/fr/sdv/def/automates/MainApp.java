package fr.sdv.def.automates;

public class MainApp {
    public static void main( String[] args ) throws InterruptedException {
        System.out.println("Starting the game...\n");
        System.out.println("Tour 1\n");

        Grille grille = new Grille(5,10);
        grille.init();
        JeuDeLaVie jeu = new JeuDeLaVie(grille);

        for (int i = 0; i < 5; i++) {
            jeu.afficherGrille();
            jeu.passerUnTour();
            System.out.println("Tour" + i + "\n");
            System.out.print("");
            Thread.sleep(2000);
        }

        System.out.println( "Ending the game...\n");
    }
}
