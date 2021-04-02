package Online;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import pl.mk5.gdx.fireapp.GdxFIRDatabase;

public class DatabaseHelper {

    String nickname;
    Map<String,Object> map;

    public DatabaseHelper(){
        map=new Map<String, Object>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean containsKey(Object o) {
                return false;
            }

            @Override
            public boolean containsValue(Object o) {
                return false;
            }

            @Override
            public Object get(Object o) {
                return null;
            }

            @Override
            public Object put(String s, Object o) {
                return null;
            }

            @Override
            public Object remove(Object o) {
                return null;
            }

            @Override
            public void putAll(Map<? extends String, ?> map) {

            }

            @Override
            public void clear() {

            }

            @Override
            public Set<String> keySet() {
                return null;
            }

            @Override
            public Collection<Object> values() {
                return null;
            }

            @Override
            public Set<Entry<String, Object>> entrySet() {
                return null;
            }
        };
        map.put("x",12);
        //map.put("y",323);
    }

    public void sendToFirebase(String heading, String msg){
        GdxFIRDatabase.instance().inReference(heading).push().setValue(msg);
    }

    public void removeFromFirebase(String reference){
        GdxFIRDatabase.instance().inReference(reference).removeValue();
    }

    public void entryNotify(int roomNumber){
        sendToFirebase("room"+roomNumber+"_"+nickname,"Connected");
    }

    public void addField(String reference, String field){
        GdxFIRDatabase.instance().inReference(reference).push().setValue(field);
    }

    public void changeFieldValue(String reference,String field, String value){
        GdxFIRDatabase.instance().inReference(reference).inReference(field).setValue(value);
    }

    public void playerInitialization(){
        //entryNotify();
        //addField();
    }

    public void changeMapValues(float x, float y){
        map.clear();
        map.put("coordinats_x",x);
        //map.put("coordinats_y",y);
    }



    public void sendCoords(String email){
        GdxFIRDatabase.instance().inReference(email).push().updateChildren(map);
        /*GdxFIRDatabase.instance().inReference("email").inReference("y").setValue(x);
        GdxFIRDatabase.instance().inReference("email").inReference("y").setValue(y);*/
    }

    public void setNickname(String nickname){
        this.nickname=nickname;
    }

}
