package com.example.yellow.navigationbar;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Yellow on 2018-3-28.
 */

public class HomeActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private MenuItem menuItem;
    private BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initBottomNavigationView();
        initViewPaper();
    }
    public void initBottomNavigationView(){
        navigationView=(BottomNavigationView)findViewById(R.id.navigation);
        BottomNavigationViewHelper.disableShiftMode(navigationView);
        navigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener(){
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item){
                        switch (item.getItemId()){
                            case R.id.navigation_home:
                                viewPager.setCurrentItem(0);
                                break;
                            case R.id.navigation_dashboard:
                                viewPager.setCurrentItem(1);
                                break;
                            case R.id.navigation_notifications:
                                viewPager.setCurrentItem(2);
                                break;
                            case R.id.navigation_user:
                                viewPager.setCurrentItem(3);
                                break;
                            default:
                                viewPager.setCurrentItem(0);
                                break;
                        }
                        return false;
                    }

        });
    }
    public void initViewPaper(){
        viewPager=(ViewPager)findViewById(R.id.viewpaper);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(menuItem!=null){
                    menuItem.setChecked(false);
                }
                else{
                    navigationView.getMenu().getItem(0).setChecked(false);
                }
                menuItem=navigationView.getMenu().getItem(position);
                menuItem.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        //禁止viewpaper滑动
/*        viewPager.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event){
                return true;
            }
        });*/

        ViewPaperAdapter adapter=new ViewPaperAdapter(getSupportFragmentManager());
        adapter.addFragment(CommonFragment.newInstance("主页"));
        adapter.addFragment(CommonFragment.newInstance("管理台"));
        adapter.addFragment(CommonFragment.newInstance("消息"));
        adapter.addFragment(CommonFragment.newInstance("个人中心"));

        viewPager.setAdapter(adapter);
    }

}
