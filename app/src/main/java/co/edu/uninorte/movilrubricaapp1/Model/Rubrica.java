package co.edu.uninorte.movilrubricaapp1.Model;

import com.orm.SugarRecord;

import java.util.ArrayList;

/**
 * Created by fdjvf on 4/11/2017.
 */

public class Rubrica extends SugarRecord {
    String name;
    String descripcion;
    ArrayList<Categoria> categoriaArray;
    int niveles;

    public Rubrica() {
    }

    public Rubrica(String name, ArrayList<Categoria> categoriaArray, int niveles) {
        this.name = name;
        this.categoriaArray = categoriaArray;
        this.niveles = niveles;
    }
}
