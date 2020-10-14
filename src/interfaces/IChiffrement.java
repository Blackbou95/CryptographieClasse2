/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import javax.crypto.Cipher;

/**
 *
 * @author Oumy Gueye
 */
public interface IChiffrement {
    public Cipher getCipher(String keyFile);
    public Cipher getCipherByPassWord(String mdp);
    public boolean Process(String fileToEncrypt,String fileDest,Cipher cipher);
    public boolean runCipher(String keyFile,String fileToEncrypt,String fileDest);
    public boolean runCipherByPass(String mbp, String fileToEncrypt, String fileDest);
    
}
