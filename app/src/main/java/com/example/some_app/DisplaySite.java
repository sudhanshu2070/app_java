package com.example.some_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.some_app.modal.BeanSiteList;
import com.example.some_app.util.Utils;
import com.google.gson.Gson;


import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DisplaySite extends Activity {

    BeanSiteList response_ticket_list = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_site);


        if (Utils.isNetworkAvailable(DisplaySite.this)) {
            Toast.makeText(this, "Network Available!", Toast.LENGTH_LONG).show();
            new PMGridTask(DisplaySite.this).execute();

        } else {
            // "No Internet Connection"
            Toast.makeText(this, "Please Check your network connection!", Toast.LENGTH_LONG).show();
        }

    }


   public class PMGridTask extends AsyncTask<Void, Void, Void> {
        ProgressDialog pd;
        Context con;

       public PMGridTask(Context con) {
            this.con = con;
        }

        @Override
        protected void onPreExecute() {
            pd = ProgressDialog.show(con, null, "Loading...");
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {

                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(4);
                nameValuePairs.add(new BasicNameValuePair("userID","1"));
                nameValuePairs.add(new BasicNameValuePair("type", "NEXT_7_DAYS"));
                nameValuePairs.add(new BasicNameValuePair("siteID", ""));
                nameValuePairs.add(new BasicNameValuePair("activityTypeFlag","1"));

                String url = "http://49.205.178.202:5055/api/PM/GetScheduleSites";

                //the HTTP POST request using the helper method
                String response = Utils.httpPostRequest(con,url, nameValuePairs);

                // Parsing the JSON response
                Gson gson = new Gson();
                response_ticket_list = gson.fromJson(response, BeanSiteList.class);
            } catch (Exception e) {
                e.printStackTrace();
                response_ticket_list = null;
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            if (response_ticket_list == null) {
                Toast.makeText(DisplaySite.this,"server error",Toast.LENGTH_LONG).show();
            } else if (response_ticket_list.getSite_list()!=null && response_ticket_list.getSite_list().size() > 0) {

               //sites_list.setAdapter(new AdapterSchedule(getActivity(),response_ticket_list,"S"));

            } else {
                Toast.makeText(DisplaySite.this,"No data found",Toast.LENGTH_LONG).show();
            }
            if (pd !=null && pd.isShowing()) {
               pd.dismiss();
            }
            super.onPostExecute(result);
        }

    }
}