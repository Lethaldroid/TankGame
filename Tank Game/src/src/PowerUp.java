package src;
import java.awt.*;
import java.awt.image.BufferedImage;

public class PowerUp extends GameObject {
    boolean isHealthBoost = false;
    boolean isSpeedBoost = false;
    boolean isaddLife = false;
    boolean isActive = true;
    static private BufferedImage health_img;
    static private BufferedImage healthrefill_img;
    static private BufferedImage speed_img;

    public PowerUp(int x, int y, boolean isHealth, boolean isSpeed,boolean isaddLife)
    {
        this.x = x;
        this.y = y;
        this.my_rectangle = new Rectangle(x, y, 40, 40);
        this.isHealthBoost = isHealth;
        this.isSpeedBoost = isSpeed;
        this.isaddLife = isaddLife;
    }
    static void setHealth_img(BufferedImage img)
    {
        PowerUp.health_img = img;
    }
    static void setHealthrefill_img(BufferedImage img)
    {
        PowerUp.healthrefill_img = img;
    }

    public static void setSpeed_img(BufferedImage speed_img) {
        PowerUp.speed_img = speed_img;
    }

    public void update() {

    }

    public void drawImage(Graphics2D g) {
        if(this.isHealthBoost){
            g.drawImage(health_img, x,y, 40,40 , null);
        }
        if(this.isSpeedBoost){
            g.drawImage(speed_img, x,y, 40,40 , null);
        }
        if(this.isaddLife)
        {
            g.drawImage(healthrefill_img, x,y, 40,40 , null);
        }
    }

    public void collision() { //this is only called during a collision with a tank
        this.isActive = false;  //when the Power Up is picked up, we simply mark it as inActive, so we can later remove it in the next iteration within main.
    }
}