package co.edu.uninorte.movilrubricaapp1;


import java.util.ArrayList;

import co.edu.uninorte.movilrubricaapp1.Model.Calificaciones.PesoElemento;
import co.edu.uninorte.movilrubricaapp1.Model.Elemento;

/**
 * Created by fdjvf on 4/19/2017.
 */

public class ElementoPesoElemento {
    public Elemento elemento;
    public PesoElemento pesoElemento;

    public static void SaveList(ArrayList<ElementoPesoElemento> elementoPesoElementos) {
        for (ElementoPesoElemento elementoPesoElemento : elementoPesoElementos) {
            elementoPesoElemento.pesoElemento.save();
        }

    }
}
