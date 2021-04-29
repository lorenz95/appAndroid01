package com.example.examplecontacts;

import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.example.examplecontacts.MainActivity.TAG_insert;
import static com.example.examplecontacts.MainActivity.nomeFile;

public class LeggiFile {
    private static String nomeClasse = "LeggiFile";

    private static String pathFile;

    public static void setPathFile(final String pathFile) {
        LeggiFile.pathFile = pathFile;
    }

    public static List<Contatto> getListContatti() {
        List<Contatto> returnList = new ArrayList<>();

        try {
            FileInputStream in = new FileInputStream(pathFile);
            ObjectInputStream stream = new ObjectInputStream(in);
            Object obj;
            /*
            while ((obj = stream.readObject()) != null) {
                if (obj instanceof Contatto) {
                    returnList.add((Contatto) obj);
                }
            }
             */
            List<Contatto> contattoList = (ArrayList<Contatto>) stream.readObject();
            returnList = contattoList;

            stream.close();
            in.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return returnList;
    }

}
