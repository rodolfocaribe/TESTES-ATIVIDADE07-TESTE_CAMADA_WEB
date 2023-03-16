package calculadora;

public class TesteManual {

	public static void main(String[] args) {
		//cenário de teste: testar o método somar da calculadora
		//cenário de teste: entradas necessárias e resultados esperados
		//arange
		Calculadora calc = new Calculadora();
		int entrada1 = 5;
		int entrada2 = 98;
		int resultadoEsperado = 103;

		//act = execução
		int resultadoObtido = calc.somar(entrada1, entrada2);
		
		//assert = comparação
		if (resultadoEsperado==resultadoObtido) {
			System.out.println("Passou no teste");
		}else
		{
			System.out.println("Não passou no teste");
		}
		
	}

}
