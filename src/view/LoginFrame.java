package view;

import controller.LoginController;
import persistence.Role;
import persistence.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.JOptionPane.showMessageDialog;

public class LoginFrame extends JFrame {
    private JTextField txtUsername;
    private JLabel lblUsername;
    private JButton btnLogin;
    private JPasswordField pswdtxtPassword;
    private JLabel lblPassword;
    private JPanel pnlLogin;
    private LoginController loginController = new LoginController();

    public LoginFrame() {
        super("Login | Vehicle Management");

        setContentPane(pnlLogin);
        pack(); //Fürs Rendering des GUIs

        ActionListener actionLogin = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                User user = loginController.Login(txtUsername.getText(), pswdtxtPassword.getText());
                if (user == null) {
                    pswdtxtPassword.setText("");
                    showMessageDialog(pnlLogin, "Username or Password is invalid", "Login", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                MainFrame mainFrame = new MainFrame(user);
                mainFrame.setVisible(true);
                mainFrame.pack();

                setVisible(false);

            }
        };

        btnLogin.addActionListener(actionLogin);
    }
}
