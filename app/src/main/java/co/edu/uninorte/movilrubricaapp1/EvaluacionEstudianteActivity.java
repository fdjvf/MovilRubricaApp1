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
    long actualCourseId;
//TODO: Mandar en el intent el curso que escogió para sacar los estudiante y las evaluaciones pertenecientes a él
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.evaluacion_estudiante_activity);

        Intent intent = getIntent();
        actualCourseId=  intent.getLongExtra("myCourseId",0);
        Asignatura actualCourse= Asignatura.findById(Asignatura.class,actualCourseId);

     //   actualCourse.getEstudiante();
   //    actualCourse.getEvaluaciones();

        binding.viewpagerEvalEstudiante.setAdapter(new myPagerAdapterEvalEst(getSupportFragmentManager(),actualCourse.getId()   ));
    }

    //TODO: OnlistFragmentInteraction()
    public void StartNewCreationActivity(View view) {

        int page = binding.viewpagerEvalEstudiante.getCurrentItem();

        if (page == 0) {

            Toast.makeText(this, "Evaluacion", Toast.LENGTH_LONG).show();
            Intent myIntent = new Intent(this, EvaluacionCreacionActivity.class);
            myIntent.putExtra("myCourseId",actualCourseId);
            startActivity(myIntent);

        } else {

            /*Intent myIntent = new Intent(this, RubricaCreacion.class);
            startActivity(myIntent);*/

        }
    }

    @Override
    public void onListFragmentInteraction(int position) {
        int page = binding.viewpagerEvalEstudiante.getCurrentItem();
        if (page == 0) {
            Toast.makeText(this, "Evaluacion" + position, Toast.LENGTH_LONG).show();
            //Comenzar activdad para el curso
        } else {
            Toast.makeText(this, "Estudiante" + position, Toast.LENGTH_LONG).show();
            //Comenzar actividad para la rubrica
        }

    }


}
