package co.edu.uninorte.movilrubricaapp1.Model;

import com.orm.SugarRecord;

/**
 * Created by fdjvf on 4/11/2017.
 */

public class Evaluacion extends SugarRecord {

    String Nombre;
    Asignatura asignatura;

    //Siempre antes de guardar estos, ya se debdio haber guardado la rubrica y la asignatura
    public Evaluacion() {

    }

    public Evaluacion(String nombre, Asignatura curso) {
        this.Nombre = nombre;
        this.asignatura = curso;

    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }


}
