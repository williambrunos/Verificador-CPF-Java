package classes;
import java.util.Scanner;

public class Verificador {
	
	//Método que verifica se o cpf digitado é válido ou não:
	public static boolean verificaCpf(int[] cpf) {
		int sum = 0, contador = 2;
		
		//Calcula a soma dos 9 primeiros números do cpf vezes um contador que 
		//varia de 2 a 10:
		
		for(int i = 8; i >= 0; i--) {
			sum = sum + (cpf[i] * contador);
			contador++;
		}
		int digitoVerificador;
		
		//O primeiro dígito verificador é o dígito que ocupa a 9º posição no array
		//e é igual a zero se o resto da divisão da soma anterior por 11 for menor do que 2
		//e é igual a 11 menos o resto da mesma divisão se esta for maior ou igual a 2:
		
		if(sum % 11 < 2) {
			digitoVerificador = 0; 
		}else {
			digitoVerificador = 11 - (sum % 11);
		}
		boolean valido;
		
		//Verifica se o primeiro dígito verificador é igual ao calculado:
		
		valido = (digitoVerificador == cpf[9]?true:false);
		
		//Se o dígito verificador no cpf for diferente do que foi calculado, os comandos
		//a seguir não serão executados para poupar processamento:
		
		if(valido == true) {
			sum = 0;
			contador = 2;
			
			//O loop a seguir faz a mesma coisa que o útlimo, mas agora levando em conta
			//o primeiro dígito verificador já calculado:
			
			for(int i = 9; i >= 0; i--) {
				sum = sum + (cpf[i] * contador);
				contador++;
			}
			int segundoDigitoVerificador;
			
			//A detemrinação do segundo digito verificador que ocupa a 10º posição no array
			//segue a mesma lógica do primeiro dígito verificador:
			
			if(sum % 11 < 2) {
				segundoDigitoVerificador = 0;
			}else {
				segundoDigitoVerificador = 11 - (sum % 11);
			}
			
			//Verifica se o dígito na 10º posição do array é igual ao dígito calculado:
			valido = (segundoDigitoVerificador == cpf[10]?true:false);
		}
		
		return valido;
	}
	public static void main(String[] args) {
		//Criação de um array de 11 elementos que serão os números do cpf:
		int[] cpf = new int[11];
		//Criação de um objeto que lê inputs:
		Scanner in = new Scanner(System.in);
		
		System.out.println("Digite seu cpf: ");
		//Preenchimento do array cpf:
		for(int i = 0; i < 11; i++) {
			cpf[i] = in.nextInt();
		}
		in.close();
		
		//Invocando o método de verificação e enviando o array inicializado:
		boolean verifica = verificaCpf(cpf);
		
		System.out.println(verifica==true?"Válido!":"Inválido!");
	}
}
