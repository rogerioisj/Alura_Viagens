package br.com.alura.activies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import br.com.alura.R;
import br.com.alura.modelo.Pacote;
import br.com.alura.util.DataUtil;
import br.com.alura.util.DiasUtil;
import br.com.alura.util.MoedaUtil;
import br.com.alura.util.ResoucesUtil;

import static br.com.alura.activies.ActivityConstantes.CHAVE_INTENT;

public class ResumoPacoteActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);
        setTitle("Resumo do pacote");

        Intent pacoteRecebido = getIntent();
        verificaPacoteRecebido(pacoteRecebido);
    }

    private void verificaPacoteRecebido(Intent intent) {
        if(intent.hasExtra(CHAVE_INTENT)){

            final Pacote pacote = (Pacote) intent.getSerializableExtra(CHAVE_INTENT);

            configuraPacote(pacote);
            configuraBotao(pacote);
        }
    }

    private void configuraPacote(Pacote pacote) {
        defineLocal(pacote);
        defineImagem(pacote);
        defineDias(pacote);
        formataMoedaBrasileira(pacote);
        DataUtil.formataDataDuracao(pacote);
    }

    private void configuraBotao(final Pacote pacote) {
        Button botaoRealizaPagamento = findViewById(R.id.resumo_pacote_botao_pagamento);
        botaoRealizaPagamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResumoPacoteActivity.this, PagamentoActivity.class);
                intent.putExtra(CHAVE_INTENT, pacote);
                startActivity(intent);
            }
        });
    }

    private void formataMoedaBrasileira(Pacote pacote) {
        TextView valor = findViewById(R.id.resumo_pacote_preco_valor);
        String moedaBrasileira = MoedaUtil.formataParaBrasileiro(pacote.getPreco());
        valor.setText(moedaBrasileira);
    }

    private void defineDias(Pacote pacote) {
        TextView dias = findViewById(R.id.resumo_pacote_dias);
        String diasEmTexto = DiasUtil.formataTexto(pacote.getDias());
        dias.setText(diasEmTexto);
    }

    private void defineImagem(Pacote pacote) {
        ImageView imagem = findViewById(R.id.resumo_pacote_imagem);
        Drawable drawableImagemPacote = ResoucesUtil.devolverDawable(this, pacote.getImagem());
        imagem.setImageDrawable(drawableImagemPacote);
    }

    private void defineLocal(Pacote pacote) {
        TextView local = findViewById(R.id.resumo_pacote_destino);
        local.setText(pacote.getLocal());
    }
}
