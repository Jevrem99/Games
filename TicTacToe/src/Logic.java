import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Logic {

    private Graphics graphics;
    private Player currentPlayer;

    public Logic() {
        graphics = new Graphics();
        currentPlayer = Player.X;
        setFieldActions();
        setResetButtonAction();
    }

    private void setFieldActions()
    {
        Field[][] fields = graphics.getFields();
        for (int i = 0; i < fields.length; i++) {
            for (int j = 0; j < fields.length; j++) {
                fields[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Field fieldPressed = (Field)e.getSource();
                        displayPlayer(fieldPressed);
                    }
                });
            }
        }
    }

    private void displayPlayer(Field field)
    {
        if(field.getPlayerMark() == null) {
            if (currentPlayer == Player.O) {
                field.setPlayerMark(Player.O);
                field.setText("O");
            } else {
                field.setPlayerMark(Player.X);
                field.setText("X");
            }
            switchPlayer();
        }
    }

    private void switchPlayer()
    {
        if(currentPlayer == Player.O)
            currentPlayer = Player.X;
        else
            currentPlayer = Player.O;
    }

    private void resetGame()
    {
        currentPlayer = Player.X;
        resetBoard();
    }

    private void resetBoard()
    {
        graphics.resetFields();
    }

    private void setResetButtonAction()
    {
        graphics.getResetButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGame();
            }
        });
    }
}
