package co.edu.uninorte.movilrubricaapp1;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import co.edu.uninorte.movilrubricaapp1.Adapters.StudentHint;
import co.edu.uninorte.movilrubricaapp1.databinding.CursoActivityNuevoCursoBinding;

public class NewCourse extends AppCompatActivity {

    public ObservableArrayList<Object> StudentHints = new ObservableArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CursoActivityNuevoCursoBinding binding = DataBindingUtil.setContentView(this, R.layout.curso_activity_nuevo_curso);
        StudentHints.add(new StudentHint("Estudiante " + StudentHints.size()));
        binding.setObj(this);
    }

    public void NewEntryStudent(View view) {
        StudentHints.add(new StudentHint("Estudiante " + StudentHint.Count));
    }
}
