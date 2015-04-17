package fr.millezimu.app.nestedviewpager.Activity.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anthonyfaucogney on 17/04/2015.
 */
public class FragmentConfiguration {
    private String name;
    private int id;
    private FragmentConfiguration parentFragment;
    private List<FragmentConfiguration> childFragments;

    public FragmentConfiguration(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public List<FragmentConfiguration> getChildFragments() {
        return childFragments;
    }

    public void addChildFragment(FragmentConfiguration childFragment) {
        if (childFragments == null)
            childFragments = new ArrayList<>();
        childFragments.add(childFragment);
        childFragment.setParentFragment(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FragmentConfiguration getParentFragment() {
        return parentFragment;
    }

    public void setParentFragment(FragmentConfiguration parentFragment) {
        this.parentFragment = parentFragment;
    }
}
