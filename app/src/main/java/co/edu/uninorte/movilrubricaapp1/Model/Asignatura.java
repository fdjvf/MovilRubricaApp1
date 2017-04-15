package co.edu.uninorte.movilrubricaapp1.Model;

import android.databinding.BindingAdapter;
import android.databinding.ObservableArrayList;
import android.widget.ListView;

import com.orm.SugarRecord;

import java.util.ArrayList;

import co.edu.uninorte.movilrubricaapp1.Adapters.CourseListAdapter;

/**
 * Created by fdjvf on 4/11/2017.
 */

public class Asignatura extends SugarRecord {

    public static ObservableArrayList<Object> list2 = new ObservableArrayList<>();
    final static private boolean t = list2.addAll(Asignatura.listAll(Asignatura.class));
    String name;
    String description;
    ArrayList<Estudiante> estudiantes;
    ArrayList<Evaluacion> evaluaciones;

    public Asignatura() {
    }

    public Asignatura(String name, String description, ArrayList<Estudiante> estudiantes, ArrayList<Evaluacion> evaluaciones) {
        this.name = name;
        this.description = description;
        this.estudiantes = estudiantes;
        this.evaluaciones = evaluaciones;

    }

    @BindingAdapter("bind:CourseItems")
    public static void bindList(ListView view, ObservableArrayList<Object> list) {
        CourseListAdapter adapter = new CourseListAdapter(list);
        view.setAdapter(adapter);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void Save()
    {
        list2.add(this);
        this.save();
    }


}
