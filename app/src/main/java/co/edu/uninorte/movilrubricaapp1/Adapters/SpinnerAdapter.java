package co.edu.uninorte.movilrubricaapp1.Adapters;

import android.content.Context;
import android.database.DataSetObserver;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;


import co.edu.uninorte.movilrubricaapp1.R;
import co.edu.uninorte.movilrubricaapp1.databinding.EvaluacionRubricaSpinnerDropdownItemBinding;

/**
 * Created by Melanis on 19/04/2017.
 */


public class SpinnerAdapter extends ListAdapter {

    public SpinnerAdapter(ObservableArrayList<Object> list) {
        super(list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null) {
            inflater = (LayoutInflater) parent.getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }


        EvaluacionRubricaSpinnerDropdownItemBinding bindingDropD;
        bindingDropD = DataBindingUtil.inflate(inflater,R.layout.evaluacion_rubrica_spinner_dropdown_item,parent,false);
        bindingDropD.setRubri(list.get(position).toString());


        return bindingDropD.getRoot();
    }


}
