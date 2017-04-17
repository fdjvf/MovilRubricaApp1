package co.edu.uninorte.movilrubricaapp1;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import co.edu.uninorte.movilrubricaapp1.Model.Elemento;
import co.edu.uninorte.movilrubricaapp1.Model.InfoNivel;
import co.edu.uninorte.movilrubricaapp1.databinding.ElementoCreacionActivityBinding;
import co.edu.uninorte.movilrubricaapp1.databinding.ElementoCreacionContentBinding;
import co.edu.uninorte.movilrubricaapp1.databinding.ElementoDescripcionInputBinding;

public class ElementoCreacion extends AppCompatActivity {


    public ObservableArrayList<Object> ElementList = new ObservableArrayList<>();
    ElementoDescripcionInputBinding texboxinputBinding;
    Elemento elemento;
    int Nivel = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ElementoCreacionActivityBinding elementoCreacionActivityBinding = DataBindingUtil.setContentView(this, R.layout.elemento_creacion_activity);
        ElementoCreacionContentBinding elementoCreacionContentBinding = elementoCreacionActivityBinding.elementoContent;

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
