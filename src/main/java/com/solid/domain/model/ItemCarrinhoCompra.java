package com.solid.domain.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ItemCarrinhoCompra {

    private String descricao;
    private BigDecimal valor;
}
