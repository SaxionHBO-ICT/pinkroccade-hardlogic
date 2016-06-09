package com.logic.hard.projecthardlogic.model;

import android.content.Context;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Werner on 08-06-16.
 */
public class UrlConnection extends AsyncTask<String,Void,String> {
    private String uName, uPassword, db_Name, link, data, status;
    private static String USERNAME = "username =";
    private static String USERPASSWORD = "userpassword =";


    private Context context;

    public UrlConnection(Context context) {
        this.context = context;

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {

            try {
                uName = params[0];
                uPassword = params[1];

                data = USERNAME + uName;
                data += "&" + USERPASSWORD + uPassword;

                link = "http:// -Webadress- /login.php?" + data; //TODO http connection syntax (webadress)

                URL url = new URL(link);
                URLConnection conn = url.openConnection();

                conn.setDoOutput(true);
                conn.connect();

                InputStreamReader reader = new InputStreamReader(conn.getInputStream());
                BufferedReader in = new BufferedReader(reader);
                StringBuffer sb = new StringBuffer("");
                String line ="";

                while((line = in.readLine()) != null){  //while not null
                    sb.append(line);
                    break;
                }
                in.close();
                return sb.toString();


            } catch (Exception e) {
                return "Exception" + e.getMessage();
            }

    }

    @Override
    protected void onPostExecute(String s) {
        this.status = s;
    }
}
