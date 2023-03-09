import javax.swing.*;
import java.awt.*;

public class Field extends JButton {

    private Player playerMark;
    private int positionX;
    private int positionY;

    public Field(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public Player getPlayerMark() {
        return playerMark;
    }

    public void setPlayerMark(Player playerMark) {
        this.playerMark = playerMark;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void reset(){playerMark = null; this.setText(null);}
    public void setWinColor(){this.setBackground(Color.GREEN);}
}
