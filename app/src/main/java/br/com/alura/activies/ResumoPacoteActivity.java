package br.com.alura.activies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
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

public class ResumoPacoteActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);
        setTitle("Resumo do pacote");

        Pacote pacoteSaoPaulo = new Pacote("São Paulo", "sao_paulo_sp", 2,
                new BigDecimal("243.99"));

        defineLocal(pacoteSaoPaulo);
        defineImagem(pacoteSaoPaulo);
        defineDias(pacoteSaoPaulo);
        formataMoedaBrasileira(pacoteSaoPaulo);
        DataUtil.formataDataDuracao(pacoteSaoPaulo);

        Intent intent = new Intent(this, PagamentoActivity.class);
        startActivity(intent);
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
