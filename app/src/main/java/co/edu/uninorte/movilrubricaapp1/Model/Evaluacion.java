package co.edu.uninorte.movilrubricaapp1.Model;

import android.databinding.Bindable;
import android.databinding.Observable;
import android.databinding.ObservableArrayList;

import com.orm.SugarRecord;

/**
 * Created by fdjvf on 4/11/2017.
 */

public class Evaluacion extends SugarRecord implements Observable{

    public static ObservableArrayList<Object> ObservableListEvaluaciones = new ObservableArrayList<>();
    String Nombre;
    Asignatura asignatura;
    Rubrica rubrica;
   // private PropertyChangeRegistry registry = new PropertyChangeRegistry();
    //Siempre antes de guardar estos, ya se debió haber guardado la rubrica y la asignatura

    //Siempre antes de guardar estos, ya se debdio haber guardado la rubrica y la asignatura
    public Evaluacion() {

    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public Evaluacion(String nombre, Asignatura curso) {
        this.Nombre = nombre;
        this.asignatura = curso;
    }

    public String getRubrica() {
        return rubrica.getName();
    }

    public void setRubrica(Rubrica rubrica) {
        this.rubrica = rubrica;
    }

    @Bindable
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public void Save() {
        ObservableListEvaluaciones.add(this);
        this.save();
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback onPropertyChangedCallback) {

    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback onPropertyChangedCallback) {

    }
}
