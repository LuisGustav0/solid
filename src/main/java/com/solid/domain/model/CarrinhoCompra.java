package com.solid.domain.model;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@Builder
public class CarrinhoCompra {

    private List<Item> listItem;

    public boolean validarCarrinho() {
        return Optional.ofNullable(this.listItem).map(List::size).map(size -> size > 0).orElse(false);
    }

    private boolean addItem(Item item) {
        if (!item.validarItem(item)) return false;

        this.listItem = Optional.ofNullable(this.listItem).orElse(new ArrayList<>());
        this.listItem.add(item);

        return true;
    }

    public static class CarrinhoCompraBuilder {

        public CarrinhoCompraBuilder addItem(Item item) {

            return this;
        }
    }
}
