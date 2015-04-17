package fr.millezimu.app.nestedviewpager.Activity.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.viewpagerindicator.TitlePageIndicator;

import fr.millezimu.app.nestedviewpager.Activity.Adapter.MySubFragmentPagerStateAdapter;
import fr.millezimu.app.nestedviewpager.Activity.Model.FragmentConfiguration;
import fr.millezimu.app.nestedviewpager.R;

/**
 * Created by anthonyfaucogney on 17/04/2015.
 */
public class MyEndFragment extends Fragment {

    FragmentConfiguration myConfig;
    private MySubFragmentPagerStateAdapter mSubPagerStateAdapter;
    private ViewPager mPagerSub;
    private TitlePageIndicator mIndicatorSub;

//    public MyFragment(FragmentConfiguration config) {
//        super();
//        myConfig = config;
//    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment, container, false);
        View tv = v.findViewById(R.id.tv_frag);
        tv.setBackgroundColor(Color.YELLOW);
        ((TextView) tv).setText("End Fragment: " + getArguments().getString("name"));

        return v;
    }
}
