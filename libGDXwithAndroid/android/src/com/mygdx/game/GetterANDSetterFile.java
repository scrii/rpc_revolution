package com.mygdx.game;

import android.util.Log;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class GetterANDSetterFile {
    int real_sign=0,real_attack=0,real_xp=0,real_level=0,real_money=0,real_health=0,real_maneuverability=0,real_ore_elbrium=0,real_protection=0,real_speed=0;
    String real_message="",real_nickname="";
    public int sign = 0;
    public int attack = 0;
    public int guardian_exp = 0;
    public int guardian_level = 0;
    public int guardian_money = 0;
    public int health = 0;
    public int maneuverability = 0;
    public String message = "";
    public int ore_elbrium = 0;
    public int protection = 0;
    public int speed = 0;
    public String nickname = "";
    GetterANDSetterFile(){

    }
    public int get_Sign(){
        String myData = "";
        File myExternalFile = new File("/data/data/com.mygdx.game/Sign.txt");
        try {
            FileInputStream fis = new FileInputStream(myExternalFile);
            DataInputStream in = new DataInputStream(fis);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                real_sign = Integer.parseInt(myData);
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return real_sign;
    }
    public int get_Attack(){
        String myData = "";
        File myExternalFile = new File("/data/data/com.mygdx.game/Attack.txt");
        try {
            FileInputStream fis = new FileInputStream(myExternalFile);
            DataInputStream in = new DataInputStream(fis);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                real_attack = Integer.parseInt(myData);
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return real_attack;
    }
    public int get_Guardian_Exp(){
        String myData = "";
        File myExternalFile = new File("/data/data/com.mygdx.game/guardian_exp.txt");
        try {
            FileInputStream fis = new FileInputStream(myExternalFile);
            DataInputStream in = new DataInputStream(fis);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                real_xp = Integer.parseInt(myData);
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return real_xp;
    }
    public int get_Guardian_Level(){
        String myData = "";
        File myExternalFile = new File("/data/data/com.mygdx.game/guardian_level.txt");
        try {
            FileInputStream fis = new FileInputStream(myExternalFile);
            DataInputStream in = new DataInputStream(fis);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                real_level = Integer.parseInt(myData);
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return real_level;
    }
    public String get_Nickname(){
        String myData = "";
        File myExternalFile = new File("/data/data/com.mygdx.game/nickname.txt");
        try {
            FileInputStream fis = new FileInputStream(myExternalFile);
            DataInputStream in = new DataInputStream(fis);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                real_nickname = myData;
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return real_nickname;
    }
    public int get_Guardian_Money(){
        String myData = "";
        File myExternalFile = new File("/data/data/com.mygdx.game/guardian_money.txt");
        try {
            FileInputStream fis = new FileInputStream(myExternalFile);
            DataInputStream in = new DataInputStream(fis);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                real_money = Integer.parseInt(myData);
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return real_money;
    }
    public int get_Health(){
        String myData = "";
        File myExternalFile = new File("/data/data/com.mygdx.game/Health.txt");
        try {
            FileInputStream fis = new FileInputStream(myExternalFile);
            DataInputStream in = new DataInputStream(fis);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                real_health = Integer.parseInt(myData);
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return real_health;
    }
    public int get_Maneuverability(){
        String myData = "";
        File myExternalFile = new File("/data/data/com.mygdx.game/Maneuverability.txt");
        try {
            FileInputStream fis = new FileInputStream(myExternalFile);
            DataInputStream in = new DataInputStream(fis);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                real_maneuverability = Integer.parseInt(myData);
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return real_maneuverability;
    }
    public String get_Message(){
        String myData = "";
        File myExternalFile = new File("/data/data/com.mygdx.game/Message.txt");
        try {
            FileInputStream fis = new FileInputStream(myExternalFile);
            DataInputStream in = new DataInputStream(fis);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                real_message = myData;
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return real_message;
    }
    public int get_Ore_Elbrium(){
        String myData = "";
        File myExternalFile = new File("/data/data/com.mygdx.game/Ore_Elbrium.txt");
        try {
            FileInputStream fis = new FileInputStream(myExternalFile);
            DataInputStream in = new DataInputStream(fis);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                real_ore_elbrium = Integer.parseInt(myData);
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return real_ore_elbrium;
    }
    public int get_Protection(){
        String myData = "";
        File myExternalFile = new File("/data/data/com.mygdx.game/Protection.txt");
        try {
            FileInputStream fis = new FileInputStream(myExternalFile);
            DataInputStream in = new DataInputStream(fis);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                real_protection = Integer.parseInt(myData);
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return real_protection;
    }
    public int get_Speed(){
        String myData = "";
        File myExternalFile = new File("/data/data/com.mygdx.game/Speed.txt");
        try {
            FileInputStream fis = new FileInputStream(myExternalFile);
            DataInputStream in = new DataInputStream(fis);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                real_speed = Integer.parseInt(myData);
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return real_speed;
    }
    public void set_Sign(int r_sign){
        sign = r_sign;
        File file = new File("/data/data/com.mygdx.game/Sign.txt");
        try {
            if (!file.exists()) file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.write(String.valueOf(sign));
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void set_Attack(int r_attack){
        attack = r_attack;
        File file = new File("/data/data/com.mygdx.game/Attack.txt");
        try {
            if (!file.exists()) file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.write(String.valueOf(attack));
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void set_Guardian_Exp(int r_guardian_exp){
        guardian_exp = r_guardian_exp;
        File file = new File("/data/data/com.mygdx.game/guardian_exp.txt");
        try {
            if (!file.exists()) file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.write(String.valueOf(guardian_exp));
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void set_Guardian_Level(int r_guardian_level){
        guardian_level = r_guardian_level;
        File file = new File("/data/data/com.mygdx.game/guardian_level.txt");
        try {
            if (!file.exists()) file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.write(String.valueOf(guardian_level));
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void set_Guardian_Money(int r_money){
        guardian_money = r_money;
        File file = new File("/data/data/com.mygdx.game/guardian_money.txt");
        try {
            if (!file.exists()) file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.write(String.valueOf(guardian_money));
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void set_Health(int r_health){
        health = r_health;
        File file = new File("/data/data/com.mygdx.game/Health.txt");
        try {
            if (!file.exists()) file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.write(String.valueOf(health));
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void set_Maneuverability(int r_maneuverability){
        maneuverability = r_maneuverability;
        File file = new File("/data/data/com.mygdx.game/Maneuverability.txt");
        try {
            if (!file.exists()) file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.write(String.valueOf(maneuverability));
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void set_Message(String r_message){
        message = r_message;
        File file = new File("/data/data/com.mygdx.game/Message.txt");
        try {
            if (!file.exists()) file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.write(message);
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void set_Ore_Elbrium(int r_ore_elbrium){
        ore_elbrium = r_ore_elbrium;
        File file = new File("/data/data/com.mygdx.game/Ore_Elbrium.txt");
        try {
            if (!file.exists()) file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.write(String.valueOf(ore_elbrium));
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void set_Protection(int r_protection){
        protection = r_protection;
        File file = new File("/data/data/com.mygdx.game/Protection.txt");
        try {
            if (!file.exists()) file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.write(String.valueOf(protection));
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void set_Speed(int r_speed){
        speed = r_speed;
        File file = new File("/data/data/com.mygdx.game/Speed.txt");
        try {
            if (!file.exists()) file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.write(String.valueOf(speed));
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void set_Nickname(String r_nickname){
        nickname = r_nickname;
        File file = new File("/data/data/com.mygdx.game/nickname.txt");
        try {
            if (!file.exists()) file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.write(nickname);
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
