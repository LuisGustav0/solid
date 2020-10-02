package com.solid.domain.model;

import com.solid.domain.enums.StatusE;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Optional;

@Data
@Builder
public class Pedido {

    private StatusE statusE;
    private CarrinhoCompra carrinhoCompra;
    private BigDecimal valorPedido;

    public BigDecimal getValorPedido() {
        return Optional.ofNullable(this.carrinhoCompra)
                       .map(CarrinhoCompra::getListItem)
                       .stream()
                       .flatMap(Collection::stream)
                       .map(Item::getValor)
                       .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public boolean confirmar() {
        if (!this.carrinhoCompra.validarCarrinho()) return false;

        this.statusE = StatusE.CONFIRMADO;

        return true;
    }
}
