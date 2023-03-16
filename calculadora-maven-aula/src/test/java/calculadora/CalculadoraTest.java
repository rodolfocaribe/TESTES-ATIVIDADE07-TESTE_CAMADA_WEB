package calculadora;

import org.junit.jupiter.api.Test;


import org.junit.jupiter.api.Assertions;
public class CalculadoraTest {

    @Test
    public void testarSomaDoisInteirosSucesso() {
    	//Arrange - Definir o cenário de teste
    	Calculadora calculadora = new Calculadora();
    	int entradaNumeroUm = 10;
    	int entradaNumeroDois = 5;
    	int saidaEsperada = 15;
    	
    	//Act - Executaros métodos que estão sendo testados
    	int saidaObtida = calculadora.somar(entradaNumeroUm, entradaNumeroDois);
    	
    	//Assign - Validar o resultado obtido
    	Assertions.assertEquals(saidaEsperada, saidaObtida);
    }
    
    @Test
    public void testarSubtrairDoisInteirosSucesso() {
    	//Arrange - Definir o cenário de teste
    	Calculadora calculadora = new Calculadora();
    	int entradaNumeroUm = 10;
    	int entradaNumeroDois = 5;
    	int saidaEsperada = 5;
    	
    	//Act - Executaros métodos que estão sendo testados
    	int saidaObtida = calculadora.subtrair(entradaNumeroUm, entradaNumeroDois);
    	
    	//Assign - Validar o resultado obtido
    	Assertions.assertEquals(saidaEsperada, saidaObtida);
    }    
    
    @Test
    public void testarMultiplicarDoisInteirosSucesso() {
    	//Arrange - Definir o cenário de teste
    	Calculadora calculadora = new Calculadora();
    	int entradaNumeroUm = 10;
    	int entradaNumeroDois = 5;
    	int saidaEsperada = 50;
    	
    	//Act - Executaros métodos que estão sendo testados
    	int saidaObtida = calculadora.multiplicar(entradaNumeroUm, entradaNumeroDois);
    	
    	//Assign - Validar o resultado obtido
    	Assertions.assertEquals(saidaEsperada, saidaObtida);
    }        

    
}