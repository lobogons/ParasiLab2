package parasilab.com.parasilab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Theme extends AppCompatActivity {
    TextView titulo2;
    String dato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme);

        recibirTituloLista();
    }

    private void recibirTituloLista() {
        Bundle extras = getIntent().getExtras();
        dato = extras.getString("titulo2");

        titulo2 = (TextView) findViewById(R.id.titulo2);
        titulo2.setText(dato);
    }
}
