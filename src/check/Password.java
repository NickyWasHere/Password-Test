package check;

public class Password {

	//Quantidade mínima de cada item
	public static int minCaracteres=8, minMaiusMinus=1, minNumeros=2, minSimbolos=1, maxSequence=3;
	
	private String password;
	private int caracteres;
	private int maiusculos;
	private int minusculos;
	private int numeros;
	private int simbolos;
	
	public String getPassword() {
		return password;
	}

	public int getCaracteres() {
		return caracteres;
	}

	public int getMaiusculos() {
		return maiusculos;
	}

	public int getMinusculos() {
		return minusculos;
	}

	public int getNumeros() {
		return numeros;
	}

	public int getSimbolos() {
		return simbolos;
	}

	public Password(String password) {
		this.password = password;
		this.caracteres = password.length();
		this.maiusculos = minimo(65, 90);
		this.minusculos = minimo(97, 122);
		this.numeros = minimo(48, 57);
		this.simbolos = minimoSimbolos();
	}
	
	private int minimo(int begin, int end) {
		int cont=0;
		
		for (int i=0; i<password.length(); i++) {
			if (password.charAt(i)>=begin && password.charAt(i)<=end) {
				cont++;
			}
		}
		
		return cont;
	}
	
	private int minimoSimbolos() {
		int cont=0;
		
		for (int i=0; i<password.length(); i++) {
			int c = password.charAt(i);
			if ((c>=33 && c<=47) || (c>=58 && c<=64) || (c>=91 && c<=96) || (c>=123 && c<=126)) {
				cont++;
			}
		}
		
		return cont;
	}
	
	public boolean testPassword() {
		String req1, req2, req3, req4, req5;
		
		//Quant de caracteres
		if (caracteres<minCaracteres) {
			req1 = "\u001B[31m"; //Vermelho
		} else {
			req1 = "\u001B[32m"; //Verde
		}
		
		//Quant de maiúsculo e minúsculo
		if (maiusculos<minMaiusMinus || minusculos<minMaiusMinus) {
			req2 = "\u001B[31m"; //Vermelho
		} else {
			req2 = "\u001B[32m"; //Verde
		}
		
		//Quant de números
		if (numeros<minNumeros) {
			req3 = "\u001B[31m"; //Vermelho
		} else {
			req3 = "\u001B[32m"; //Verde
		}
		
		//Quant de símbolos
		if (simbolos<minSimbolos) {
			req4 = "\u001B[31m"; //Vermelho
		} else {
			req4 = "\u001B[32m"; //Verde
		}
		
		if (checkSequence()==false) {
			req5 = "\u001B[31m"; //Vermelho
		} else {
			req5 = "\u001B[32m"; //Verde
		}
		
		System.out.println(toString(req1, req2, req3, req4, req5));
		
		if (req1=="\u001B[32m" && req1==req2 && req1==req3 && req1==req4 && req1==req5) {
			return true;
		} else {
			return false;
		}
	}
	
	private boolean checkSequence() {
		for (int i=2; i<password.length(); i++) {
			int atual = password.charAt(i);
			int anterior = password.charAt(i-1);
			int anterior2 = password.charAt(i-2);
			
			//3 caracteres iguais seguidos
			if ((atual==anterior && atual==anterior2)) { 
				return false;
				
			  //3 caracteres em sequência
			} else if (anterior2+1==anterior && anterior+1==atual) { 
				return false;
				
			}
		}
		return true;
	}

	public String toString(String req1, String req2, String req3, String req4, String req5) {
		String ANSI_RESET = "\u001B[0m";
		
		return "Requisitos mínimos: \n"
				+ req1 + minCaracteres + " caracteres;\n" + ANSI_RESET
				+ req2 + minMaiusMinus + " letras maiúsculas e minúsculas;\n" + ANSI_RESET
				+ req3 + minNumeros + " números;\n" + ANSI_RESET
				+ req4 + minSimbolos + " símbolos;\n" + ANSI_RESET
				+ req5 + "repetição/sequência de no máximo " + maxSequence + " caracteres;\n" + ANSI_RESET;
	}

}
