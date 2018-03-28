package com.example.yellow.navigationbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yellow on 2018-3-28.
 */

public class ViewPaperAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragmentList=new ArrayList<>();

    @Override
    public Fragment getItem(int potion){
        return fragmentList.get(potion);
    }
    @Override
    public int getCount(){
        return fragmentList.size();
    }
    public ViewPaperAdapter(FragmentManager manager){
        super(manager);
    }
    public void addFragment(Fragment fragment){
        fragmentList.add(fragment);
    }

}
