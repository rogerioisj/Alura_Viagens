package br.com.alura.activies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;

import br.com.alura.R;
import br.com.alura.modelo.Pacote;
import br.com.alura.util.DataUtil;
import br.com.alura.util.DiasUtil;
import br.com.alura.util.MoedaUtil;
import br.com.alura.util.ResoucesUtil;

import static br.com.alura.activies.ActivityConstantes.CHAVE_INTENT;

public class ResumoCompraActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Resumo da Compra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_compra);
        setTitle(TITULO_APPBAR);

        Intent pacoteRecebido = getIntent();
        verificaPacoteRecebido(pacoteRecebido);
    }

    private void verificaPacoteRecebido(Intent intent) {
        if (intent.hasExtra(CHAVE_INTENT)){
            Pacote pacote = (Pacote) intent.getSerializableExtra(CHAVE_INTENT);

            configuraPacote(pacote);
        }
    }

    private void configuraPacote(Pacote pacote) {
        defineLocal(pacote);
        defineImagem(pacote);
        defineDias(pacote);
        definePreco(pacote);
    }

    private void definePreco(Pacote pacote) {
        TextView preco = findViewById(R.id.res_pagamento_preco);
        String precoFormatado = MoedaUtil.formataParaBrasileiro(pacote.getPreco());
        preco.setText(precoFormatado);
    }

    private void defineDias(Pacote pacote) {
        TextView dias = findViewById(R.id.res_pagamento_duracao);
        String diasEmTexto = DataUtil.formataDataDuracao(pacote);
        dias.setText(diasEmTexto);
    }

    private void defineImagem(Pacote pacote) {
        ImageView imagem = findViewById(R.id.res_pagamento_imagem_destino);
        Drawable drawable = ResoucesUtil.devolverDawable(this, pacote.getImagem());
        imagem.setImageDrawable(drawable);
    }

    private void defineLocal(Pacote pacote) {
        TextView local = findViewById(R.id.res_pagamento_destino);
        local.setText(pacote.getLocal());
    }
}
