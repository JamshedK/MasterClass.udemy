package com.example.awtSample;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyWindow extends Frame {

    public MyWindow(String title)  {
        super(title);
        setSize(500, 400);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Font sansSerifLarge = new Font("SansSerifLarge", Font.BOLD, 18);
        Font sansSerifSmall = new Font("SansSerifLarge", Font.BOLD, 12);
        g.setFont(sansSerifLarge);
        g.drawString("The complete Java tutorial course", 60, 60);
        g.setFont(sansSerifSmall);
        g.drawString("By TIm Buchalka", 60, 100);

    }
}
