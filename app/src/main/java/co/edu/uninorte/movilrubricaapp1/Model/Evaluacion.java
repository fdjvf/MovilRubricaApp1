package co.edu.uninorte.movilrubricaapp1.Model;

import android.databinding.Bindable;
import android.databinding.Observable;
import android.databinding.ObservableArrayList;
import android.databinding.PropertyChangeRegistry;

import com.orm.SugarRecord;

import co.edu.uninorte.movilrubricaapp1.BR;

/**
 * Created by fdjvf on 4/11/2017.
 */

public class Evaluacion extends SugarRecord implements Observable {

    String Nombre;
    Asignatura asignatura;
    Rubrica rubrica;
    public static ObservableArrayList<Object> ObservableListEvaluaciones = new ObservableArrayList<>();
   // private PropertyChangeRegistry registry = new PropertyChangeRegistry();
    //Siempre antes de guardar estos, ya se debió haber guardado la rubrica y la asignatura

    public Evaluacion() {

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
    @Bindable
    public void setNombre(String nombre) {
        this.Nombre = nombre;
        //registry.notifyChange(this, BR.eval);

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
