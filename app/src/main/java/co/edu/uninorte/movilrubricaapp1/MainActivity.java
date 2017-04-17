package co.edu.uninorte.movilrubricaapp1;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import co.edu.uninorte.movilrubricaapp1.Model.Asignatura;
import co.edu.uninorte.movilrubricaapp1.Model.Estudiante;
import co.edu.uninorte.movilrubricaapp1.Model.Rubrica;
import co.edu.uninorte.movilrubricaapp1.databinding.MainActivityBinding;

public class MainActivity extends AppCompatActivity implements ItemFragment.OnListElementClick {


    MainActivityBinding binding;
    Asignatura t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Asignatura.deleteAll(Asignatura.class);
        Rubrica.deleteAll(Rubrica.class);
        Estudiante.deleteAll(Estudiante.class);
        binding = DataBindingUtil.setContentView(this, R.layout.main_activity);
        t = new Asignatura();
        for (int i = 1; i < 4; i++) {

            t.setName("Curso " + i);
            t.setDescription("Breve Descripcion");
            t.Save();
            Rubrica r = new Rubrica();
            r.setName("Rubrica " + i);
            r.setDescripcion("Breve Descripcion");
            r.Save();
        }
        //Cuando se crea el elemento ya queda registradoo, puede modificarlo y luego guardarlo de nuevoo
        binding.viewpager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));


        //  binding.CoursesList.setSelection(0);//Permite que la lista comience en una posicion espeficia


}
    public void StartNewCreationActivity(View view) {

        int page = binding.viewpager.getCurrentItem();
        t.setDescription(page + "");

        if (page == 0) {

          /*  Intent myIntent = new Intent(this, NewCourse.class);
            startActivity(myIntent);*/

        } else {

            Intent myIntent = new Intent(this, RubricaCreacion.class);
            startActivity(myIntent);

        }
    }

    @Override
    public void onListFragmentInteraction(int position) {
        int page = binding.viewpager.getCurrentItem();
        if (page == 0) {
            Toast.makeText(this, "Curso" + position, Toast.LENGTH_LONG).show();
            //Comenzar activdad para el curso
        } else {
            Toast.makeText(this, "Rubrica" + position, Toast.LENGTH_LONG).show();
            //Comenzar actividad para la rubrica
        }

    }
}
