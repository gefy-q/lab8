package lab6.view;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import lab6.Main;
import lab6.controllers.LocaleController;
import lab6.controllers.locale.AbstractLocale;
import lab6.controllers.locale.ILocaleLoader;
import lab6.model.User;
import lab6.model.UserCredentials;
import lab6.udp.UDPException;

public class LoginView extends javax.swing.JFrame implements ILocaleLoader {
    public static LoginView instance = null;
    public LoginView(String[] args) {
        initComponents();
        updateLocale();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        authLabel = new javax.swing.JLabel();
        loginLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        loginField = new javax.swing.JTextField();
        registerButton = new javax.swing.JButton();
        authButton = new javax.swing.JButton();
        languageButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Авторизация");
        setResizable(false);

        authLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        authLabel.setText("Авторизация");

        loginLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        loginLabel.setText("Логин:");

        passwordLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        passwordLabel.setText("Пароль:");

        registerButton.setText("Зарегистрироваться");
        registerButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registerButtonMouseClicked(evt);
            }
        });

        authButton.setText("Войти");
        authButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                authButtonMouseClicked(evt);
            }
        });

        languageButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/globe.png"))); // NOI18N
        languageButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                languageButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(languageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(registerButton, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(authButton)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(loginLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(passwordLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(loginField)
                                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(16, 16, 16))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(authLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(languageButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(authLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginLabel)
                    .addComponent(loginField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabel)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registerButton)
                    .addComponent(authButton))
                .addGap(18, 18, 18))
        );

        passwordLabel.getAccessibleContext().setAccessibleName("Па");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void authButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_authButtonMouseClicked
        String login = loginField.getText();
        String password = passwordField.getText();
        UserCredentials credentials = new UserCredentials(login, password);
        User result = null;
        try {
            result = Main.getUdpManager().auth(credentials);
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(this, LocaleController.get("LOGIN_ERROR"), LocaleController.get("ERROR_HEADER"), JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(result == null) {
            JOptionPane.showMessageDialog(this, LocaleController.get("LOGIN_ERROR"), LocaleController.get("ERROR_HEADER"), JOptionPane.ERROR_MESSAGE);
            return;
        }
        Main.setCredentials(credentials);
        Main.setCurrentUser(result);
        this.dispose();
        MainView.main(null);
    }//GEN-LAST:event_authButtonMouseClicked

    private void registerButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerButtonMouseClicked
        String login = loginField.getText();
        String password = passwordField.getText();
        UserCredentials credentials = new UserCredentials(login, password);
        try {
            Main.getUdpManager().register(credentials);
            JOptionPane.showMessageDialog(this, LocaleController.get("LOGIN_SUCCESS"), LocaleController.get("SUCCESS_HEADER"), JOptionPane.INFORMATION_MESSAGE);
            loginField.setText("");
            passwordField.setText("");
        } catch(UDPException ex) {
            JOptionPane.showMessageDialog(this, LocaleController.get("LOGIN_REGISTRATION_ERROR"), LocaleController.get("ERROR_HEADER"), JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_registerButtonMouseClicked

    private void languageButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_languageButtonMouseClicked
        if(LanguageView.instance!=null){
            LanguageView.instance.toFront();
        }else{
        LanguageView.main(null);}
    }//GEN-LAST:event_languageButtonMouseClicked

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                instance = new LoginView(args);
                instance.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton authButton;
    private javax.swing.JLabel authLabel;
    private javax.swing.JButton languageButton;
    private javax.swing.JTextField loginField;
    private javax.swing.JLabel loginLabel;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JButton registerButton;
    // End of variables declaration//GEN-END:variables

    @Override
    public void updateLocale() {
        AbstractLocale locale = Main.getLocaleController().getLocale();
        ImageIcon icon = new ImageIcon(getClass().getResource("/resources/dragon/head.png"));
        setIconImage(icon.getImage());
        setTitle(locale.getKey("LOGIN_TITLE"));
        authLabel.setText(locale.getKey("LOGIN_TITLE"));
        loginLabel.setText(locale.getKey("LOGIN_LOGIN_LABEL"));
        passwordLabel.setText(locale.getKey("LOGIN_PASSWORD_LABEL"));
        registerButton.setText(locale.getKey("LOGIN_REGISTER"));
        authButton.setText(locale.getKey("LOGIN_AUTH"));
    }
}
