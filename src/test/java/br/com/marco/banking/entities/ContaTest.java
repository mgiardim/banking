package br.com.marco.banking.entities;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContaTest {

    @Test
    @DisplayName("""
            Dado que tenho uma conta com saldo 1000.0
            Quando sacar 200.0
            Entao o saldo devera ser de 800.0
            """)
    void testSacarValido() {
        Conta conta = new Conta("111111111", "0001");
        conta.depositar(1000.0);

        conta.sacar(200.0);

        assertEquals(800.0, conta.getSaldo());
    }

    @Test
    @DisplayName("""
            Dado que tenho uma conta com saldo 1000.0
            Quando sacar 1001.0
            Entao deve lancar uma excecao
            """)
    void testSacarInvalido() {
        Conta conta = new Conta("111111111", "0001");
        conta.depositar(1000.0);

        assertThrows(RuntimeException.class, () -> conta.sacar(1001.0));
    }

    @Test
    @DisplayName("""
            Dado que tenho uma conta com saldo 1000.0
            Quando sacar 1000.0
            Entao saldo deve ser 0.0
            """)
    void testSacarSaldoTotal() {
        Conta conta = new Conta("111111111", "0001");
        conta.depositar(1000.0);

        conta.sacar(1000.0);

        assertEquals(0.0, conta.getSaldo());
    }


    @Test
    @DisplayName("""
            Dado que tenho uma conta com saldo 0.0
            Quando depositar 500.0
            Entao o saldo devera ser de 500.0
            """)
    void testDepositar() {
        Conta conta = new Conta("222222222", "0002");
        conta.depositar(500.0);
        assertEquals(500.0,conta.getSaldo());
    }



    @Test
    @DisplayName("""
            Dado que tenho uma conta com saldo 0.0
            Quando depositar -500.0
            Entao devera lancar uma excecao de valor invalido
            """)
    void testDepositarValorInvalido() {
        Conta conta = new Conta("222222222", "0002");
        assertThrows(RuntimeException.class, () ->conta.depositar(-500));
    }
}