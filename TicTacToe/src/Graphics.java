import javax.swing.*;
import java.awt.*;

public class Graphics extends JFrame {

    private final int windowWidth = Settings.windowWidth;
    private final int windowHeight = Settings.windowHeight;
    private final JPanel mainPanel;
    private final JPanel rightSidePanel;
    private final Field[][] fields = new Field[3][3];
    private final JButton resetButton;



    public Graphics(){
        mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(windowWidth,windowHeight));
        mainPanel.setLayout(new GridLayout(3,3));
        setFields(mainPanel);
        rightSidePanel = new JPanel();
        rightSidePanel.setPreferredSize(new Dimension(windowWidth/3,windowHeight));
        resetButton = new JButton("Reset game");
        rightSidePanel.add(resetButton);
        this.setResizable(false);
        Image icon = Toolkit.getDefaultToolkit().getImage("images/TicTacToeIcon.png");
        this.setIconImage(icon);
        this.setTitle("TicTacToe");
        this.setSize(windowWidth,windowHeight);
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
