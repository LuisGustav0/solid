package com.solid.domain.model;

import com.solid.domain.enums.StatusE;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
public class CarrinhoCompra {

    private StatusE status;
    private List<ItemCarrinhoCompra> listItem;
    private BigDecimal valorTotal;

    public CarrinhoCompra() {
        this.status = StatusE.EM_ABERTO;
        this.listItem = new ArrayList<>();
        this.valorTotal = BigDecimal.ZERO;
    }

    public BigDecimal getValorTotal() {
        return this.listItem.stream().map(ItemCarrinhoCompra::getValor).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void exibirStatus() {
        System.out.println("Status: " + this.status);
    }

    public void exibirValorTotal() {
        System.out.println("Valor total: " + this.getValorTotal());
    }

    public void exibirListaItem() {
        this.listItem.forEach(System.out::println);
    }

    public void addItem(String descricao, BigDecimal valor) {
        this.listItem.add(new ItemCarrinhoCompra(descricao, valor));
    }

    public boolean confirmarPedido() {
        if (!this.validarCarrinho()) return false;

        this.status = StatusE.CONFIRMADO;
        this.enviarEmailConfirmacao();

        return true;
    }

    private void enviarEmailConfirmacao() {
        System.out.println("Envia e-mail de confirmação...");
    }

    public boolean validarCarrinho() {
        return Optional.ofNullable(this.listItem).map(List::size).map(size -> size > 0).orElse(false);
    }
}
