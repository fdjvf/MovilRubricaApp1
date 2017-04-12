package co.edu.uninorte.movilrubricaapp1.Model;

import com.orm.SugarRecord;

import java.util.ArrayList;

/**
 * Created by fdjvf on 4/11/2017.
 */

public class Asignatura extends SugarRecord {

    String name;
    String descripcion;
    ArrayList<Estudiante> estudiantes;
    ArrayList<Evaluacion> evaluaciones;

    public Asignatura() {
    }
    public Asignatura(String name, String descripcion, ArrayList<Estudiante> estudiantes, ArrayList<Evaluacion> evaluaciones) {
        this.name = name;
        this.descripcion = descripcion;
        this.estudiantes = estudiantes;
        this.evaluaciones = evaluaciones;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
