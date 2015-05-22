package se.leanbit.sats;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Config;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.PlayerStyle;
import com.google.android.youtube.player.YouTubePlayerView;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.PlayerStyle;
import com.google.android.youtube.player.YouTubePlayerView;



import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import com.google.android.youtube.player.YouTubePlayer;

import se.leanbit.sats.models.SatsActivity;
import se.leanbit.sats.models.*;

import se.leanbit.sats.repositories.services.SatsActivitiesService;
import se.leanbit.sats.repositories.services.WebService;


public class BookedActivity extends YouTubeBaseActivity implements
        YouTubePlayer.OnInitializedListener
{

    private static final int RECOVERY_DIALOG_REQUEST = 1;

    final String classTypeUrl = "https://api2.sats.com/v1.0/se/classTypes";
    private FullClassTypes fct;
    private int classIndex;
    public VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Gson gson = new GsonBuilder().create();
        try
        {
            fct = gson.fromJson(new WebService().execute(classTypeUrl).get(), FullClassTypes.class);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        } catch (ExecutionException e)
        {
            e.printStackTrace();
        }


        Intent intent = getIntent();
        SatsActivity activity = (SatsActivity) intent.getSerializableExtra("Activity");
        setContentView(R.layout.booked_class);


        for (int i = 0; i < fct.classTypes.length; i++)
        {
            if (fct.classTypes[i].name.equals(activity.subType))
            {
                classIndex = i;
            }
        }

        TextView que = (TextView) findViewById(R.id.queue);
        TextView className = (TextView) findViewById(R.id.Class);
        TextView duration = (TextView) findViewById(R.id.duration);
        TextView dateText = (TextView) findViewById(R.id.booked_class_day);
        TextView centerName = (TextView) findViewById(R.id.booked_class_instructor);
        TextView description = (TextView) findViewById(R.id.booked_class_description);
        TextView instructorName = (TextView) findViewById(R.id.booked_class_instructor_name);


        YouTubePlayerView youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtubeplayerview);


        ProgressBar cardioBar = (ProgressBar) findViewById(R.id.booked_class_fitness_progressbar);
        ProgressBar strenghtBar = (ProgressBar) findViewById(R.id.booked_class_strength_progressbar);
        ProgressBar flexibilityBar = (ProgressBar) findViewById(R.id.booked_class_flexibility_progressbar);
        ProgressBar balanceBar = (ProgressBar) findViewById(R.id.booked_class_balance_progressbar);
        ProgressBar resilienceBar = (ProgressBar) findViewById(R.id.booked_class_resilience_progressbar);

        que.setText("" + activity.booking.positionInQueue);
        duration.setText("" + activity.durationInMinutes + " min");
        className.setText(activity.subType);
        description.setText(fct.classTypes[classIndex].description);
        dateText.setText(activity.date);
        centerName.setText(new SatsActivitiesService().getRegion(activity));
        instructorName.setText(activity.booking.clazz.instructorId);


        for (int i = 0; i < this.fct.classTypes[classIndex].profile.length; i++)
        {
            switch (this.fct.classTypes[classIndex].profile[i].id)
            {
                case "cardio":
                    cardioBar.setProgress(this.fct.classTypes[classIndex].profile[0].value);
                    break;

                case "strength":
                    strenghtBar.setProgress(this.fct.classTypes[classIndex].profile[1].value);
                    break;

                case "flexibility":
                    flexibilityBar.setProgress(this.fct.classTypes[classIndex].profile[2].value);
                    break;

                case "balance":
                    balanceBar.setProgress(this.fct.classTypes[classIndex].profile[3].value);
                    break;

                case "agility":
                    resilienceBar.setProgress(this.fct.classTypes[classIndex].profile[4].value);
                    break;
            }
            youTubePlayerView.initialize(Config.DEVELOPER_KEY, this);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_booked, menu);
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


    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider,
                                        YouTubeInitializationResult errorReason) {
        if (errorReason.isUserRecoverableError()) {
            errorReason.getErrorDialog(this, RECOVERY_DIALOG_REQUEST).show();
        } else {
            String errorMessage = String.format(
                    "error player", errorReason.toString());
            Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider,
                                        YouTubePlayer player, boolean wasRestored) {
        if (!wasRestored) {

            // loadVideo() will auto play video
            // Use cueVideo() method, if you don't want to play it automatically
            player.cueVideo("1H_znJi2nbE");

            // Hiding player controls
            player.setPlayerStyle(PlayerStyle.MINIMAL);
        }
    }

    public class Config {
        // Google Console APIs developer key
        // Replace this key with your's
        public static final String DEVELOPER_KEY = "AIzaSyCJxCUMuVKTx0RM8EyNOMeNpdfKHkbYcKc";

        // YouTube video id
        //public static final String YOUTUBE_VIDEO_CODE = "1H_znJi2nbE";
    }
}
