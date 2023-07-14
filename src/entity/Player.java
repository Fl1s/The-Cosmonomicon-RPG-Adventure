package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity {
    GamePanel gp;
    KeyHandler keyH;

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/Player_Up1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/Player_Up2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/Player_Down1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/Player_Down2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/Player_Left1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/Player_Left2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/Player_Right1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/Player_Right2.png"));
            idleUp = ImageIO.read(getClass().getResourceAsStream("/player/Player_Idle_Up.png"));
            idleDown = ImageIO.read(getClass().getResourceAsStream("/player/Player_Idle_Down.png"));
            idleLeft = ImageIO.read(getClass().getResourceAsStream("/player/Player_Idle_Left.png"));
            idleRight = ImageIO.read(getClass().getResourceAsStream("/player/Player_Idle_Right.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void update() {
        if (keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true){
            if (keyH.upPressed) {
                direction = "up";
                y -= speed;
            } else if (keyH.downPressed) {
                direction = "down";
                y += speed;
            } else if (keyH.leftPressed) {
                direction = "left";
                x -= speed;
            } else if (keyH.rightPressed) {
                direction = "right";
                x += speed;
            }

            spriteCounter++;
            if (spriteCounter > 12) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 3;
                } else if (spriteNum == 3){
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
        else if (!keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true){
            spriteNum = 1;
        }

    }

    public void draw(Graphics2D g2) {
//        g2.setColor(Color.white);
//        g2.fillRect(x, y, gp.tileSize, gp.tileSize);

        BufferedImage image = null;

        switch (direction) {
            case "up":
                if (spriteNum == 1) {
                    image = idleUp;
                }
                if (spriteNum == 2) {
                    image = up1;
                }
                if (spriteNum == 3){
                    image = up2;
                }
                break;
            case "down":
                if (spriteNum == 1) {
                    image = idleDown;
                }
                if (spriteNum == 2) {
                    image = down1;
                }
                if (spriteNum == 3){
                    image = down2;
                }
                break;
            case "left":
                if (spriteNum == 1) {
                    image = idleLeft;
                }
                if (spriteNum == 2) {
                    image = left1;
                }
                if (spriteNum == 3){
                    image = left2;
                }
                break;
            case "right":
                if (spriteNum == 1) {
                    image = idleRight;
                }
                if (spriteNum == 2){
                    image = right1;
                }
                if (spriteNum == 3) {
                    image = right2;
                }
                break;
        }
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
}