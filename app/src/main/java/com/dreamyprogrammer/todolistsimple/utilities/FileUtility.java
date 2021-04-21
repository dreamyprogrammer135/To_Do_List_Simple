package com.dreamyprogrammer.todolistsimple.utilities;

import android.content.Context;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class FileUtility {

    public static Boolean existFile(String fileName, Context context) {
        File file = new File(context.getFilesDir() + "/"+ fileName);
        return file.exists();
    }


    public static void createToFile(String fileName, Context context) {
        try {
            OutputStream outputStream = context.openFileOutput(fileName, Context.MODE_PRIVATE);
            OutputStreamWriter osw = new OutputStreamWriter(outputStream);
            osw.write("Задача №1;1;null;false");
            osw.close();
        } catch (Throwable t) {
            Toast.makeText(context.getApplicationContext(),
                    "Exception: " + t.toString(), Toast.LENGTH_LONG).show();
        }
    }


    public static void saveToFile(String fileName, Context context, List<String> list) {
        try {
            OutputStream outputStream = context.openFileOutput(fileName, Context.MODE_PRIVATE);
            OutputStreamWriter osw = new OutputStreamWriter(outputStream);
            for (int i = 0; i <list.size() ; i++) {
                osw.write(list.get(i));
            }
            osw.close();
        } catch (Throwable t) {
            Toast.makeText(context.getApplicationContext(),
                    "Exception: " + t.toString(), Toast.LENGTH_LONG).show();
        }
    }



    public static List<String> readFromFile(String fileName, Context context) {
        List<String> list = new ArrayList<>();

        try {
            InputStream inputStream = context.openFileInput(fileName);
            if (inputStream != null) {
                InputStreamReader isr = new InputStreamReader(inputStream);
                BufferedReader reader = new BufferedReader(isr);
                String line;
                while ((line = reader.readLine()) != null) {
                    list.add(line);
                }
                inputStream.close();
            }
        } catch (Throwable t) {
            Toast.makeText(context.getApplicationContext(),
                    "Exception: " + t.toString(), Toast.LENGTH_LONG).show();
        }
        return list;
    }
}