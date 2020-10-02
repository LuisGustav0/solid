package com.solid.domain.model;

import com.solid.util.UtilNumero;
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
        return Optional.ofNullable(this.listItem).map(List::size).map(UtilNumero::isValorMaiorQueZero).orElse(false);
    }

    public static class CarrinhoCompraBuilder {

        public CarrinhoCompraBuilder() {
            this.listItem = new ArrayList<>();
        }

        public CarrinhoCompraBuilder addItem(Item item) {
            if (!item.validarItem(item)) return this;

            this.listItem = Optional.ofNullable(this.listItem).orElse(new ArrayList<>());
            this.listItem.add(item);

            return this;
        }
    }
}
