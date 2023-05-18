package com.iftm.client.service;

import com.iftm.client.dto.ClientDTO;
import com.iftm.client.entities.Client;
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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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

    /**
     * Exemplo Extra
     * Cenário de Teste : método findByIncomeGreaterThan retorna a página com clientes corretos
     * Entrada:
     * - Paginação:
     * - Pagina = 1;
     * - 2
     * - Asc
     * - Income
     * - Income: 4800.00
     * - Clientes:
     * Pagina: 0
     * {
     * "id": 7,
     * "name": "Jose Saramago",
     * "cpf": "10239254871",
     * "income": 5000.0,
     * "birthDate": "1996-12-23T07:00:00Z",
     * "children": 0
     * },
     * <p>
     * {
     * "id": 4,
     * "name": "Carolina Maria de Jesus",
     * "cpf": "10419244771",
     * "income": 7500.0,
     * "birthDate": "1996-12-23T07:00:00Z",
     * "children": 0
     * },
     * <p>
     * Pagina: 1
     * {
     * "id": 8,
     * "name": "Toni Morrison",
     * "cpf": "10219344681",
     * "income": 10000.0,
     * "birthDate": "1940-02-23T07:00:00Z",
     * "children": 0
     * }
     * Resultado:
     * Página não vazia
     * Página contendo um cliente
     * Página contendo o cliente da página 1
     */
    @Test
    @DisplayName("testar método findByIncomeGreaterThan retorna a página com clientes corretos")
    public void testarBuscaPorSalarioMaiorQueRetornaElementosEsperados() {
        //cenário de teste
        double entrada = 4800.00;
        int paginaApresentada = 1;
        int linhasPorPagina = 2;
        String ordemOrdenacao = "ASC";
        String campoOrdenacao = "income";
        Client clienteSete = new Client(7L, "Jose Saramago", "10239254871", 5000.0, Instant.parse("1996-12-23T07:00:00Z"), 0);
        Client clienteQuatro = new Client(4L, "Carolina Maria de Jesus", "10419244771", 7500.0, Instant.parse("1996-12-23T07:00:00Z"), 0);
        Client clienteOito = new Client(8L, "Toni Morrison", "10219344681", 10000.0, Instant.parse("1940-02-23T07:00:00Z"), 0);

        PageRequest pagina = PageRequest.of(paginaApresentada, linhasPorPagina,
                Sort.Direction.valueOf(ordemOrdenacao), campoOrdenacao);

        //configurar o Mock
        List<Client> lista = new ArrayList<>();
        lista.add(clienteSete);
        lista.add(clienteQuatro);
        Page<Client> paginaEsperada = new PageImpl<>(lista, pagina, 1);
        Mockito.when(repositorio.findByIncomeGreaterThan(entrada, pagina)).thenReturn(paginaEsperada);

        //testar se o método da service não retorna erro.
        //AtomicReference<Page<ClientDTO>> page = null;
        //Assertions.assertDoesNotThrow(()->{
        //page.set(servico.findByIncomeGreaterThan(pagina, entrada));},"Exception identificada");

        Page<ClientDTO> page = servico.findByIncomeGreaterThan(pagina, entrada);

        assertThat(page).isNotEmpty();
        //assertThat(page.getTotalElements()).isEqualTo(3);
        assertThat(page.getNumberOfElements()).isEqualTo(2);
        assertThat(page.toList().get(0).toEntity()).isEqualTo(clienteSete);
        assertThat(page.toList().get(1).toEntity()).isEqualTo(clienteQuatro);

    }
}
