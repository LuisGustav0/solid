package com.solid.domain.model;

import com.solid.util.UtilNumero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
public class Item {

    private String descricao;
    private BigDecimal valor;

    public boolean validarItem(Item item) {
        if (item == null) return false;

        if (UtilNumero.isValorMenor(item.getValor(), BigDecimal.ZERO)) return false;

        return true;
    }
}
