package co.edu.uninorte.movilrubricaapp1.Model;

import com.orm.SugarRecord;

/**
 * Created by fdjvf on 4/11/2017.
 */

public class Evaluacion extends SugarRecord {

    Rubrica rubrica;
    String Nombre;
    Asignatura asignatura;

    //Siempre antes de guardar estos, ya se debdio haber guardado la rubrica y la asignatura
    public Evaluacion() {

    }

    public Evaluacion(Rubrica rubric, String nombre, Asignatura curso) {
        this.rubrica = rubric;
        this.Nombre = nombre;
        this.asignatura = curso;

    }

}
