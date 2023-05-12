package com.iftm.client.service;

import com.iftm.client.repositories.ClientRepository;
import com.iftm.client.services.ClientService;
import com.iftm.client.services.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class ClientServiceTest {

    @InjectMocks
    private ClientService servico;

    @Mock
    private ClientRepository repositorio;

    @DisplayName("Testar se o método deleteById apaga um registro e não retorna outras informações")
    @Test
    public void testarApagarPorIdTemSucessoComIdExistente() {
        //cenário
        long idExistente = 1;
        //configurando mock : definindo que o método deleteById não retorna nada para esse id.
        Mockito.doNothing().when(repositorio).deleteById(idExistente);

        Assertions.assertDoesNotThrow(() -> {
            servico.delete(idExistente);
        });
        Mockito.verify(repositorio, Mockito.times(1)).deleteById(idExistente);

    }

    @DisplayName("Testar se o método deleteById retorna exception para idInexistente")
    @Test
    public void testarApagarPorIdGeraExceptionComIdInexistente() {
        //cenário
        long idNaoExistente = 100;
        //configurando mock : definindo que o método deleteById retorna uma exception para esse id.
        Mockito.doThrow(ResourceNotFoundException.class).when(repositorio).deleteById(idNaoExistente);

        Assertions.assertThrows(ResourceNotFoundException.class, () -> servico.delete(idNaoExistente));

        Mockito.verify(repositorio, Mockito.times(1)).deleteById(idNaoExistente);

    }
}
