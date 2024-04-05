package entity;

import main.GamePanel;

import java.util.Random;


public class NPC_Merchant extends Entity {
    public NPC_Merchant(GamePanel gp) {
        super(gp);
        direction = "down";
        speed = 1;

        getImage();
    }

    public void getImage() {
        up1 = setup("/npc/merchant_move_up1");
        up2 = setup("/npc/merchant_move_up2");
        down1 = setup("/npc/merchant_move_down1");
        down2 = setup("/npc/merchant_move_down2");
        left1 = setup("/npc/merchant_move_left");
        left2 = setup("/npc/merchant_idle_left");
        right1 = setup("/npc/merchant_move_right");
        right2 = setup("/npc/merchant_idle_right");

        idleUp = setup("/npc/merchant_idle_up");
        idleDown = setup("/npc/merchant_idle_down");
        idleLeft = setup("/npc/merchant_idle_left");
        idleRight = setup("/npc/merchant_idle_right");

    }
    public void setAction(){
        actionLockCounter ++;

        if (actionLockCounter == 120){
            Random random = new Random();
            int i = random.nextInt(100)+1;
            if (i <= 25){
                direction = "up";
            }
            if (i > 25 && i <= 50){
                direction = "down";
            }
            if (i > 50 && i <= 75){
                direction = "left";
            }
            if (i > 75 && i <= 100){
                direction = "right";
            }
            actionLockCounter = 0;
        }
    }

}
