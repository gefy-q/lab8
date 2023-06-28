package lab6.view;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import lab6.Main;
import lab6.controllers.locale.*;

public class LanguageView extends javax.swing.JFrame implements ILocaleLoader {
    public static LanguageView instance = null;
    public LanguageView(String[] args) {
        initComponents();
        updateLocale();
        if(Main.getLocaleController().getLocale().getName().equals("ru"))
            languageBox.setSelectedIndex(0);
        if(Main.getLocaleController().getLocale().getName().equals("pt"))
            languageBox.setSelectedIndex(1);
        if(Main.getLocaleController().getLocale().getName().equals("it"))
            languageBox.setSelectedIndex(2);
        if(Main.getLocaleController().getLocale().getName().equals("es"))
            languageBox.setSelectedIndex(3);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                instance = null;
            }
        });
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        languageLabel = new javax.swing.JLabel();
        applyButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();
        languageBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Язык");
        setResizable(false);

        languageLabel.setText("Выберите язык:");

        applyButton.setText("Применить");
        applyButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                applyButtonMouseClicked(evt);
            }
        });

        closeButton.setText("Закрыть");
        closeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeButtonMouseClicked(evt);
            }
        });

        languageBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Русский / Russian", "Português / Portuguese", "Italiano / Italian", "Español (Puerto Rico) / Spanish (Puerto Rico)" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(languageLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(languageBox, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(applyButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(closeButton)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(languageLabel)
                    .addComponent(languageBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(applyButton)
                    .addComponent(closeButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeButtonMouseClicked
        dispose();
    }//GEN-LAST:event_closeButtonMouseClicked

    private void applyButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_applyButtonMouseClicked
        if(languageBox.getSelectedIndex()==0){
            Main.getLocaleController().setLocale(new RuLocale());
        }else if (languageBox.getSelectedIndex()==1) {
            Main.getLocaleController().setLocale(new PtLocale());}
        else if (languageBox.getSelectedIndex()==2) {
            Main.getLocaleController().setLocale(new ItLocale());}
        else if (languageBox.getSelectedIndex()==3) {
            Main.getLocaleController().setLocale(new EsLocale());
        }
        if(LoginView.instance!=null){
            LoginView.instance.updateLocale();
        }
        if(CommandsView.instance!=null){
            CommandsView.instance.updateLocale();
        }
        if(MainView.instance!=null){
            MainView.instance.updateLocale();
        }
        if(VisualizationView.instance!=null){
            VisualizationView.instance.updateLocale();
        }
        if(ItemView.instance!=null){
            ItemView.instance.updateLocale();
        }
        updateLocale();
    }//GEN-LAST:event_applyButtonMouseClicked

    public static void main(String args[]) {
        if(instance != null) {
            instance.toFront();
            return;
        }
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LanguageView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LanguageView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LanguageView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LanguageView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                instance = new LanguageView(args);
                instance.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton applyButton;
    private javax.swing.JButton closeButton;
    private javax.swing.JComboBox<String> languageBox;
    private javax.swing.JLabel languageLabel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void updateLocale() {
        AbstractLocale locale = Main.getLocaleController().getLocale();
        ImageIcon icon = new ImageIcon(getClass().getResource("/resources/dragon/head.png"));
        setIconImage(icon.getImage());
        setTitle(locale.getKey("LANGUAGE_TITLE"));
        applyButton.setText(locale.getKey("SAVE"));
        closeButton.setText(locale.getKey("CLOSE"));
        languageLabel.setText(locale.getKey("LANGUAGE_LABEL"));
    }
}
