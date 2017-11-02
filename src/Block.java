import processing.core.PApplet;
import processing.core.PImage;

public abstract class Block {
    private int blockType;          // 1 = floor  2 = barrier  3 = breakable
    private PImage img;
    private Position position;

    Block(Position p, PImage img,int blockType) {
        this.blockType = blockType;
        this.position = p;
        this.img = img;
    }

    abstract void draw(PApplet pApplet);
    abstract float isCollsion(Position p);

    public int getBlockType() {
        return blockType;
    }

    public void setBlockType(int blockType) {
        this.blockType = blockType;
    }

    public PImage getImage() {
        return img;
    }

    public void setImage(PImage img) {
        this.img = img;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
