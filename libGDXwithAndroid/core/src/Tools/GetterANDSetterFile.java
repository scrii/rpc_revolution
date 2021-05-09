package Tools;

import com.badlogic.gdx.Gdx;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class GetterANDSetterFile {
    float real_attack=0,real_health=0,real_protection=0,real_speed=0,real_money=0,real_ore_elbrium=0,real_maneuverability=0;
    int  real_sign=0,real_xp=0,real_level=0,coefficient_attack=0,coefficient_protection=0,coefficient_speed=0;
    String real_message="",real_nickname="";
    public int sign = 0,f_attack=0,f_protection=0,f_speed=0;
    public float attack = 0;
    public int guardian_exp = 0;
    public int guardian_level = 0;
    public float guardian_money = 0;
    public float health = 0;
    public float maneuverability = 0;
    public String message = "";
    public float ore_elbrium = 0;
    public float protection = 0;
    public float speed = 0;
    public String nickname = "";
    public GetterANDSetterFile(){

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
    public float get_Attack(){
        String myData = "";
        File myExternalFile = new File("/data/data/com.mygdx.game/Attack.txt");
        try {
            FileInputStream fis = new FileInputStream(myExternalFile);
            DataInputStream in = new DataInputStream(fis);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                real_attack = Float.parseFloat(myData);
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
    public float get_Guardian_Money(){
        String myData = "";
        File myExternalFile = new File("/data/data/com.mygdx.game/guardian_money.txt");
        try {
            FileInputStream fis = new FileInputStream(myExternalFile);
            DataInputStream in = new DataInputStream(fis);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                real_money = Float.parseFloat(myData);
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return real_money;
    }
    public float get_Health(){
        String myData = "";
        File myExternalFile = new File("/data/data/com.mygdx.game/Health.txt");
        try {
            FileInputStream fis = new FileInputStream(myExternalFile);
            DataInputStream in = new DataInputStream(fis);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                real_health = Float.parseFloat(myData);
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return real_health;
    }
    public float get_Maneuverability(){
        String myData = "";
        File myExternalFile = new File("/data/data/com.mygdx.game/Maneuverability.txt");
        try {
            FileInputStream fis = new FileInputStream(myExternalFile);
            DataInputStream in = new DataInputStream(fis);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                real_maneuverability = Float.parseFloat(myData);
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
    public float get_Ore_Elbrium(){
        String myData = "";
        File myExternalFile = new File("/data/data/com.mygdx.game/Ore_Elbrium.txt");
        try {
            FileInputStream fis = new FileInputStream(myExternalFile);
            DataInputStream in = new DataInputStream(fis);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                real_ore_elbrium = Float.parseFloat(myData);
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return real_ore_elbrium;
    }
    public float get_Protection(){
        String myData = "";
        File myExternalFile = new File("/data/data/com.mygdx.game/Protection.txt");
        try {
            FileInputStream fis = new FileInputStream(myExternalFile);
            DataInputStream in = new DataInputStream(fis);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                real_protection = Float.parseFloat(myData);
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return real_protection;
    }
    public float get_Speed(){
        String myData = "";
        File myExternalFile = new File("/data/data/com.mygdx.game/Speed.txt");
        try {
            FileInputStream fis = new FileInputStream(myExternalFile);
            DataInputStream in = new DataInputStream(fis);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                real_speed = Float.parseFloat(myData);
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
        String myData = "";
        File myExternalFile = new File("/data/data/com.mygdx.game/CoefficientAttack.txt");
        try {
            FileInputStream fis = new FileInputStream(myExternalFile);
            DataInputStream in = new DataInputStream(fis);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
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
        String myData = "";
        File myExternalFile = new File("/data/data/com.mygdx.game/CoefficientProtection.txt");
        try {
            FileInputStream fis = new FileInputStream(myExternalFile);
            DataInputStream in = new DataInputStream(fis);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
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
        String myData = "";
        File myExternalFile = new File("/data/data/com.mygdx.game/CoefficientSpeed.txt");
        try {
            FileInputStream fis = new FileInputStream(myExternalFile);
            DataInputStream in = new DataInputStream(fis);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
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
    public void set_Coefficient_Attack(int c_attack){
        f_attack = c_attack;
        File file = new File("/data/data/com.mygdx.game/CoefficientAttack.txt");
        try {
            if (!file.exists()) file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.write(String.valueOf(f_attack));
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void set_Coefficient_Protection(int c_protection){
        f_protection = c_protection;
        File file = new File("/data/data/com.mygdx.game/CoefficientProtection.txt");
        try {
            if (!file.exists()) file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.write(String.valueOf(f_protection));
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void set_Coefficient_Speed(int c_speed){
        f_speed = c_speed;
        File file = new File("/data/data/com.mygdx.game/CoefficientSpeed.txt");
        try {
            if (!file.exists()) file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.write(String.valueOf(f_speed));
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
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
    public void set_Attack(float r_attack){
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
    public void set_Guardian_Money(float r_money){
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
    public void set_Health(float r_health){
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
    public void set_Maneuverability(float r_maneuverability){
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
    public void set_Ore_Elbrium(float r_ore_elbrium){
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
    public void set_Protection(float r_protection){
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
    public void set_Speed(float r_speed){
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

    public void add_elbrium(int e){
        set_Ore_Elbrium(get_Ore_Elbrium()+e);
        Gdx.app.log("GetterANDSetter","Elbrium upd: "+get_Ore_Elbrium());
    }
    public void set_online(String s){
        File file = new File("/data/data/com.mygdx.game/Online.txt");
        try {
            if (!file.exists()) file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.write(s);
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public String get_Online(){
        String myData = "";
        File myExternalFile = new File("/data/data/com.mygdx.game/Online.txt");
        try {
            FileInputStream fis = new FileInputStream(myExternalFile);
            DataInputStream in = new DataInputStream(fis);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
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

    public void set_StartChat(int c_startChat){
        File file = new File("/data/data/com.mygdx.game/StartChat.txt");
        try {
            if (!file.exists()) file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.write(String.valueOf(c_startChat));
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}