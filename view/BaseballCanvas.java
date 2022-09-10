package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class BaseballCanvas extends JPanel{

    public static int WIDTH = 500;
    public static int HEIGHT = 500;
    private int balls;
    private int strikes;


    private BaseballGamePanel panel;

    public BaseballCanvas(BaseballGamePanel panel){
        this.panel = panel;
        setPreferredSize(new Dimension( WIDTH, HEIGHT));
        setBackground(Color.BLACK);

    }


    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2= (Graphics2D ) g;
        //ready
        BaseballGamePanel.GameState state= panel.getGameState();
        if(state== BaseballGamePanel.GameState.READY){
            g2.setColor(Color.yellow);
            g2.setFont(new Font("Courier New",Font.BOLD,30));
            g2.drawString("Click <Play> to State  ", 70, 150);
        } else {
            g2.setColor(Color.yellow);
            g2.setFont(new Font("Courier New", Font.BOLD, 14));
            //drawing balls
            g2.drawString("Balls: ", 20, 100);
            for (int i=0;i<3;i++){
                if (i<balls)
                g2.fillOval(i*140+100, 80 , 50 , 50);
                else
                g2.drawOval(i*140+100, 80 , 50 , 50);

            }
        }
            //draw strikes
            g2.drawString("Strikes: ", 20, 200);
            for (int i=0;i<3;i++){
                if (i<strikes)
                g2.fillOval(i*140+100, 180 , 50 , 50);
                else
                g2.drawOval(i*140+100, 180 , 50 , 50);
            }
        
        
    }
    public void setBallStrikeCount(int balls, int strikes){
        this.balls=balls;
        this.strikes=strikes;
    }
    
}
