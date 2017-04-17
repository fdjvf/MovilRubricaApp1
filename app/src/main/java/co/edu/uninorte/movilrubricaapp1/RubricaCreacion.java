package co.edu.uninorte.movilrubricaapp1;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import co.edu.uninorte.movilrubricaapp1.databinding.RubricaCreacionBinding;
import co.edu.uninorte.movilrubricaapp1.databinding.RubricaCreacionContentBinding;

public class RubricaCreacion extends AppCompatActivity {

    public ObservableArrayList<Object> mylist = new ObservableArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RubricaCreacionBinding rubricaCreacionBinding = DataBindingUtil.setContentView(this, R.layout.rubrica_creacion);
        RubricaCreacionContentBinding rubricaCreacionContentBinding = rubricaCreacionBinding.rubricaContent;
        Toolbar toolbar = rubricaCreacionBinding.toolbar;
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rubricaCreacionContentBinding.setCategoriamodel(this);

        rubricaCreacionBinding.AgregarCategoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //      Intent temp=new Intent(this,CreacionCate)
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        //Verificar el nombre del item
        finish();
        return true;
    }
}
