package se.leanbit.sats;

import android.os.Bundle;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import se.leanbit.sats.fragments.ListFragment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_container);

        Fragment mListFragment = new ListFragment();
        FragmentManager fm = getFragmentManager();

        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.add(R.id.listfragment_container, mListFragment, "listFrag")
                .commit();

        Log.d("onCreate", "onCreate fired ..............");
    }
/*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SatsActivitiesService service = new SatsActivitiesService();
        SatsActivity[] activities = service.getActivitiesBetween("2015-01-01", "2015-05-30");
        SatsTimeFormatService format = new SatsTimeFormatService();
        for(int i = 0; i < activities.length; i++)
        {
            String print = service.getActivityName(activities[i]);
            print += "\n"+format.getDate(activities[i]);
            print += "\n"+format.getWeekDates(activities[i]);
            print += "\n"+service.getActivityName(activities[i]);
            print += "\n"+service.getGroupType(activities[i]);
            print += "\n"+service.getRegion(activities[i]);
            print += "\n"+service.isCustom(activities[i]);
            print += "\n"+service.isPast(activities[i]);
            Log.e("DEBUG",print);
        }

    }
*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
