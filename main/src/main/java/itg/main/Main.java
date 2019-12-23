package itg.main;

import itg.ui.Ui;
import thread.dir.InterruptDemo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

//https://blog.csdn.net/xietansheng/article/details/72814492
public class Main {
    public static void main(String[] args) {

        final InterruptDemo demo = new InterruptDemo("thread-1");
        createUi(new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                if ("开始".equals(e.getActionCommand())) {
                    demo.start();
                } else if ("暂停".equals(e.getActionCommand())) {

                } else if ("结束".equals(e.getActionCommand())) {
                    demo.finish();
                }
                System.err.println(e.getActionCommand());
            }
        });
    }

    private static void createUi(AbstractAction abstractAction) {
        Ui ui = new Ui();
        JFrame jFrame = ui.initFrame("测试");
        LayoutManager layoutManager = ui.getGridLayout(3, 3);
        String[] str = {"开始", "暂停", "结束"};
        JPanel panel = ui.getPanel(layoutManager, str);
        ui.addClick(abstractAction);
        ui.show(panel, jFrame);
    }
}
