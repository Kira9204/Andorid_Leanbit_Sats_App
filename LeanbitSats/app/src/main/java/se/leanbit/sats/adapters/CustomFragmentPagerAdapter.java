package se.leanbit.sats.adapters;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import se.leanbit.sats.R;
import se.leanbit.sats.fragments.PagerFragment;

/**
 * Created by gina on 2015-05-12.
 */
public class CustomFragmentPagerAdapter extends FragmentStatePagerAdapter
{
    final Integer[] tempArray;
    protected Context mContext;

    public CustomFragmentPagerAdapter(FragmentManager fm, Context context, Integer[] tempArray)
    {
        super(fm);
        mContext = context;
        this.tempArray = tempArray;

    }

    @Override
    public Fragment getItem(int position)
    {
        Fragment fragment = new PagerFragment();
        Bundle args = new Bundle();
        args.putInt("page_position", position + 1);
        fragment.setArguments(args);


        return fragment;
    }

    @Override
    public int getCount()
    {
        return tempArray.length;
    }

    @Override
    public float getPageWidth(int position){
        return 0.18f;
    }

}
