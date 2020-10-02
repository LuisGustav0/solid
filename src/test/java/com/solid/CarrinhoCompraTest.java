package com.solid;

import com.solid.domain.enums.StatusE;
import com.solid.domain.model.CarrinhoCompra;
import com.solid.domain.model.Item;
import com.solid.domain.model.Pedido;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CarrinhoCompraTest {

    @Test
    void testeInicialPedido() {
        Pedido pedido = Pedido.builder().build();

        assertEquals(StatusE.EM_ABERTO, pedido.getStatusE());
        assertEquals(BigDecimal.ZERO, pedido.getValorPedido());
    }

    @Test
    void testePedidoComCarrinhoCompraListaItemVazio() {
        Pedido pedido = Pedido.builder().build();

        assertNotNull(pedido.getCarrinhoCompra().getListItem());
        assertEquals(0, pedido.getCarrinhoCompra().getListItem().size());
    }

    @Test
    void testePedidoValidarCarrinhoCompra() {
        Item bicicleta = Item.builder().descricao("Bicicleta").valor(BigDecimal.valueOf(710.10)).build();
        Item geladeira = Item.builder().descricao("Geladeira").valor(BigDecimal.valueOf(1950.15)).build();
        Item tapete = Item.builder().descricao("Tapete").valor(BigDecimal.valueOf(350.20)).build();

        CarrinhoCompra carrinhoCompra = CarrinhoCompra.builder()
                                                      .addItem(bicicleta)
                                                      .addItem(geladeira)
                                                      .addItem(tapete)
                                                      .build();

        Pedido pedido = Pedido.builder().carrinhoCompra(carrinhoCompra).build();

        assertTrue(pedido.getCarrinhoCompra().validarCarrinho());
    }

    @Test
    void testePedidoCarrinhoCompraConfirmado() {
        Item bicicleta = Item.builder().descricao("Bicicleta").valor(BigDecimal.valueOf(710.10)).build();
        Item geladeira = Item.builder().descricao("Geladeira").valor(BigDecimal.valueOf(1950.15)).build();
        Item tapete = Item.builder().descricao("Tapete").valor(BigDecimal.valueOf(350.20)).build();

        CarrinhoCompra carrinhoCompra = CarrinhoCompra.builder()
                                                      .addItem(bicicleta)
                                                      .addItem(geladeira)
                                                      .addItem(tapete)
                                                      .build();

        Pedido pedido = Pedido.builder().carrinhoCompra(carrinhoCompra).build();

        assertTrue(pedido.confirmar());
        assertEquals(StatusE.CONFIRMADO, pedido.getStatusE());
    }
}
