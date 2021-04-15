package Tools;

import com.teamname.game.Actor.Bullet;
import com.teamname.game.Main;
import com.teamname.game.Screens.GameSc;

public class BulletGenerator {
    boolean isFire;

    public void update(Joystick joy){
        isFire=(joy.getDir().getX()==0&&joy.getDir().getY()==0)?false:true;

        if(isFire) GameSc.bullets.add(new Bullet(Main.actor,GameSc.player.position,5,GameSc.player.R,joy.getDir()));
    }
}
