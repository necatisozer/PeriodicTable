package com.example.melahat.periodictable;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

public class JsonParser {

    public static PeriodicTable loadJSONFromAsset(Context context) {
        String json;
        try {
            String fileName = Locale.getDefault().getLanguage().equals("tr") ? "periodic-tr.json" : "periodic-en.json";
            InputStream is = context.getApplicationContext().getAssets().open(fileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

        Gson gson = new GsonBuilder().create();
        return gson.fromJson(json, PeriodicTable.class);
    }

}
