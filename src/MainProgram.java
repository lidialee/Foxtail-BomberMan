import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;
import java.util.List;

public class MainProgram extends PApplet {
    private ImageSetting imageSetting;
    private Block[][] map = new Block[Constant.WINDOW_ROW][Constant.WINDOW_COL];
    private List<Item> itemList = new ArrayList<>();
    private Player player1, player2;

    @Override
    public void settings() {
        this.size(800, 600);
    }

    @Override
    public void setup() {
        this.background(255);
        imageSetting = new ImageSetting(this);
        makeBarrierAndFloor();
        makeItemAndBreakable();
        settingPlayer();
    }

    @Override
    public void draw() {
        drawItems();
        drawBarrierAndFloor();
        drawPlayer();

    }

    public static void main(String[] args) {
        PApplet.main("MainProgram");
    }

    private void makeBarrierAndFloor() {
        for (int i = 0; i < Constant.WINDOW_ROW; i++) {
            for (int j = 0; j < Constant.WINDOW_COL; j++) {
                if (i == 0 || i == 14 | j == 0 | j == 19)
                    map[i][j] = new BarrierBlock(new Position(j, i), ImageSetting.getBarrier(), 2);
                else if (i % 2 == 0 && j % 4 == 0) {
                    map[i][j] = new BarrierBlock(new Position(j, i), ImageSetting.getBarrier(), 2);
                } else {
                    map[i][j] = new FloorBlcok(new Position(j, i), ImageSetting.getFloor(), 1);
                }
            }
        }
    }

    private void makeItemAndBreakable() {
        int count = 0;
        PImage img = null;

        while (count < 20) {
            int itemType = (int) (Math.random() * 3);
            int row = (int) (Math.random() * 15);
            int col = (int) (Math.random() * 20);

            if (row != 1 && col != 1 && row != 18 && col != 18) {
                if (map[row][col].getBlockType() != 2) {
                    switch (itemType) {
                        case 0:
                            img = ImageSetting.getItemList()[0];
                            break;
                        case 1:
                            img = ImageSetting.getItemList()[1];
                            break;
                        case 2:
                            img = ImageSetting.getItemList()[2];
                            break;
                    }
                    itemList.add(new Item(itemType, new Position(col, row), img));
                    map[row][col] = new BreakableBlock(new Position(col, row), ImageSetting.getBreakableBlockList()[0], 3);
                    count++;
                }
            }
        }
    }

    private void drawBarrierAndFloor() {
        for (int i = 0; i < Constant.WINDOW_ROW; i++) {
            for (int j = 0; j < Constant.WINDOW_COL; j++) {
                map[i][j].draw(this);
            }
        }
    }

    private void drawItems() {
        for (Item i : itemList) {
            i.draw(this);
        }
    }

    private void settingPlayer(){
        player1 = new Player(1,new Position(1*40,1*40),ImageSetting.getCharStayList(),ImageSetting.getMovementList());
        player2 = new Player(1,new Position(18*40,13*40),ImageSetting.getCharStayList(),ImageSetting.getMovementList());
    }

    private void drawPlayer(){
        player1.draw(this);
        player2.draw(this);
    }

    @Override
    public void keyPressed() {
        int keyInput = Character.toUpperCase(keyCode);

        switch (keyInput){
            case 'W':
                player1.moveUp();
                player1.setCharacterDirection(2);
                break;
            case 'S' :
                System.out.println("=");
                player1.moveDown();
                player1.setCharacterDirection(1);
                break;
            case 'D' :
                player1.moveRight();
                player1.setCharacterDirection(3);
                break;
            case 'A' :
                player1.moveLeft();
                player1.setCharacterDirection(4);
                break;
            case 'Q':
                player1.throwBomb();
                break;
            case UP:
                player2.moveUp();
                player2.setCharacterDirection(2);
                break;
            case DOWN:
                player2.moveDown();
                player2.setCharacterDirection(1);
                break;
            case RIGHT:
                player2.moveRight();
                player2.setCharacterDirection(3);
                break;
            case LEFT :
                player2.moveLeft();
                player2.setCharacterDirection(4);
                break;
            case ENTER:
                System.out.println("엔터");
                player2.throwBomb();
                break;
        }
    }
}
