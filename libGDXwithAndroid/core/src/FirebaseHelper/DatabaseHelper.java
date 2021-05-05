package FirebaseHelper;

import com.badlogic.gdx.Gdx;
import com.google.gson.Gson;


import Tools.GetterANDSetterFile;
//<!!!---> import de.tomgrill.gdxfirebase.core.GDXFirebase;
//import de.tomgrill.gdxfirebase.core.database.DatabaseReference;
//<!!!---> import de.tomgrill.gdxfirebase.core.auth.OnCompleteListener;
//<!!!---> import de.tomgrill.gdxfirebase.core.auth.Task;
import pl.mk5.gdx.fireapp.GdxFIRApp;
import pl.mk5.gdx.fireapp.GdxFIRDatabase;
import pl.mk5.gdx.fireapp.functional.Consumer;

public class DatabaseHelper {

    String nickname;
    String send = "default";
    private Gson gson;
    String s;
    GetterANDSetterFile getter_setter;
    private String valueOf_online = "NONE";
    public boolean bool_tnp_read_online=false;
    //DatabaseReference reference = GDXFirebase.FirebaseDatabase().getReference("storetest");
    //String key = reference.push().getKey();
    //reference.child(key).setValue("some value");

    public DatabaseHelper() {
        gson = new Gson();
        getter_setter = new GetterANDSetterFile();
    }

    public void sendToFirebase(String heading, String msg) {
        GdxFIRDatabase.instance().inReference(heading).setValue(msg);
    }

    public void init() {
        GdxFIRApp.inst().configure();
    }

    public void removeFromFirebase(String reference) {
        GdxFIRDatabase.instance().inReference(reference).removeValue();
    }

    public void entryNotify() {
        //acceptString("online");
        if (s.length() > 0) sendToFirebase("online", s + ";" + getter_setter.get_Nickname());
        else sendToFirebase("online", getter_setter.get_Nickname());
    }

    public void addField(String reference, String field) {
        GdxFIRDatabase.instance().inReference(reference).push().setValue(field);
    }

    public void changeFieldValue(String reference, String field, String value) {
        GdxFIRDatabase.instance().inReference(reference).inReference(field).setValue(value);
    }

    public void playerDataUpdate(String nickname, Message msg) {
        GdxFIRDatabase.instance().inReference(nickname).push().setValue(msg);
    }


    public void collectPlayer(String ref) {
        GdxFIRDatabase.instance().inReference(ref).readValue(Message.class).then(new Consumer<Message>() {
            @Override
            public void accept(Message message) {
                logger(message);
            }
        });
    }

    public void logger(Message message) {
        Gdx.app.log("TAGG", message.x + "");
    }




        //GDXFirebase.FirebaseDatabase().getReference("email").child("coordinats_y").setValue(y+"");
        /*GdxFIRDatabase.instance().inReference("email").inReference("y").setValue(x);
        GdxFIRDatabase.instance().inReference("email").inReference("y").setValue(y);*/


    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void updateValues(String reference, Message msg) {
        GdxFIRDatabase.instance().inReference(reference).setValue(msg);
    }
    // <!-- -->
    /*public Message readValue(){
        GdxFIRDatabase.instance().inReference()
    }*/

    //public Point2D getPosition()


    public void readString(int case_) {

        // 0 - отправляет никнейм в reference online
        // 1 - удалить из поля online, закрыть приложение
        // 2 - прочитать поле online. требуется вызов метода getvalueOf_online

        switch (case_) {
            case 0:
                GdxFIRDatabase.instance().inReference("online").readValue(String.class).then(new Consumer<String>() {
                    @Override
                    public void accept(String s) {
                        tmp_online(s);
                        bool_tnp_read_online=true;
                    }
                });
                break;

            case 1:
                GdxFIRDatabase.instance().inReference("online").readValue(String.class).then(new Consumer<String>() {
                    @Override
                    public void accept(String s) {
                        tmp_delete_from_online(s);
                    }
                });
                break;

            case 2:
                GdxFIRDatabase.instance().inReference("online").readValue(String.class).then(new Consumer<String>() {
                    @Override
                    public void accept(String s) {
                        tmp_read_online(s);
                    }
                });
                break;
        }

    }

   public void getP(){
        readString(2);
        //while(!bool_tnp_read_online)Gdx.app.debug("DBHelper","waiting...");
        Gdx.app.error("DBHelper","accepted");
   }

    private void tmp_read_online(String s) {
        valueOf_online = s;
        bool_tnp_read_online=true;
        Gdx.app.error("DBHelper", "valueOf_online updated");

    }

    public String getValueOf_online() {
        return valueOf_online;
    }

    private void tmp_online(String s) {
        if (s == null) sendToFirebase("online", getter_setter.get_Nickname() + ";");
        else if (!s.contains(getter_setter.get_Nickname()))
            sendToFirebase("online", s + getter_setter.get_Nickname() + ";");
    }

    private void tmp_delete_from_online(String s) {
        if (s != null & s.contains(getter_setter.get_Nickname()))
            sendToFirebase("online", s.replace(getter_setter.get_Nickname() + ";", ""));
        Gdx.app.log("Game_manager", "GAME STOPED");
        Gdx.app.exit();
    }


    public Message toMessage(String s) {
        return gson.fromJson("{" + s, Message.class);
    }

    public void setMetadata(String s) {
        this.s = s;
    }

    public void createPlayer() {
        //GdxFIRDatabase.instance().inReference(getter_setter.get_Nickname()).setValue(new Message(getter_setter.get_Nickname(), 0, 0, getter_setter.get_Guardian_Money(), getter_setter.get_Ore_Elbrium(), getter_setter.get_Speed(), getter_setter.get_Attack(), getter_setter.get_Health(), getter_setter.get_Health(), "back", "front").toString());
    }

    public String stringReturn(String s) {
        return s;
    }

    public void logOut() {
        readString(1);
    }

    public void test(){
        //GdxFIRDatabase.instance().inReference(getter_setter.get_Nickname()).onConnect().thenListener()
    }
    //GDXFirebase.FirebaseDatabase().getReference(reference).addValueEventListener(vListener);
    //Gdx.app.log("READED_PL_DATA",GdxFIRDatabase.instance().inReference(reference).readValue(Message.class).toString());
}


