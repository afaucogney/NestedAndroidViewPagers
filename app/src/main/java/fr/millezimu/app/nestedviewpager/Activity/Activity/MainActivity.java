package fr.millezimu.app.nestedviewpager.Activity.Activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.viewpagerindicator.TitlePageIndicator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fr.millezimu.app.nestedviewpager.Activity.Adapter.MyMainFragmentPagerStateAdapter;
import fr.millezimu.app.nestedviewpager.Activity.Fragment.MySubViewPagerFragment;
import fr.millezimu.app.nestedviewpager.Activity.Model.FragmentConfiguration;
import fr.millezimu.app.nestedviewpager.R;

/**
 * Created by anthonyfaucogney on 17/04/2015.
 */
public class MainActivity extends FragmentActivity {

    final int MAIN_FRAGMENT_COUNT = 4;
    private FloatingActionButton rightLowerButton;

    public List<FragmentConfiguration> getConfigList() {
        return configList;
    }

    List<FragmentConfiguration> configList;
    private MyMainFragmentPagerStateAdapter mMainPagerStateAdapter;
    private ViewPager mPagerMain;
    private TitlePageIndicator mIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        super.setContentView(R.layout.vp_main);

        configList = generateConfiguration();

        // Creation de l'adapter
        mMainPagerStateAdapter = new MyMainFragmentPagerStateAdapter(super.getSupportFragmentManager(), configList);
        // Creation du Pager
        mPagerMain = (ViewPager) super.findViewById(R.id.vp_main);
        // Affectation de l'adapter au ViewPager
        mPagerMain.setAdapter(this.mMainPagerStateAdapter);

        TitlePageIndicator indicator = (TitlePageIndicator) findViewById(R.id.tpi_main);
        indicator.setViewPager(mPagerMain);
        mIndicator = indicator;

        setupFBA();

    }

    private List<FragmentConfiguration> generateConfiguration() {
        configList = new ArrayList<>();
        for (int i = 0; i < MAIN_FRAGMENT_COUNT; i++) {
            String mainName = generateString(new Random(), "ABCDEFGHIJKLMNOPQRSTUVWXYZ", 10);
            FragmentConfiguration mainFrag = new FragmentConfiguration(i, mainName);
            final int SUB_FRAGMENT_COUNT = (int) (Math.random() * 5);
            for (int j = 0; j < SUB_FRAGMENT_COUNT; j++) {
                String subName = generateString(new Random(), "ABCDEFGHIJKLMNOPQRSTUVWXYZ", 5);
                FragmentConfiguration subFrag = new FragmentConfiguration(j, subName);
                mainFrag.addChildFragment(subFrag);
            }
            configList.add(mainFrag);
        }
        return configList;
    }

    public static String generateString(Random rng, String characters, int length) {
        char[] text = new char[length];
        for (int i = 0; i < length; i++) {
            text[i] = characters.charAt(rng.nextInt(characters.length()));
        }
        return new String(text);
    }

    private void setupFBA() {
        final ImageView fabIconNext = new ImageView(this);
        fabIconNext.setImageDrawable(getResources().getDrawable(R.drawable.abc_ic_go_search_api_mtrl_alpha));

        rightLowerButton = new FloatingActionButton.Builder(this)
                .setContentView(fabIconNext)
                .setPosition(FloatingActionButton.POSITION_BOTTOM_RIGHT)
                .build();

        rightLowerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int c = mPagerMain.getCurrentItem();
                MySubViewPagerFragment frag = (MySubViewPagerFragment) mMainPagerStateAdapter.getItem(c);
                if (!frag.swipNextFragment()) {

                    new Handler().post(new Runnable() {
                        @Override
                        public void run() {
                            if ((mPagerMain.getCurrentItem() < (mMainPagerStateAdapter.getCount() - 1)))
                                mPagerMain.setCurrentItem(mPagerMain.getCurrentItem() + 1);//, true);
                            else
                                finish();
                        }
                    });


                }
            }
        });

    }
}
