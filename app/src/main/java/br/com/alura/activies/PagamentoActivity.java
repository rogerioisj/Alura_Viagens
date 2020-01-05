package br.com.alura.activies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;

import br.com.alura.R;
import br.com.alura.modelo.Pacote;
import br.com.alura.util.MoedaUtil;

import static br.com.alura.activies.ActivityConstantes.CHAVE_INTENT;

public class PagamentoActivity extends AppCompatActivity {

    public static final String APP_BAR = "Pagamento";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);
        setTitle(APP_BAR);

        Intent pacoteRecebido = getIntent();
        if(pacoteRecebido.hasExtra(CHAVE_INTENT)){
            final Pacote pacote = (Pacote) pacoteRecebido.getSerializableExtra(CHAVE_INTENT);

            formataMoedaBrasileira(pacote);

            Button botaoFinalizaCompra = findViewById(R.id.pagamento_botao_finaliza_pagamento);
            botaoFinalizaCompra.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(PagamentoActivity.this, ResumoCompraActivity.class);
                    intent.putExtra(CHAVE_INTENT, pacote);
                    startActivity(intent);
                }
            });
        }
    }

    private void formataMoedaBrasileira(Pacote pacoteSaoPaulo) {
        TextView preco = findViewById(R.id.pagamento_valor);
        String precoFinalFormatado = MoedaUtil.formataParaBrasileiro(pacoteSaoPaulo.getPreco());
        preco.setText(precoFinalFormatado);
    }
}
