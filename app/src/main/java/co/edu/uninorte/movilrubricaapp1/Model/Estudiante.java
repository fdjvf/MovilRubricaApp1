package co.edu.uninorte.movilrubricaapp1.Model;

import android.databinding.Bindable;
import android.databinding.Observable;
import android.databinding.ObservableArrayList;
import android.databinding.PropertyChangeRegistry;

import com.orm.SugarRecord;

import co.edu.uninorte.movilrubricaapp1.BR;


public class Estudiante extends SugarRecord implements Observable {


    public static ObservableArrayList<Object> ObservableListEstudiantes = new ObservableArrayList<>();
    String name = "";
    Boolean state;
    Asignatura asignatura;
    private PropertyChangeRegistry registry = new PropertyChangeRegistry();

    public Estudiante() {

    }

    public Estudiante(String name, Boolean state, Asignatura asignatura) {
        this.name = name;
        this.state = state;
        this.asignatura = asignatura;

    }

    //Siempre guardar el ID
    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    @Bindable
    public String getName() {
        return name;
    }

    @Bindable
    public void setName(String name) {
        this.name = name;
        registry.notifyChange(this, BR.studenthint);
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
         //registry.notifyChange(this, BR.bar);
    }
    public void Save() {
        ObservableListEstudiantes.add(this);
        this.save();
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
