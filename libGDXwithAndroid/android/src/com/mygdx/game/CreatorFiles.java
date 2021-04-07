package com.mygdx.game;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class CreatorFiles {
    CreatorFiles(){

    }
    public void create(){
        File file1 = new File("/data/data/com.mygdx.game/The_core_of_the_second_life.txt");
        if(!file1.exists()){
            try {
                if (!file1.exists()) file1.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                PrintWriter printWriter1 = new PrintWriter(file1);
                printWriter1.write(String.valueOf(0));
                printWriter1.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        File file2 = new File("/data/data/com.mygdx.game/Jump_into_hyperspace.txt");
        if(!file2.exists()){
            try {
                if (!file2.exists()) file2.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                PrintWriter printWriter2 = new PrintWriter(file2);
                printWriter2.write(String.valueOf(0));
                printWriter2.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        File file3 = new File("/data/data/com.mygdx.game/Fast_drill_effect.txt");
        if(!file3.exists()){
            try {
                if (!file3.exists()) file3.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                PrintWriter printWriter3 = new PrintWriter(file3);
                printWriter3.write(String.valueOf(0));
                printWriter3.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
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
                printWriter7.write(String.valueOf(10));
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
                printWriter8.write(String.valueOf(1));
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
    }
}
