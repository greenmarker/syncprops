package com.github.greenmarker;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * Generate files for test: Res_en_GB.properties (base file with all resource strings)
 * and few, 5, property files, where some resource strings have been translated.
 *
 * Save files in src/test/resources. At compile time they will be copied to , and on those copied filed test will work.
 * Files in src/test/resources will remain intact.
 */
public class PropertiesGenerator {

    public static void main(String[] args) throws IOException {
        File dir = new File("src/test/resources");
        generateBasePropFile(new  File(dir, "Res_en_GB.properties"));
        generatePropFile(new  File(dir, "Res_pl_PL.properties"));
        generatePropFile(new  File(dir,"Res_fr.properties"));
        generatePropFile(new  File(dir,"Res_de_DE.properties"));
        generatePropFile(new  File(dir,"Res_de_CH.properties"));
        generatePropFile(new  File(dir,"Res_tr.properties"));
    }

    private static void generatePropFile(File file) throws IOException {
        int[] tab = new int[1000];
        for (int i=0; i<tab.length; i++){
            tab[i] = i;
        }
        int prevR = 0;
        int tmp = 0;
        for (int n=0; n<1000; n++){
            tmp = tab[prevR];
            int r = new Random().nextInt(tab.length);
            tab[prevR] = tab[r];
            tab[r]=tmp;
        }

        try (FileWriter writer = new FileWriter(file)){
            for(int i=0; i<tab.length/2; i++){
                writer.write("key" + tab[i] + "=translated value\r\n");
            }
        }
    }

    private static void generateBasePropFile(File file) throws IOException {
        try (FileWriter writer = new FileWriter(file) ){
            writer.write("#################### section AB \r\n \r\n");
            for(int i=0; i<1000; i++){
                writer.write("key" + i + "=base value\r\n");
            }
        }
    }
}
