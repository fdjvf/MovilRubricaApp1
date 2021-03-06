package co.edu.uninorte.movilrubricaapp1;

import android.content.Intent;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import co.edu.uninorte.movilrubricaapp1.Adapters.EstudianteListAdapter;
import co.edu.uninorte.movilrubricaapp1.Model.Asignatura;
import co.edu.uninorte.movilrubricaapp1.databinding.CalificacionEstudiantesActivityBinding;

public class EstudiantesCalificacionActivity extends AppCompatActivity {
    public static long actualCourse;

    @BindingAdapter("bind:EstudianteItems")
    public static void bindList(ListView view, ObservableArrayList<Object> list) {
        view.setAdapter(new EstudianteListAdapter(Asignatura.ObservableEstudiantesCurso));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        actualCourse = intent.getLongExtra("myCourseId", 0);
        Asignatura as = Asignatura.findById(Asignatura.class, actualCourse);
        as.getEstudiante();
        CalificacionEstudiantesActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.calificacion_estudiantes_activity);
        binding.setNombreEst(as);
        binding.mylistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(EstudiantesCalificacionActivity.this, "SAD", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(EstudiantesCalificacionActivity.this, calificacionevaluacion.class);


                //Calificacion de evaluacion
            }
        });

    }
}
