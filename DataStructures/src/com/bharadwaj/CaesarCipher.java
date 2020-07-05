package com.bharadwaj;

public class CaesarCipher {
	
	protected char[] encoder = new char[26];
	protected char[] decoder = new char[26];

	public CaesarCipher(int rotation) {
		for(int k=0; k<26; k++) {
			encoder[k] = (char) ('A' + (k+rotation) % 26);
			decoder[k] = (char) ('A' + (k-rotation+26) % 26);
		}
	}
	
	public String encrypt(String msg) {
		return transform(msg, encoder);
	}
	
	public String decrypt(String secret) {
		return transform(secret, decoder);
	}
	
	public String transform(String original, char[] code) {
		char[] msg = original.toCharArray();
		
		for(int k=0; k<msg.length; k++) {
			if(Character.isUpperCase(msg[k])) {
				int j = msg[k] - 'A';
				msg[k] = code[j];
			}
		}
	  return new String(msg);
	}
	
	public static void main(String args[]) {
		CaesarCipher cipher = new CaesarCipher(3);
		System.out.println(cipher.encoder);
		System.out.println(cipher.decoder);
		
		String message = "THIS IS BHARADWAJ; CODE RED";
		
		System.out.println(message);
		
		String coded = cipher.encrypt(message);
		String original = cipher.decrypt(coded);
		
		System.out.println(coded);
		System.out.println(original);
	}
}
