import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Image;
import java.awt.Graphics;
import java.awt.Color;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import parser.ExpressionParser;
import parser.MyCalcException;
import parser.UnknownVariableException;

public class BGraph extends JPanel implements Runnable {
    
    private final int width;
    private final int height;
    
    private final int locationX;
    private final int locationY;
    
    private int locationOY;
    private int locationOX;
    
    private double scaleX;
    private double scaleY;
    
    private static String function;
    
    BGraph() {
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        locationX = (int)screenSize.getWidth() / 2 - 320;
        locationY = (int)screenSize.getHeight() / 2 - 240;
        
        width = 640;
        height = 480;
        
        locationOY = width / 2;
        locationOX = height / 2;
        
        scaleX = 100;
        scaleY = 10;
    }
    
    public static void main(String args[]) {
        function = args[0];
        SwingUtilities.invokeLater(new BGraph());
    }
    
    void drawGraph(Graphics g) {
        Graphics g2 = g;
        g2.setColor(Color.RED);
        int prevX = 0, prevY = 0;
        boolean isFirst = true;
        for (int i = 0; i <= width; i++) {
            double x, y;
            int curX, curY;
            
            x = (double)(i - locationOY) / scaleX;

            
            try {
                y = ExpressionParser.calc(function, x);
                y = y * scaleY;
                
                curX = i;
                curY = height - (int)y - locationOX;
                
                if (isFirst) {
                    prevX = curX;
                    prevY = curY;
                }
                
                g2.drawLine(prevX, prevY, curX, curY);
                prevX = curX;
                prevY = curY;
                isFirst = false;
            } catch (MyCalcException e) {
                isFirst = true;
                if (e instanceof UnknownVariableException) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
    
    void drawAxis(Graphics g) {
        Graphics g2 = g;
        g2.setColor(Color.BLACK);
        // OX
        g2.drawLine(0, locationOX, width, locationOX);
        // OY
        g2.drawLine(locationOY, 0, locationOY, height);
    }
    
	public void paint(Graphics g) {
		Graphics g2 = g;
        drawAxis(g);
        drawGraph(g);
	}
    
    public void run() {
        JFrame f = new JFrame("BGraph");
        
        Image icon = null;
        try {
            icon = ImageIO.read(new File("resources/mainIcon.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
        f.setIconImage(icon);
        f.setSize(width, height);
        f.setLocation(locationX, locationY);
        
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        f.add(new BGraph());
        
        f.setVisible(true);
    }
}
