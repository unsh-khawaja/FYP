package fyp.uos.he.Adapters;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    ArrayList<String> arrTitle=new ArrayList<>();
    ArrayList<Fragment> arrFragments=new ArrayList<>();
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {
        return arrFragments.get(position);
    }

    @Override
    public int getCount() {
        return arrFragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return arrTitle.get(position);
    }
    public void addTabPage(String title, Fragment freg){
        arrTitle.add(title);
        arrFragments.add(freg);
    }
}


