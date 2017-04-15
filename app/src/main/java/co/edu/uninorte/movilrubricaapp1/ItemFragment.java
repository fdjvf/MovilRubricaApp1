package co.edu.uninorte.movilrubricaapp1;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import co.edu.uninorte.movilrubricaapp1.Adapters.CourseListAdapter;
import co.edu.uninorte.movilrubricaapp1.Adapters.RubricaListAdapter;
import co.edu.uninorte.movilrubricaapp1.Model.Asignatura;
import co.edu.uninorte.movilrubricaapp1.Model.Rubrica;
import co.edu.uninorte.movilrubricaapp1.databinding.FragmentSlideMainBinding;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class ItemFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_PAGE = "pagina";
    private static int pag = 0;
    public ObservableArrayList<Object> list;
    //private static final String ARG_LISTA = "vector";
    // TODO: Customize parameters
    private int pagina = 1;
    private OnListFragmentInteractionListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static ItemFragment newInstance(int columnCount) {
        ItemFragment fragment = new ItemFragment();

        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @BindingAdapter("bind:CourseItems")
    public static void bindList(ListView view, ObservableArrayList<Object> list) {
    /*    if(pag==0)
        {
            pag=1;
        }
        else if(pag==1){

            pag=2;
        }else
        {
            pag=1;
        }*/
        switch (pag) {
            case 1:
                view.setAdapter(new CourseListAdapter(Asignatura.list2));
                break;
            case 2:
                view.setAdapter(new RubricaListAdapter(Rubrica.list));
                break;

        }
    }

    public int getPagina() {
        return pagina;
    }

    public void setPagina(int pagina) {
        this.pagina = pagina;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            pagina = getArguments().getInt(ARG_PAGE);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FragmentSlideMainBinding bindingFragment = DataBindingUtil.inflate(inflater, R.layout.fragment_slide_main, container, false);


        switch (pagina) {
                case 1:
                    list = Asignatura.list2;

                    break;
                case 2:
                    list = Rubrica.list;
                    break;

            }

        bindingFragment.setCourse(this);
        return bindingFragment.getRoot();
    }

  /*  @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }*/

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(View item);
    }
}
