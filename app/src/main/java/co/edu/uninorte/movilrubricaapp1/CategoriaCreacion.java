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
import co.edu.uninorte.movilrubricaapp1.Model.Elemento;
import co.edu.uninorte.movilrubricaapp1.Model.Rubrica;
import co.edu.uninorte.movilrubricaapp1.databinding.CategoriaCreacionActivityBinding;
import co.edu.uninorte.movilrubricaapp1.databinding.CategoriaCreacionContentBinding;
import co.edu.uninorte.movilrubricaapp1.databinding.CategoriaDescripcionInputBinding;


public class CategoriaCreacion extends AppCompatActivity {

    public ObservableArrayList<Object> ElementList = new ObservableArrayList<>();
    CategoriaDescripcionInputBinding texboxinputBinding;
    Categoria categoria;
    Rubrica myrubrica;
    int Nivel = 0;
    boolean IsEditable;
    boolean isNew;
    boolean elementedited;
    int LastClicked = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final CategoriaCreacionActivityBinding categoriaCreacionActivityBinding = DataBindingUtil.setContentView(this, R.layout.categoria_creacion_activity);
        final CategoriaCreacionContentBinding categoriaCreacionContentBinding = categoriaCreacionActivityBinding.categoriaContent;

        Intent intent = getIntent();
        IsEditable = intent.getBooleanExtra("Edicion", true);
        isNew = intent.getBooleanExtra("Nuevo", true);

        if (!isNew) {
            categoriaCreacionActivityBinding.AgregarElemento.setEnabled(false);
        }
        if (IsEditable) {

            long catid = intent.getLongExtra("CateEdit", 0);
            categoria = Categoria.findById(Categoria.class, catid);
            categoria.getElementos();
            ElementList = categoria.ObservableListElements;

        } else {

            long id = intent.getLongExtra("Rubrica", 0);
            myrubrica = Rubrica.findById(Rubrica.class, id);
            Nivel = myrubrica.EscalaMaxima;
            categoria = new Categoria();
            categoria.rubrica = myrubrica;
            categoria.setDescripcion("");
            categoria.setName("");
            categoria.save();
        }
        Toolbar toolbar = categoriaCreacionActivityBinding.toolbar;
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        categoriaCreacionContentBinding.setCategoriabinding(categoria);
        categoriaCreacionContentBinding.setElementList(this);
        categoriaCreacionContentBinding.ElementosListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent temp = new Intent(CategoriaCreacion.this, ElementoCreacion.class);
                temp.putExtra("Edicion", true);
                elementedited = true;
                LastClicked = position;
                Elemento elemento = (Elemento) ElementList.get(position);
                temp.putExtra("elementoedit", elemento.getId());
                startActivityForResult(temp, 1);


            }
        });

        categoriaCreacionActivityBinding.AgregarElemento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Actividad de creacion de elementos
                Intent temp = new Intent(CategoriaCreacion.this, ElementoCreacion.class);
                temp.putExtra("Edicion", false);
                temp.putExtra("Categoria", categoria.getId());
                startActivityForResult(temp, 1);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (elementedited) {
            long id = data.getLongExtra("editcElemento", 1);
            Elemento elemento = Elemento.findById(Elemento.class, id);
            ElementList.set(LastClicked, elemento);
            elementedited = false;
        } else {

            if (resultCode == RESULT_OK) {
                long id = data.getLongExtra("NuevoElemento", 0);
                Elemento newElement = Elemento.findById(Elemento.class, id);
                ElementList.add(newElement);
            }


        }
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

            Intent myIntent = getIntent();
            if (IsEditable) {
                categoria.save();
                myIntent.putExtra("editcategoria", categoria.getId());
                setResult(RESULT_OK, myIntent);
            } else {
                if (!categoria.getElementoslista().isEmpty()) {
                    if (categoria.getDescripcion().isEmpty()) {
                        categoria.setDescripcion("Breve Descripción");
                    }
                    if (categoria.getName().isEmpty()) {
                        categoria.setName("Categoria " + myrubrica.getCategorias().size());
                    }
                    categoria.rubrica = myrubrica;
                    categoria.save();
                    myIntent.putExtra("NewCategoria", categoria.getId());

                    setResult(RESULT_OK, myIntent);
                } else {
                    setResult(RESULT_CANCELED, myIntent);
                    categoria.delete();
                }

            }

            finish();
        }

        return true;
    }
}