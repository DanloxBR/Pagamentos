package com.danieldev.pagamento.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public final class PagamentoUtils {

    private PagamentoUtils() {
    }

    public static String gerarTransacaoId() {
        return UUID.randomUUID().toString();
    }

    public static BigDecimal arredondar(BigDecimal valor) {
        if (valor == null) return BigDecimal.ZERO;
        return valor.setScale(2, RoundingMode.HALF_UP);
    }

    public static String formatarData(LocalDateTime data) {
        if (data == null) return null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return data.format(formatter);
    }

    public static boolean valorValido(BigDecimal valor) {
        return valor != null && valor.compareTo(BigDecimal.ZERO) > 0;
    }

    public static BigDecimal toBigDecimal(String valor) {
        try {
            return new BigDecimal(valor);
        } catch (Exception e) {
            return BigDecimal.ZERO;
        }
    }
}