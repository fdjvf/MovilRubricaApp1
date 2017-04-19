package co.edu.uninorte.movilrubricaapp1;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import co.edu.uninorte.movilrubricaapp1.Model.Asignatura;

/**
 * Created by Melanis on 18/04/2017.
 */

public class myPagerAdapterEvalEst extends FragmentPagerAdapter {
    private static int NUM_ITEMS = 2;
long courseId;

    public myPagerAdapterEvalEst(FragmentManager fm, long mycourse) {
        super(fm);
        this.courseId= mycourse;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: // Fragment # 0 - This will show FirstFragment
                return ItemFragmentEvalEst.newInstance(1,courseId);
            case 1: // Fragment # 0 - This will show FirstFragment different title
                return ItemFragmentEvalEst.newInstance(2,courseId);
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }
    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        return "Page " + position;
    }
}
