package com.solid;

import com.solid.domain.model.CarrinhoCompra;

import java.math.BigDecimal;

class CarrinhoCompraTest {

    static void firstTest() {
        CarrinhoCompra carrinhoCompra = new CarrinhoCompra();

        carrinhoCompra.exibirStatus();
        carrinhoCompra.exibirValorTotal();

//        carrinhoCompra.addItem("Bicicleta", BigDecimal.valueOf(710.10));
//        carrinhoCompra.addItem("Geladeira", BigDecimal.valueOf(1950.15));
//        carrinhoCompra.addItem("Tapete", BigDecimal.valueOf(350.20));

        carrinhoCompra.exibirListaItem();

        boolean isCarrinhoConfirmado = carrinhoCompra.confirmarPedido();

        if (isCarrinhoConfirmado) {
            System.out.println("Pedido realizado com sucesso!");
        } else {
            System.out.println("Erro na confirmação do pedido. Carrinho não possui itens!");
        }

        carrinhoCompra.exibirStatus();
        carrinhoCompra.exibirValorTotal();
    }

    public static void main(String[] args) {
        firstTest();
    }
}
