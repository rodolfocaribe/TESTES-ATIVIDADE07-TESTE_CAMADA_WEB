package test.calculadora;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import calculadora.Calculadora;

public class CalculadoraTest {
	
	@Test
	public void testaSomaDoisInteirosPositivos() {
		//cenário de teste: testar o método somar da calculadora
				//cenário de teste: entradas necessárias e resultados esperados
				//arange
				Calculadora calc = new Calculadora();
				int entrada1 = 5;
				int entrada2 = 98;
				int resultadoEsperado = 103;

				//act = execução
				int resultadoObtido = calc.somar(entrada1, entrada2);
				
				//assert = comparação automática
				Assertions.assertEquals(resultadoEsperado, resultadoObtido);	
	}

}
