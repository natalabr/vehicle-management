import view.LoginFrame;
import view.MainFrame;

import java.awt.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        LoginFrame loginFrame = new LoginFrame();

        loginFrame.setSize(300, 200);
        loginFrame.setLocationRelativeTo(null);

        loginFrame.setVisible(true);
    }
}