import javax.swing.*;
import java.awt.*;

public class Graphics extends JFrame {

    private int windowWidth = 500;
    private int windowHight = 500;
    private JPanel mainPanel;
    private JPanel rightSidePanel;
    private Field fields[][] = new Field[3][3];
    private JButton resetButton;



    public Graphics(){
        mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(windowWidth,windowHight));
        mainPanel.setLayout(new GridLayout(3,3));
        setFields(mainPanel);
        rightSidePanel = new JPanel();
        rightSidePanel.setPreferredSize(new Dimension(windowWidth/3,windowHight));
        resetButton = new JButton("Reset game");
        rightSidePanel.add(resetButton);
        this.setTitle("TicTacToe");
        this.setSize(windowWidth,windowHight);
        this.setLayout(new FlowLayout());
        this.add(mainPanel);
        this.add(rightSidePanel);
        this.pack();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void setFields(JPanel panel)
    {
        for (int i = 0; i < 3; i++) {
            for(int j = 0;j < 3;j++)
            {
                fields[i][j] = new Field(i,j);
                fields[i][j].setBackground(Color.white);
                panel.add(fields[i][j]);
            }
        }
    }

    public void resetFields()
    {
        for (int i = 0; i < fields.length; i++) {
            for (int j = 0; j < fields.length; j++) {
                fields[i][j].reset();
            }
        }
    }

    public Field[][] getFields() {
        return fields;
    }
    public JButton getResetButton() {
        return resetButton;
    }

}
