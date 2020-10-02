package com.solid;

import com.solid.domain.enums.StatusE;
import com.solid.domain.model.CarrinhoCompra;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;


class CarrinhoCompraTest {

    @Test
    void testeInicialComCarrinhoCompra() {
        CarrinhoCompra carrinhoCompra = new CarrinhoCompra();

        assertEquals(StatusE.EM_ABERTO, carrinhoCompra.getStatus());
        assertEquals(BigDecimal.ZERO, carrinhoCompra.getValorTotal());
    }

    @Test
    void testeCarrinhoCompraListaItemVazio() {
        CarrinhoCompra carrinhoCompra = new CarrinhoCompra();

        assertNotNull(carrinhoCompra.getListItem());
        assertEquals(carrinhoCompra.getListItem().size(), 0);
    }

    @Test
    void testeValidarCarrinhoCompra() {
        CarrinhoCompra carrinhoCompra = new CarrinhoCompra();
        carrinhoCompra.addItem("Bicicleta", BigDecimal.valueOf(710.10));
        carrinhoCompra.addItem("Geladeira", BigDecimal.valueOf(1950.15));
        carrinhoCompra.addItem("Tapete", BigDecimal.valueOf(350.20));

        assertTrue(carrinhoCompra.validarCarrinho());
    }

    @Test
    void testeCarrinhoCompraConfirmado() {
        CarrinhoCompra carrinhoCompra = new CarrinhoCompra();
        carrinhoCompra.addItem("Bicicleta", BigDecimal.valueOf(710.10));
        carrinhoCompra.addItem("Geladeira", BigDecimal.valueOf(1950.15));
        carrinhoCompra.addItem("Tapete", BigDecimal.valueOf(350.20));

        assertTrue(carrinhoCompra.confirmarPedido());
        assertEquals(StatusE.CONFIRMADO, carrinhoCompra.getStatus());
    }
}
