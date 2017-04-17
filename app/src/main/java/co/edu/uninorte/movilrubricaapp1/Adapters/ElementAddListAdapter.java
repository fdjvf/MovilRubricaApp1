package co.edu.uninorte.movilrubricaapp1.Adapters;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import co.edu.uninorte.movilrubricaapp1.Model.Elemento;
import co.edu.uninorte.movilrubricaapp1.R;
import co.edu.uninorte.movilrubricaapp1.databinding.CateogoriaElementoFilaBinding;

/**
 * Created by fdjvf on 4/17/2017.
 */

public class ElementAddListAdapter extends ListAdapter {

    public ElementAddListAdapter(ObservableArrayList<Object> list) {
        super(list);
    }

    @BindingAdapter("bind:NewElement")
    public static void bindList(ListView view, ObservableArrayList<Object> list) {
        ElementAddListAdapter adapter = new ElementAddListAdapter(list);
        view.setAdapter(adapter);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null) {
            inflater = (LayoutInflater) parent.getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        CateogoriaElementoFilaBinding binding;
        binding = DataBindingUtil.inflate(inflater, R.layout.cateogoria_elemento_fila, parent, false);
        binding.setElementoinfor((Elemento) list.get(position));
        return binding.getRoot();
    }

}
