package com.github.greenmarker;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class SortPropTest {

    @Test
    public void main() throws IOException, InterruptedException {
        SortPropTest sp = new SortPropTest();
        sp.generateTestData(new File("src/test/resources"));
    }

    @BeforeAll
    public void generateTestData(File dir) throws IOException {
        generateBasePropFile(new  File(dir, "Res_en_GB.properties"));
        generatePropFile(new  File(dir, "Res_pl_PL.properties"));
        generatePropFile(new  File(dir,"Res_fr.properties"));
        generatePropFile(new  File(dir,"Res_de_DE.properties"));
        generatePropFile(new  File(dir,"Res_de_CH.properties"));
        generatePropFile(new  File(dir,"Res_tr.properties"));
    }

    private void generatePropFile(File file) throws IOException {
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

    private void generateBasePropFile(File file) throws IOException {
        try (FileWriter writer = new FileWriter(file) ){
            writer.write("#################### section AB \r\n \r\n");
            for(int i=0; i<1000; i++){
                writer.write("key" + i + "=base value\r\n");
            }
        }
    }
}
