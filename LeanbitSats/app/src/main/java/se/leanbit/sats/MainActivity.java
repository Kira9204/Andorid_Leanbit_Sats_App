package se.leanbit.sats;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import se.leanbit.sats.models.SatsActivity;
import se.leanbit.sats.repositories.services.SatsActivitiesService;
import se.leanbit.sats.repositories.services.SatsTimeFormatService;


public class MainActivity extends ActionBarActivity {

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
