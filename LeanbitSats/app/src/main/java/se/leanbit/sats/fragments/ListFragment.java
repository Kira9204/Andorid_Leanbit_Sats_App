package se.leanbit.sats.fragments;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        SatsActivitiesService satsActivitiesService = new SatsActivitiesService();
        SatsActivity[] activities = satsActivitiesService.getActivitiesBetween("2015-03-01","2015-05-29");

        ArrayList<SatsActivity> listOfActivities = new ArrayList<>();
        for(int i = 0; i < activities.length; i++)
        {
            listOfActivities.add(activities[i]);
        }
        View view = inflater.inflate(R.layout.stickylist_headersview, container, false);

        StickyListHeadersListView stickyList = (StickyListHeadersListView) view;

        StickyListAdapter activityListAdapter = new StickyListAdapter(getActivity(),listOfActivities);

        stickyList.setAdapter(activityListAdapter);
        return view;
    }
}
