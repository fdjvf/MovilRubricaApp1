package co.edu.uninorte.movilrubricaapp1;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListAdapter;
import android.widget.ListView;


import co.edu.uninorte.movilrubricaapp1.Model.Asignatura;
import co.edu.uninorte.movilrubricaapp1.View.CourseListAdapter;
import co.edu.uninorte.movilrubricaapp1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

  public ObservableArrayList<Asignatura> t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding= DataBindingUtil.setContentView(this,R.layout.activity_main);

        for (int i=1;i<4;i++)
        {
            Asignatura asignatura=new Asignatura();
            asignatura.setDescription("Holaaaaaa" +i);
            asignatura.setName("Potato "+i);
            asignatura.save();
        }
        t=Asignatura.observableArrayList();
        binding.setObj(this);



}
    @BindingAdapter("bind:items")
    public  static void bindList(ListView view, ObservableArrayList<Asignatura> list) {
        ListAdapter adapter = new CourseListAdapter(list);
        view.setAdapter(adapter);
    }
}
