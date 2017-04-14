package co.edu.uninorte.movilrubricaapp1;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import co.edu.uninorte.movilrubricaapp1.Model.Asignatura;
import co.edu.uninorte.movilrubricaapp1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    public ObservableArrayList<Object> CourseList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        Asignatura.deleteAll(Asignatura.class);
        CourseList = Asignatura.list;
        binding.setObj(this);
        //  binding.CoursesList.setSelection(0);//Permite que la lista comience en una posicion espeficia


}


    public void CreateCourseActivity(View view) {
        Asignatura asignatura = new Asignatura();
        asignatura.setDescription("Breve Descripcion");
        asignatura.setName("Materia " + Asignatura.list.size());
        asignatura.Save();

    }
}
