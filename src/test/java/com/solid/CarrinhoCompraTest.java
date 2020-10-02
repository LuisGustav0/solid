package com.solid;

import com.solid.domain.enums.StatusE;
import com.solid.domain.model.CarrinhoCompra;
import com.solid.domain.model.Item;
import com.solid.domain.model.Pedido;

import java.math.BigDecimal;

class CarrinhoCompraTest {

    static void carrinhoCompraSemListaItem() {
        CarrinhoCompra carrinhoCompra = CarrinhoCompra.builder().build();

        Pedido pedido = Pedido.builder().statusE(StatusE.EM_ABERTO).carrinhoCompra(carrinhoCompra).build();

        System.out.println("Status do pedido: " + pedido.getStatusE());
        System.out.println("Carrinho possui item do pedido: " + pedido.getCarrinhoCompra().validarCarrinho());
        System.out.println("Valor do pedido: " + pedido.getValorPedido());
        System.out.println("Confirmação do pedido: " + pedido.confirmar());
        System.out.println("Status do pedido depois da confirmação: " + pedido.getStatusE());
    }

    static void carrinhoCompraComListaItem() {
        Item portaCopo = Item.builder().descricao("Porta Copo").valor(BigDecimal.valueOf(4.55)).build();
        Item lampada = Item.builder().descricao("Lâmpada").valor(BigDecimal.valueOf(8.32)).build();

        CarrinhoCompra carrinhoCompra = CarrinhoCompra.builder().addItem(portaCopo).addItem(lampada).build();

        Pedido pedido = Pedido.builder().statusE(StatusE.EM_ABERTO).carrinhoCompra(carrinhoCompra).build();

        System.out.println("Status do pedido: " + pedido.getStatusE());
        System.out.println("Carrinho possui item do pedido: " + pedido.getCarrinhoCompra().validarCarrinho());
        System.out.println("Valor do pedido: " + pedido.getValorPedido());
        System.out.println("Confirmação do pedido: " + pedido.confirmar());
        System.out.println("Status do pedido depois da confirmação: " + pedido.getStatusE());
    }

    public static void main(String[] args) {
        carrinhoCompraSemListaItem();
        carrinhoCompraComListaItem();
    }
}
