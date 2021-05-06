package Online;


import com.teamname.game.Actor.Player;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import Tools.Point2D;


public class PlayerDataCreator {
    float x;
    float y;
    String color_front = "red", color_background = "blue";
    String nickname,text_message;
    int protect,health,attack,speed;
    float elbrium,gold;
    Message sendToFirebase;

    DatabaseHelper databaseHelper;



    public PlayerDataCreator(){
        x=0;
        y=0;
        read();
        databaseHelper=new DatabaseHelper();
        sendToFirebase = new Message(text_message,nickname,x,y,gold,elbrium,speed,attack,health,protect,color_background,color_front);


    }

    public void update(Point2D pos){
        ///read();
        sendToFirebase.x=pos.getX();
        sendToFirebase.y=pos.getY();
        databaseHelper.updateValues(nickname,sendToFirebase);
    }

    public Message getMessage(){
        return sendToFirebase;
    }

    public void setCoords(Point2D pos){
        x=pos.getX();
        y=pos.getY();
    }

    public void read(){
        String myData1 = "";
        File myExternalFile1 = new File("/data/data/com.mygdx.game/Protection.txt");
        try {
            FileInputStream fis1 = new FileInputStream(myExternalFile1);
            DataInputStream in1 = new DataInputStream(fis1);
            BufferedReader br1 = new BufferedReader(new InputStreamReader(in1));
            String strLine1;
            while ((strLine1 = br1.readLine()) != null) {
                myData1 = myData1 + strLine1;
                protect = Integer.parseInt(myData1);
            }
            br1.close();in1.close();fis1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //=====================================================================
        String myData2 = "";
        File myExternalFile2 = new File("/data/data/com.mygdx.game/Health.txt");
        try {
            FileInputStream fis2 = new FileInputStream(myExternalFile2);
            DataInputStream in2 = new DataInputStream(fis2);
            BufferedReader br2 = new BufferedReader(new InputStreamReader(in2));
            String strLine2;
            while ((strLine2 = br2.readLine()) != null) {
                myData2 = myData2 + strLine2;
                health = Integer.parseInt(myData2);
            }
            br2.close();in2.close();fis2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //=====================================================================
        String myData3 = "";
        File myExternalFile3 = new File("/data/data/com.mygdx.game/Attack.txt");
        try {
            FileInputStream fis3 = new FileInputStream(myExternalFile3);
            DataInputStream in3 = new DataInputStream(fis3);
            BufferedReader br3 = new BufferedReader(new InputStreamReader(in3));
            String strLine3;
            while ((strLine3 = br3.readLine()) != null) {
                myData3 = myData3 + strLine3;
                attack = Integer.parseInt(myData3);
            }
            br3.close();in3.close();fis3.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //=====================================================================
        String myData4 = "";
        File myExternalFile4 = new File("/data/data/com.mygdx.game/Speed.txt");
        try {
            FileInputStream fis4 = new FileInputStream(myExternalFile4);
            DataInputStream in4 = new DataInputStream(fis4);
            BufferedReader br4 = new BufferedReader(new InputStreamReader(in4));
            String strLine4;
            while ((strLine4 = br4.readLine()) != null) {
                myData4 = myData4 + strLine4;
                speed = Integer.parseInt(myData4);
            }
            br4.close();in4.close();fis4.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //=======================================================================
        String myData5 = "";
        File myExternalFile5 = new File("/data/data/com.mygdx.game/guardian_money.txt");
        try {
            FileInputStream fis5 = new FileInputStream(myExternalFile5);
            DataInputStream in5 = new DataInputStream(fis5);
            BufferedReader br5 = new BufferedReader(new InputStreamReader(in5));
            String strLine5;
            while ((strLine5 = br5.readLine()) != null) {
                myData5 = myData5 + strLine5;
                gold = Integer.parseInt(myData5);
            }
            br5.close();in5.close();fis5.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //=======================================================================
        String myData6 = "";
        File myExternalFile6 = new File("/data/data/com.mygdx.game/Ore_Elbrium.txt");
        try {
            FileInputStream fis6 = new FileInputStream(myExternalFile6);
            DataInputStream in6 = new DataInputStream(fis6);
            BufferedReader br6 = new BufferedReader(new InputStreamReader(in6));
            String strLine6;
            while ((strLine6 = br6.readLine()) != null) {
                myData6 = myData6 + strLine6;
                elbrium = Integer.parseInt(myData6);
            }
            br6.close();in6.close();fis6.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //=======================================================================
        String myData36 = "";
        File myExternalFile36 = new File("/data/data/com.mygdx.game/nickname.txt");
        try {
            FileInputStream fis36 = new FileInputStream(myExternalFile36);
            DataInputStream in36 = new DataInputStream(fis36);
            BufferedReader br36 = new BufferedReader(new InputStreamReader(in36));

            String strLine36;
            while ((strLine36 = br36.readLine()) != null) {
                myData36 = myData36 + strLine36;
                nickname = myData36;
            }
            br36.close();
            in36.close();
            fis36.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //========================================================================
        String myData = "";
        File myExternalFile = new File("/data/data/com.mygdx.game/Message.txt");
        try {
            FileInputStream fis = new FileInputStream(myExternalFile);
            DataInputStream in = new DataInputStream(fis);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            String strLine;
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                text_message = myData;
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
