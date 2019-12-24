package itg.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class Ui {
    private ArrayList<JButton> jButtonList = new ArrayList<JButton>();


    public static void create(AbstractAction abstractAction){
        Ui ui = new Ui();
        JFrame jFrame = ui.initFrame("测试");
        LayoutManager layoutManager = ui.getGridLayout(3, 3);
        String[] str = {"开始", "暂停", "结束"};
        JPanel panel = ui.getPanel(layoutManager, str);
        ui.addClick(abstractAction);
        ui.show(panel, jFrame);
    }

    public JFrame initFrame(String frameName) {
        JFrame jFrame = new JFrame(frameName);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setSize(300, 200);
        return jFrame;
    }


    /**
     * 获取网格布局管理器
     *
     * @return
     */
    public GridLayout getGridLayout(int raws, int lines) {
        GridLayout gridLayout = new GridLayout(raws, lines);
        return gridLayout;
    }


    public JPanel getPanel(LayoutManager layoutManager, String[] btnArray) {

        JPanel jPanel = new JPanel(layoutManager);
        for (String str : btnArray) {
            JButton btn = new JButton(str);
            jButtonList.add(btn);
            jPanel.add(btn);
        }
        return jPanel;
    }

    public void addClick(AbstractAction onClickListener) {
        for (JButton btn : jButtonList) {
            btn.addActionListener(onClickListener);
        }
    }


    public void show(JPanel jPanel, JFrame jFrame) {
        jFrame.setContentPane(jPanel);
        jFrame.setVisible(true);
    }


}
