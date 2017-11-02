import processing.core.PApplet;
import processing.core.PImage;

public class ImageSetting {

    static private PImage barrier;
    static private PImage floor;
    static private PImage[] charStayList;
    static private PImage[] breakableBlockList;
    static private PImage[] effectList;
    static private PImage[] itemList;
    static private PImage[] movementList;

    public ImageSetting(PApplet pApplet) {
        PImage wholeStays = pApplet.loadImage("image_src/bomberman-stay.png");
        PImage wholeBlocks = pApplet.loadImage("image_src/bomberman-block.png");
        PImage wholeEffects = pApplet.loadImage("image_src/bomberman-effect.png");
        PImage wholeItems = pApplet.loadImage("image_src/bomberman-items.png");
        PImage wholeMovements = pApplet.loadImage("image_src/bomberman-movement.png");

        charStayList = new PImage[12];
        breakableBlockList = new PImage[3];
        effectList = new PImage[45];
        itemList = new PImage[3];
        movementList = new PImage[20];

        for(int i = 0;i<5;i++){
            for(int j =0 ;j<4;j++){
                movementList[j*5+i] = wholeMovements.get(21*i,32*j,20,32);
                movementList[j*5+i].resize(30,40);
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                charStayList[j * 3 + i] = wholeStays.get(20 * i, 32 * j, 20, 32);
                charStayList[j * 3 + i].resize(27,40);
            }
        }

        floor = wholeItems.get(0,24,24,24);              // floor
        floor.resize(40,40);

        barrier = wholeBlocks.get(0, 120 , 40, 40);      // breakable
        for(int i = 0;i<3;i++){
            breakableBlockList[i] = wholeBlocks.get(0*40, 0 , 40, 40);      // unbreakable
        }


        // 이동속도, 폭탄 증가, 화력 증가
        itemList[0] = wholeItems.get(48, 0, 24, 24);        // 폭탄 추가
        itemList[0].resize(40,40);

        itemList[1] = wholeItems.get(120,0, 24,24);         // 이동 속도 증가
        itemList[1].resize(40,40);

        itemList[2] = wholeItems.get(0,0,24,24);            // 화력 증가
        itemList[2].resize(40,40);


        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 5; j++) {
                effectList[j * 9 + i] = wholeEffects.get(24 * i, 24 * j, 24, 24);
            }
        }
    }

    public static PImage getBarrier() {
        return barrier;
    }

    public static PImage getFloor() {
        return floor;
    }

    public static PImage[] getCharStayList() {
        return charStayList;
    }

    public static PImage[] getBreakableBlockList() {
        return breakableBlockList;
    }

    public static PImage[] getEffectList() {
        return effectList;
    }

    public static PImage[] getItemList() {
        return itemList;
    }

    public static PImage[] getMovementList() {
        return movementList;
    }
}
