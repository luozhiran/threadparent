package itg.ui;


import itg.ui.factory.JFrameFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * SpringLayout，弹性布局管理器。使用该布局的容器内的 每一个组件或容器都对应着一个约束，
 * 通过该约束定义组件或容器四条边的坐标位置 来实现对组件的布局。
 * 该布局主要涉及三个类: SpringLayout、SpringLayout.Constraints、Spring，分别表示 布局管理器、约束、坐标距离。
 */
public class SpringLayoutUi {

    private JTextArea jTextArea, jinputText;
    private JLabel jConnectIdLabel;
    public final static String SEND = "发送";
    public final static String FINISH = "结束";

    public JFrame createUi(ActionListener actionListener) {
        JFrame jFrame = JFrameFactory.create("测试", 400, 300);

        SpringLayout springLayout = new SpringLayout();
        Panel parentPanel = new Panel(springLayout);
        jFrame.add(parentPanel);


        JLabel leftLabel = new JLabel("服务器控制台:");
        parentPanel.add(leftLabel);
        springLayout.putConstraint(SpringLayout.NORTH, leftLabel, Spring.constant(5), SpringLayout.NORTH, parentPanel);
        springLayout.putConstraint(SpringLayout.WEST, leftLabel, Spring.constant(5), SpringLayout.WEST, parentPanel);

        jConnectIdLabel = new JLabel("Ip：xxx.xxx.xxx.xxx");
        jConnectIdLabel.setForeground(Color.BLUE);
        jConnectIdLabel.setFont(Font.getFont("10"));
        parentPanel.add(jConnectIdLabel);
        springLayout.putConstraint(SpringLayout.WEST, jConnectIdLabel, Spring.constant(5), SpringLayout.EAST, leftLabel);
        springLayout.putConstraint(SpringLayout.NORTH, jConnectIdLabel, Spring.constant(5), SpringLayout.NORTH, parentPanel);


        JButton sentBtn = new JButton("发送");
        parentPanel.add(sentBtn);
        springLayout.putConstraint(SpringLayout.NORTH, sentBtn, Spring.constant(5), SpringLayout.SOUTH, leftLabel);
        springLayout.putConstraint(SpringLayout.WEST, sentBtn, Spring.constant(5), SpringLayout.WEST, parentPanel);

        sentBtn.addActionListener(actionListener);

        JButton endBtn = new JButton("结束");
        parentPanel.add(endBtn);
        springLayout.putConstraint(SpringLayout.NORTH, endBtn, Spring.constant(5), SpringLayout.SOUTH, sentBtn);
        springLayout.putConstraint(SpringLayout.WEST, endBtn, Spring.constant(5), SpringLayout.WEST, parentPanel);
        endBtn.addActionListener(actionListener);

        jTextArea = new JTextArea("接收内容", 5, 10);
        jTextArea.setLineWrap(true);
        jTextArea.setEditable(false);
        jTextArea.setForeground(Color.GRAY);
        JScrollPane receiverScrollPane = new JScrollPane();
        receiverScrollPane.setViewportView(jTextArea);
        receiverScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        receiverScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        parentPanel.add(receiverScrollPane);
        springLayout.putConstraint(SpringLayout.WEST, receiverScrollPane, Spring.constant(5), SpringLayout.EAST, leftLabel);
        springLayout.putConstraint(SpringLayout.EAST, receiverScrollPane, Spring.constant(5), SpringLayout.EAST, parentPanel);
        springLayout.putConstraint(SpringLayout.NORTH, receiverScrollPane, Spring.constant(5), SpringLayout.SOUTH, leftLabel);


        jinputText = new JTextArea("输入文本");
        jinputText.setLineWrap(true);
        JScrollPane inputScrollPane = new JScrollPane();
        inputScrollPane.setViewportView(jinputText);
        inputScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        inputScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        parentPanel.add(inputScrollPane);

        springLayout.putConstraint(SpringLayout.NORTH, inputScrollPane, Spring.constant(5), SpringLayout.SOUTH, receiverScrollPane);
        springLayout.putConstraint(SpringLayout.WEST, inputScrollPane, Spring.constant(5), SpringLayout.EAST, leftLabel);
        springLayout.putConstraint(SpringLayout.EAST, inputScrollPane, Spring.constant(5), SpringLayout.EAST, parentPanel);
        springLayout.putConstraint(SpringLayout.SOUTH, inputScrollPane, Spring.constant(-5), SpringLayout.SOUTH, parentPanel);

        return jFrame;
    }


    public void setReceiveText(String str) {
        jTextArea.append(str);
        jTextArea.append("\n");
    }

    public String getSendContent() {
        return jinputText.getText();
    }


    public void setIpText(String ip) {
        jConnectIdLabel.setText(String.format("Ip：%s", ip));
    }

}
