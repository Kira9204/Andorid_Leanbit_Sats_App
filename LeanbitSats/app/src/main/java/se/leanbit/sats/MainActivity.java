package se.leanbit.sats;

import android.os.Bundle;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.*;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import se.leanbit.sats.adapters.CustomFragmentPagerAdapter;
import se.leanbit.sats.fragments.ListFragment;
import android.util.Log;


public class MainActivity extends ActionBarActivity {

    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_container);
        Fragment mListFragment = new ListFragment();

        final Integer[] tempArray = new Integer[20];

        for(int i = 0; i < tempArray.length; i++)
        {
            tempArray[i] = i;
        }
        CustomFragmentPagerAdapter adapter = new CustomFragmentPagerAdapter(getSupportFragmentManager(),this, tempArray);
        ViewPager mViewPager = (ViewPager) findViewById(R.id.horizontal_view_pager);

        mViewPager.setAdapter(adapter);
        FragmentManager fm = getFragmentManager();


//      Set ToolBar as  ActionBar
        toolbar = (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
           toolbar.setNavigationIcon(R.drawable.action_bar_menu);
        toolbar.setTitle("Settings");
        toolbar.setSubtitle("Settings menu");
        toolbar.setMinimumHeight(110);

        final ImageView toolbarRefresh = (ImageView) findViewById(R.id.logo_refresh);
        //getSupportActionBar().setIcon(R.drawable.meny_icon_20dp);
        // Set an OnMenuItemClickListener to handle menu item clicks
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener()
        {
            @Override
            public boolean onMenuItemClick(MenuItem item)
            {
                // Handle the menu item
                return true;
            }
        });

        toolbarRefresh.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Animation rotation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
                toolbarRefresh.startAnimation(rotation);
            }

        });
        // Inflate a menu to be displayed in the toolbar
        toolbar.inflateMenu(R.menu.menu_main);

        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.add(R.id.listfragment_container, mListFragment, "listFrag")
                .commit();
        Log.d("onCreate", "onCreate fired ..............");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
