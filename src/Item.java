import processing.core.PApplet;
import processing.core.PImage;

public class Item {
    private int itemType;
    private Position position;
    private PImage image;

    public Item(int itemType,Position position, PImage image) {
        this.itemType = itemType;
        this.position = position;
        this.image = image;
    }

    public void draw(PApplet pApplet){
        pApplet.image(this.image,position.getX()*40,position.getY()*40);
    }


    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public PImage getImage() {
        return image;
    }

    public void setImage(PImage image) {
        this.image = image;
    }
}
