package parasilab.com.parasilab;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class TeoriaFragment extends Fragment {

    List<String> ChildList;
    Map<String, List<String>> ParentListItems;
    ExpandableListView expandableListView;

    List<String> ParentList = new ArrayList<>();
    {
        ParentList.add("Clasificación General");
        ParentList.add("Metazoarios");
        ParentList.add("Protozoarios");
    }

    String[] CgName = {
            "Intestino Delgado", "Intestino Grueso", "Tisulares", "Hematicos"
    };

    String[] MtName = {
            "Entrada 1", "Entrada 2", "Entrada 3", "Entrada 4"
    };

    String[] PtName = {
            "Entrada 1", "Entrada 2", "Entrada 3", "Entrada 4"
    };

    String[] DefaultName = {
            "No hay entradas"
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ParentListItems = new LinkedHashMap<>();
        for (String HoldItem: ParentList) {
            if (HoldItem.equals("Clasificación General")) {
                loadChild(CgName);
            }
            else if (HoldItem.equals("Metazoarios")) {
                loadChild(MtName);
            }
            else if (HoldItem.equals("Protozoarios")) {
                loadChild(PtName);
            }
            else {
                loadChild(DefaultName);
            }
            ParentListItems.put(HoldItem, ChildList);
        }

        View v = inflater.inflate(R.layout.fragment_teoria, null);
        expandableListView = (ExpandableListView) v.findViewById(R.id.expandListView);
        final ExpandableListAdapter expandableListAdapter = new ListAdapter(this, ParentList, ParentListItems);
        expandableListView.setAdapter(expandableListAdapter);

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                final String selected = (String) expandableListAdapter.getChild(i, i1);

                Intent intent;
                intent = new Intent(TeoriaFragment.super.getActivity(), ListChild.class);
                intent.putExtra("titulo", selected);
                startActivity(intent);
                return true;
            }
        });
        return v;
    }

    private void loadChild(String[] ParentElementName) {
        ChildList = new ArrayList<>();
        Collections.addAll(ChildList, ParentElementName);
    }
}
