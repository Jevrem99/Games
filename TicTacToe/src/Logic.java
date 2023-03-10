
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Logic {

    private Graphics graphics;
    private boolean gameBlocked;
    private Player currentPlayer;
    private Player winner;
    private Field[][] fields;

    public Logic() {
        graphics = new Graphics();
        currentPlayer = Player.X;
        fields = graphics.getFields();
        gameBlocked = false;
        setFieldActions();
        setResetButtonAction();
    }

    private void setFieldActions()
    {
        Field[][] fields = graphics.getFields();
        for (int i = 0; i < fields.length; i++) {
            for (int j = 0; j < fields.length; j++) {
                fields[i][j].addActionListener(e -> {
                    Field fieldPressed = (Field) e.getSource();
                    if (!gameBlocked) {
                        displayPlayer(fieldPressed);
                        if (checkForWinner()) {
                            if (showDialogForWinner() == 0) {
                                resetGame();
                            } else
                                blockGame();
                        }
                        if(boardFull() && !gameBlocked)
                        {
                            if(showDialogForDraw() == 0){
                                resetGame();
                            }else
                                blockGame();
                        }
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
                field.setPicture(Player.O);
            } else {
                field.setPlayerMark(Player.X);
                field.setPicture(Player.X);
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
        gameBlocked = false;
        resetBoard();
    }

    private void resetBoard()
    {
        graphics.resetFields();
    }

    private boolean boardFull()
    {
        for (int i = 0; i <fields.length; i++) {
            for (int j = 0; j < fields.length; j++) {
                if(fields[i][j].getPlayerMark() == null)
                    return false;
            }
        }
        return true;
    }
    private boolean checkForWinner()
    {
        boolean winnerFound = false;
        for (int i = 0; i < fields.length; i++) {  //Prolazak kroz sve redove
            if(fields[i][0].getPlayerMark() == fields[i][1].getPlayerMark() && fields[i][1].getPlayerMark() == fields[i][2].getPlayerMark() && fields[i][0].getPlayerMark() != null)
            {
                winner = fields[i][0].getPlayerMark();
                winnerFound = true;
                fields[i][0].setBackground(Color.GREEN);
                fields[i][1].setBackground(Color.GREEN);
                fields[i][2].setBackground(Color.GREEN);
            }
        }

        for (int i = 0; i < fields.length; i++) {  //Prolazak kroz sve kolone
            if(fields[0][i].getPlayerMark() == fields[1][i].getPlayerMark() && fields[1][i].getPlayerMark() == fields[2][i].getPlayerMark() && fields[0][i].getPlayerMark() != null)
            {
                winner = fields[0][i].getPlayerMark();
                winnerFound = true;
                fields[0][i].setBackground(Color.GREEN);
                fields[1][i].setBackground(Color.GREEN);
                fields[2][i].setBackground(Color.GREEN);
            }
        }

        if(fields[0][0].getPlayerMark() == fields[1][1].getPlayerMark() && fields[1][1].getPlayerMark() == fields[2][2].getPlayerMark() && fields[0][0].getPlayerMark() != null)
        {
            winner = fields[0][0].getPlayerMark();
            winnerFound = true;
            fields[0][0].setBackground(Color.GREEN);
            fields[1][1].setBackground(Color.GREEN);
            fields[2][2].setBackground(Color.GREEN);
        }

        if(fields[0][2].getPlayerMark() == fields[1][1].getPlayerMark() && fields[1][1].getPlayerMark() == fields[2][0].getPlayerMark() && fields[0][2].getPlayerMark() != null)
        {
            winner = fields[0][2].getPlayerMark();
            winnerFound = true;
            fields[0][2].setBackground(Color.GREEN);
            fields[1][1].setBackground(Color.GREEN);
            fields[2][0].setBackground(Color.GREEN);
        }

        return winnerFound;
    }


    private void setResetButtonAction()
    {
        graphics.getResetButton().addActionListener(e -> resetGame());
    }

    private int showDialogForWinner()
    {
        int optionPane;
        optionPane = JOptionPane.showConfirmDialog(graphics,
                "Winner is player " + winner+"\n New game?","We have a winner!",
                JOptionPane.YES_NO_OPTION);

        return optionPane;
    }

    private int showDialogForDraw()
    {
        int optionPane;
        optionPane = JOptionPane.showConfirmDialog(graphics,
                "Nobody won the game.\n New game?","Draw",
                JOptionPane.YES_NO_OPTION);
        return optionPane;
    }

    private void blockGame()
    {
        gameBlocked = true;
    }


}
