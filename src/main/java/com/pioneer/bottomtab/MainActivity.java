package com.pioneer.bottomtab;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;

import com.pioneer.bottomtab.fragment.GovaffFragment;
import com.pioneer.bottomtab.fragment.HomeFragment;
import com.pioneer.bottomtab.fragment.NewscenterFragment;
import com.pioneer.bottomtab.fragment.SettingFragment;
import com.pioneer.bottomtab.fragment.SmartserviceFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    @BindView(R.id.newscenter)
    RadioButton newscenter;
    @BindView(R.id.govaffairs)
    RadioButton govaffairs;
    @BindView(R.id.setting)
    RadioButton setting;
    @BindView(R.id.smartservice)
    RadioButton smartservice;
    @BindView(R.id.home)
    RadioButton home;
    @BindView(R.id.viewpager)
    ViewPager viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initViewPagerData();

        viewpager.addOnPageChangeListener(this);
    }

    private void initViewPagerData() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new NewscenterFragment());
        fragments.add(new SmartserviceFragment());
        fragments.add(new GovaffFragment());
        fragments.add(new SettingFragment());
        viewpager.setAdapter(new TabAdapter(getSupportFragmentManager(), fragments));
    }


    @OnClick({R.id.newscenter, R.id.govaffairs, R.id.setting, R.id.smartservice, R.id.home})
    public void onViewClicked(View view) {
        int item = 0;
        switch (view.getId()) {
            case R.id.newscenter:
                item = 1;
                break;
            case R.id.govaffairs:
                item = 3;
                break;
            case R.id.setting:
                item = 4;
                break;
            case R.id.smartservice:
                item = 2;
                break;
            case R.id.home:
                item = 0;
                break;
        }

        viewpager.setCurrentItem(item, false);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position){
            case 0:
                home.setChecked(true);
                break;
            case 1:
                newscenter.setChecked(true);
                break;
            case 2:
                smartservice.setChecked(true);
                break;
            case 3:
                govaffairs.setChecked(true);
                break;
            case 4:
                setting.setChecked(true);
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
