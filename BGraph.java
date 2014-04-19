import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JButton;

import java.awt.Image;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class BGraph implements Runnable {
    private static int locationX;
    private static int locationY;

    private static int width;
    private static int height;

    private static String function;
    
    
    BGraph() {
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        width = 640;
        height = 480;
    }
    
    public static void main(String args[]) {
        function = args[0];
        SwingUtilities.invokeLater(new BGraph());
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
        
        f.add(new Painter(width, height, function));
       
        JPanel buttonsPanel = new JPanel(new FlowLayout()); 
        buttonsPanel.add(new JLabel(function));
        buttonsPanel.add(new JButton("+Y"));
        buttonsPanel.add(new JButton("-Y"));
        buttonsPanel.add(new JButton("+X"));
        buttonsPanel.add(new JButton("-X"));
        f.add(buttonsPanel, BorderLayout.SOUTH);
       
        f.setVisible(true);
    }
}
