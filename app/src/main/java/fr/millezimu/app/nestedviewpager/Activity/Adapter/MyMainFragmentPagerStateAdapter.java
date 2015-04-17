package fr.millezimu.app.nestedviewpager.Activity.Adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

import fr.millezimu.app.nestedviewpager.Activity.Fragment.MySubViewPagerFragment;
import fr.millezimu.app.nestedviewpager.Activity.Model.FragmentConfiguration;

/**
 * Created by anthonyfaucogney on 17/04/2015.
 */
public class MyMainFragmentPagerStateAdapter extends FragmentStatePagerAdapter {

    List<FragmentConfiguration> fragConfig = new ArrayList<>();

    public MyMainFragmentPagerStateAdapter(FragmentManager fm, List<FragmentConfiguration> list) {
        super(fm);
        fragConfig = list;
    }

    @Override
    public Fragment getItem(int i) {
        return instanciateMainFragment(fragConfig.get(i));
    }

    @Override
    public int getCount() {
        return fragConfig.size();
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return String.valueOf(fragConfig.get(position).getId());
    }


    private Fragment instanciateMainFragment(FragmentConfiguration config) {
        MySubViewPagerFragment fragment = new MySubViewPagerFragment();
        Bundle args = new Bundle();
        args.putString("name", config.getName());
        args.putInt("id", config.getId());
        fragment.setArguments(args);
        return fragment;
    }
}
