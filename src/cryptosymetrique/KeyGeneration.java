/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptosymetrique;

import interfaces.ICryptoConfig;
import interfaces.IKeyGeneration;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Oumy Gueye
 */
public class KeyGeneration implements IKeyGeneration {

    public boolean  keygeneration(String filePath) {
        SecretKey k = genkey();
        return savekey(filePath , k);
       
    }
    @Override
    public SecretKey genkey() {
        
     try {
           KeyGenerator kg = KeyGenerator.getInstance(ICryptoConfig.algo);
           kg.init(ICryptoConfig.keysize);
           return kg.generateKey();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(KeyGeneration.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
      
    @Override
    public boolean savekey(String FilePath, SecretKey key) {
        try {
            FileOutputStream fos = new FileOutputStream(FilePath);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(key);
            oos.close();
            fos.close();
            return true;
            
        } catch (Exception ex) {
            Logger.getLogger(KeyGeneration.class.getName()).log(Level.SEVERE, null, ex);
    }
        return false;

    
    
}

    @Override
    public SecretKey recupkey(String FilePath) {
        try {
            FileInputStream fis = new FileInputStream(FilePath);
            ObjectInputStream ois = new ObjectInputStream(fis);
            SecretKey key = (SecretKey) ois.readObject();
            return key;
        } catch (Exception ex) {
            Logger.getLogger(KeyGeneration.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public SecretKey genkeyPass(String mdp) {
       SecretKey clepbe=null;
        //on appelle Transforme le mot de passe en tableau de Char
        char[] password = mdp.toCharArray();
        PBEKeySpec pbe = new PBEKeySpec(password, ICryptoConfig.salt, ICryptoConfig.ieration, ICryptoConfig.keysize);
        //on vide le tableau de char password
        mdp="";
	for (int j = 0; j < password.length; j++) {
		password[j] = 0;
	}
	try {  
         //on appelle le KDF: PBEKeySpec pour construire une clé
         //KDF: Key Derivation Function
          SecretKeyFactory kdfFactory = SecretKeyFactory.getInstance(ICryptoConfig.kdf);
          SecretKey keyPBE = kdfFactory.generateSecret(pbe);
          clepbe=new SecretKeySpec(keyPBE.getEncoded(), ICryptoConfig.algo);
			
       } catch (Exception e) {
	     // TODO Auto-generated catch block
	      e.printStackTrace();
       }
                
       return clepbe;
    }

    
}
