package co.edu.uninorte.movilrubricaapp1.Model;

import android.databinding.Bindable;
import android.databinding.Observable;
import android.databinding.PropertyChangeRegistry;

import com.orm.SugarRecord;

import java.util.ArrayList;


public class Estudiante extends SugarRecord implements Observable {
    String name;
    Boolean state;
    ArrayList<Evaluacion> Evaluaciones;
    private PropertyChangeRegistry registry = new PropertyChangeRegistry();

    public Estudiante() {
    }

    public Estudiante(String name, Boolean state, ArrayList<Evaluacion> evaluaciones) {
        this.name = name;
        this.state = state;
        Evaluaciones = evaluaciones;
    }

    @Bindable
    public String getName() {
        return name;
    }

    @Bindable
    public void setName(String name) {
        this.name = name;
        //    registry.notifyChange(this, BR);
    }

    public Boolean getState() {
        return state;
    }

    @Bindable
    public void setState(Boolean state) {
        this.state = state;
        //     registry.notifyChange(this, BR.bar);
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
