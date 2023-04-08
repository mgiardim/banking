package br.com.marco.banking.entities;

import br.com.marco.banking.entities.base.Recebivel;
import br.com.marco.banking.entities.base.Rendavel;
import br.com.marco.banking.entities.base.Sacavel;
import br.com.marco.banking.entities.base.Transferivel;
import br.com.marco.banking.exceptions.RentabilidadeInvalidaException;
import br.com.marco.banking.exceptions.SaqueInvalidoException;
import br.com.marco.banking.exceptions.TransferenciaInvalidaException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ContaRendimentoTeste {

    @Test
    @DisplayName("""
            Dado que tenho uma conta origem com saldo 1500
            E uma conta destino com saldo 500
            Quando transferir 500 reais da conta origem
            Entao conta origem tera um saldo de 1000
            e a conta destino tera o saldo de 1000
            """)
    void testTransferenciaValida() {
        Transferivel contaOrigem = new ContaRendimento("111111111", "0001");
        Recebivel contaDestino = new ContaCorrente("222222222", "0002");
        contaOrigem.depositar(1500.0);
        contaDestino.depositar(500.0);
        contaOrigem.transferir(500.0, contaDestino);
        assertEquals(1000.0, contaOrigem.getSaldo());
        assertEquals(1000.0, contaDestino.getSaldo());
    }

    @Test
    @DisplayName("""
            Dado que a contaAbstract origem e a mesma contaAbstract do destino
            Entao deve exibir um erro de contas iguais
            """)
    void testTransferenciaInvalida() {
        ContaRendimento contaOrigem = new ContaRendimento("111111111", "0001");
        assertThrows(TransferenciaInvalidaException.class, () -> contaOrigem.transferir(500.0, contaOrigem));
    }

    @Test
    @DisplayName("""
            Dado que tenho uma conta corrente com saldo 1000
            Quando sacar 500 reais da conta corrente
            Entao conta corrente tera um saldo de 500
            """)
    void testSaqueValido() {
        Sacavel contaOrigem = new ContaRendimento("111111111", "0001");
        contaOrigem.depositar(1000.0);
        contaOrigem.sacar(500.0);
        assertEquals(500.0, contaOrigem.getSaldo());
    }

    @Test
    @DisplayName("""
            Dado que tenho uma conta corrente com saldo 1000
            Quando sacar 1500 reais da conta corrente
            Entao operacao deve enviar um erro
            """)
    void testSaqueInvalido() {
        ContaRendimento contaOrigem = new ContaRendimento("111111111", "0001");
        contaOrigem.depositar(1000.0);
        assertThrows(SaqueInvalidoException.class, () -> contaOrigem.sacar(1500.0));
    }

    @Test
    @DisplayName("""
            Dado que tenho uma conta do tipo rendimento com saldo 1000
            Quando der 1 mes tera um redimento de X % 
            Entao o valor sera de
            """)
    void testRendimentoValido() {
        Rendavel contaOrigem = new ContaRendimento("111111111", "0001");
        contaOrigem.depositar(1000.0);
        contaOrigem.render(0.13);
        assertEquals(1130.0, contaOrigem.getSaldo());
    }

    @Test
    @DisplayName("""
            Dado que tenho uma conta do tipo rendimento com saldo 1000
            Quando der 1 mes tera um redimento negativo X % 
            Entao devera exibir uma mensagem de erro
            """)
    void testRendimentoInvalido() {
        ContaRendimento contaOrigem = new ContaRendimento("111111111", "0001");
        contaOrigem.depositar(1000.0);
        assertThrows(RentabilidadeInvalidaException.class, () -> contaOrigem.render(-0.1));
    }
}
