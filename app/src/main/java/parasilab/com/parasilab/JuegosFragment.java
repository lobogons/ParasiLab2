package parasilab.com.parasilab;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class JuegosFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_juegos, null);
        ListView listView = (ListView) v.findViewById(R.id.listJuegos);
        String[] values  = new String[]{
                "Memorama", "Rompecabezas", "Crucigrama de imágenes",
                "Sopa de letras", "Laberinto"
        };

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, android.R.id.text1, values);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final String selected = (String) adapter.getItem(i);  //toma el nombre de la lista seleccionada

                Intent intent;
                intent = new Intent(view.getContext(), Theme.class);    //Theme es el activity que se abrira
                intent.putExtra("titulo2", selected); //envia el valor a la nueva activity
                startActivity(intent);
            }
        });

        return v;
    }
}
