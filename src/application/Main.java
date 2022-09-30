package application;

import java.util.Scanner;

import check.Password;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean flag=false;
		
		do {
			System.out.print("Digite uma senha: ");
			Password password = new Password(sc.next());
			
			System.out.println();
			boolean pass = password.testPassword();
			
			if (pass) {
				System.out.println("Senha aceita");
			} else {
				System.out.println("Senha não aceita");
			}
			
			System.out.println();
			System.out.print("Deseja tentar novamente? (s/n) ");
			char repeat = sc.next().charAt(0);
			
			if (repeat=='s' || repeat=='S') {
				flag=true;
			} else if (repeat=='n' || repeat=='N') {
				flag=false;
			}
				
		} while(flag);
		
		sc.close();

	}

}
