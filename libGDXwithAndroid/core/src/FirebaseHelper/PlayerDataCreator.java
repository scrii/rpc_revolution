package FirebaseHelper;


import Tools.GetterANDSetterFile;
import Tools.Point2D;


public class PlayerDataCreator {
    float x;
    float y;
    String color_front = "red", color_background = "blue";
    String nickname,text_message;
    double protect,health,attack,speed;
    double elbrium,gold;
    Message sendToFirebase;
    GetterANDSetterFile getter_setter;

    FirebaseHelper.DatabaseHelper databaseHelper;



    public PlayerDataCreator(){
        x=0;
        y=0;
        getter_setter = new GetterANDSetterFile();
        //read();

        databaseHelper=new DatabaseHelper();
        //sendToFirebase = new Message(nickname,x,y,gold,elbrium,speed,attack,health,protect,color_background,color_front);



    }

    public void update(Point2D pos){
        ///read();
        sendToFirebase.x=pos.getX()-100;
        sendToFirebase.y=pos.getY()-100;
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
        getter_setter.get_Protection();
        health=getter_setter.get_Health();
        attack=getter_setter.get_Attack();
        speed=getter_setter.get_Speed();
        gold=getter_setter.get_Guardian_Money();
        elbrium=getter_setter.get_Ore_Elbrium();
        nickname=getter_setter.get_Nickname();
        text_message=getter_setter.get_Message();
    }
}
