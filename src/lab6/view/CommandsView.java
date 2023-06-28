package lab6.view;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Objects;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import lab6.Main;
import lab6.controllers.LocaleController;
import lab6.controllers.locale.AbstractLocale;
import lab6.controllers.locale.ILocaleLoader;
import lab6.model.Coordinates;
import lab6.model.Dragon;
import lab6.model.DragonCave;
import lab6.model.DragonCharacter;

public class CommandsView extends javax.swing.JFrame implements ILocaleLoader {
    public static CommandsView instance = null;
    public CommandsView() {
        initComponents();
        updateLocale();
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

        titleLabel = new javax.swing.JLabel();
        clearButton = new javax.swing.JButton();
        removeGreaterButton = new javax.swing.JButton();
        removeGreaterSpinner = new javax.swing.JSpinner();
        closeButton = new javax.swing.JButton();
        infoButton = new javax.swing.JButton();
        countLessThanWingspanButton = new javax.swing.JButton();
        wingspanSpinner = new javax.swing.JSpinner();
        countByAgeButton = new javax.swing.JButton();
        ageSpinner = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Список команд");
        setResizable(false);

        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Список команд");

        clearButton.setText("Очистить коллекцию");
        clearButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearButtonMouseClicked(evt);
            }
        });

        removeGreaterButton.setText("Удалить элемент больше, чем:");
        removeGreaterButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeGreaterButtonMouseClicked(evt);
            }
        });

        closeButton.setText("Закрыть");
        closeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeButtonMouseClicked(evt);
            }
        });

        infoButton.setText("Информация о коллекции");
        infoButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                infoButtonMouseClicked(evt);
            }
        });

        countLessThanWingspanButton.setText("Посчитать размах меньше:");
        countLessThanWingspanButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                countLessThanWingspanButtonMouseClicked(evt);
            }
        });

        countByAgeButton.setText("Посчитать по возрасту:");
        countByAgeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                countByAgeButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(closeButton)
                .addGap(159, 159, 159))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(removeGreaterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(removeGreaterSpinner))
                    .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addComponent(clearButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(infoButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(countLessThanWingspanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(wingspanSpinner))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(countByAgeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ageSpinner)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(clearButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(removeGreaterButton)
                    .addComponent(removeGreaterSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(countLessThanWingspanButton)
                    .addComponent(wingspanSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(countByAgeButton)
                    .addComponent(ageSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(infoButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(closeButton)
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeButtonMouseClicked
        dispose();
    }//GEN-LAST:event_closeButtonMouseClicked

    private void clearButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearButtonMouseClicked
        try {
            Main.getCollectionController().clear();
            JOptionPane.showMessageDialog(this, LocaleController.get("COMMANDS_CLEARED"));
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(this, LocaleController.get("SERVER_CONNECTION_ERROR"), LocaleController.get("ERROR_HEADER"), JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_clearButtonMouseClicked

    private void removeGreaterButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeGreaterButtonMouseClicked
        try {
            Main.getCollectionController().removeGreater(new Dragon(-1, "1", new Coordinates(1l, 1), null, 1, "1", 1d, DragonCharacter.CUNNING, new DragonCave(Integer.parseInt(removeGreaterSpinner.getValue().toString())), Main.getCurrentUser()));
            JOptionPane.showMessageDialog(this, LocaleController.get("COMMANDS_REMOVED_GREATER").replace("{NUMBER}", removeGreaterSpinner.getValue().toString()));
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(this, LocaleController.get("SERVER_CONNECTION_ERROR"), LocaleController.get("ERROR_HEADER"), JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_removeGreaterButtonMouseClicked

    private void infoButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_infoButtonMouseClicked
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format(LocaleController.get("COMMANDS_INFO_TYPE")+"%s\n", Main.getCollectionController().getClass().getName())).append("\n");
            sb.append(String.format(LocaleController.get("COMMANDS_INFO_INITIALIZATION")+"%s\n", Main.getCollectionController().getInitTime().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(Main.getLocaleController().getLocale().getLocale())))).append("\n");
            sb.append(String.format(LocaleController.get("COMMANDS_INFO_SIZE")+"%s\n", Main.getCollectionController().size())).append("\n");
            JOptionPane.showMessageDialog(null, sb.toString(), LocaleController.get("COMMANDS_INFO_HEADER"), JOptionPane.INFORMATION_MESSAGE);
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(this, LocaleController.get("SERVER_CONNECTION_ERROR"), LocaleController.get("ERROR_HEADER"), JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_infoButtonMouseClicked

    private void countLessThanWingspanButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_countLessThanWingspanButtonMouseClicked
        try {
            long result = ((ArrayList<Dragon>)Main.getCollectionController().toList()).stream().filter(d -> d.getWingspan() < Double.valueOf(wingspanSpinner.getValue().toString())).count();
            JOptionPane.showMessageDialog(this, LocaleController.get("COMMANDS_LESS_WINGSPAN").replace("{NUMBER}", result+""));
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(this, LocaleController.get("SERVER_CONNECTION_ERROR"), LocaleController.get("ERROR_HEADER"), JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_countLessThanWingspanButtonMouseClicked

    private void countByAgeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_countByAgeButtonMouseClicked
        try {
            long result = ((ArrayList<Dragon>)Main.getCollectionController().toList()).stream().filter(d -> Objects.equals(d.getAge(), Integer.valueOf(ageSpinner.getValue().toString()))).count();
            JOptionPane.showMessageDialog(this, LocaleController.get("COMMANDS_AGE").replace("{NUMBER}", result+""));
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(this, LocaleController.get("SERVER_CONNECTION_ERROR"), LocaleController.get("ERROR_HEADER"), JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_countByAgeButtonMouseClicked

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
            java.util.logging.Logger.getLogger(CommandsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CommandsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CommandsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CommandsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                instance = new CommandsView();
                instance.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner ageSpinner;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton closeButton;
    private javax.swing.JButton countByAgeButton;
    private javax.swing.JButton countLessThanWingspanButton;
    private javax.swing.JButton infoButton;
    private javax.swing.JButton removeGreaterButton;
    private javax.swing.JSpinner removeGreaterSpinner;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JSpinner wingspanSpinner;
    // End of variables declaration//GEN-END:variables

    @Override
    public void updateLocale() {
        AbstractLocale locale = Main.getLocaleController().getLocale();
        ImageIcon icon = new ImageIcon(getClass().getResource("/resources/dragon/head.png"));
        setIconImage(icon.getImage());
        setTitle(locale.getKey("COMMANDS_TITLE"));
        titleLabel.setText(locale.getKey("COMMANDS_TITLE"));
        clearButton.setText(locale.getKey("COMMANDS_BUTTON_CLEAR"));
        closeButton.setText(locale.getKey("CLOSE"));
        countLessThanWingspanButton.setText(locale.getKey("COMMANDS_BUTTON_LESS_WINGSPAN"));
        infoButton.setText(locale.getKey("COMMANDS_INFO_HEADER"));
        removeGreaterButton.setText(locale.getKey("COMMANDS_BUTTON_REMOVE_GREATER"));
        countByAgeButton.setText(locale.getKey("COMMANDS_BUTTON_AGE"));
    }
}
