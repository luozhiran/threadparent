package itg.ui.factory;

import javax.swing.*;

public class JFrameFactory {

    public static JFrame create(String title, int width, int height) {
        JFrame jf = new JFrame(title);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setSize(width,height);
        jf.setLocationRelativeTo(null);
        return jf;
    }

    public static JFrame create(String title) {
        JFrame jf = new JFrame(title);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setSize(300, 200);
        jf.setLocationRelativeTo(null);
        return jf;
    }
}
