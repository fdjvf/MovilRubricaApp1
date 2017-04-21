package co.edu.uninorte.movilrubricaapp1;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import co.edu.uninorte.movilrubricaapp1.Model.Asignatura;
import co.edu.uninorte.movilrubricaapp1.Model.Estudiante;
import co.edu.uninorte.movilrubricaapp1.Model.Evaluacion;
import co.edu.uninorte.movilrubricaapp1.Model.Rubrica;
import co.edu.uninorte.movilrubricaapp1.databinding.EvaluacionEstudianteActivityBinding;

public class EvaluacionEstudianteActivity extends AppCompatActivity implements ItemFragmentEvalEst.OnListElementClick2 {
//TODO: EVERYTHING
EvaluacionEstudianteActivityBinding binding;
    Evaluacion eval;
    Estudiante est;
    Rubrica rub;
    Asignatura actualCourse;
    long actualCourseId;
//TODO: Mandar en el intent el curso que escogió para sacar los estudiante y las evaluaciones pertenecientes a él
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.evaluacion_estudiante_activity);

        Intent intent = getIntent();
        actualCourseId=  intent.getLongExtra("myCourseId",0);
        actualCourse = Asignatura.findById(Asignatura.class, actualCourseId);


        binding.viewpagerEvalEstudiante.setAdapter(new myPagerAdapterEvalEst(getSupportFragmentManager(), actualCourseId));
    }

    //TODO: OnlistFragmentInteraction()
    public void StartNewCreationActivity1(View view) {

        int page = binding.viewpagerEvalEstudiante.getCurrentItem();

        if (page == 0) {

            Toast.makeText(this, "Evaluacion", Toast.LENGTH_LONG).show();
            Intent myIntent = new Intent(this, EvaluacionCreacionActivity.class);
            myIntent.putExtra("myCourseId",actualCourseId);
            startActivityForResult(myIntent, 1);


        } else {

            /*Intent myIntent = new Intent(this, RubricaCreacion.class);
            startActivity(myIntent);*/

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {

            binding.viewpagerEvalEstudiante.setAdapter(new myPagerAdapterEvalEst(getSupportFragmentManager(), actualCourseId));
        }


    }

    @Override
    public void onListFragmentInteraction(int position) {
        int page = binding.viewpagerEvalEstudiante.getCurrentItem();
        if (page == 0) {
            Intent myIntent = new Intent(this, EstudiantesCalificacionActivity.class);
            myIntent.putExtra("myCourseId", actualCourseId);

        } else {
            Toast.makeText(this, "Estudiante" + position, Toast.LENGTH_LONG).show();
            //Comenzar actividad para la rubrica
        }

    }


}
