package Tools;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.teamname.game.Actor.Player;
import com.teamname.game.Main;
import com.teamname.game.Screens.GameSc;

import java.util.Timer;
import java.util.TimerTask;


public class Joystick {
    Texture CircleImg, StickImg;
    public Circle CircleBounds, StickBounds;
    public float Rcircle, Rstick;
    private int pointer = -1;
    float length;
    float dx;
    float dy;
    static float Speed;
    Point2D CirclePos;
    Point2D StickPos;
    Point2D direction;
    float joyX,joyY;
    boolean isDownTouch,fireJoy;
    public boolean oreOverlaps=false;
    Point2D joyDirection=new Point2D(0,0);
    private static final int logOutSec=5;
    private int counter=logOutSec;
    Timer timer;
    float realSpeed=0;
    boolean rspeedN;
    int case_;


    // Size общий размер джойстика
    public Joystick(Texture cimg, Texture simg, Point2D point, float Size, int case_) {
        CircleImg = cimg;
        StickImg = simg;
        Rcircle = Size / 2;
        Rstick = Rcircle / 2;
        CircleBounds = new Circle(point, Rcircle);
        StickBounds = new Circle(point, Rstick);
        direction = new Point2D(0, 0);
        CirclePos=new Point2D(point.getX(),point.getY());
        StickPos=new Point2D(point.getX(),point.getY());
        Speed=GameSc.player.Speed;
        joyX=point.getX();
        joyY=point.getY();
        this.case_=case_;

        //if(case_==0)timeCheck();
        fireJoy=!(case_==0);
    }


    public void draw(SpriteBatch batch) {
        batch.draw(CircleImg, CircleBounds.pos.getX()-Rcircle, CircleBounds.pos.getY()-Rcircle, Rcircle * 2, Rcircle * 2);
        batch.draw(StickImg, StickBounds.pos.getX()-Rstick, StickBounds.pos.getY()-Rstick, Rstick * 2, Rstick * 2);
    }

    public void update(float x, float y, boolean isDownTouch, int pointer) {
        //при каких обстоятельствах вызываем atControl()
        Point2D touch = new Point2D(x, y);
        if(pointer==this.pointer) {
            dx = CircleBounds.pos.getX() - x;
            dy = CircleBounds.pos.getY() - y;
        }
        length = (float) Math.sqrt(dx * dx + dy * dy);

        //попали в окружность - ок
        if (CircleBounds.isContains(touch) && isDownTouch && this.pointer == -1) this.pointer = pointer;
        if (CircleBounds.Overlaps(StickBounds) && isDownTouch && pointer == this.pointer)
            atControl(new Point2D(x,y));
        if ((!isDownTouch && pointer == this.pointer)){returnStick();GameSc.player.isMove=false;
            //Gdx.app.log("PLAYER_MOVE", "FALSE");
        }
        //стик выходит за окружность
        // изменяется положение как стика, так и персонажа
        // полоучение позиции игрока, за исключением его поворота???
        if(!CircleBounds.isContains(StickBounds.pos)){
            StickBounds.pos.setX(-Rcircle/ length * dx +joyX);StickBounds.pos.setY(-Rcircle/ length * dy +joyY);
        }

    }

    //вызываем, когда палец попал в окружность джойстика
    //двигает стик по окружности, создает направление
    public void atControl(Point2D point) {
        StickBounds.pos.setPoint(point);
        GameSc.player.isMove=true;
        isDownTouch=true;
        counter=0;
        rspeedN=true;
        float coef = (float)Math.sqrt(Math.pow(StickBounds.pos.getX()-CircleBounds.pos.getX(),2)+Math.pow(StickBounds.pos.getY()-CircleBounds.pos.getY(),2));
        //if(case_!=1)Gdx.app.error("JOYSTICK","coef: "+Rcircle);
        if(case_!=1&&(GameSc.player.Speed * coef) / Rcircle<=GameSc.player.Speed) {
            GameSc.player.setRealSpeed((GameSc.player.Speed * coef) / Rcircle);
            // Gdx.app.error("realSPeed",GameSc.player.getRealSpeed()+"");}
        }
        //Gdx.app.log("PLAYER_MOVE", "TRUE");
        //узнаем разность x окружности и стика (дифферинциалы)
        float dx = CircleBounds.pos.getX() - point.getX();
        float dy = CircleBounds.pos.getY() - point.getY();
        float dist = (float) Math.sqrt(dx * dx + dy * dy);
        //Gdx.app.log("isDownTouch",isDownTouch+"");
        //ошибка division by zero (решено)
        if(dist!=0)direction.setPoint(-(dx / dist), -(dy / dist));
        else{direction.setPoint(0,0);}
        joyDirection=direction;


    }

    public void returnStick() {
        // возвращает стик к центру
        StickBounds.pos.setPoint(CircleBounds.pos);
        // задать velocity для плавного возвращения
        // когда пользователь отпускает стик, камере не передается информация
        if(fireJoy||!fireJoy)direction.setPoint(0,0);
        GameSc.player.setRealSpeed(0);
        //direction.setPoint(0, 0);
        isDownTouch=false;
        rspeedN=false;
        //GameSc.player.setRealSpeed(0);
        //Gdx.app.error("REALspeed",GameSc.player.getRealSpeed()+"");

        pointer = -1;
    }

    public Point2D getDir() {
        return direction;
    }



    public void timeCheck(){
        timer=new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                //Gdx.app.log("counter",counter+"");
                //if(counter==0)counter=logOutSec;

                if(isDownTouch&&GameSc.player.getRealSpeed()<Speed)
                    GameSc.player.changeSpeed(0.1f);
                else if(!isDownTouch&&GameSc.player.getRealSpeed()>0.7f)
                    GameSc.player.changeSpeed(-0.5f);
                else if(!isDownTouch&&GameSc.player.getRealSpeed()<=0.7f)
                    GameSc.player.setRealSpeed(0);
                Gdx.app.error("Joystick","realSpeed: "+GameSc.player.getRealSpeed());
            }
        };
        timer.scheduleAtFixedRate(task,0,100);
    }
}
