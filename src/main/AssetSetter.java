package main;

import object.ChestObject;
import object.KeyObject;

public class AssetSetter {

    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {
        gp.objects[0] = new KeyObject();
        gp.objects[0].worldX = gp.tileSize * 23;
        gp.objects[0].worldY = gp.tileSize * 25;

        gp.objects[1] = new ChestObject();
        gp.objects[1].worldX = gp.tileSize * 23;
        gp.objects[1].worldY = gp.tileSize * 20;
    }
}
