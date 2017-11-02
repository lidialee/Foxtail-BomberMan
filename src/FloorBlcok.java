import processing.core.PApplet;
import processing.core.PImage;

public class FloorBlcok  extends  Block{
    FloorBlcok(Position p, PImage img, int blockType) {
        super(p, img,blockType);
    }

    @Override
    void draw(PApplet pApplet) {
        pApplet.image(getImage(),getPosition().getX()*40,getPosition().getY()*40);
    }

    @Override
    float isCollsion(Position p) {
        return 0;
    }
}
