package parasilab.com.parasilab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ListChild extends AppCompatActivity {
    TextView titulo;
    String dato;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_child);

        recibirTituloLista();

        listView = findViewById(R.id.list1);
        String[] values  = new String[]{
                "Intestino Delgado 1", "Intestino Delgado 2", "Intestino Delgado 3",
                "Intestino Delgado 4", "Intestino Delgado 5", "Intestino Delgado 6",
                "Intestino Delgado 7", "Intestino Delgado 8", "Intestino Delgado 9"
        };

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final String selected = (String) adapter.getItem(i);

                Intent intent;
                intent = new Intent(view.getContext(), Theme.class);
                intent.putExtra("titulo2", selected);
                startActivity(intent);
            }
        });
    }

    private void recibirTituloLista() {
        Bundle extras = getIntent().getExtras();
        dato = extras.getString("titulo");

        titulo = (TextView) findViewById(R.id.titulo);
        titulo.setText(dato);
    }
}
