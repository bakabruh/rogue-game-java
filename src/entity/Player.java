package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity {
    GamePanel gp;
    KeyHandler kh;

    public Player(GamePanel gp, KeyHandler kh) {
        this.gp = gp;
        this.kh = kh;

        setDefaultValues();
        getPlayerSprite();
    }

    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 4;
        direction = "right";
    }

    public void getPlayerSprite() {
        try {
            right = ImageIO.read(getClass().getResourceAsStream("/player/right.png"));
            left = ImageIO.read(getClass().getResourceAsStream("/player/left.png"));
            up = ImageIO.read(getClass().getResourceAsStream("/player/up.png"));
            down = ImageIO.read(getClass().getResourceAsStream("/player/down.png"));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        if(kh.upPressed) {
            direction = "up";
            y -= speed;
        }
        if(kh.downPressed) {
            direction = "down";
            y += speed;
        }
        if(kh.leftPressed) {
            direction = "left";
            x -= speed;
        }
        if(kh.rightPressed) {
            direction = "right";
            x += speed;
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;

        switch (direction) {
            case "right":
                image = right;
                break;
            case "left":
                image = left;
                break;
            case "up":
                image = up;
                break;
            case "down":
                image = down;
                break;
        }

        g2.drawImage(image, x, y, gp.tileSize,  gp.tileSize, null);
    }
}
