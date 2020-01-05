package br.com.alura.activies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import br.com.alura.R;
import br.com.alura.dao.PacoteDAO;
import br.com.alura.modelo.Pacote;
import br.com.alura.ui.adapter.ListaPacotesAdapter;

public class ListaPacotesActivity extends AppCompatActivity implements ActivityConstantes {

    public static final String TITULO_APP_BAR = "Pacotes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);
        setTitle(TITULO_APP_BAR);
        configuraLista();

    }

    private void configuraLista() {
        ListView listaDePacotes = findViewById(R.id.activity_lista_pacotes_listview);
        final List<Pacote> listaPacote = new PacoteDAO().lista();
        configuraClickPacote(listaDePacotes, listaPacote);
    }

    private void configuraClickPacote(ListView Pacotes, final List<Pacote> listaPacote) {
        Pacotes.setAdapter(new ListaPacotesAdapter(listaPacote, this));
        Pacotes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ListaPacotesActivity.this, ResumoPacoteActivity.class);
                intent.putExtra(CHAVE_INTENT, listaPacote.get(position));
                startActivity(intent);
            }
        });
    }

}
