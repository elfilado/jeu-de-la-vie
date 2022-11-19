package fr.sdv.def.automates;

public class MainApp {
    public static void main( String[] args ) throws InterruptedException {
        System.out.println("Starting the game...\n");

        Grille grille = new Grille(5,10);
        grille.init();
        JeuDeLaVie jeu = new JeuDeLaVie(grille);

        while (!(grille.isFinDuJeu())){
            int i = 1;
            System.out.println("Tour " + (i) + "\n");
            jeu.afficherGrille();
            jeu.passerUnTour();
            Thread.sleep(2000);
            System.out.print("");
            i++;
            System.out.println("Tour " + (i) + "\n");
            jeu.afficherGrille();
        }

        System.out.println( "Ending the game...\n");
    }
}
