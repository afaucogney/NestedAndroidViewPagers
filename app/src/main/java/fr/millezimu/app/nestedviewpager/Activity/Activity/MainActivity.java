package fr.millezimu.app.nestedviewpager.Activity.Activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.viewpagerindicator.TitlePageIndicator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fr.millezimu.app.nestedviewpager.Activity.Model.FragmentConfiguration;
import fr.millezimu.app.nestedviewpager.Activity.Adapter.MyMainFragmentPagerStateAdapter;
import fr.millezimu.app.nestedviewpager.R;

/**
 * Created by anthonyfaucogney on 17/04/2015.
 */
public class MainActivity extends FragmentActivity {

    final int MAIN_FRAGMENT_COUNT = 4;

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
        mMainPagerStateAdapter = new MyMainFragmentPagerStateAdapter(super.getSupportFragmentManager(),configList);
        // Creation du Pager
        mPagerMain = (ViewPager) super.findViewById(R.id.vp_main);
        // Affectation de l'adapter au ViewPager
        mPagerMain.setAdapter(this.mMainPagerStateAdapter);

        TitlePageIndicator indicator = (TitlePageIndicator) findViewById(R.id.tpi_main);
        indicator.setViewPager(mPagerMain);
        mIndicator = indicator;



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
}
