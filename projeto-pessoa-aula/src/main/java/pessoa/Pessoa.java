package pessoa;

public class Pessoa {
private String nome;
	
	public void setNome(String nome) {
		if (nome.length()<2 || nome.length()>100)
			throw new IllegalArgumentException("O nome precisa ter entre 2 e 100 caracteres");
		this.nome = nome.toUpperCase();		
	}

	public String getNome() {		
		return this.nome;
	}

}
