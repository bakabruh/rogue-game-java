package main;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    // SCREEN SETTINGS
    final int originalTileSize = 16;
    final int scale = 3;

    final int tileSize = originalTileSize * scale;
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;

    int FPS = 60;

    Thread gameThread;
    KeyHandler keyHandler = new KeyHandler();

    // Set player's default position
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000/FPS;
        double newDrawTime = System.nanoTime() + drawInterval;

        while(gameThread != null) {
            update();
            repaint();

            try {
                double remainingDrawTime = newDrawTime - System.nanoTime();
                remainingDrawTime = remainingDrawTime / 1000000;

                if(remainingDrawTime < 0) {
                    remainingDrawTime = 0;
                }

                Thread.sleep((long)remainingDrawTime);

                newDrawTime += drawInterval;
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void update() {
        if(keyHandler.upPressed) {
            playerY -= playerSpeed;
        }
        if(keyHandler.downPressed) {
            playerY += playerSpeed;
        }
        if(keyHandler.leftPressed) {
            playerX -= playerSpeed;
        }
        if(keyHandler.rightPressed) {
            playerX += playerSpeed;
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.white);
        g2.fillRect(playerX, playerY, tileSize, tileSize);
        g2.dispose();
    }
}
