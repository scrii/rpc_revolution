package com.mygdx.game;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class GetterANDSetterFile {
    double real_attack=0,real_health=0,real_protection=0,real_speed=0,real_money=0,real_ore_elbrium=0,real_maneuverability=0;
    int  real_sign=0,real_xp=0,real_level=0,coefficient_attack=0,coefficient_protection=0,coefficient_speed=0,real_startChat=0,TrueOrFalse=0;
    String real_message="",real_nickname="",myData = "",strLine;
    File myExternalFile;
    FileInputStream fis;
    DataInputStream in;
    BufferedReader br;
    File file;
    PrintWriter printWriter;
    public GetterANDSetterFile(){}
    public int get_StartChat(){
        myData = "";
        myExternalFile = new File("/data/data/com.mygdx.game/StartChat.txt");
        try {
            fis = new FileInputStream(myExternalFile);
            in = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(in));
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                real_startChat = Integer.parseInt(myData);
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return real_startChat;
    }
    public int get_Sign(){
        myData = "";
        myExternalFile = new File("/data/data/com.mygdx.game/Sign.txt");
        try {
            fis = new FileInputStream(myExternalFile);
            in = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(in));
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
    public double get_Attack(){
        myData = "";
        myExternalFile = new File("/data/data/com.mygdx.game/Attack.txt");
        try {
            fis = new FileInputStream(myExternalFile);
            in = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(in));
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                real_attack = Double.parseDouble(myData);
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
        myData = "";
        myExternalFile = new File("/data/data/com.mygdx.game/guardian_exp.txt");
        try {
            fis = new FileInputStream(myExternalFile);
            in = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(in));
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
        myData = "";
        myExternalFile = new File("/data/data/com.mygdx.game/guardian_level.txt");
        try {
            fis = new FileInputStream(myExternalFile);
            in = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(in));
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
        myData = "";
        myExternalFile = new File("/data/data/com.mygdx.game/nickname.txt");
        try {
            fis = new FileInputStream(myExternalFile);
            in = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(in));
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
    public double get_Guardian_Money(){
        myData = "";
        myExternalFile = new File("/data/data/com.mygdx.game/guardian_money.txt");
        try {
            fis = new FileInputStream(myExternalFile);
            in = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(in));
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                real_money = Double.parseDouble(myData);
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return real_money;
    }
    public double get_Health(){
        myData = "";
        myExternalFile = new File("/data/data/com.mygdx.game/Health.txt");
        try {
            fis = new FileInputStream(myExternalFile);
            in = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(in));
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                real_health = Double.parseDouble(myData);
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return real_health;
    }
    public double get_Maneuverability(){
        myData = "";
        myExternalFile = new File("/data/data/com.mygdx.game/Maneuverability.txt");
        try {
            fis = new FileInputStream(myExternalFile);
            in = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(in));
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                real_maneuverability = Double.parseDouble(myData);
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
        myData = "";
        myExternalFile = new File("/data/data/com.mygdx.game/Message.txt");
        try {
            fis = new FileInputStream(myExternalFile);
            in = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(in));
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
    public double get_Ore_Elbrium(){
        myData = "";
        myExternalFile = new File("/data/data/com.mygdx.game/Ore_Elbrium.txt");
        try {
            fis = new FileInputStream(myExternalFile);
            in = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(in));
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                real_ore_elbrium = Double.parseDouble(myData);
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return real_ore_elbrium;
    }
    public double get_Protection(){
        myData = "";
        myExternalFile = new File("/data/data/com.mygdx.game/Protection.txt");
        try {
            fis = new FileInputStream(myExternalFile);
            in = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(in));
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                real_protection = Double.parseDouble(myData);
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return real_protection;
    }
    public double get_Speed(){
        myData = "";
        myExternalFile = new File("/data/data/com.mygdx.game/Speed.txt");
        try {
            fis = new FileInputStream(myExternalFile);
            in = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(in));
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                real_speed = Double.parseDouble(myData);
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return real_speed;
    }
    public int get_Coefficient_Attack(){
        myData = "";
        myExternalFile = new File("/data/data/com.mygdx.game/CoefficientAttack.txt");
        try {
            fis = new FileInputStream(myExternalFile);
            in = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(in));
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                coefficient_attack = Integer.parseInt(myData);
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return coefficient_attack;
    }
    public int get_Coefficient_Protection(){
        myData = "";
        myExternalFile = new File("/data/data/com.mygdx.game/CoefficientProtection.txt");
        try {
            fis = new FileInputStream(myExternalFile);
            in = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(in));
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                coefficient_protection = Integer.parseInt(myData);
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return coefficient_protection;
    }
    public int get_Coefficient_Speed(){
        myData = "";
        myExternalFile = new File("/data/data/com.mygdx.game/CoefficientSpeed.txt");
        try {
            fis = new FileInputStream(myExternalFile);
            in = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(in));
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                coefficient_speed = Integer.parseInt(myData);
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return coefficient_speed;
    }
    public int get_TrueOrFalse(){
        myData = "";
        myExternalFile = new File("/data/data/com.mygdx.game/TrueOrFalse.txt");
        try {
            fis = new FileInputStream(myExternalFile);
            in = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(in));
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                TrueOrFalse = Integer.parseInt(myData);
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return TrueOrFalse;
    }
    public void set_TrueOrFalse(int c_TrueOrFalse){
        file = new File("/data/data/com.mygdx.game/TrueOrFalse.txt");
        try {
            printWriter = new PrintWriter(file);
            printWriter.write(String.valueOf(c_TrueOrFalse));
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void set_StartChat(int c_startChat){
        file = new File("/data/data/com.mygdx.game/StartChat.txt");
        try {
            printWriter = new PrintWriter(file);
            printWriter.write(String.valueOf(c_startChat));
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void set_Coefficient_Attack(int c_attack){
        file = new File("/data/data/com.mygdx.game/CoefficientAttack.txt");
        try {
            printWriter = new PrintWriter(file);
            printWriter.write(String.valueOf(c_attack));
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void set_Coefficient_Protection(int c_protection){
        file = new File("/data/data/com.mygdx.game/CoefficientProtection.txt");
        try {
            printWriter = new PrintWriter(file);
            printWriter.write(String.valueOf(c_protection));
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void set_Coefficient_Speed(int c_speed){
        file = new File("/data/data/com.mygdx.game/CoefficientSpeed.txt");
        try {
            printWriter = new PrintWriter(file);
            printWriter.write(String.valueOf(c_speed));
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void set_Sign(int r_sign){
        file = new File("/data/data/com.mygdx.game/Sign.txt");
        try {
            printWriter = new PrintWriter(file);
            printWriter.write(String.valueOf(r_sign));
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void set_Attack(double r_attack){
        file = new File("/data/data/com.mygdx.game/Attack.txt");
        try {
            printWriter = new PrintWriter(file);
            printWriter.write(String.valueOf(r_attack));
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void set_Guardian_Exp(int r_guardian_exp){
        file = new File("/data/data/com.mygdx.game/guardian_exp.txt");
        try {
            printWriter = new PrintWriter(file);
            printWriter.write(String.valueOf(r_guardian_exp));
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void set_Guardian_Level(int r_guardian_level){
        file = new File("/data/data/com.mygdx.game/guardian_level.txt");
        try {
            printWriter = new PrintWriter(file);
            printWriter.write(String.valueOf(r_guardian_level));
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void set_Guardian_Money(double r_money){
        file = new File("/data/data/com.mygdx.game/guardian_money.txt");
        try {
            printWriter = new PrintWriter(file);
            printWriter.write(String.valueOf(r_money));
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void set_Health(double r_health){
        file = new File("/data/data/com.mygdx.game/Health.txt");
        try {
            printWriter = new PrintWriter(file);
            printWriter.write(String.valueOf(r_health));
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void set_Maneuverability(double r_maneuverability){
        file = new File("/data/data/com.mygdx.game/Maneuverability.txt");
        try {
            printWriter = new PrintWriter(file);
            printWriter.write(String.valueOf(r_maneuverability));
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void set_Message(String r_message){
        file = new File("/data/data/com.mygdx.game/Message.txt");
        try {
            printWriter = new PrintWriter(file);
            printWriter.write(r_message);
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void set_Ore_Elbrium(double r_ore_elbrium){
        file = new File("/data/data/com.mygdx.game/Ore_Elbrium.txt");
        try {
            printWriter = new PrintWriter(file);
            printWriter.write(String.valueOf(r_ore_elbrium));
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void set_Protection(double r_protection){
        file = new File("/data/data/com.mygdx.game/Protection.txt");
        try {
            printWriter = new PrintWriter(file);
            printWriter.write(String.valueOf(r_protection));
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void set_Speed(double r_speed){
        file = new File("/data/data/com.mygdx.game/Speed.txt");
        try {
            printWriter = new PrintWriter(file);
            printWriter.write(String.valueOf(r_speed));
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void set_Nickname(String r_nickname){
        file = new File("/data/data/com.mygdx.game/nickname.txt");
        try {
            printWriter = new PrintWriter(file);
            printWriter.write(r_nickname);
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // //
    public void set_online(String s){
        file = new File("/data/data/com.mygdx.game/Online.txt");
        try {
            if (!file.exists()) file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            printWriter = new PrintWriter(file);
            printWriter.write(s);
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public String get_Online(){
        myExternalFile = new File("/data/data/com.mygdx.game/Online.txt");
        try {
            fis = new FileInputStream(myExternalFile);
            in = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(in));
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return myData;
    }

    public String getTexture(){
        return "texture";
    }
    // //
}