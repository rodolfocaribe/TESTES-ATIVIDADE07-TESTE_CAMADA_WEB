package pessoa;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PessoaTest {
	private Pessoa pessoa;	
	
	@BeforeEach
	public void iniciaDados() {
		pessoa = new Pessoa();
	}
	
	/**
	 * Cenário de teste 1
	 */	
	@Test
	@DisplayName("Testar o nome da pessoa quando a entrada é válida (entre 2 e 100 caracteres) no limite superior")
	public void testarNomeCorretoNoLimiteSuperior() {
		//Arrange = Cria o cenário
		String entradaNome = "Bruno Queiroz 12345678901234567890123456789012345678901234567890123456789012345678901234567890123456";
		String resultadoEsperado = "BRUNO QUEIROZ 12345678901234567890123456789012345678901234567890123456789012345678901234567890123456";
		
		//Act = executar os métodos a serem testados		
		pessoa.setNome(entradaNome);
		String resultadoObtido = pessoa.getNome();
		
		//Assign = comparação
		Assertions.assertEquals(resultadoEsperado, resultadoObtido);
	}

	/**
	 * Cenário de teste 1
	 */
	@Test
	@DisplayName("Testar o nome da pessoa quando a entrada é válida (entre 2 e 100 caracteres) no limite inferior")
	public void testarNomeCorretoNoLimiteInferior() {
		String entradaNome = "Ze";
		String resultadoEsperado = "ZE";

		pessoa.setNome(entradaNome);
		String resultadoObtido = pessoa.getNome();

		Assertions.assertEquals(resultadoEsperado, resultadoObtido);
	}	
	
	/**
	 * Cenário de teste 3	 
	 */
	@Test
	@DisplayName("Testar o nome da pessoa quando a entrada é inválida, menos de 2 caracteres")
	public void testarNomeInCorretoAbaixoLimiteInferior() {
		String entradaNome = "A";
		
		assertThrows(IllegalArgumentException.class, ()->{pessoa.setNome(entradaNome);});
	}	
	
	/**
	 * Cenário de teste 4
	 */
	@Test
	@DisplayName("Testar o nome da pessoa quando a entrada é inválida, mais de 100 caracteres")
	public void testarNomeInCorretoAcimaLimiteSuperior() {
		String entradaNome = "0101Bruno Queiroz 12345678901234567890123456789012345678901234567890123456789012345678901234567890123456";
		
		assertThrows(IllegalArgumentException.class, ()->{pessoa.setNome(entradaNome);});
	}	
	
}
