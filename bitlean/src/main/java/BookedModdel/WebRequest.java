package se.segr.android.leanbit_sats_app;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by sebastiangraveleij on 27/04/15.
 */
public class WebRequest extends AsyncTask<String, String, String>{

    public String result;
    final private String LOG_TAG = "WEB_REC";

    protected String doInBackground(String... params) {
        BufferedReader reader = null;
        StringBuilder data = new StringBuilder();
        try {
            URL url = new URL(params[0]);
            Log.e(LOG_TAG, params[0]);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.addRequestProperty("accept", "Application/json");
            int status = connection.getResponseCode();

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
        return result;
    }
}
