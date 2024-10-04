package com.example.some_app.util;

import android.content.Context;
import android.net.ConnectivityManager;

// import com.github.scribejava.core.model.HttpClient;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import java.util.List;
//import org.apache.http.client.methods.HttpPost;// to ask
//import org.apache.http.impl.client.DefaultHttpClient; //to ask
//
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

//import oauth.signpost.http.HttpResponse;

public class Utils {

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connMgr = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connMgr.getActiveNetworkInfo() != null
                && connMgr.getActiveNetworkInfo().isAvailable()
                && connMgr.getActiveNetworkInfo().isConnected())
            return true;
        else {
            return false;
        }
    }


    public static String httpPostRequest(Context context, String url, List<NameValuePair> parameterList) {
        // System.out.println("url:: " + url);
        String str = "";
        InputStream is = null;
        HttpsTrustManager.allowAllSSL();
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost;

        if(url.contains("https") || url.contains("http")){
            httppost = new HttpPost(url);
        }else{
            httppost = new HttpPost("http://"+url);
        }
        try {
            httppost.setEntity(new UrlEncodedFormEntity(parameterList));
            HttpResponse httpResponse = httpclient.execute(httppost);
            HttpEntity httpEntity = httpResponse.getEntity();
            is = httpEntity.getContent();
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(is));
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            is.close();
            str = sb.toString();
            //System.out.println("response::" + str);
        } catch (Exception e) {
            //e.printStackTrace();
            e.getMessage();
        }
        return str;
    }


//    public static String httpPostRequest(String urlString, Map<String, String> parameterMap) {
//        String response = "";
//        InputStream is = null;
//
//        try {
//            URL url = new URL(urlString);
//            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
//            urlConnection.setRequestMethod("POST");
//            urlConnection.setDoOutput(true);
//            urlConnection.setDoInput(true);
//            urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
//
//            // Build post parameters as a query string
//            StringBuilder postData = new StringBuilder();
//            for (Map.Entry<String, String> entry : parameterMap.entrySet()) {
//                if (postData.length() != 0) postData.append('&');
//                postData.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
//                postData.append('=');
//                postData.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
//            }
//            byte[] postDataBytes = postData.toString().getBytes("UTF-8");
//
//            // Write the request body
//            OutputStream os = urlConnection.getOutputStream();
//            os.write(postDataBytes);
//            os.flush();
//            os.close();
//
//            // Read the response
//            is = urlConnection.getInputStream();
//            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
//            StringBuilder sb = new StringBuilder();
//            String line;
//            while ((line = reader.readLine()) != null) {
//                sb.append(line + "\n");
//            }
//            response = sb.toString();
//
//            urlConnection.disconnect();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (is != null) {
//                try {
//                    is.close();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//
//        return response;
//    }

}
