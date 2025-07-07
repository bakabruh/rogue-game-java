package entity;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
    public int playerX, playerY;
    public int speed;
    public BufferedImage right, left, up, down;
    public String direction;

    public int spriteCounter = 0;
    public int spriteNum = 1;
    public Rectangle solidArea;
    public boolean collisionOn = false;
}
