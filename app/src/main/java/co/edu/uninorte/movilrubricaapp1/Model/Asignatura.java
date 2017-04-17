package co.edu.uninorte.movilrubricaapp1.Model;

import android.databinding.Bindable;
import android.databinding.Observable;
import android.databinding.ObservableArrayList;
import android.databinding.PropertyChangeRegistry;

import com.orm.SugarRecord;

import java.util.ArrayList;

/**
 * Created by fdjvf on 4/11/2017.
 */

public class Asignatura extends SugarRecord implements Observable {

    public static ObservableArrayList<Object> list2 = new ObservableArrayList<>();
    final static private boolean t = list2.addAll(Asignatura.listAll(Asignatura.class));



    String name = "";
    String description = "";
    ObservableArrayList<Estudiante> estudiantes = new ObservableArrayList<>();
    ArrayList<Evaluacion> evaluaciones;

    private PropertyChangeRegistry registry = new PropertyChangeRegistry();

    public Asignatura() {
    }

    public Asignatura(String name, String description, ObservableArrayList<Estudiante> estudiantes, ArrayList<Evaluacion> evaluaciones, PropertyChangeRegistry registry1) {
        this.name = name;
        this.description = description;
        this.estudiantes = estudiantes;
        this.evaluaciones = evaluaciones;

    }

    @Bindable
    public String getName() {
        return name;
    }

    @Bindable
    public void setName(String name) {
        this.name = name;
        //    registry.notifyChange(this, BR.);
    }

    @Bindable
    public String getDescription() {
        return description;
    }

    @Bindable
    public void setDescription(String description) {
        this.description = description;
        //      registry.notifyChange(this, BR.coursemodel);
    }

    public ObservableArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(ObservableArrayList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }



    public void Save()
    {
        list2.add(this);
        this.save();
        for (Estudiante t : estudiantes) {
            t.save();
        }
    }


    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback onPropertyChangedCallback) {
        registry.add(onPropertyChangedCallback);
    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback onPropertyChangedCallback) {
        registry.remove(onPropertyChangedCallback);

    }
}
