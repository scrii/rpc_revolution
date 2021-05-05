package Constants;

import com.teamname.game.Main;
import com.teamname.game.Screens.GameSc;

public class Constants {
    public Player player;
    public Joystick joystick;

    public Constants(int case_){
        // 0 - GameSc
        onCreate();
    }

    private void onCreate(){
        player=new Player();
        joystick=new Joystick();
    }

    static class Player{


        public Player(){


        }

        Constants c;

        public static final int R = Main.HEIGHT/20;
        public static final int x=Main.BACKGROUND_WIDTH/2;
        public static final int y=Main.BACKGROUND_HEIGHT/2;
        //public static final float x=Main.WIDTH/2-R;
       // public static final float y=Main.HEIGHT/2-R;
    }

    static class Joystick{
        public Joystick(){}

        public static final int joyX=(Main.HEIGHT/3)/2+(Main.HEIGHT/3)/4;
        public static final int joyY=(Main.HEIGHT/3)/2+(Main.HEIGHT/3)/4;
        public static final int joySize = Main.HEIGHT/3;
        public static final int logOutSec=5;
    }






}
