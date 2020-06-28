package com.self.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Author: ZST
 * @Date: 2020/6/1
 */
public class TankFram extends Frame {
    public TankFram() {
        setResizable(false);
        setVisible(true);
        setTitle("Self-Tank");
        setSize(800, 800);
        setResizable(false);

        addWindowListener(new WindowAdapter() {
            /**
             * Invoked when a window is in the process of being closed.
             * The close operation can be overridden at this point.
             *
             * @param e
             */
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    @Override
    public void paint(Graphics g) {
        g.draw3DRect(200, 200, 30, 50, false);
    }
}
