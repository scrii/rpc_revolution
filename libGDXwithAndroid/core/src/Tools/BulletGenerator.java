package Tools;

import com.badlogic.gdx.Gdx;
import com.teamname.game.Actor.Bullet;
import com.teamname.game.Main;
import com.teamname.game.Screens.GameSc;

import java.util.Timer;
import java.util.TimerTask;

public class BulletGenerator {
    boolean isFire;
    boolean isTime=true;
    Timer timer;
    private static final int Sec=1;
    private int counter=Sec;
    private TimerTask task;

    public BulletGenerator(){
        timer=new Timer();
        task = new TimerTask() {
            @Override
            public void run() {
                if(counter==0){
                    isTime=true;
                    Gdx.app.error("isTime",isTime+"");
                }
                else counter--;
            }
        };
        timer.scheduleAtFixedRate(task,0,1000);
    }

    public void update(Joystick joy){
        isFire= joy.getDir().getX() != 0 || joy.getDir().getY() != 0;
        //Gdx.app.log("isFIRE",isFire+"");


        if(isFire && isTime) {
            Point2D point = new Point2D(GameSc.player.send_in_ONLINE.getX()-GameSc.player.R-GameSc.player.R/5-GameSc.player.R/5,GameSc.player.send_in_ONLINE.getY()-GameSc.player.R-GameSc.player.R/5-GameSc.player.R/5);
            GameSc.bullets.add(new Bullet(Main.actor, point, 7, GameSc.player.R/5, joy.getDir()));
            isTime=false;
            counter=Sec;

            Gdx.app.error("isTime",isTime+"");

        }
    }

    public void timeCheck(){
        isTime=false;

    }



}
