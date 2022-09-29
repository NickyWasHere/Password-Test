package application;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite uma senha:");
		String password = sc.next();
		
		int quantCaracteres = password.length();
		int minMaiusculo = minimo(password, 65, 90);
		int minMinusculo = minimo(password, 97, 122);
		int minNumeros = minimo(password, 48, 57);
		int minSimbolos = minimoSimbolos(password);
		
		sc.close();

	}
	
	public static int minimo(String password, int begin, int end) {
		int cont=0;
		
		for (int i=0; i<password.length(); i++) {
			if (password.charAt(i)>=begin && password.charAt(i)<=end) {
				cont++;
			}
		}
		
		return cont;
	}

	public static int minimoSimbolos(String password) {
		int cont=0;
		
		for (int i=0; i<password.length(); i++) {
			int c = password.charAt(i);
			if ((c>=33 && c<=47) || (c>=58 && c<=64) || (c>=91 && c<=96) || (c>=123 && c<=126)) {
				cont++;
			}
		}
		
		return cont;
	}
}
