package se.leanbit.sats;

import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.*;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import se.leanbit.sats.adapters.CustomFragmentPagerAdapter;
import se.leanbit.sats.adapters.DrawerListAdapter;
import se.leanbit.sats.adapters.interfaces.PagerScrollListener;
import se.leanbit.sats.fragments.ListFragment;
import android.util.Log;
import se.leanbit.sats.models.SatsActivity;
import se.leanbit.sats.repositories.services.SatsActivitiesService;
import se.leanbit.sats.repositories.services.SatsTimeFormatService;

import java.util.ArrayList;
import java.util.LinkedHashMap;


public class MainActivity extends ActionBarActivity
{
    private Toolbar toolbar;
    private DrawerLayout mDrawerLayout;
    private RelativeLayout mDrawerPane;
    private ImageView mToolbarRefreshIcon;
    private boolean mDrawerIsOpen;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        final SatsActivitiesService satsActivitiesService = new SatsActivitiesService();
        final SatsActivity[] activities = satsActivitiesService.getActivitiesBetween("2015-03-01", "2015-06-30");
        final SatsTimeFormatService satsTimeFormatService = new SatsTimeFormatService();

        final ArrayList<SatsActivity> listOfActivities = new ArrayList<>();
        for (int i = 0; i < activities.length; i++)
        {
            listOfActivities.add(activities[i]);
        }

        final ArrayList<Integer> listOfWeeks = new ArrayList<>();
        final LinkedHashMap<Integer, Integer> weekMap = satsActivitiesService.getTraningMap(activities);
        for (Integer item : weekMap.keySet())
        {
            listOfWeeks.add(item);
        }


        setContentView(R.layout.main_container);


        final Fragment mListFragment = new ListFragment();
        CustomFragmentPagerAdapter adapter = new CustomFragmentPagerAdapter(getSupportFragmentManager(), this, listOfActivities, satsActivitiesService, satsTimeFormatService, activities, listOfWeeks, weekMap);

        ViewPager mViewPager = (ViewPager) findViewById(R.id.horizontal_view_pager);
        mViewPager.setAdapter(adapter);
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
        {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
            {
                PagerScrollListener listener = (PagerScrollListener) mListFragment;
                position += 2;
                int antalPass = 0;
                int maxAntalPass = 0;

               /* if(position < satsTimeFormatService.isCurrentWeek(position)){

                }*/
                for (Integer key : weekMap.keySet())
                {
                    maxAntalPass += weekMap.get(key);
                }
                for (int i = 0; i < position ; i++)
                {
                    int weekNum = listOfWeeks.get(i);
                    int passThisWeek = weekMap.get(weekNum);
                    antalPass = antalPass + passThisWeek;
                    Log.d("onPageScrolled...", "weekNum  " + weekNum + " passThisWeek" + passThisWeek);
                }
                if(antalPass > maxAntalPass-1)
                {
                    antalPass = maxAntalPass-1;
                }
                listener.onPagePositionChanged(antalPass);


                Log.d("onPageScrolled", " " + position + " position" + antalPass + " antalPass " + positionOffset + " position offset " + " positionOffsetPixels" + positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position)
            {

                // Log.d("onPageSelected"," " +position +" position.............................");
            }

            @Override
            public void onPageScrollStateChanged(int state)
            {
                // Log.d("onPageScrollStateCh"," " +state +" state............");
            }
        });

        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.add(R.id.listfragment_container, mListFragment, "listFrag")
            .commit();


//      Set ToolBar as  ActionBar
        toolbar = (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
           //toolbar.setNavigationIcon(R.drawable.action_bar_menu);
        //toolbar.setTitle("Settings");
        //toolbar.setSubtitle("Settings menu");
        //toolbar.setMinimumHeight(150);

        final ImageView toolbarSettingsIcon = (ImageView) findViewById(R.id.action_bar_logo_settings);
        final ImageView toolbarSatsIcon = (ImageView) findViewById(R.id.action_bar_logo_sats);
        mToolbarRefreshIcon = (ImageView) findViewById(R.id.action_bar_logo_refresh);
        //getSupportActionBar().setIcon(R.drawable.meny_icon);
        // Set an OnMenuItemClickListener to handle menu item clicks
        /*
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener()
        {
            @Override
            public boolean onMenuItemClick(MenuItem item)
            {
                // Handle the menu item
                return true;
            }
        });
*/

        // DrawerLayout
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mDrawerLayout.setScrimColor(Color.TRANSPARENT);

        // Populate the Navigtion Drawer with options
        mDrawerPane = (RelativeLayout) findViewById(R.id.drawerPane);
        ListView drawerList = (ListView) findViewById(R.id.navList);
        DrawerListAdapter drawerListAdapter = new DrawerListAdapter(this);
        drawerList.setAdapter(drawerListAdapter);
        mDrawerIsOpen = false;


        mToolbarRefreshIcon.setOnClickListener(actionBarRefreshListener);
        toolbarSettingsIcon.setOnClickListener(actionBarSettingsListener);
        toolbarSatsIcon.setOnClickListener(actionBarSettingsListener);

        // Inflate a menu to be displayed in the toolbar
        toolbar.inflateMenu(R.menu.menu_main);
    }


    private View.OnClickListener actionBarRefreshListener = new View.OnClickListener()
    {
        @Override
        public void onClick(View v) {
            Animation rotation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
            mToolbarRefreshIcon.startAnimation(rotation);
        }
    };

    private View.OnClickListener actionBarSettingsListener = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            if(!mDrawerIsOpen)
            {
                mDrawerLayout.openDrawer(mDrawerPane);
            }
            else
            {
                mDrawerLayout.closeDrawer(mDrawerPane);
            }
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
