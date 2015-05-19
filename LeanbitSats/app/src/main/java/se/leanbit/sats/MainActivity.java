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
import android.util.DisplayMetrics;
import android.view.*;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import se.leanbit.sats.adapters.CustomFragmentPagerAdapter;
import se.leanbit.sats.adapters.DrawerListAdapter;
import se.leanbit.sats.adapters.interfaces.PagerScrollListener;
import se.leanbit.sats.fragments.ListFragment;
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
        final CustomFragmentPagerAdapter adapter = new CustomFragmentPagerAdapter(getSupportFragmentManager(), this, listOfActivities, satsActivitiesService, satsTimeFormatService, activities, listOfWeeks, weekMap);
        final ImageView leftShadow =(ImageView) findViewById(R.id.shadow_left);
        final ImageView rightShadow =(ImageView) findViewById(R.id.shadow_right);
        final ImageView pinkMarkerImageView = (ImageView) findViewById(R.id.marker_left);

        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        float screenWidth = displaymetrics.widthPixels;
        float dimenPix = getResources().getDimension(R.dimen.shadow_size);

        RelativeLayout.LayoutParams lpRight = new RelativeLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
        RelativeLayout.LayoutParams lpLeft = new RelativeLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
        lpRight.width = (int)dimenPix;
        lpLeft.width = (int)dimenPix;
        lpRight.setMargins((int)(screenWidth/5*2)-(int)dimenPix,(int)getResources().getDimension(R.dimen.height_of_top_rectangle),0,(int)getResources().getDimension(R.dimen.height_of_bottom_rectangle));
        lpLeft.setMargins((int)(screenWidth/5*3),(int)getResources().getDimension(R.dimen.height_of_top_rectangle),0,(int)getResources().getDimension(R.dimen.height_of_bottom_rectangle));
        leftShadow.setLayoutParams(lpLeft);
        rightShadow.setLayoutParams(lpRight);

        ViewPager mViewPager = (ViewPager) findViewById(R.id.horizontal_view_pager);
        mViewPager.setAdapter(adapter);
        mViewPager.setCurrentItem(listOfWeeks.indexOf(satsTimeFormatService.getCurrentWeekNum())-2);
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
        {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
            {
                PagerScrollListener listener = (PagerScrollListener) mListFragment;
                position += 2;
                int antalPass = 0;
                int maxAntalPass = 0;

                int currentWeekPosition =listOfWeeks.indexOf(satsTimeFormatService.getCurrentWeekNum());
                if(position < currentWeekPosition+3)
                {
                    if(positionOffset <0.4)
                    {
                        pinkMarkerImageView.setImageResource(R.drawable.calendet_mark_left);
                    }
                }
                if(position >currentWeekPosition+1)
                {
                    if(positionOffset >0.3)
                    {
                        pinkMarkerImageView.setImageResource(R.drawable.back_to_now_left);
                    }
                }

                for (Integer key : weekMap.keySet())
                {
                    maxAntalPass += weekMap.get(key);
                }
                for (int i = 0; i < position ; i++)
                {
                    int weekNum = listOfWeeks.get(i);
                    int passThisWeek = weekMap.get(weekNum);
                    antalPass = antalPass + passThisWeek;
                }
                if(antalPass > maxAntalPass-1)
                {
                    antalPass = maxAntalPass-1;
                }
                listener.onPagePositionChanged(antalPass);
            }

            @Override
            public void onPageSelected(int position) {}

            @Override
            public void onPageScrollStateChanged(int state) {}
        });

        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.add(R.id.listfragment_container, mListFragment, "listFrag")
            .commit();

        toolbar = (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);

        final ImageView toolbarSettingsIcon = (ImageView) findViewById(R.id.action_bar_logo_settings);
        final ImageView toolbarSatsIcon = (ImageView) findViewById(R.id.action_bar_logo_sats);
        mToolbarRefreshIcon = (ImageView) findViewById(R.id.action_bar_logo_refresh);

        // DrawerLayout
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        //mDrawerLayout.setScrimColor(Color.parseColor("ff444444"));
        mDrawerLayout.setScrimColor(Color.argb(100,68,68,68));

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
