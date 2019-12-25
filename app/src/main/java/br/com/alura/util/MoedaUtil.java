package br.com.alura.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class MoedaUtil {

    public static final String IDIOMAPT_BR = "pt";
    public static final String NACIONALIDADE_BR = "BR";
    public static final String SUBSTITUIR_CIFRA = "R$";
    public static final String SUBSTITUTO_CIFRA = "R$ ";

    public static String formataParaBrasileiro(BigDecimal valor) {
        NumberFormat formatoBrasileiro = DecimalFormat.getCurrencyInstance(new Locale(IDIOMAPT_BR, NACIONALIDADE_BR));
        String precoDefinitivo = formatoBrasileiro.format(valor).replace(SUBSTITUIR_CIFRA, SUBSTITUTO_CIFRA);
        return precoDefinitivo;
    }
}
