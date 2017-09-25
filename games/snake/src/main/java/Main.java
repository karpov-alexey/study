import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Line2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;


/**
 * Created by alex on 25.09.2017.
 */
public class Main extends JFrame{
    int width = 20;
    int height = 20;
    int heightStep = 1;
    int widthStep = 1;

    int frames = 0;
    int count = 0;

    int x = 0, y = 0, fruitX = 0, fruitY = 0;
    Random random = new Random();
    Draw draw;

    public Main() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//        frame.setUndecorated(true);

        setSize(200, 200);
        setResizable(false);
        setVisible(true);
        draw = new Draw();
        add(draw);
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                x += 1;
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }


    private void setup() {
        Dimension dimension = getSize();
        heightStep = (int)dimension.getHeight() / height;
        widthStep = (int)dimension.getWidth() / width;


        x = width / 2;
        y = height / 2;
        fruitX = random.nextInt(width);
        fruitY = random.nextInt(height);
    }

    private void input() {

    }

    private void logic() {

    }

    private void draw() {
//        draw.revalidate();

        draw.repaint();
    }

    public void start() {
        setup();
        while (true) {
            input();
            logic();
            draw();

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

     class Draw extends JPanel {

        public void paint(Graphics g) {
            super.paint(g);
            g.drawOval(x * heightStep, y * widthStep, heightStep, widthStep);
            g.drawRect(fruitX * heightStep, fruitY * widthStep, heightStep, widthStep);
        }
    }


    public static void main(String[] args) {
        Main main = new Main();
        main.start();
    }
}
