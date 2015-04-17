package fr.millezimu.app.nestedviewpager.Activity.Adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import fr.millezimu.app.nestedviewpager.Activity.Fragment.MyEndFragment;
import fr.millezimu.app.nestedviewpager.Activity.Model.FragmentConfiguration;

/**
 * Created by anthonyfaucogney on 17/04/2015.
 */
public class MySubFragmentPagerStateAdapter extends FragmentStatePagerAdapter {


    FragmentConfiguration config;

    public MySubFragmentPagerStateAdapter(FragmentManager fm, FragmentConfiguration config) {
        super(fm);
        this.config = config;
    }

    @Override
    public Fragment getItem(int i) {
        return instanciateSubFragment(config.getChildFragments().get(i));
    }

    @Override
    public int getCount() {
        return config.getChildFragments().size();
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return String.valueOf(config.getChildFragments().get(position).getId());
    }


    private Fragment instanciateSubFragment(FragmentConfiguration config) {
        MyEndFragment fragment = new MyEndFragment();
        Bundle args = new Bundle();
        args.putString("name", config.getName());
        args.putInt("id", config.getId());
        fragment.setArguments(args);
        return fragment;
    }
}
