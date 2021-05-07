package com.mygdx.game;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class CreatorFiles {
    CreatorFiles(){

    }
    public void create(){
        File file4 = new File("/data/data/com.mygdx.game/Health.txt");
        if(!file4.exists()){
            try {
                if (!file4.exists()) file4.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                PrintWriter printWriter4 = new PrintWriter(file4);
                printWriter4.write(String.valueOf(10));
                printWriter4.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        File file5 = new File("/data/data/com.mygdx.game/Protection.txt");
        if(!file5.exists()){
            try {
                if (!file5.exists()) file5.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                PrintWriter printWriter5 = new PrintWriter(file5);
                printWriter5.write(String.valueOf(3));
                printWriter5.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        File file6 = new File("/data/data/com.mygdx.game/Attack.txt");
        if(!file6.exists()){
            try {
                if (!file6.exists()) file6.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                PrintWriter printWriter6 = new PrintWriter(file6);
                printWriter6.write(String.valueOf(3));
                printWriter6.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        File file7 = new File("/data/data/com.mygdx.game/Speed.txt");
        if(!file7.exists()){
            try {
                if (!file7.exists()) file7.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                PrintWriter printWriter7 = new PrintWriter(file7);
                printWriter7.write(String.valueOf(3));
                printWriter7.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        File file8 = new File("/data/data/com.mygdx.game/Maneuverability.txt");
        if(!file8.exists()){
            try {
                if (!file8.exists()) file8.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                PrintWriter printWriter8 = new PrintWriter(file8);
                printWriter8.write(String.valueOf(0));
                printWriter8.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        File file9 = new File("/data/data/com.mygdx.game/Ore_Elbrium.txt");
        if(!file9.exists()){
            try {
                if (!file9.exists()) file9.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                PrintWriter printWriter9 = new PrintWriter(file9);
                printWriter9.write(String.valueOf(0));
                printWriter9.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        File file10 = new File("/data/data/com.mygdx.game/Message.txt");
        if(!file10.exists()){
            try {
                if (!file10.exists()) file10.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        File file11 = new File("/data/data/com.mygdx.game/Sign.txt");
        if(!file11.exists()){
            try {
                if (!file11.exists()) file11.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                PrintWriter printWriter11 = new PrintWriter(file11);
                printWriter11.write(String.valueOf(1));
                printWriter11.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        File file12 = new File("/data/data/com.mygdx.game/CoefficientAttack.txt");
        if(!file12.exists()){
            try {
                if (!file12.exists()) file12.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                PrintWriter printWriter12 = new PrintWriter(file12);
                printWriter12.write(String.valueOf(0));
                printWriter12.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        File file13 = new File("/data/data/com.mygdx.game/CoefficientProtection.txt");
        if(!file13.exists()){
            try {
                if (!file13.exists()) file13.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                PrintWriter printWriter13 = new PrintWriter(file13);
                printWriter13.write(String.valueOf(0));
                printWriter13.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        File file14 = new File("/data/data/com.mygdx.game/CoefficientSpeed.txt");
        if(!file14.exists()){
            try {
                if (!file14.exists()) file14.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                PrintWriter printWriter14 = new PrintWriter(file14);
                printWriter14.write(String.valueOf(0));
                printWriter14.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        File file15 = new File("/data/data/com.mygdx.game/StartChat.txt");
        if(!file15.exists()){
            try {
                if (!file15.exists()) file15.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                PrintWriter printWriter15 = new PrintWriter(file15);
                printWriter15.write(String.valueOf(0));
                printWriter15.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
