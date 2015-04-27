package se.segr.android.leanbit_sats_app;

import android.app.Activity;
import android.os.Bundle;

public class Main2Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main2);

        Activities acts = new Activities();
        se.segr.android.leanbit_sats_app.Activity act = new se.segr.android.leanbit_sats_app.Activity();
        act.date = "2015-04-20 13:40:10";
        Booking booking = new Booking();
        booking.centerId = "113";
        act.booking = booking;

       // String dateTimes = acts.getDate(act);
        //String dateTime = acts.getDateHeaderOtherWeek(act);
        //String test = acts.getRegion(act);
        acts.populateActivitiesBetwineen("2015-04-10", "2015-04-20");
        int bool = acts.getWeek(act);
        int i = 0;

    }
}
