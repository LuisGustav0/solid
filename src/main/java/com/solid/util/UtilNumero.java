package com.solid.util;

import java.math.BigDecimal;

public class UtilNumero {

    public static boolean isValorMenor(Number num1, Number num2) {
        if (num1 == null || num2 == null) return false;

        return num1.longValue() < num2.longValue();
    }

    public static boolean isValorMaior(Number num1, Number num2) {
        if (num1 == null || num2 == null) return false;

        return num1.longValue() > num2.longValue();
    }

    public static boolean isValorMaiorQueZero(Number valor) {
        return isValorMaior(valor, BigDecimal.ZERO);
    }
}
