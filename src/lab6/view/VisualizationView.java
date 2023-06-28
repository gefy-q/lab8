package lab6.view;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import lab6.Main;
import lab6.controllers.LocaleController;
import lab6.controllers.locale.ILocaleLoader;
import lab6.model.Dragon;
import lab6.view.component.VisualizationPanel;

public class VisualizationView extends javax.swing.JFrame implements ILocaleLoader {
    public static VisualizationView instance = null;
    private List<Dragon> data;
    private VisualizationPanel panel;
    public VisualizationView(List<Dragon> data) {
        this.data = data;
        initComponents();
        updateLocale();
    }

    @SuppressWarnings("unchecked")                        
    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Визуализация коллекции");
        setResizable(false);
        setPreferredSize(new java.awt.Dimension(600, 600));
        try {
            data = (ArrayList<Dragon>)Main.getCollectionController().toList();
            panel = new VisualizationPanel(data);
            getContentPane().add(panel);
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    instance = null;
                    panel.getTimer().stop();
                }
            });
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(this, LocaleController.get("SERVER_CONNECTION_ERROR"), LocaleController.get("ERROR_HEADER"), JOptionPane.ERROR_MESSAGE);
        }
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(List<Dragon> current) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VisualizationView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VisualizationView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VisualizationView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VisualizationView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                instance = new VisualizationView(current);
                instance.setVisible(true);
            }
        });
    }

    @Override
    public void updateLocale() {
        ImageIcon icon = new ImageIcon(getClass().getResource("/resources/dragon/head.png"));
        getContentPane().setBackground(Color.WHITE);
        setIconImage(icon.getImage());
        setTitle(LocaleController.get("VISUALIZATION_TITLE"));
    }
}
