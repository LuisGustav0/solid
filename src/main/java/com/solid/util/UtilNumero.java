package com.solid.util;

import java.math.BigDecimal;

public class UtilNumero {

    public static boolean isValorMenor(BigDecimal num1, BigDecimal num2) {
        if (num1 == null || num2 == null) return false;

        return num1.compareTo(num2) < 1;
    }
}
