package Tools;

import com.badlogic.gdx.Gdx;
import com.teamname.game.Actor.Bullet;
import com.teamname.game.Main;
import com.teamname.game.Screens.GameSc;

public class BulletGenerator {
    boolean isFire;

    public void update(Joystick joy){
        isFire= joy.getDir().getX() != 0 || joy.getDir().getY() != 0;
        //Gdx.app.log("isFIRE",isFire+"");

        if(isFire) {
            GameSc.bullets.add(new Bullet(Main.actor, GameSc.player.send_in_ONLINE, 7, GameSc.player.R/3, joy.getDir()));
            //Gdx.app.log("Bullets_m",GameSc.bullets.toString());
        }
    }
}
