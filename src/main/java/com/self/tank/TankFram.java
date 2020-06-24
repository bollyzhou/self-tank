package com.self.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Author: ZST
 * @Date: 2020/6/1
 */
public class TankFram extends Frame {
    int x = 200, y = 200 ;
    public TankFram() {
        setResizable(false);
        setVisible(true);
        setTitle("Self-Tank");
        setSize(800, 600);
        setResizable(false);


        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        addKeyListener(new MyKeyListener());
    }
    @Override
    public void paint(Graphics g) {
        System.out.println("dongqisdfd");
        g.fillRect(x, y, 20,20);
        x = x + 10;
        y = y + 10;
    }

    class MyKeyListener extends KeyAdapter {


        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("pressed");
        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("released");
        }
    }
}
