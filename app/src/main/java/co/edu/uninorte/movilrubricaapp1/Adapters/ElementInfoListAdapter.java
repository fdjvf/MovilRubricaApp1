package co.edu.uninorte.movilrubricaapp1.Adapters;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import co.edu.uninorte.movilrubricaapp1.Model.InfoNivel;
import co.edu.uninorte.movilrubricaapp1.R;
import co.edu.uninorte.movilrubricaapp1.databinding.ElementoElementinfoFilaBinding;

/**
 * Created by fdjvf on 4/17/2017.
 */

public class ElementInfoListAdapter extends ListAdapter {

    public ElementInfoListAdapter(ObservableArrayList<Object> list) {
        super(list);
    }

    @BindingAdapter("bind:NewInfoElement")
    public static void bindList(ListView view, ObservableArrayList<Object> list) {
        ElementInfoListAdapter adapter = new ElementInfoListAdapter(list);
        view.setAdapter(adapter);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null) {
            inflater = (LayoutInflater) parent.getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        ElementoElementinfoFilaBinding binding;
        binding = DataBindingUtil.inflate(inflater, R.layout.elemento_elementinfo_fila, parent, false);
        binding.setElementInfo((InfoNivel) list.get(position));
        return binding.getRoot();
    }


}
