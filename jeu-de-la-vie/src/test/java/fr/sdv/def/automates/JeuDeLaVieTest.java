package fr.sdv.def.automates;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class JeuDeLaVieTest{

    Grille grille = new Grille(5,10);
    boolean[][] tab = grille.getTableau();
    boolean[][] copie = Arrays.copyOf(tab, tab.length);

    @Test
    public void testAreAllNeighborsInsideBounds() {
        assertTrue(grille.areAllNeighborsInsideBounds(1,8));
    }

    @Test
    public void testAreAllNeighborsInsideBoundsRowLimit() {
        assertFalse(grille.areAllNeighborsInsideBounds(0,8));
    }


    @Test
    public void testIsNeighborInsideBoundsColumnLimit() {
        assertFalse(grille.areAllNeighborsInsideBounds(1,9));
    }

    @Test
    public void testRowLength() {
        assertEquals(5,tab.length);
    }

    @Test
    public void testColumnLength() {
        assertEquals(10,tab[0].length);
    }

    @Test
    public void testTabCopy() {
        assertEquals(tab, copie);
    }

    @Test
    public void testCopyRowLength() {
        assertEquals(5,copie.length);
    }

    @Test
    public void testCopyColumnLength() {
        assertEquals(10,copie[0].length);
    }
}
