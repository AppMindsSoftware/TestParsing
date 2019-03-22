package com.example.saikrishna.jsonparsing;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ListView;
import android.widget.Toast;

import com.asksira.webviewsuite.WebViewSuite;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView jsonListView;
    RecyclerView RecyclerView;
    RecyclerViewAdapter recyclerViewAdapter;
    JsonAdapter jsonAdapter;
    WebView webView;
    ArrayList<JsonDataModel> arrayList;
    String serviceDataUrl = "https://api.androidhive.info/contacts";
    String imageURL = "https://www.krgv.com/androidv2/pages/news_view.cfm?newsid=190826";


    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jsonListView = (ListView) findViewById(R.id.jsonListView);
        RecyclerView = (RecyclerView) findViewById(R.id.RecyclerView);
        webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.setInitialScale(1);
        webView.getSettings().setAppCacheEnabled(false);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setInitialScale(30);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setAppCacheEnabled(true);
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.loadUrl(imageURL);
       // webView.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);


        Toast.makeText(this, "Loading", Toast.LENGTH_SHORT).show();

        new JsonParsingAsynTask(serviceDataUrl).execute();
    }



    private class JsonParsingAsynTask extends AsyncTask<Void, Void, Void
            > {
        ProgressDialog progressDialog;
        String url;

        public JsonParsingAsynTask(String serviceDataUrl) {
            this.url = serviceDataUrl;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setMessage("Loding...");
            progressDialog.setIndeterminate(false);
            progressDialog.setCancelable(false);

        }

        @Override
        protected Void doInBackground(Void... voids) {

            try {
                String response = makeHttpConnection(url);
                JSONObject jsonObject = new JSONObject(response);
                JSONArray jsonArray = jsonObject.getJSONArray("contacts");
                arrayList = new ArrayList<>();
                for (int i = 0; i < jsonArray.length(); i++) {
                    arrayList.add(new JsonDataModel(jsonArray.get(i).toString()));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if (progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
            //jsonAdapter = new JsonAdapter(MainActivity.this, arrayList);
            recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this, arrayList);

            jsonListView.setAdapter(jsonAdapter);
        }
    }

    private String makeHttpConnection(String globalURL) {
        String response = null;
        try {
            URL url = new URL(globalURL);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            InputStream inputStream = new BufferedInputStream(httpURLConnection.getInputStream());
            response = convertInputStreamToString(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    private String convertInputStreamToString(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        try {
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return stringBuilder.toString();
    }
}
