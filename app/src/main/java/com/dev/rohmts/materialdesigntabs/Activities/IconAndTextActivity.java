package com.dev.rohmts.materialdesigntabs.Activities;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.dev.rohmts.materialdesigntabs.Fragments.OneFragment;
import com.dev.rohmts.materialdesigntabs.Fragments.ThreeFragment;
import com.dev.rohmts.materialdesigntabs.Fragments.TwoFragment;
import com.dev.rohmts.materialdesigntabs.R;

import java.util.ArrayList;
import java.util.List;

public class IconAndTextActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private int[] tabIcons = { R.drawable.ic_recents_call,
            R.drawable.ic_favorites, R.drawable.ic_nearby

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icon_and_text);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //noinspection ConstantConditions
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = findViewById(R.id.vpIconText);
        setUpViewPager(viewPager);

        tabLayout = findViewById(R.id.iconTextTabLayout);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();

    }

    private void setupTabIcons() {

        final TextView tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabOne.setText("RECENT");
        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_recents_call, 0, 0);
        tabLayout.getTabAt(0).setCustomView(tabOne);

        final TextView tabTwo = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabTwo.setText("FAVORITE");
        tabTwo.setTextColor(ContextCompat.getColor(getApplicationContext(), android.R.color.darker_gray));
        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_favorites, 0, 0);
        tabLayout.getTabAt(1).setCustomView(tabTwo);

        final TextView tabThree = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabThree.setText("NEARBY");
        tabThree.setTextColor(ContextCompat.getColor(getApplicationContext(), android.R.color.darker_gray));
        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_nearby, 0, 0);
        tabLayout.getTabAt(2).setCustomView(tabThree);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        viewPager.setCurrentItem(0);
                        tabOne.setTextColor(ContextCompat.getColor(getApplicationContext(), android.R.color.white));
                        break;
                    case 1:
                        viewPager.setCurrentItem(1);
                        tabTwo.setTextColor(ContextCompat.getColor(getApplicationContext(), android.R.color.white));
                        break;
                    case 2:
                        viewPager.setCurrentItem(2);
                        tabThree.setTextColor(ContextCompat.getColor(getApplicationContext(), android.R.color.white));
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        viewPager.setCurrentItem(0);
                        tabOne.setTextColor(ContextCompat.getColor(getApplicationContext(), android.R.color.darker_gray));
                        break;
                    case 1:
                        viewPager.setCurrentItem(1);
                        tabTwo.setTextColor(ContextCompat.getColor(getApplicationContext(), android.R.color.darker_gray));
                        break;
                    case 2:
                        viewPager.setCurrentItem(2);
                        tabThree.setTextColor(ContextCompat.getColor(getApplicationContext(), android.R.color.darker_gray));
                        break;
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setUpViewPager(ViewPager viewPager) {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFrag(new OneFragment(), "ITEM ONE");
        viewPagerAdapter.addFrag(new TwoFragment(), "ITEM TWO");
        viewPagerAdapter.addFrag(new ThreeFragment(), "ITEM THREE");
        viewPager.setAdapter(viewPagerAdapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return false;
    }
}
