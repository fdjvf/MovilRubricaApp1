package co.edu.uninorte.movilrubricaapp1.Model;

import com.orm.SugarRecord;

import java.util.ArrayList;


public class Estudiante extends SugarRecord {

    String name;
    Boolean state;
    ArrayList<Evaluacion> Evaluaciones;

    public Estudiante() {
    }


    public Estudiante(String name, Boolean state, ArrayList<Evaluacion> evaluaciones) {
        this.name = name;
        this.state = state;
        Evaluaciones = evaluaciones;
    }
}
