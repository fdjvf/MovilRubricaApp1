package co.edu.uninorte.movilrubricaapp1;

import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import co.edu.uninorte.movilrubricaapp1.Adapters.ElementInfoListAdapter;
import co.edu.uninorte.movilrubricaapp1.Model.Elemento;
import co.edu.uninorte.movilrubricaapp1.Model.InfoNivel;
import co.edu.uninorte.movilrubricaapp1.databinding.ElementoCreacionActivityBinding;
import co.edu.uninorte.movilrubricaapp1.databinding.ElementoCreacionContentBinding;
import co.edu.uninorte.movilrubricaapp1.databinding.ElementoDescripcionInputBinding;

public class ElementoCreacion extends AppCompatActivity {


    public ObservableArrayList<Object> ElementList = new ObservableArrayList<>();
    ElementoDescripcionInputBinding texboxinputBinding;
    ElementoCreacionContentBinding elementoCreacionContentBinding;
    Elemento elemento;
    int Nivel = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ElementoCreacionActivityBinding elementoCreacionActivityBinding = DataBindingUtil.setContentView(this, R.layout.elemento_creacion_activity);
        elementoCreacionContentBinding = elementoCreacionActivityBinding.elementoContent;

        Intent intent = getIntent();

        Nivel = intent.getIntExtra("Nivel", 0);
        Toolbar toolbar = elementoCreacionActivityBinding.toolbar;
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        elemento = new Elemento();
        elemento.setName("");
        LoadList();
        elementoCreacionContentBinding.setElementonewBinding(elemento);
        elementoCreacionContentBinding.setInfoelementList(this);
        elementoCreacionContentBinding.ElementosListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                final int pos = position;
                final AlertDialog.Builder Alertbuilder = new AlertDialog.Builder(
                        ElementoCreacion.this, R.style.Theme_AppCompat_Dialog_Alert);
                texboxinputBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.elemento_descripcion_input, null, false);
                texboxinputBinding.setDescripcionInfoNivel((InfoNivel) ElementList.get(pos));
                Alertbuilder.setTitle("Ingresar descripcion");
                Alertbuilder.setCancelable(false);
                Alertbuilder.setView(texboxinputBinding.getRoot());
                Alertbuilder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ElementInfoListAdapter.bindList(elementoCreacionContentBinding.ElementosListView, ElementList);
                    }
                });

                Alertbuilder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ((InfoNivel) ElementList.get(pos)).setDescripcion("");
                        ElementInfoListAdapter.bindList(elementoCreacionContentBinding.ElementosListView, ElementList);

                    }
                });
                AlertDialog dialog = Alertbuilder.create();
                dialog.show();

            }
        });
    }

    public void LoadList() {
        for (int i = 1; i <= Nivel; i++) {
            ElementList.add(new InfoNivel("Breve Descripcion", i));
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        elemento.save();

        // setResult(0,);
        finish();
        return true;
    }
}
