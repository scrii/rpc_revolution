package Tools;

import com.badlogic.gdx.Gdx;
import com.teamname.game.Actor.Elbrium;
import com.teamname.game.Main;
import com.teamname.game.Screens.GameSc;

import java.awt.Point;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Spawner extends TimerTask {
    private int rank;
    public Spawner(){
    }

    @Override
    public void run() {
        spawnOre();
    }

    public void start(){
        TimerTask timerTask = new Spawner();
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(timerTask, 0, 30*1000);
        //timer.scheduleAtFixedRate(timerTask, 0, 3*60*1000);
    }

    private void spawnOre() {
        rank= +(int) (Math.random() * 3);
        Elbrium elbrium = new Elbrium(Main.actor,new Point2D((float)Math.random()*Main.BACKGROUND_WIDTH/1.3f,
                (float)Math.random()*Main.BACKGROUND_HEIGHT/1.3f),rank);
        GameSc.ore.add(elbrium);
        Gdx.app.log("TIMER","ore spawned");
    }

    public void setRank(int rank){
        this.rank=rank;
    }

    public void deleteOre(){

    }




}
