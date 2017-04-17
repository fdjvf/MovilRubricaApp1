package co.edu.uninorte.movilrubricaapp1.Model;

import android.databinding.Bindable;
import android.databinding.Observable;
import android.databinding.ObservableArrayList;
import android.databinding.PropertyChangeRegistry;

import com.orm.SugarRecord;

import java.util.List;

import co.edu.uninorte.movilrubricaapp1.BR;

/**
 * Created by fdjvf on 4/11/2017.
 */

public class Rubrica extends SugarRecord implements Observable {

    public static ObservableArrayList<Object> ObservableListRubrica = new ObservableArrayList<>();
    //    final static private boolean t = ObservableListRubrica.addAll(Rubrica.listAll(Rubrica.class));
    public ObservableArrayList<Categoria> ObservableListRubricaCategorias;
    public int EscalaMaxima;
    String name;
    String descripcion;
    private PropertyChangeRegistry registry = new PropertyChangeRegistry();

    public Rubrica() {
    }

    public Rubrica(String name, int niveles, String descripcion) {
        this.name = name;
        this.EscalaMaxima = niveles;
        this.descripcion = descripcion;
    }

    @Bindable
    public String getName() {
        return name;
    }//Implementar Observable en el Display

    @Bindable
    public void setName(String name) {
        this.name = name;
        registry.notifyChange(this, BR.rubricamodel);
    }

    @Bindable
    public String getDescripcion() {
        return descripcion;

    }

    @Bindable
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        registry.notifyChange(this, BR.rubricamodel);
    }

    public List<Categoria> getCategorias() {
        List<Categoria> temp = Categoria.find(Categoria.class, "rubrica = ?", String.valueOf(this.getId()));
        ObservableListRubricaCategorias.addAll(temp);
        return temp;
    }
    public void Save() {
        ObservableListRubrica.add(this);
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
