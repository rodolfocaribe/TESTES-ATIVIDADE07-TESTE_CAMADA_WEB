package com.iftm.client.repositories;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.iftm.client.entities.Client;

@DataJpaTest
public class ClientRepositoryTest {
    @Autowired
    private ClientRepository repositorio;

    /**
     * Objetivo: Verificar se a busca por id realmente retorna o cliente correto.
     * ●
     * monta o cenário,
     * - arquivo import.sql carrega o cenário (clientes cadastrados)
     * - definir o id de um cliente que exista em import.sql
     * ●
     * executa a ação
     * - executar o método de buscar por id
     * (Utilizaremos a classe Optional para encapsular o objeto da
     * classe Client)
     * ●
     * e valida a saída.
     * - verifica se foi retornado um objeto.
     * - verifica se o nome e o cpf do cliente retornado corresponde
     * ao esperado.
     */
    @Test
    @DisplayName("Verificar se a busca por id realmente retorna o\n" +
            "     * cliente correto.")
    public void testarBuscaPorIDRetornaClienteCorreto(){
        long idBuscado = 1; //corresponde ao primeiro registro do arquivo import.sql
        String nomeBuscado = "Conceição Evaristo";
        String cpfBuscado = "10619244881";

        Client respostaEsperada = new Client(1L, "Conceição Evaristo", "10619244881", null, null, null);

        Optional<Client> resposta = repositorio.findById(idBuscado);

        //verificação se um client foi retornado
        Assertions.assertThat(resposta).isPresent();
        //assertTrue(resposta.isPresent());
        //assertNotNull(resposta.get());

        //verificar se o objeto retorna corresponde ao objeto esperado.
        //Assertions.assertThat(resposta.get()).isEqualTo(respostaEsperada);

        //verificar se os dados do cliente esperado corresponde aos dados do cliente retornado
        Assertions.assertThat(resposta.get().getName()).isEqualTo(nomeBuscado);
        Assertions.assertThat(resposta.get().getCpf()).isEqualTo(cpfBuscado);
        //assertEquals(nomeBuscado, resposta.get().getName());
        //assertEquals(cpfBuscado, resposta.get().getCpf());


    }

}
