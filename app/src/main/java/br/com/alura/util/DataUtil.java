package br.com.alura.util;

import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import br.com.alura.R;
import br.com.alura.modelo.Pacote;

public class DataUtil {
    public static String formataDataDuracao(Pacote pacote) {
        Calendar dataIda = Calendar.getInstance();
        Calendar dataVolta = Calendar.getInstance();
        dataVolta.add(Calendar.DATE, pacote.getDias());
        SimpleDateFormat formatoBrasileiro = new SimpleDateFormat("dd/MM");
        String dataIdaFormatada = formatoBrasileiro.format(dataIda.getTime());
        String dataVoltaFormatada = formatoBrasileiro.format(dataVolta.getTime());
        String dataCompletaFormatada = dataIdaFormatada + " - "
                + dataVoltaFormatada
                + " de "
                + dataVolta.get(Calendar.YEAR);
        return dataCompletaFormatada;
    }
}
