package aarnav100.developer.dturesources.Adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import aarnav100.developer.dturesources.Fragments.DtuHome;
import aarnav100.developer.dturesources.Fragments.DtuMaps;
import aarnav100.developer.dturesources.Fragments.DtuNews;
import aarnav100.developer.dturesources.Fragments.HelpDesk;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int NoofTabs;
    public PagerAdapter(FragmentManager fm, int NoofTabs) {
        super(fm);
        this.NoofTabs=NoofTabs;
    }


    @Override
    public Fragment getItem(int i) {
        switch (i){
            case  0:
                return new DtuHome();
            case  1:
                return new DtuNews();
            case 2:
                return new DtuMaps();
            case 3:
                return new HelpDesk();
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return NoofTabs;
    }
}
