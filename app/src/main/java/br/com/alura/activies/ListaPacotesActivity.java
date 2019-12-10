package br.com.alura.activies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import br.com.alura.R;
import br.com.alura.dao.PacoteDAO;
import br.com.alura.modelo.Pacote;
import br.com.alura.ui.adapter.ListaPacotesAdapter;

public class ListaPacotesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);
        ListView listaDePacotes = findViewById(R.id.activity_lista_pacotes_listview);
        List<Pacote> listaPacote = new PacoteDAO().lista();
        listaDePacotes.setAdapter(new ListaPacotesAdapter(listaPacote, this));
    }

}
