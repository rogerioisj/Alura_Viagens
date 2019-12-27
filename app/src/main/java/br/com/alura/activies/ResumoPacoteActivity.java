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
import br.com.alura.util.DiasUtil;
import br.com.alura.util.MoedaUtil;
import br.com.alura.util.ResoucesUtil;

public class ResumoPacoteActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);

        Pacote pacoteSaoPaulo = new Pacote("São Paulo", "sao_paulo_sp", 2,
                new BigDecimal("243.99"));

        TextView local = findViewById(R.id.resumo_pacote_destino);
        local.setText(pacoteSaoPaulo.getLocal());

        ImageView imagem = findViewById(R.id.resumo_pacote_imagem);
        Drawable drawableImagemPacote = ResoucesUtil.devolverDawable(this, pacoteSaoPaulo.getImagem());
        imagem.setImageDrawable(drawableImagemPacote);

        TextView dias = findViewById(R.id.resumo_pacote_dias);
        String diasEmTexto = DiasUtil.formataTexto(pacoteSaoPaulo.getDias());
        dias.setText(diasEmTexto);

        TextView valor = findViewById(R.id.resumo_pacote_preco_valor);
        String moedaBrasileira = MoedaUtil.formataParaBrasileiro(pacoteSaoPaulo.getPreco());
        valor.setText(moedaBrasileira);
    }
}
