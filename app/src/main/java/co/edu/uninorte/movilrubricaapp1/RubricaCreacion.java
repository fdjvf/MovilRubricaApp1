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
import android.widget.Toast;

import co.edu.uninorte.movilrubricaapp1.Model.Categoria;
import co.edu.uninorte.movilrubricaapp1.Model.Rubrica;
import co.edu.uninorte.movilrubricaapp1.databinding.RubricaCreacionBinding;
import co.edu.uninorte.movilrubricaapp1.databinding.RubricaCreacionContentBinding;
import co.edu.uninorte.movilrubricaapp1.databinding.RubricaDescripcionInputBinding;


public class RubricaCreacion extends AppCompatActivity {

    public ObservableArrayList<Object> mylist = new ObservableArrayList<>();
    public Rubrica rubrica;
    RubricaDescripcionInputBinding texboxinputBinding;
    RubricaCreacionBinding rubricaCreacionBinding;
    Boolean isEditable;
    RubricaCreacionContentBinding rubricaCreacionContentBinding;
    private Boolean doSomething = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        rubricaCreacionBinding = DataBindingUtil.setContentView(this, R.layout.rubrica_creacion);
        rubricaCreacionContentBinding = rubricaCreacionBinding.rubricaContent;
        Intent t = getIntent();
        rubricaCreacionBinding.AgregarCategoria.setEnabled(false);
        isEditable = t.getBooleanExtra("Edicion", true);
        if (isEditable) {
            //Modo edicion activado
            long id = t.getLongExtra("RubId", 0);
            rubrica = Rubrica.findById(Rubrica.class, id);
            rubricaCreacionContentBinding.LevelsSpinner.setEnabled(false);

        } else {
            //Modo nueva rubrica activado
            rubrica = new Rubrica();
            rubrica.setName("");
            rubrica.setDescripcion("");
            rubrica.save();
            //guardado normalito, sin agregarlo a la vaina observable

            rubricaCreacionContentBinding.LevelsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (!doSomething) {
                        doSomething = true;

                    } else {//Permite actualizar la vista con los elementos correspondientes
                        rubricaCreacionContentBinding.LevelsSpinner.setEnabled(false);
                        rubrica.EscalaMaxima = position + 3;
                        rubrica.save();
                        rubricaCreacionBinding.AgregarCategoria.setEnabled(true);
                        Toast.makeText(RubricaCreacion.this, "A partir de ahora, usted no puede modificar la escala de calificación ", Toast.LENGTH_LONG).show();
                    }

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });


            rubricaCreacionBinding.AgregarCategoria.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent temp = new Intent(RubricaCreacion.this, CategoriaCreacion.class);
                    temp.putExtra("Rubrica", rubrica.getId());

                    startActivityForResult(temp, 1);


                }
            });
        }

        Toolbar toolbar = rubricaCreacionBinding.toolbar;
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rubricaCreacionContentBinding.setRubricamodel(rubrica);
        rubricaCreacionContentBinding.setCategoriamodel(this);
        //     rubricaCreacionContentBinding.LevelsSpinner.setSelection(0);

        rubricaCreacionContentBinding.CategoriasDisponiblesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Categoria categoria = (Categoria) mylist.get(position);
                Intent temp = new Intent(RubricaCreacion.this, CategoriaCreacion.class);
                temp.putExtra("Edicion", isEditable);
                temp.putExtra("CateEdit", categoria.getId());
                startActivityForResult(temp, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //Agregado nuevo valor
        if (resultCode == RESULT_OK) {
            long id = data.getLongExtra("NewCategoria", 0);

            Categoria categoria = Categoria.findById(Categoria.class, id);

            mylist.add(categoria);
        }


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
            //    rubrica.EscalaMaxima=rubricaCreacionContentBinding.LevelsSpinner.getdROW
            if (!rubrica.getCategorias().isEmpty()) {
                if (rubrica.getDescripcion().isEmpty()) {
                    rubrica.setDescripcion("Breve Descripción");
                }
                if (rubrica.getName().isEmpty()) {
                    rubrica.setName("Rubrica " + Rubrica.ObservableListRubrica.size() + 1);
                }
                rubrica.Save();
            } else {
                rubrica.delete();
            }
            finish();

        }

        return true;
    }
}
