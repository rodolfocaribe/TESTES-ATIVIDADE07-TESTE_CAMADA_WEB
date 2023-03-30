package pessoa;

public class Pessoa {
	private String nome;

	public void setNome(String nome) {
		if (nome.length() >= 2 && nome.length() <= 100)
			this.nome = nome.toUpperCase();
		else
			throw new IllegalArgumentException("O nome precisa ter entre 2 e 100 caracteres");

	}

	public String getNome() {
		return this.nome;
	}

}
