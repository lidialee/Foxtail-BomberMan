import processing.core.PApplet;
import processing.core.PImage;

public class Player{
    private int characterDirection;         // 1 = down  2 = up  3 = right  4 = left
    private Position position;
    private PImage[] stayImageList;
    private PImage[] movementList;
    private int count = 0;

    public Player(int characterState, Position position, PImage[] stayList,PImage[] moveList) {
        this.characterDirection = characterState;
        this.position = position;
        this.stayImageList = stayList;
        this.movementList = moveList;
    }

    public void draw(PApplet pApplet) {
        count++;
        switch (characterDirection){
            case 1:
                //pApplet.image(stayImageList[count/10%3], position.getX(), position.getY());
                pApplet.image(movementList[count/10%5], position.getX(), position.getY());      //  down
                break;
            case 2:
                //pApplet.image(stayImageList[count/10%3+6], position.getX(), position.getY());
                pApplet.image(movementList[count/10%5+10], position.getX(), position.getY());   // up
                break;
            case 3:
                //pApplet.image(stayImageList[count/10%3+3], position.getX(), position.getY());
                pApplet.image(movementList[count/10%5+5], position.getX(), position.getY());    // right
                break;
            case 4:
                //pApplet.image(stayImageList[count/10%3+9], position.getX(), position.getY());
                pApplet.image(movementList[count/10%5+15], position.getX(), position.getY());       // left
                break;
        }

    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }


    public int getCharacterDirection() {
        return characterDirection;
    }

    public void setCharacterDirection(int characterDirection) {
        this.characterDirection = characterDirection;
    }

    public void moveUp(){
        position.setY(position.getY() - Constant.STEP);
    }

    public void moveDown() { position.setY(position.getY() + Constant.STEP); }

    public void moveRight() { position.setX(position.getX() + Constant.STEP); }

    public void moveLeft() {
        position.setX(position.getX() - Constant.STEP);
    }

    public void throwBomb(){ }


}
