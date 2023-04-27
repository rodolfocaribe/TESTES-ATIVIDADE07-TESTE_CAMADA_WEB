package com.iftm.client.repositories;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.iftm.client.entities.Client;

@DataJpaTest
public class ClientRepositoryTest {
    @Autowired
    private ClientRepository repositorio;

    @Test
    @DisplayName("Testa se o método findById realmente retorna o cliente correto.")
    void testaSeBuscaObjetoQuandoExisteId() {
        long idExistente = 1;
        String nomeEsperado = "Conceição Evaristo";
        String cpfEsperado = "10619244881";
        Optional<Client> resultado = repositorio.findById(idExistente);
        assertTrue(resultado.isPresent(), "Objeto não encontrado.");
        assertEquals(nomeEsperado, resultado.get().getName());
        assertEquals(cpfEsperado, resultado.get().getCpf());
    }

    @Test
    @DisplayName("Testa se o método deleteById realmente apaga o cliente correto.")
    void testaSeApagarObjetoQuandoExisteId() {
        long idExistente =1L;
        int numElementosEsperados = 11;
        repositorio.deleteById(idExistente);
        Optional<Client> resultado = repositorio.findById(idExistente);
        assertFalse(resultado.isPresent(), "Objeto encontrado.");
        assertEquals(numElementosEsperados, repositorio.count(),
                "Numero de elementos do Banco de dados incorretos");
    }

}
