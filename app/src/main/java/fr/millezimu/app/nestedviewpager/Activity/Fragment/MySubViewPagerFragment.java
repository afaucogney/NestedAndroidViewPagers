package fr.millezimu.app.nestedviewpager.Activity.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.viewpagerindicator.TitlePageIndicator;

import fr.millezimu.app.nestedviewpager.Activity.Activity.MainActivity;
import fr.millezimu.app.nestedviewpager.Activity.Adapter.MySubFragmentPagerStateAdapter;
import fr.millezimu.app.nestedviewpager.R;

/**
 * Created by anthonyfaucogney on 17/04/2015.
 */
public class MySubViewPagerFragment extends Fragment {

    private MySubFragmentPagerStateAdapter mSubPagerStateAdapter;
    private ViewPager mPagerSub;
    private TitlePageIndicator mIndicatorSub;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.vp_sub, container, false);

        int id = getArguments().getInt("id");

        // Creation de l'adapter
        mSubPagerStateAdapter = new MySubFragmentPagerStateAdapter(getChildFragmentManager(), ((MainActivity) getActivity()).getConfigList().get(id));
        // Creation du Pager
        mPagerSub = (ViewPager) v.findViewById(R.id.vp_sub);
        // Affectation de l'adapter au ViewPager
        mPagerSub.setAdapter(this.mSubPagerStateAdapter);

        TitlePageIndicator indicator = (TitlePageIndicator) v.findViewById(R.id.tpi_sub);
        indicator.setViewPager(mPagerSub);
        mIndicatorSub = indicator;
        return v;
    }

    public boolean swipNextFragment() {
        boolean result = false;
        int c = mPagerSub.getCurrentItem();
        if (c < (mPagerSub.getAdapter().getCount() - 1)) {
            result = true;
            new Handler().post(new Runnable() {
                @Override
                public void run() {
                    mPagerSub.setCurrentItem(mPagerSub.getCurrentItem() + 1);
                }
            });

        }
        return result;
    }
}
