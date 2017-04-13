package co.edu.uninorte.movilrubricaapp1.View;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import co.edu.uninorte.movilrubricaapp1.Model.Asignatura;
import co.edu.uninorte.movilrubricaapp1.R;
import co.edu.uninorte.movilrubricaapp1.databinding.CursoFilaBinding;

/**
 * Created by fdjvf on 4/13/2017.
 */

public class CourseListAdapter extends BaseAdapter {

    protected ObservableArrayList<Asignatura> list;

    public CourseListAdapter (ObservableArrayList<Asignatura> list) {
        this.list = list;
    }

    protected LayoutInflater inflater;


    @Override
    public int getCount() {
        return list.size();
    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
     return list.get(position);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null) {
            inflater = (LayoutInflater) parent.getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        CursoFilaBinding binding;
        binding = DataBindingUtil.inflate(inflater, R.layout.curso_fila, parent, false);
        binding.setCourse(list.get(position));

        return binding.getRoot();
    }
}
