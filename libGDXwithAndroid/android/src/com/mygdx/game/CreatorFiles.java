package com.mygdx.game;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class CreatorFiles {
    CreatorFiles(){}
    File file4,file5,file6,file7,file8,file9,file10,file11,file12,file13,file14,file15,file16;
    PrintWriter printWriter4,printWriter5,printWriter6,printWriter7,printWriter8,printWriter9,printWriter11,printWriter12,printWriter13,printWriter14,printWriter15,printWriter16;
    public void create(){
        file4 = new File("/data/data/com.mygdx.game/Health.txt");
        file5 = new File("/data/data/com.mygdx.game/Protection.txt");
        file6 = new File("/data/data/com.mygdx.game/Attack.txt");
        file7 = new File("/data/data/com.mygdx.game/Speed.txt");
        file8 = new File("/data/data/com.mygdx.game/Maneuverability.txt");
        file9 = new File("/data/data/com.mygdx.game/Ore_Elbrium.txt");
        file10 = new File("/data/data/com.mygdx.game/Message.txt");
        file11 = new File("/data/data/com.mygdx.game/Sign.txt");
        file12 = new File("/data/data/com.mygdx.game/CoefficientAttack.txt");
        file13 = new File("/data/data/com.mygdx.game/CoefficientProtection.txt");
        file14 = new File("/data/data/com.mygdx.game/CoefficientSpeed.txt");
        file15 = new File("/data/data/com.mygdx.game/StartChat.txt");
        file16 = new File("/data/data/com.mygdx.game/TrueOrFalse.txt");
        try {
            file4.createNewFile();
            file5.createNewFile();
            file6.createNewFile();
            file7.createNewFile();
            file8.createNewFile();
            file9.createNewFile();
            file10.createNewFile();
            file11.createNewFile();
            file12.createNewFile();
            file13.createNewFile();
            file14.createNewFile();
            file15.createNewFile();
            file16.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
            try {
                printWriter4 = new PrintWriter(file4);
                printWriter4.write(String.valueOf(10));
                printWriter4.close();
                printWriter5 = new PrintWriter(file5);
                printWriter5.write(String.valueOf(3));
                printWriter5.close();
                printWriter6 = new PrintWriter(file6);
                printWriter6.write(String.valueOf(3));
                printWriter6.close();
                printWriter7 = new PrintWriter(file7);
                printWriter7.write(String.valueOf(3));
                printWriter7.close();
                printWriter8 = new PrintWriter(file8);
                printWriter8.write(String.valueOf(0));
                printWriter8.close();
                printWriter9 = new PrintWriter(file9);
                printWriter9.write(String.valueOf(0));
                printWriter9.close();
                printWriter11 = new PrintWriter(file11);
                printWriter11.write(String.valueOf(1));
                printWriter11.close();
                printWriter12 = new PrintWriter(file12);
                printWriter12.write(String.valueOf(0));
                printWriter12.close();
                printWriter13 = new PrintWriter(file13);
                printWriter13.write(String.valueOf(0));
                printWriter13.close();
                printWriter14 = new PrintWriter(file14);
                printWriter14.write(String.valueOf(0));
                printWriter14.close();
                printWriter15 = new PrintWriter(file15);
                printWriter15.write(String.valueOf(0));
                printWriter15.close();
                printWriter16 = new PrintWriter(file16);
                printWriter16.write(String.valueOf(0));
                printWriter16.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
    }
}