package com.example.odooandroid;

import android.os.AsyncTask;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTPRequest {
    public interface HTTPRequestListener {
        void onResponse(String result);
    }

    public static class HTTPSELECTRequest extends AsyncTask<String, Void, String> {
        private HTTPRequestListener listener;

        public HTTPSELECTRequest(HTTPRequestListener listener) {
            this.listener = listener;
        }

        public HTTPSELECTRequest() {

        }

        @Override
        protected String doInBackground(String... params) {
            HttpURLConnection urlConnection = null;
            StringBuilder response = new StringBuilder("");
            for (String adresse : params) {
                try {
                    URL url = new URL(adresse);
                    urlConnection = (HttpURLConnection) url.openConnection();
                    int code = urlConnection.getResponseCode();
                    if (code != 200) {
                        throw new Exception("Invalid response from server: " + code);
                    }
                    BufferedReader rd = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                    String line;
                    while ((line = rd.readLine()) != null) {
                        response.append(line).append('\n');
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (urlConnection != null) {
                        urlConnection.disconnect();
                    }
                }
            }
            return response.toString();
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            if (listener != null) {
                listener.onResponse(result);
            }
        }
    }
}