package adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

import ui.fragmentImpl.QuestionFragmentImpl;

/**
 * Created by Duy on 03/20/2018.
 */

public class CustomPagerAdapter extends FragmentStatePagerAdapter {

    private ArrayList<QuestionFragmentImpl> fragments = new ArrayList<>();
    private final List<String> titles = new ArrayList<>();

    public CustomPagerAdapter(FragmentManager fm) {
        super(fm);
        // this.fragments=fragments;
    }
//    public CustomPagerAdapter(FragmentManager fm, ArrayList<Fragment> fragments) {
//        super(fm);
//        this.fragments=fragments;
//    }

    public ArrayList<QuestionFragmentImpl> getFragments() {
        return fragments;
    }

    @Override
    public Fragment getItem(int position) {

        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    public void addFragment(QuestionFragmentImpl fragment, String title) {
        fragments.add(fragment);
        titles.add(title);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }

}
