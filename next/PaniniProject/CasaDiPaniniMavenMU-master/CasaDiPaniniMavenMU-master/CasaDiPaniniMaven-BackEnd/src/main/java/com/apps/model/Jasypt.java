package com.apps.model;

import org.jasypt.util.password.ConfigurablePasswordEncryptor;

public class Jasypt {
	
	private static final String	ALGO_CHIFFREMENT	= "SHA-256";
	
	static public String crypterMotsDePasse(String motDePasse) {
		
		ConfigurablePasswordEncryptor passwordEncryptor = new ConfigurablePasswordEncryptor();
		passwordEncryptor.setAlgorithm(ALGO_CHIFFREMENT);
		passwordEncryptor.setPlainDigest(false);
		String motDePasseChiffre = passwordEncryptor.encryptPassword(motDePasse);
		return motDePasseChiffre;
	}
	
	static public boolean deCrypterMotsDePasse(String motDePasse, String inputPassword) {
		
		ConfigurablePasswordEncryptor passwordEncryptor = new ConfigurablePasswordEncryptor();
		passwordEncryptor.setAlgorithm(ALGO_CHIFFREMENT);
		passwordEncryptor.setPlainDigest(false);
		
		if (passwordEncryptor.checkPassword(inputPassword, motDePasse)) {
			return true;
		} else {
			return false;
		}
	}
	
}
