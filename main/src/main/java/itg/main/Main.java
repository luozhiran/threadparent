package itg.main;

import itg.ui.SpringLayoutUi;
import itg.ui.Ui;
import thread.dir.InterruptDemo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//https://blog.csdn.net/xietansheng/article/details/72814492
public class Main {
    public static void main(String[] args) {

        final SpringLayoutUi springLayoutUi = new SpringLayoutUi();
        springLayoutUi.createUi(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (SpringLayoutUi.SEND.equals(e.getActionCommand())) {
                    System.err.println(springLayoutUi.getSendContent());
                } else if (SpringLayoutUi.FINISH.equals(e.getActionCommand())) {

                }
            }
        }).setVisible(true);


    }

}
