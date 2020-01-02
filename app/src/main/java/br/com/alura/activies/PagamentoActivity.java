package br.com.alura.activies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.math.BigDecimal;

import br.com.alura.R;
import br.com.alura.modelo.Pacote;
import br.com.alura.util.MoedaUtil;

public class PagamentoActivity extends AppCompatActivity {

    public static final String APP_BAR = "Pagamento";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);
        setTitle(APP_BAR);

        Pacote pacoteSaoPaulo = new Pacote("São Paulo", "sao_paulo_sp", 2,
                new BigDecimal("243.99"));

        formataMoedaBrasileira(pacoteSaoPaulo);

        Intent intent = new Intent(this, ResumoCompraActivity.class);
        startActivity(intent);
    }

    private void formataMoedaBrasileira(Pacote pacoteSaoPaulo) {
        TextView preco = findViewById(R.id.pagamento_valor);
        String precoFinalFormatado = MoedaUtil.formataParaBrasileiro(pacoteSaoPaulo.getPreco());
        preco.setText(precoFinalFormatado);
    }
}
