package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
    private JTextField txtUsername;
    private JLabel lblUsername;
    private JButton btnLogin;
    private JPasswordField pswdtxtPassword;
    private JLabel lblPassword;
    private JPanel pnlLogin;

    public LoginFrame() {
        super("Login | Vehicle Management");

        setContentPane(pnlLogin);
        pack(); //Fürs Rendering des GUIs

        ActionListener actionLogin = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // sprawdzic czy sie zgadza login
                // User user = loginController.login(username, password)
                // jesli sie zgadza, to dostaniesy obiekt klasy Benutzer
                // jesli Benutzer.rola = admin to utworz nowy MainFrame(rola)

            }
        };

        btnLogin.addActionListener(actionLogin);
    }
}
