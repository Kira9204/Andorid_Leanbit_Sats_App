package se.leanbit.sats.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import se.leanbit.sats.R;

/**
 * Created by gina on 2015-05-12.
 */
public class PagerFragment extends Fragment
{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Bundle args = getArguments();
        int position = args.getInt("page_position");

        LinearLayout fragmentLayout = (LinearLayout)inflater.inflate(R.layout.pager_fragment, container, false);
        LinearLayout mainView = (LinearLayout)fragmentLayout.findViewById(R.id.main_view);
        LinearLayout markedCell = (LinearLayout)fragmentLayout.findViewById(R.id.cell_2);

        changeColor(position, mainView);
        LinearLayout circleCell = (LinearLayout)inflater.inflate(R.layout.pager_circle_cell, container, false);
        markedCell.addView(circleCell);
        return fragmentLayout;
    }



    private View changeColor(int position, View view)
    {
        if(position%2==0){
            view.setBackgroundColor(Color.GRAY);
        }else{
            view.setBackgroundColor(Color.WHITE);
        }
        return view;
    }
}
