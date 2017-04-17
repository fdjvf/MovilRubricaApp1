package co.edu.uninorte.movilrubricaapp1;

import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import co.edu.uninorte.movilrubricaapp1.Model.Categoria;
import co.edu.uninorte.movilrubricaapp1.databinding.CategoriaCreacionActivityBinding;
import co.edu.uninorte.movilrubricaapp1.databinding.CategoriaCreacionContentBinding;
import co.edu.uninorte.movilrubricaapp1.databinding.CategoriaDescripcionInputBinding;


public class CategoriaCreacion extends AppCompatActivity {

    public ObservableArrayList<Object> ElementList = new ObservableArrayList<>();
    CategoriaDescripcionInputBinding texboxinputBinding;
    Categoria categoria;
    int Nivel = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final CategoriaCreacionActivityBinding categoriaCreacionActivityBinding = DataBindingUtil.setContentView(this, R.layout.categoria_creacion_activity);
        final CategoriaCreacionContentBinding categoriaCreacionContentBinding = categoriaCreacionActivityBinding.categoriaContent;

        Intent intent = getIntent();

        Nivel = intent.getIntExtra("Nivel", 0);


        Toolbar toolbar = categoriaCreacionActivityBinding.toolbar;
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        categoria = new Categoria();
        categoria.setDescripcion("");
        categoria.setName("");

        categoriaCreacionContentBinding.setCategoriabinding(categoria);
        categoriaCreacionContentBinding.setElementList(this);
        categoriaCreacionActivityBinding.AgregarElemento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Actividad de creacion de elementos
                Intent temp = new Intent(CategoriaCreacion.this, ElementoCreacion.class);
                temp.putExtra("Nivel", Nivel);
                startActivityForResult(temp, 1);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Agrega todo
        //Verificar el nombre del item
        if (item.getTitle() != null) {

            final AlertDialog.Builder Alertbuilder = new AlertDialog.Builder(
                    CategoriaCreacion.this, R.style.Theme_AppCompat_Dialog_Alert);
            texboxinputBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.categoria_descripcion_input, null, false);
            texboxinputBinding.setDescripcionCategoria(categoria);
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
                    categoria.setDescripcion("");

                }
            });
            AlertDialog dialog = Alertbuilder.create();
            dialog.show();
        } else {
            //Oprime la flechita de salir y se guarda la rubrica
            categoria.save();
            finish();
        }

        return true;
    }
}