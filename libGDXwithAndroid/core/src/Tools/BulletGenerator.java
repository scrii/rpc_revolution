package Tools;

import com.badlogic.gdx.Gdx;
import com.teamname.game.Actor.Bullet;
import com.teamname.game.Main;
import com.teamname.game.Screens.GameSc;

import java.util.Timer;
import java.util.TimerTask;

public class BulletGenerator extends TimerTask {
    boolean isFire;
    boolean isTime=true;

    public void update(Joystick joy){
        isFire= joy.getDir().getX() != 0 || joy.getDir().getY() != 0;
        //Gdx.app.log("isFIRE",isFire+"");


        if(isFire && isTime) {
            Point2D point = new Point2D(GameSc.player.send_in_ONLINE.getX()-GameSc.player.R-GameSc.player.R/5-GameSc.player.R/5,GameSc.player.send_in_ONLINE.getY()-GameSc.player.R-GameSc.player.R/5-GameSc.player.R/5);
            GameSc.bullets.add(new Bullet(Main.actor, point, 7, GameSc.player.R/5, joy.getDir()));
            isTime=false;
            TimerTask timerTask = new BulletGenerator();
            Timer timer = new Timer(true);
            timer.scheduleAtFixedRate(timerTask, 0, 1000);

        }
    }


    @Override
    public void run() {
        isTime=true;
    }
}
