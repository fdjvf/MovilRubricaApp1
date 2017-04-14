package co.edu.uninorte.movilrubricaapp1.Adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import co.edu.uninorte.movilrubricaapp1.R;
import co.edu.uninorte.movilrubricaapp1.databinding.CursoAddstudentRowBinding;


/**
 * Created by fdjvf on 4/13/2017.
 */

public class StudentAddAdapter extends ListAdapter {
    public StudentAddAdapter(ObservableArrayList<Object> list) {
        super(list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null) {
            inflater = (LayoutInflater) parent.getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        CursoAddstudentRowBinding binding;
        binding = DataBindingUtil.inflate(inflater, R.layout.curso_addstudent_row, parent, false);
        binding.setStudenthint((StudentHint) list.get(position));
        return binding.getRoot();
    }
}
