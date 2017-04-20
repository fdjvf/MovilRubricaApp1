package co.edu.uninorte.movilrubricaapp1;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import co.edu.uninorte.movilrubricaapp1.Adapters.ExpandableListAdapter;
import co.edu.uninorte.movilrubricaapp1.Model.Calificaciones.PesoCategoria;
import co.edu.uninorte.movilrubricaapp1.Model.Calificaciones.PesoElemento;
import co.edu.uninorte.movilrubricaapp1.Model.Categoria;
import co.edu.uninorte.movilrubricaapp1.Model.Elemento;
import co.edu.uninorte.movilrubricaapp1.Model.Evaluacion;
import co.edu.uninorte.movilrubricaapp1.Model.Rubrica;
import co.edu.uninorte.movilrubricaapp1.databinding.EvaluacionCreacionActivityBinding;

/**
 * Created by fdjvf on 4/19/2017.
 */

public class EvaluacionCreacionActivity extends AppCompatActivity {
    Evaluacion evaluacion;
    Rubrica r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final EvaluacionCreacionActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.evaluacion_creacion_activity);
        Rubrica.deleteAll(Rubrica.class);
        Categoria.deleteAll(Categoria.class);
        Elemento.deleteAll(Elemento.class);
        PesoElemento.deleteAll(PesoElemento.class);
        PesoCategoria.deleteAll(PesoCategoria.class);

        Intent i = getIntent();
        i.getLongExtra("myCourseId", 0);

        fill();


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Rubrica.getListNames());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        binding.spinnerRubricas.setAdapter(adapter);
        binding.spinnerRubricas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                r = (Rubrica) Rubrica.ObservableListRubrica.get(position);
                List<Categoria> categorias = r.getCategorias();
                List<CategoriaPesoCategoria> categoriaPesoCategorias = new ArrayList<CategoriaPesoCategoria>();
                HashMap<Integer, ArrayList<ElementoPesoElemento>> miHash = new HashMap<Integer, ArrayList<ElementoPesoElemento>>();

                for (int i = 0; i < categorias.size(); i++) {
                    Categoria cat = categorias.get(i);
                    CategoriaPesoCategoria catpeso = new CategoriaPesoCategoria();
                    PesoCategoria pcat = new PesoCategoria();
                    pcat.setPeso("");
                    pcat.categoria = cat;
                    pcat.save();
                    catpeso.categoria = cat;
                    catpeso.pesoCategoria = pcat;

                    categoriaPesoCategorias.add(catpeso);

                    List<Elemento> elementos = cat.getElementoslista();
                    ArrayList<ElementoPesoElemento> elementoPesoElementos = new ArrayList<>();

                    for (Elemento var : elementos) {
                        PesoElemento pesoElemento = new PesoElemento();
                        pesoElemento.setPeso("");
                        pesoElemento.pesoCategoria = pcat;
                        pesoElemento.save();

                        ElementoPesoElemento elepeso = new ElementoPesoElemento();
                        elepeso.elemento = var;
                        elepeso.pesoElemento = pesoElemento;

                        elementoPesoElementos.add(elepeso);
                    }
                    miHash.put(i, elementoPesoElementos);

                }

                ExpandableListAdapter expandableListAdapter = new ExpandableListAdapter(EvaluacionCreacionActivity.this, categoriaPesoCategorias, miHash);
                binding.exprubrica.setAdapter(expandableListAdapter);
                //TODO: desactivar el spinner cuando cargue la rubrica
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Toolbar toolbar = binding.toolbar3;
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        evaluacion = new Evaluacion();
        //evaluacion.setAsignatura();
        // evaluacion.setRubrica(r);


        return true;
    }

    public void fill() {

        for (int i = 1; i < 11; i++) {
            Rubrica r = new Rubrica();
            r.setName("Rubrica " + i);
            r.Save();

            for (int j = 1; j < 6; j++) {
                Categoria cat = new Categoria();
                cat.setName("Categoria " + j);
                cat.rubrica = r;
                cat.save();

                for (int k = 1; k < 5; k++) {
                    Elemento el = new Elemento();
                    el.setName("Elemento " + k);
                    el.categoria = cat;
                    el.save();
                }
            }
        }
    }


}
