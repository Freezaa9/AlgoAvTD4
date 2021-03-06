/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoavtd4;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Geoffrey
 */
public class HashOATTest {
    
    public HashOATTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

     /**
     * Test of ajouter method, of class HashOAT.
     */
    @Test
    public void testAjouter() {
        System.out.println("ajouter");
        
        HashDico<String> monDico = new HashOAT<>(512);
        char c1 = 33;
        char c2 = 126;
        int fin;
        fin = c2 - c1;
        String s = "";
        for (int i = 0; i < fin; i++) {
            s = String.valueOf(c1) + " - " + String.valueOf(c2);
            monDico.ajouter(String.valueOf(c1) + String.valueOf(c2), s);
            c1++;
            c2--;
        }
        
        assertEquals(monDico.rechercher("RM"), "R - M");
        assertEquals(monDico.rechercher("RRRR"), null);
        
        assertEquals(monDico.ajouter("RM", "toto"), "R - M");
        assertEquals(monDico.rechercher("RM"), "toto");
        
        
    }

    /**
     * Test of rechercher method, of class HashOAT.
     */
    @Test
    public void testRechercher() {
        System.out.println("rechercher");        
        HashDico<String> monDico = new HashOAT<>(512);
        char c1 = 33;
        char c2 = 126;
        int fin;
        fin = c2 - c1;
        String s = "";
        String tabString[] = new String[93];
        for (int i = 0; i < fin; i++) {
            s= String.valueOf(c1) + String.valueOf(c2);
//            System.out.print(String.valueOf(c1) + " - ");
 //           System.out.print(String.valueOf(c2) + " - ");
 //           System.out.println(HashDico.getHashedIndex(String.valueOf(c1) + String.valueOf(c2), 512));
            tabString[i]= s;
            monDico.ajouter(s, s);
            c1++;
            c2--;
        }
        for (int i = 0; i < tabString.length; i++) {
            assertEquals(tabString[i], monDico.rechercher(tabString[i]));
        }
        assertEquals(null, monDico.rechercher("RRRRRR"));
        assertEquals(null, monDico.rechercher("RIib"));
        
        
    }

    /**
     * Test of exist method, of class HashOAT.
     */
    @Test
    public void testExist() {
        System.out.println("exist");
        
        HashDico<String> monDico = new HashOAT<>(512);
        char c1 = 33;
        char c2 = 126;
        int fin;
        fin = c2 - c1;
        String s = "";
        for (int i = 0; i < fin; i++) {
            s = String.valueOf(c1) + " - " + String.valueOf(c2);
            monDico.ajouter(String.valueOf(c1) + String.valueOf(c2), s);
            c1++;
            c2--;
        }
        
        assertTrue(monDico.exist("RM"));
        assertFalse(monDico.exist("RRRR"));
    }

    /**
     * Test of supprimer method, of class HashOAT.
     */
    @Test
    public void testSupprimer() {
        System.out.println("supprimer");
        
        HashDico<String> monDico = new HashOAT<>(512);
        char c1 = 33;
        char c2 = 126;
        int fin;
        fin = c2 - c1;
        String s = "";
        for (int i = 0; i < fin; i++) {
            s = String.valueOf(c1) + " - " + String.valueOf(c2);
            monDico.ajouter(String.valueOf(c1) + String.valueOf(c2), s);
            c1++;
            c2--;
        }
        
        assertTrue(monDico.exist("RM"));        
        monDico.supprimer("RM");
        assertFalse(monDico.exist("RM"));
    }

    /**
     * Test of nbElem method, of class HashOAT.
     */
    @Test
    public void testNbElem() {
        System.out.println("nbElem");
        
        HashDico<String> monDico = new HashOAT<>(512);
        
        assertEquals(monDico.nbElem(), 0);
        
        char c1 = 33;
        char c2 = 126;
        int fin;
        fin = c2 - c1;
        String s = "";
        for (int i = 0; i < fin; i++) {
            s = String.valueOf(c1) + " - " + String.valueOf(c2);
            monDico.ajouter(String.valueOf(c1) + String.valueOf(c2), s);
            c1++;
            c2--;
        }
        
        assertEquals(monDico.nbElem(), 93);
        
        monDico.ajouter("RM", "R-M");
        assertEquals(monDico.nbElem(), 93);
        
        monDico.supprimer("RM");
        assertEquals(monDico.nbElem(), 92);
        
        monDico.supprimer("RMEE");
        assertEquals(monDico.nbElem(), 92);
        
    }

    /**
     * Test of vider method, of class HashOAT.
     */
    @Test
    public void testVider() {
        HashDico<String> monDico = new HashOAT<>(512);        
        char c1 = 33;
        char c2 = 126;
        int fin;
        fin = c2 - c1;
        String s = "";
        String tabString[] = new String[93];
        for (int i = 0; i < fin; i++) {
            s = String.valueOf(c1) + String.valueOf(c2);
            //System.out.print(String.valueOf(c1) + " - ");
            //           System.out.print(String.valueOf(c2) + " - ");
            //           System.out.println(HashDico.getHashedIndex(String.valueOf(c1) + String.valueOf(c2), 512));
            tabString[i] = s;
            monDico.ajouter(s, s);
            c1++;
            c2--;
        }
        monDico.vider();
        for (int i = 0; i < tabString.length; i++) {
            assertFalse(monDico.exist(tabString[i]));
        }

    }

    /**
     * Test of estVide method, of class HashOAT.
     */
    @Test
    public void testEstVide() {
        System.out.println("estVide");
        
        HashDico<String> monDico = new HashOAT<>(512);
        
        assertTrue(monDico.estVide());
        
        char c1 = 33;
        char c2 = 126;
        int fin;
        fin = c2 - c1;
        String s = "";
        for (int i = 0; i < fin; i++) {
            s = String.valueOf(c1) + " - " + String.valueOf(c2);
            monDico.ajouter(String.valueOf(c1) + String.valueOf(c2), s);
            c1++;
            c2--;
        }
        
        assertFalse(monDico.estVide());
        
        monDico.vider();
        
        assertTrue(monDico.estVide());
    }

    /**
     * Test of estOrganise method, of class HashOAT.
     */
    @Test
    public void testEstOrganise() {
        System.out.println("estOrganise");
        HashDico<String> monDico = new HashOAT<>(10);        
        char c1 = 33;
        char c2 = 126;
        int fin;
        fin = c2 - c1;
        String s = "";
        assertTrue(monDico.estOrganise());
        for (int i = 0; i < fin; i++) {
            s = String.valueOf(c1) + String.valueOf(c2);
            //System.out.print(String.valueOf(c1) + " - ");
            //           System.out.print(String.valueOf(c2) + " - ");
            //           System.out.println(HashDico.getHashedIndex(String.valueOf(c1) + String.valueOf(c2), 512));
            monDico.ajouter(s, s);
            c1++;
            c2--;
        }
        assertFalse(monDico.estOrganise());
    }
    /**
     * Test of organiser method, of class HashOAT.
     */
    @Test
    public void testOrganiser() {
        System.out.println("organiser");
        HashDico<String> monDico = new HashOAT<>(10);          
        
        char c1 = 33;
        char c2 = 126;
        int fin;
        fin = c2 - c1;
        String s = "";
        for (int i = 0; i < fin; i++) {
            s = String.valueOf(c1) + " - " + String.valueOf(c2);
            monDico.ajouter(String.valueOf(c1) + String.valueOf(c2), s);
            c1++;
            c2--;
        }
        int i = 0;
        //while (!monDico.estOrganise()) {
         //   i++;
           // monDico.organiser();
            
        //}
        System.out.println("nombre de bouble : " + i);
    }
    
}
