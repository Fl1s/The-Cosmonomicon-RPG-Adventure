package object;

import main.GamePanel;

import javax.imageio.ImageIO;

public class OBJ_Boots extends SuperObject{
    GamePanel gp;
    public OBJ_Boots(GamePanel gp) {
        this.gp = gp;

        name = "Boots";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/traveller_boots.png"));
            uTool.scaleImage(image,gp.tileSize,gp.tileSize);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
