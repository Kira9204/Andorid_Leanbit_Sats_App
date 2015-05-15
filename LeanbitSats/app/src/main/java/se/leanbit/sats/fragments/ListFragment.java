package se.leanbit.sats.fragments;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Set;

import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

import se.leanbit.sats.MainActivity;
import se.leanbit.sats.R;
import se.leanbit.sats.adapters.StickyListAdapter;
import se.leanbit.sats.models.SatsActivity;
import se.leanbit.sats.repositories.services.SatsActivitiesService;

public class ListFragment extends Fragment
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
       final SatsActivitiesService satsActivitiesService = new SatsActivitiesService();
        final SatsActivity[] activities = satsActivitiesService.getActivitiesBetween("2015-03-01","2015-06-30");

/*
    detta är om man vill få ut hur många träningspass och en map men antalet träningar med talet som värde och veckan som key.
        LinkedHashMap traningMap = satsActivitiesService.getTraningMap(activities);
        int totTraning = satsActivitiesService.getMaxTraning(activities);
*/
        final ArrayList<SatsActivity> listOfActivities = new ArrayList<>();
        for(int i = 0; i < activities.length; i++)
        {
            listOfActivities.add(activities[i]);
        }

        Log.e("WHAT_IS", "MAX ACTIVITIES: "+satsActivitiesService.getMaxTraning(activities));
        LinkedHashMap<Integer, Integer> traningMap = satsActivitiesService.getTraningMap(activities);
        Integer trainingMapKeys[] = traningMap.keySet().toArray(new Integer[traningMap.keySet().size()]);
        for(int i = 0; i < trainingMapKeys.length; i++)
        {
            Log.e("WHAT_IS", "Week num: "+trainingMapKeys[i]+" num activities: "+traningMap.get(trainingMapKeys[i]));
        }
        //Log.e("WHAT_IS", "MAP: KEYS (WEEK): "+satsActivitiesService.getTraningMap(activities).keySet().toString());
        //Log.e("WHAT_IS", "MAP: VALUES: "+satsActivitiesService.getTraningMap(activities).values().toString());
        View view = inflater.inflate(R.layout.stickylist_headersview, container, false);

        StickyListHeadersListView stickyList = (StickyListHeadersListView) view;

        StickyListAdapter activityListAdapter = new StickyListAdapter(getActivity(),listOfActivities);

        stickyList.setAdapter(activityListAdapter);

        stickyList.setOnScrollListener(new AbsListView.OnScrollListener()
        {

            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState)
            {
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem,
                                 int visibleItemCount, int totalItemCount)
            {

                Log.d("onScroll ", firstVisibleItem + "-" + visibleItemCount + "-" + totalItemCount + (satsActivitiesService.isPast(listOfActivities.get(firstVisibleItem))));
                if (satsActivitiesService.isPast(listOfActivities.get(firstVisibleItem)))
                {
                    TextView tv = (TextView) view.getRootView().findViewById(R.id.header_text);
                    tv.setText("Tidigare Träning");
                }
                else
                {
                    TextView tv = (TextView) view.getRootView().findViewById(R.id.header_text);
                    tv.setText("Kommande träning");
                }
            }
        });
        return view;
    }
}
