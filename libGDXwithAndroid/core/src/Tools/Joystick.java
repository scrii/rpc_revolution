package Tools;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.teamname.game.Actor.Player;
import com.teamname.game.Main;
import com.teamname.game.Screens.GameSc;


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
    Point2D joyDirection=new Point2D(0,0);

    // Size общий размер джойстика
    public Joystick(Texture cimg, Texture simg, Point2D point, float Size) {
        CircleImg = cimg;
        StickImg = simg;
        Rcircle = Size / 2;
        Rstick = Rcircle / 2;
        CircleBounds = new Circle(point, Rcircle);
        StickBounds = new Circle(point, Rstick);
        direction = new Point2D(0, 0);
        CirclePos=new Point2D(point.getX(),point.getY());
        StickPos=new Point2D(GameSc.getJoyX(),GameSc.getJoyY());
        Speed=GameSc.player.Speed;
    }


    public void draw(SpriteBatch batch) {
        // !!! реализовать нормальное следование джойстика за персонажем
        //CircleBounds.add(GameSc.player.direction.getX(),GameSc.player.direction.getY());
        //StickBounds.add(GameSc.player.X,GameSc.player.Y);
        //CircleBounds.add();
        //StickBounds.add();
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
        if ((!isDownTouch && pointer == this.pointer))returnStick();
        //стик выходит за окружность
        // изменяется положение как стика, так и персонажа
        // полоучение позиции игрока, за исключением его поворота???
        if(!CircleBounds.isContains(StickBounds.pos)){
            StickBounds.pos.setX(-Rcircle/ length * dx +GameSc.getJoyX());StickBounds.pos.setY(-Rcircle/ length * dy +GameSc.getJoyY());
        }

    }

    //вызываем, когда палец попал в окружность джойстика
    //двигает стик по окружности, создает направление
    public void atControl(Point2D point) {
        StickBounds.pos.setPoint(point);
        //узнаем разность x окружности и стика (дифферинциалы)
        float dx = CircleBounds.pos.getX() - point.getX();
        float dy = CircleBounds.pos.getY() - point.getY();
        float dist = (float) Math.sqrt(dx * dx + dy * dy);

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
        direction.setPoint(0, 0);

        pointer = -1;
    }

    public Point2D getDir() {
        return direction;
    }
}
