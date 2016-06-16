package com.logic.hard.projecthardlogic.activity;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.logic.hard.projecthardlogic.R;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.v("xmlTest", "onCreate");

        XmlPullParserFactory pullParserFactory;
        try {
            pullParserFactory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = pullParserFactory.newPullParser();

            InputStream in_s = getApplicationContext().getAssets().open("test.xml");
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(in_s, null);

            parseXML(parser);

        } catch (XmlPullParserException e) {
            Log.v("xmlTest", "XmlPullParserException");
            e.printStackTrace();
        } catch (IOException e) {
            Log.v("xmlTest", "IOException");
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    protected void onResume() {
        getSupportFragmentManager().popBackStackImmediate();
        super.onResume();
    }

    private void parseXML(XmlPullParser parser) throws XmlPullParserException,IOException
    {
        int eventType = parser.getEventType();
        Log.v("xmlTest", "begin");

        while (eventType != XmlPullParser.END_DOCUMENT){
            String name = null;
            switch (eventType){
                case XmlPullParser.START_DOCUMENT:
                    //products = new ArrayList();
                    break;
                case XmlPullParser.START_TAG:
                    name = parser.getName();
                    if (name.equals("product")){
                        Log.v("xmlTest", "product");
                    } else {
                        if (name.equals("productname")){
                            Log.v("xmlTest", parser.nextText());
                        } else if (name.equals("productcolor")){
                            Log.v("xmlTest", parser.nextText());
                        } else if (name.equals("productquantity")){
                            Log.v("xmlTest", parser.nextText());
                        }
                    }
                    break;
                case XmlPullParser.END_TAG:
                    name = parser.getName();
                    //if (name.equalsIgnoreCase("product") && currentProduct != null){
                    //    products.add(currentProduct);
                    //}
            }
            eventType = parser.next();
        }
    }

}
