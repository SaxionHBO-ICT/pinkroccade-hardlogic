package com.logic.hard.projecthardlogic.controller;

import android.content.Context;
import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Vincent on 6/16/2016.
 */
public class XMLReader {

    public static void readLoopLijstXML(Context context) {
        XmlPullParserFactory pullParserFactory;
        try {
            pullParserFactory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = pullParserFactory.newPullParser();

            InputStream in_s = context.getAssets().open("Looplijst.xml");
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(in_s, null);

            parseLooplijstXML(parser);

        } catch (XmlPullParserException e) {
            Log.v("xmlTest", "XmlPullParserException");
            e.printStackTrace();
        } catch (IOException e) {
            Log.v("xmlTest", "IOException");
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static void parseLooplijstXML(XmlPullParser parser) throws XmlPullParserException,IOException
    {
        int eventType = parser.getEventType();
        Log.v("xmlTest", "begin");
        String clientName = null;
        String clientAddress = null;
        String clientPhoneNumber = null;
        String activity = null;
        String comments = null;
        String key = null;
        String duration = null;
        String startTime = null;

        while (eventType != XmlPullParser.END_DOCUMENT){
            String name = null;

            switch (eventType){
                case XmlPullParser.START_DOCUMENT:
                    //products = new ArrayList();
                    break;
                case XmlPullParser.START_TAG:
                    name = parser.getName();
                    if (name.equals("Textbox270")){
                        clientName = parser.getAttributeValue(null, "Textbox270");
                        //Log.v("xmlTest", clientName);
                    } else {
                        if (name.equals("Tablix16")){
                            if (parser.getAttributeCount() == 3) {
                                clientAddress = parser.getAttributeValue(null, "Client_adres") + " " + parser.getAttributeValue(null, "Client_postcode1");
                                //Log.v("xmlTest", clientAddress);
                                clientPhoneNumber = parser.getAttributeValue(null, "Client_telefoon2");
                                //Log.v("xmlTest", clientPhoneNumber);
                            }
                            //Log.v("xmlTest", parser.nextText());
                        } else if (name.equals("Product_omschrijving1")){
                            activity = parser.getAttributeValue(null, "Product_omschrijving1");
                            //Log.v("xmlTest", activity);
                        } else if (name.equals("Client_sleutelprotocol1")){
                            key = parser.getAttributeValue(null, "Client_sleutelprotocol1");
                            if (key.equals("N")) {
                                key = "Nee";
                            }
                            //Log.v("xmlTest", key);
                        } else if (name.equals("Opmerking_JN")){
                            comments = parser.getAttributeValue(null, "Opmerking_JN");
                            //Log.v("xmlTest", comments);
                        } else if (name.equals("Client_id")){
                            startTime = parser.getAttributeValue(null, "Startdatumtijd");
                            //Log.v("xmlTest", startTime);
                        } else if (name.equals("Tijdsduur1")){
                            duration = parser.getAttributeValue(null, "Tijdsduur1");
                            //Log.v("xmlTest", duration);
                        }
                    }
                    break;
                case XmlPullParser.END_TAG:
                    name = parser.getName();
                    //if (name.equalsIgnoreCase("product") && currentProduct != null){
                    //    products.add(currentProduct);
                    //}
                    if (name.equalsIgnoreCase("Client_id")) {
                        if (clientName != null) {
                            Log.v("xmlTest", clientName);
                            Log.v("xmlTest", clientAddress);
                            Log.v("xmlTest", clientPhoneNumber);
                            Log.v("xmlTest", activity);
                            Log.v("xmlTest", key);
                            Log.v("xmlTest", comments);
                            Log.v("xmlTest", startTime);
                            Log.v("xmlTest", duration);
                        }
                    }


            }
            eventType = parser.next();
        }
    }
}
