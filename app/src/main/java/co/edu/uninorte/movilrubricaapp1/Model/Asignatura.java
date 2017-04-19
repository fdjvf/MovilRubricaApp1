package co.edu.uninorte.movilrubricaapp1.Model;

import android.databinding.Bindable;
import android.databinding.Observable;
import android.databinding.ObservableArrayList;
import android.databinding.PropertyChangeRegistry;

import com.orm.SugarRecord;

import java.io.Serializable;
import java.util.List;

import co.edu.uninorte.movilrubricaapp1.BR;

/**
 * Created by fdjvf on 4/11/2017.
 */

public class Asignatura extends SugarRecord implements Observable {
    //Manejo de Binding

    public static ObservableArrayList<Object> ObserVableAsignaturas = new ObservableArrayList<>();
//    final static private boolean l = ObserVableAsignaturas.addAll(Asignatura.listAll(Asignatura.class));

    public ObservableArrayList<Object> ObservableEstudiantesCurso = new ObservableArrayList<>();
    public ObservableArrayList<Object> ObservableEvaluacionesCurso = new ObservableArrayList<>();

    String name = "";
    String description = "";
    private PropertyChangeRegistry registry = new PropertyChangeRegistry();

    public Asignatura() {
    }

    public Asignatura(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Bindable
    public String getName() {
        return name;
    }

    @Bindable
    public void setName(String name) {
        this.name = name;
        registry.notifyChange(this, BR.coursemodel);//Permite doble binding
    }

    @Bindable
    public String getDescription() {
        return description;
    }

    @Bindable
    public void setDescription(String description) {
        this.description = description;
        registry.notifyChange(this, BR.coursemodel);
    }

    //Solo utilizar para creacion, de resto utilizar el save
    public void Save()
    {
        ObserVableAsignaturas.add(this);
        this.save();
    }

    public boolean getEstudiante() {
        List<Estudiante> temp = Estudiante.find(Estudiante.class, "asignatura = ?", String.valueOf(this.getId()));
        return ObservableEstudiantesCurso.addAll(temp);//Nuevo estudiante, se guarda el solo y ademas se guarda en este observable

    }

    public List<Evaluacion> getEvaluaciones() {
        List<Evaluacion> temp = Evaluacion.find(Evaluacion.class, "asignatura = ?", String.valueOf(this.getId()));
        ObservableEvaluacionesCurso.addAll(temp);//Nuevo estudiante, se guarda el solo y ademas se guarda en este observable
        return temp;
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
