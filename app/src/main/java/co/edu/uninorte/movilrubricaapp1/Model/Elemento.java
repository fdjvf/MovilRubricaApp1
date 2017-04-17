package co.edu.uninorte.movilrubricaapp1.Model;

import android.databinding.ObservableArrayList;

import com.orm.SugarRecord;

import java.util.List;

/**
 * Created by fdjvf on 4/11/2017.
 */

public class Elemento extends SugarRecord {

    public ObservableArrayList<InfoNivel> ObservableDescricionNivel;
    String name;
    String descripcion;
    Categoria categoria;

    public Elemento() {

    }


    public Elemento(String name, Float peso, String descripcion, Categoria categoria) {
        this.name = name;
        this.descripcion = descripcion;
        this.categoria = categoria;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;//Considerar TwoBinding
    }

    public List<InfoNivel> getInfoNivel() {
        List<InfoNivel> infoNivelList = InfoNivel.find(InfoNivel.class, "elemento = ?", String.valueOf(this.getId()));
        ObservableDescricionNivel.addAll(infoNivelList);
        return infoNivelList;
    }

}
