package co.edu.uninorte.movilrubricaapp1.Model;

import android.databinding.ObservableArrayList;

import com.orm.SugarRecord;

import java.util.List;

/**
 * Created by fdjvf on 4/11/2017.
 */

public class Rubrica extends SugarRecord {
    public static ObservableArrayList<Object> ObservableListRubrica = new ObservableArrayList<>();
    final static private boolean t = ObservableListRubrica.addAll(Rubrica.listAll(Rubrica.class));
    public ObservableArrayList<Categoria> ObservableListRubricaCategorias;
    public int EscalaMaxima;
    String name;
    String descripcion;

    public Rubrica() {
    }

    public Rubrica(String name, int niveles, String descripcion) {
        this.name = name;
        this.EscalaMaxima = niveles;
        this.descripcion = descripcion;
    }

    public String getName() {
        return name;
    }//Implementar Observable en el Display

    public void setName(String name) {
        this.name = name;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

}
