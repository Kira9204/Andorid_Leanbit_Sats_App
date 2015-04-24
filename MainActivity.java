package leanbit.SatsWebApi;

import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new UpdateActivities().update("2015-04-10","2015-04-20");
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

    private class UpdateActivities extends AsyncTask<String, String, Void>
    {
        private final String LOG_TAG = "UPDATE_ACTIVITIES";
        private final String ACCEPT_HEADER = "Application/json";
        private final String CLIENT_AUTH_HEADER = "berer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJodHRwOi8vd3d3LnNhdHMuc2UiLCJpc3MiOiJzZWxmIiwibmJmIjoxNDI5MjcxMTI1LCJleHAiOjE0Mjk4NzU5MjUsImh0dHA6Ly9zY2hlbWFzLnhtbHNvYXAub3JnL3dzLzIwMDUvMDUvaWRlbnRpdHkvY2xhaW1zL25hbWUiOiI1NTFwNDYxMDAiLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJTdGFuZGFyZE1lbWJlc";
        private final String HTTP_ADDRESS = "http://leanbit.erikwelander.se/api.sats.com/v1.0/se/training/activities";
        private String result;

        public void update(final String fromDate, final String toDate)
        {
            this.execute(HTTP_ADDRESS, fromDate, toDate);
        }

        protected void onPreExecute(){}
        @Override
        protected Void doInBackground(String... params)
        {
            BufferedReader reader = null;
            StringBuilder data = new StringBuilder();

            String request_url = params[0] + "/" + params[1] + "/" + params[2];
            try {
                URL url = new URL(request_url);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.addRequestProperty("Accept", ACCEPT_HEADER);
                connection.addRequestProperty("Authorization", CLIENT_AUTH_HEADER);
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                String line;
                while ((line = reader.readLine()) != null) {
                    data.append(line);
                }
                result = data.toString();
            } catch (Exception e) {
                Log.e(LOG_TAG, "Could not start download", e);
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (Exception e) {
                        Log.e(LOG_TAG, "Could not close reader", e);
                    }
                }
            }
            return null;
        }

        protected void onPostExecute(Void v)
        {
            TextView t = (TextView)findViewById(R.id.main_text);
            t.setText(result);

        }
    }
}
