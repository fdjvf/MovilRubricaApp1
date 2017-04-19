package co.edu.uninorte.movilrubricaapp1;

import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import co.edu.uninorte.movilrubricaapp1.Adapters.ExpandableListAdapter;
import co.edu.uninorte.movilrubricaapp1.Model.Categoria;
import co.edu.uninorte.movilrubricaapp1.Model.Elemento;
import co.edu.uninorte.movilrubricaapp1.Model.Rubrica;
import co.edu.uninorte.movilrubricaapp1.databinding.EvaluacionCreacionActivityBinding;
import co.edu.uninorte.movilrubricaapp1.databinding.EvaluacionPesocategoriaInputBinding;

public class CreacionEvaluacionActivitty extends AppCompatActivity {


    public List<Rubrica> RubricList;
    public ObservableArrayList<Object> spinnerlist;
    ExpandableListAdapter listAdapter;
    EvaluacionPesocategoriaInputBinding texboxinputBinding;
    EvaluacionCreacionActivityBinding evaluacionCreacionActivityBinding;

    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    TextView lblPesoCat;
    Rubrica rubrica;
    Categoria cat;
    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        evaluacionCreacionActivityBinding = DataBindingUtil.setContentView(this,R.layout.evaluacion_creacion_activity);

        spinnerlist = new ObservableArrayList<>();
        RubricList = Rubrica.listAll(Rubrica.class);
        List<String> rubricas = getAllNamesRub(RubricList);

        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, rubricas);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        evaluacionCreacionActivityBinding.spinnerRubricas.setAdapter(adapter);
        evaluacionCreacionActivityBinding.exprubrica.setDescendantFocusability(ViewGroup.FOCUS_BEFORE_DESCENDANTS);


        Intent i = getIntent();
        long idcourse= i.getLongExtra("myCourseId",0);

        evaluacionCreacionActivityBinding.spinnerRubricas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    inflateExpandable(parent, position);


                    lblPesoCat = (TextView) findViewById(R.id.pesoCategoria);
                    lblPesoCat.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {


                            final android.support.v7.app.AlertDialog.Builder Alertbuilder = new android.support.v7.app.AlertDialog.Builder(
                                    CreacionEvaluacionActivitty.this, R.style.Theme_AppCompat_Dialog_Alert);
                            texboxinputBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.evaluacion_pesocategoria_input, null, false);

                            //texboxinputBinding.setPesoCategoria();
                            Alertbuilder.setTitle("Ingresar descripcion");
                            Alertbuilder.setCancelable(false);
                            Alertbuilder.setView(texboxinputBinding.getRoot());
                            Alertbuilder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                }
                            });

                            Alertbuilder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    rubrica.setDescripcion("");

                                }
                            });
                            android.support.v7.app.AlertDialog dialog = Alertbuilder.create();
                            dialog.show();


//textview actualizar


                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        evaluacionCreacionActivityBinding.setCreacionEvaluacionmodel(this);

    }

    private void inflateExpandable(AdapterView<?> parent, int position) {
        String nameRubrica = parent.getItemAtPosition(position).toString();
        listDataChild = new HashMap<String, List<String>>();
        List<Rubrica> RubricaSelected;

        RubricaSelected = Rubrica.find(Rubrica.class, "name = ?", nameRubrica);
        rubrica = RubricaSelected.get(0);
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

}
