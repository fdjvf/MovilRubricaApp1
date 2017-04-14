package co.edu.uninorte.movilrubricaapp1.Adapters;

import android.databinding.BindingAdapter;
import android.databinding.ObservableArrayList;
import android.widget.ListView;

/**
 * Created by fdjvf on 4/13/2017.
 */

public class StudentHint {
    public static ObservableArrayList<Object> list = new ObservableArrayList<>();
    public static int Count = 1;
    String hint;

    public StudentHint(String hint) {
        this.hint = hint;
        Count++;
    }

    public StudentHint() {

    }

    @BindingAdapter("bind:NewStudentHints")
    public static void bindList(ListView view, ObservableArrayList<Object> list) {
        StudentAddAdapter adapter = new StudentAddAdapter(list);
        view.setAdapter(adapter);
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

}
