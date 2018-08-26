package conjectura_de_goldbach;

public class ConjecturaGoldBach {

	
	public static boolean isPrimo(int n) {
		if(n == 2)
			return true;
		
		int i = 2;
		do {									//do while para invalidar input de 0 e 1
			if(n % i == 0 || n <= 1)			//verifica o resto da divisão de cada número até a metade do valor input
				return false;					//retorna falso se encontrar uma divisão sem resto
			
			i++;
		}while(i < (n/2));
		
		return true;
	}
	
	public static void conjecturaGoldBach(int n) {
		int primo1 = 0, primo2 = 0;
		
		primo1 = obterPrimoMaisProximo(n);
		if(n - primo1 == 1 )								//se o número primo mais próximo for o número anterior
			primo1 = obterPrimoMaisProximo(--primo1);		//obtém o primo mais próximo do número anterior
		
		primo2 = n - primo1;								//obtém a sobra da subtração do valor pelo primeiro número primo
		while(!isPrimo(primo2) && (primo1 + primo2) != n) { //verifica se a sobra é um primo e se a soma resulta no valor de n
			primo1 = obterPrimoMaisProximo(--primo1);		
			primo2 = n - primo1;
		}

		System.out.println("primo1: " + primo1);
		System.out.println("primo2: " + primo2);
	}
	
	private static int obterPrimoMaisProximo(int n) {
		for(int i = n ; i > 0 ; i--) {
			if(isPrimo(i))
				return i;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		conjecturaGoldBach(898980);
	}
}
