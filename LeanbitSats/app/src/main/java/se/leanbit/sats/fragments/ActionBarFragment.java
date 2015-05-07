package se.leanbit.sats.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.TextView;
import se.emilsjolander.stickylistheaders.StickyListHeadersListView;
import se.leanbit.sats.R;
import se.leanbit.sats.adapters.StickyListAdapter;
import se.leanbit.sats.models.SatsActivity;
import se.leanbit.sats.repositories.services.SatsActivitiesService;

import java.util.ArrayList;

/**
 * Created by erik on 2015-05-05.
 */
public class ActionBarFragment extends Fragment
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.action_bar, container, false);
        return view;
    }
}
