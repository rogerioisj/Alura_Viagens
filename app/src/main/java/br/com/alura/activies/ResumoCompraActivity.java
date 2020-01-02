package br.com.alura.activies;

import androidx.appcompat.app.AppCompatActivity;

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

public class ResumoCompraActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Resumo da Compra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_compra);
        setTitle(TITULO_APPBAR);
        Pacote pacoteSaoPaulo = new Pacote("São Paulo", "sao_paulo_sp", 2,
                new BigDecimal("243.99"));

        defineLocal(pacoteSaoPaulo);
        defineImagem(pacoteSaoPaulo);
        defineDias(pacoteSaoPaulo);
        definePreco(pacoteSaoPaulo);
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
