package co.edu.uninorte.movilrubricaapp1;

import android.content.Context;
import android.content.Intent;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.databinding.ObservableArrayList;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import co.edu.uninorte.movilrubricaapp1.Adapters.ExpandableListAdapter;
import co.edu.uninorte.movilrubricaapp1.Adapters.SpinnerAdapter;
import co.edu.uninorte.movilrubricaapp1.Model.Categoria;
import co.edu.uninorte.movilrubricaapp1.Model.Elemento;
import co.edu.uninorte.movilrubricaapp1.Model.Rubrica;
import co.edu.uninorte.movilrubricaapp1.databinding.EvaluacionCreacionActivityBinding;

public class CreacionEvaluacionActivitty extends AppCompatActivity {


    public List<Rubrica> RubricList;
    public ObservableArrayList<Object> spinnerlist;
    ExpandableListAdapter listAdapter;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    public static ArrayAdapter<String> dataAdapter;
    EvaluacionCreacionActivityBinding evaluacionCreacionActivityBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.evaluacion_creacion_activity);
        evaluacionCreacionActivityBinding = DataBindingUtil.setContentView(this,R.layout.evaluacion_creacion_activity);

        Intent i = getIntent();
        long idcourse= i.getLongExtra("myCourseId",0);
        evaluacionCreacionActivityBinding.exprubrica.setDescendantFocusability(ViewGroup.FOCUS_BEFORE_DESCENDANTS);
        evaluacionCreacionActivityBinding.spinnerRubricas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    Toast.makeText(parent.getContext(), (String) parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
                    inflateExpandable(parent, position);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        RubricList = Rubrica.listAll(Rubrica.class);

        //TODO:dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

    }

    private void inflateExpandable(AdapterView<?> parent, int position) {
        String nameRubrica = parent.getItemAtPosition(position).toString();
        listDataChild = new HashMap<String, List<String>>();
        List<Rubrica> RubricaSelected;
        RubricaSelected = Rubrica.find(Rubrica.class, "name = ?", nameRubrica);
        List<Categoria> categ = RubricaSelected.get(0).getCategorias();
        List<Elemento> elems;
        ArrayList<String> elemnames;

        listDataHeader = getAllNamesCat(categ);
        for (int i = 0; i < listDataHeader.size(); i++) {
            elems = categ.get(i).getElementoslista();
            elemnames = getAllNamesEl(elems);
            listDataChild.put(listDataHeader.get(i), elemnames);
        }
        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);
        evaluacionCreacionActivityBinding.exprubrica.setAdapter(listAdapter);


    }
    @BindingAdapter("bind:RubricaSpinner")
    public static void bindList(Spinner view, ObservableArrayList<Object> list){
        List<Rubrica> listaR= Rubrica.listAll(Rubrica.class);
        for(int i=0;i<listaR.size();i++){
            list.add(listaR.get(i).getName());
        }
        SpinnerAdapter spinnerAdapter= new SpinnerAdapter(list);
        view.setAdapter(spinnerAdapter);
    }
    private ArrayList<String> getAllNamesCat(List<Categoria> cats) {
        ArrayList<String> names = new ArrayList<>();
        for (int i = 0; i < cats.size(); i++) {
            names.add(i, cats.get(i).getName());
        }

        return names;
    }

    private ArrayList<String> getAllNamesEl(List<Elemento> cats) {
        ArrayList<String> names = new ArrayList<>();
        for (int i = 0; i < cats.size(); i++) {
            names.add(i, cats.get(i).getName());
        }

        return names;
    }

    public ArrayList<String> getAllNamesRub(List<Rubrica> cats) {
        ArrayList<String> names = new ArrayList<>();
        for (int i = 0; i < cats.size(); i++) {
            names.add(i, cats.get(i).getName());
        }

        return names;
    }
/*
    public void crearRubricas() {
        Rubrica rub = new Rubrica();
        rub.setName("Rubrica1");
        rub.save();

        Categoria cat = new Categoria();
        cat.rubrica = rub;
        cat.setName("Categoria1");
        cat.save();
        Categoria cat2 = new Categoria();
        cat2.rubrica = rub;
        cat2.setName("Categoria2");
        cat2.save();

        for (int i = 1; i < 5; i++) {
            Elemento elem = new Elemento();
            elem.setName("Elemento" + i);
            elem.setCategoria(cat);
            elem.save();
            Elemento elem2 = new Elemento();
            elem2.setName("Elemento" + i);
            elem2.setCategoria(cat2);
            elem2.save();
        }


    }

*/

}
