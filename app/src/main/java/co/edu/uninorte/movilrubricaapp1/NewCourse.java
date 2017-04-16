package co.edu.uninorte.movilrubricaapp1;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import co.edu.uninorte.movilrubricaapp1.Model.Asignatura;
import co.edu.uninorte.movilrubricaapp1.Model.Estudiante;
import co.edu.uninorte.movilrubricaapp1.databinding.CursoActivityNuevoCursoBinding;


public class NewCourse extends AppCompatActivity {

    public ObservableArrayList<Estudiante> CourseStudents;
    public Estudiante FirstStudent = new Estudiante();
    public Asignatura newAsignatura;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CursoActivityNuevoCursoBinding binding = DataBindingUtil.setContentView(this, R.layout.curso_activity_nuevo_curso);
        newAsignatura = new Asignatura();
        CourseStudents = newAsignatura.getEstudiantes();

        binding.setStudentModel(this);
        binding.setCoursemodel(newAsignatura);
        binding.setFirststudent(FirstStudent);


        //      StudentHints.add(new StudentHint("Estudiante " + StudentHints.size()));

    }


    public void NewEntryStudent(View view) {
        //    StudentHints.add(new StudentHint("Estudiante " + StudentHint.Count));//Floatin Button
        Estudiante estudiante = new Estudiante();
        CourseStudents.add(estudiante);




    }

    public void SaveCourse(View view) {
        CourseStudents.add(FirstStudent);
        newAsignatura.Save();
        this.finish();

        //Guardar Curso
    }

    public void DeleteEntryStudent(View view) {
        int pos = (int) view.getTag();
        CourseStudents.remove(pos);
        //Borra un student


    }

}
