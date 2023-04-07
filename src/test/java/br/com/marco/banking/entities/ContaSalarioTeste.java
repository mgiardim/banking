package br.com.marco.banking.entities;


import br.com.marco.banking.entities.base.Sacavel;
import br.com.marco.banking.exceptions.SaqueInvalidoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class ContaSalarioTeste {
    @Test
    @DisplayName("""
            Dado que tenho uma conta salario com saldo 1000
            Quando sacar 500 reais da conta salario
            Entao conta salario tera um saldo de 500
            """)
    void testSaqueValido() {
        Sacavel contaOrigem = new ContaSalario("111111111", "0001");
        contaOrigem.depositar(1000.0);
        contaOrigem.sacar(500.0);
        assertEquals(500.0, contaOrigem.getSaldo());
    }

    @Test
    @DisplayName("""
            Dado que tenho uma conta salario com saldo 1000
            Quando sacar 1500 reais da conta salario
            Entao operacao deve enviar um erro
            """)
    void testSaqueInvalido() {
        ContaSalario contaOrigem = new ContaSalario("111111111", "0001");
        contaOrigem.depositar(1000.0);
        assertThrows(SaqueInvalidoException.class, () -> contaOrigem.sacar(1500.0));
    }
}
