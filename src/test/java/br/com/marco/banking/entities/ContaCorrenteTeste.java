package br.com.marco.banking.entities;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ContaCorrenteTeste {

    @Test
    @DisplayName("""
            Dado que tenho uma conta origem com saldo 1500
            E uma conta destino com saldo 500
            Quando transferir 500 reais da conta origem
            Entao conta origem tera um saldo de 1000
            e a conta destino tera o saldo de 1000
            """)
    void testTransferencia() {
        ContaCorrente contaOrigem = new ContaCorrente("111111111", "0001");
        ContaCorrente contaDestino = new ContaCorrente("222222222", "0002");
        contaOrigem.getConta().depositar(1500.0);
        contaDestino.getConta().depositar(500.0);
        contaOrigem.getConta().transferencia(500.0,contaOrigem.getConta(),contaDestino.getConta());
        assertEquals(1000.0,contaOrigem.getConta().getSaldo());
        assertEquals(1000.0,contaDestino.getConta().getSaldo());
    }
}
