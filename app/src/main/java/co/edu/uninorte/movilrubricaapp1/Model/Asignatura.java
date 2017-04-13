package co.edu.uninorte.movilrubricaapp1.Model;

import android.databinding.ObservableArrayList;

import com.orm.SugarRecord;

import java.util.ArrayList;

/**
 * Created by fdjvf on 4/11/2017.
 */

public class Asignatura extends SugarRecord {

    String name;
    String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    ArrayList<Estudiante> estudiantes;
    ArrayList<Evaluacion> evaluaciones;

    public Asignatura() {
    }
    public Asignatura(String name, String description, ArrayList<Estudiante> estudiantes, ArrayList<Evaluacion> evaluaciones) {
        this.name = name;
        this.description = description;
        this.estudiantes = estudiantes;
        this.evaluaciones = evaluaciones;
    }
  public static ObservableArrayList<Asignatura> observableArrayList()
    {
        ObservableArrayList<Asignatura>temp=new ObservableArrayList<>();
        temp.addAll(Asignatura.listAll(Asignatura.class));
        return temp;
    }


}
