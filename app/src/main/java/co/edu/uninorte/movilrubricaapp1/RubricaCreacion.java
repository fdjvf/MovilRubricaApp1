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
import android.widget.AdapterView;

import co.edu.uninorte.movilrubricaapp1.Model.Categoria;
import co.edu.uninorte.movilrubricaapp1.Model.Rubrica;
import co.edu.uninorte.movilrubricaapp1.databinding.RubricaCreacionBinding;
import co.edu.uninorte.movilrubricaapp1.databinding.RubricaCreacionContentBinding;
import co.edu.uninorte.movilrubricaapp1.databinding.RubricaDescripcionInputBinding;


public class RubricaCreacion extends AppCompatActivity {

    public ObservableArrayList<Object> mylist = new ObservableArrayList<>();
    public Rubrica rubrica;
    RubricaDescripcionInputBinding texboxinputBinding;
    private Boolean doSomething = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final RubricaCreacionBinding rubricaCreacionBinding = DataBindingUtil.setContentView(this, R.layout.rubrica_creacion);
        final RubricaCreacionContentBinding rubricaCreacionContentBinding = rubricaCreacionBinding.rubricaContent;

        Toolbar toolbar = rubricaCreacionBinding.toolbar;
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rubrica = new Rubrica();
        rubrica.setName("");
        rubrica.setDescripcion("");

        rubricaCreacionContentBinding.setRubricamodel(rubrica);
        rubricaCreacionContentBinding.setCategoriamodel(this);
        rubricaCreacionBinding.AgregarCategoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent temp = new Intent(RubricaCreacion.this, CategoriaCreacion.class);
                temp.putExtra("Nivel", Integer.valueOf(rubricaCreacionContentBinding.LevelsSpinner.getSelectedItem().toString()));
                startActivityForResult(temp, 1);


            }
        });
        rubricaCreacionContentBinding.LevelsSpinner.setSelection(0);
        rubricaCreacionContentBinding.LevelsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (!doSomething) {
                    doSomething = true;

                } else {//Permite actualizar la vista con los elementos correspondientes
                    if (position == 0) {//Escala 3
                        mylist = Categoria.getCategorias(3);
                    } else if (position == 1) {//Escala 4
                        mylist = Categoria.getCategorias(4);
                    } else {//Escala 5
                        mylist = Categoria.getCategorias(5);
                    }

//                   Toast.makeText(RubricaCreacion.this,"Hola "+position,Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

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
                    RubricaCreacion.this, R.style.Theme_AppCompat_Dialog_Alert);
            texboxinputBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.rubrica_descripcion_input, null, false);
            texboxinputBinding.setDescripcionRubrica(rubrica);
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
            AlertDialog dialog = Alertbuilder.create();
            dialog.show();
        } else {
            //Oprime la flechita de salir y se guarda la rubrica
            rubrica.Save();
            finish();
        }

        return true;
    }
}
