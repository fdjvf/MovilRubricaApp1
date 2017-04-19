package co.edu.uninorte.movilrubricaapp1;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.io.Serializable;

import co.edu.uninorte.movilrubricaapp1.Model.Asignatura;
import co.edu.uninorte.movilrubricaapp1.Model.Categoria;
import co.edu.uninorte.movilrubricaapp1.Model.Elemento;
import co.edu.uninorte.movilrubricaapp1.Model.Estudiante;
import co.edu.uninorte.movilrubricaapp1.Model.InfoNivel;
import co.edu.uninorte.movilrubricaapp1.Model.Rubrica;
import co.edu.uninorte.movilrubricaapp1.databinding.MainActivityBinding;

public class MainActivity extends AppCompatActivity implements ItemFragment.OnListElementClick, Serializable {


    MainActivityBinding binding;
    Asignatura t;
    boolean EditingRubrica;
    MyPagerAdapter myPagerAdapter;
    boolean EditingCurso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Asignatura.deleteAll(Asignatura.class);
        Rubrica.deleteAll(Rubrica.class);
        Estudiante.deleteAll(Estudiante.class);
        Categoria.deleteAll(Categoria.class);
        Elemento.deleteAll(Elemento.class);
        InfoNivel.deleteAll(InfoNivel.class);

        myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        binding = DataBindingUtil.setContentView(this, R.layout.main_activity);
        //Cuando se crea el elemento ya queda registradoo, puede modificarlo y luego guardarlo de nuevoo
        binding.viewpager.setAdapter(myPagerAdapter);

        // binding.CoursesList.setSelection(0);//Permite que la lista comience en una posicion espeficia


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {

            //     ItemFragment.bindList(   myPagerAdapter.Rubricas.getListView(),Rubrica.ObservableListRubrica);
        }
    }

    public void StartNewCreationActivity(View view) {

        int page = binding.viewpager.getCurrentItem();


        if (page == 0) {

            Intent myIntent = new Intent(this, NewCourse.class);
            startActivity(myIntent);

        } else {

            Intent myIntent = new Intent(this, RubricaCreacion.class);
            myIntent.putExtra("Edicion", false);
            myIntent.putExtra("Nuevo", true);
            startActivity(myIntent);

        }
    }

    @Override
    public void onListFragmentInteraction(int position) {
        int page = binding.viewpager.getCurrentItem();
        if (page == 0) {
            Intent myIntent = new Intent(this, EvaluacionEstudianteActivity.class);
            Asignatura selectedCourse= (Asignatura) Asignatura.ObserVableAsignaturas.get(position);
            long selectedCourseId= selectedCourse.getId();
            myIntent.putExtra("myCourseId", selectedCourseId);
            startActivity(myIntent);
            EditingCurso = true;
        } else {

            Intent myIntent = new Intent(this, RubricaCreacion.class);
            Rubrica selectedRubrica = (Rubrica) Rubrica.ObservableListRubrica.get(position);
            long idRubrica = selectedRubrica.getId();
            myIntent.putExtra("Edicion", true);
            EditingRubrica = true;
            myIntent.putExtra("Nuevo", false);
            myIntent.putExtra("rubricaId", idRubrica);
            startActivityForResult(myIntent, 1);


            //Comenzar actividad para la rubrica
        }

    }
}
