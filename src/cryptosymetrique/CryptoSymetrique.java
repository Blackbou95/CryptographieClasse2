/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptosymetrique;

/**
 *
 * @author Oumy Gueye
 */
public class CryptoSymetrique {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       //new KeyGeneration().keygeneration("./essai.key");
        
        Chiffrement chiffrement = new Chiffrement();
        chiffrement.runCipher("./essai.key","./test.txt","./resultat.txt");
        Dechiffrement dechiffrement = new  Dechiffrement();
         dechiffrement.runCipher("./essai.key","./resultat.txt","./resultat1.txt");
        
                
    }
    
}
