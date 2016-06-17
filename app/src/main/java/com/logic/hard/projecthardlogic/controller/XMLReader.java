package com.logic.hard.projecthardlogic.controller;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.util.Log;

import com.logic.hard.projecthardlogic.model.Gauge;
import com.logic.hard.projecthardlogic.model.LoopLijstItem;
import com.logic.hard.projecthardlogic.model.LoopLijstModel;
import com.logic.hard.projecthardlogic.model.Productiviteit;
import com.logic.hard.projecthardlogic.model.ReportModel;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by Vincent on 6/16/2016.
 */
public class XMLReader {

    public static void readProductivityXML(Context context) {
        XmlPullParserFactory pullParserFactory;
        try {
            pullParserFactory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = pullParserFactory.newPullParser();

            InputStream in_s = context.getAssets().open("Productiviteit.xml");
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(in_s, null);

            parseProductiviteitXML(parser);

        } catch (XmlPullParserException e) {
            Log.v("xmlTest", "XmlPullParserException");
            e.printStackTrace();
        } catch (IOException e) {
            Log.v("xmlTest", "IOException");
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static void parseProductiviteitXML(XmlPullParser parser) throws XmlPullParserException, IOException {
        int eventType = parser.getEventType();
        Productiviteit p = new Productiviteit("Productiviteit");
        Log.v("xmlTest", "begin");
        String name = null;
        String naam = null;
        double min = 0;
        double max = 0;
        double in = 0;
        Gauge productiviteit = null;
        Gauge handenAanBed = null;


        while (eventType != XmlPullParser.END_DOCUMENT) {
            switch (eventType) {
                case XmlPullParser.START_DOCUMENT:
                    //products = new ArrayList();
                    break;
                case XmlPullParser.START_TAG:
                    name = parser.getName();
                    if (name.equals("Gaugepanel1")) {
                        naam = "productiviteit";
                        min = 0;
                        max = 0;
                        in = 0;
                        //Log.v("xmlTest", clientName);
                    } else if (name.equals("Gaugepanel2")) {
                        naam = "HandenAanbed";
                        min = 0;
                        max = 0;
                        in = 0;
                    } else {
                        if (name.equals("GaugeScale0")) {
                            if (parser.getAttributeCount() == 2) {
                                max = Double.parseDouble(parser.getAttributeValue(null, "MaximumValue"));
                                //Log.v("xmlTest", clientAddress);
                                min = Double.parseDouble(parser.getAttributeValue(null, "MinimumValue"));
                                //Log.v("xmlTest", clientPhoneNumber);
                            }
                            //Log.v("xmlTest", parser.nextText());
                        } else if (name.equals("GaugePointer0")) {
                            in = Double.parseDouble(parser.getAttributeValue(null, "GaugeInputValue"));
                            //Log.v("xmlTest", activity);
                        }
                    }
                    break;
                case XmlPullParser.END_TAG:
                    name = parser.getName();
                    //if (name.equalsIgnoreCase("product") && currentProduct != null){
                    //    products.add(currentProduct);
                    //}
                    if (name.equalsIgnoreCase("Gaugepanel1")) {
                        if (name != null) {
                            productiviteit = new Gauge(naam, min, max, in);
                        }
                    } else if (name.equalsIgnoreCase("Gaugepanel2")) {
                        if (name != null) {
                            handenAanBed = new Gauge(naam, min, max, in);
                        }
                    }
                    break;
            }
            eventType = parser.next();
        }
        Gauge[] e = new Gauge[2];
        e[0] = productiviteit;
        e[1] = handenAanBed;
        p.setGauges(e);
        ReportModel.getInstance().getReportList().add(p);

    }

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
            e.printStackTrace();
        }
    }

    private static void parseLooplijstXML(XmlPullParser parser) throws XmlPullParserException, IOException {
        int eventType = parser.getEventType();
        ArrayList<LoopLijstItem> items = new ArrayList<>();
        Log.v("xmlTest", "begin");
        String clientName = null;
        String clientAddress = null;
        String clientPhoneNumber = null;
        String activity = null;
        String comments = null;
        String key = null;
        String duration = null;
        String startTime = null;

        while (eventType != XmlPullParser.END_DOCUMENT) {
            String name = null;

            switch (eventType) {
                case XmlPullParser.START_DOCUMENT:
                    break;
                case XmlPullParser.START_TAG:
                    name = parser.getName();
                    if (name.equals("Textbox270")) {
                        clientName = parser.getAttributeValue(null, "Textbox270");
                        //Log.v("xmlTest", clientName);
                    } else {
                        if (name.equals("Tablix16")) {
                            if (parser.getAttributeCount() == 3) {
                                clientAddress = parser.getAttributeValue(null, "Client_adres") + " " + parser.getAttributeValue(null, "Client_postcode1");
                                //Log.v("xmlTest", clientAddress);
                                clientPhoneNumber = parser.getAttributeValue(null, "Client_telefoon2");
                                //Log.v("xmlTest", clientPhoneNumber);
                            }
                            //Log.v("xmlTest", parser.nextText());
                        } else if (name.equals("Product_omschrijving1")) {
                            activity = parser.getAttributeValue(null, "Product_omschrijving1");
                            //Log.v("xmlTest", activity);
                        } else if (name.equals("Client_sleutelprotocol1")) {
                            key = parser.getAttributeValue(null, "Client_sleutelprotocol1");
                            if (key.equals("N")) {
                                key = "Nee";
                            }
                            //Log.v("xmlTest", key);
                        } else if (name.equals("Opmerking_JN")) {
                            comments = parser.getAttributeValue(null, "Opmerking_JN");
                            //Log.v("xmlTest", comments);
                        } else if (name.equals("Client_id")) {
                            startTime = parser.getAttributeValue(null, "Startdatumtijd");
                            //Log.v("xmlTest", startTime);
                        } else if (name.equals("Tijdsduur1")) {
                            duration = parser.getAttributeValue(null, "Tijdsduur1");
                            //Log.v("xmlTest", duration);
                        }
                    }
                    break;
                case XmlPullParser.END_TAG:
                    name = parser.getName();
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

                            items.add(new LoopLijstItem(clientName, clientAddress, activity, comments));
                            Log.d("n", "" + items.size());
                        }
                    }
                    break;
            }
            eventType = parser.next();
        }
        LoopLijstModel l = new LoopLijstModel("LoopLijst");
        for (LoopLijstItem item : items) {
            l.addLoopLijstItem(item);
        }
        ReportModel.getInstance().getReportList().add(l);
    }
}
