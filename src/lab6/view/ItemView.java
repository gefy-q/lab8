package lab6.view;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import lab6.Main;
import lab6.controllers.LocaleController;
import lab6.controllers.locale.ILocaleLoader;
import lab6.model.Coordinates;
import lab6.model.Dragon;
import lab6.model.DragonCave;
import lab6.model.DragonCharacter;

public class ItemView extends javax.swing.JFrame implements ILocaleLoader {
    public static ItemView instance = null;
    public int modelId = -1;
    private Dragon model = new Dragon();
    public ItemView(int modelId) {
        this.modelId = modelId;
        initComponents();
        characteristicBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {
                LocaleController.get("DRAGON_CHARACTER_CUNNING"),
                LocaleController.get("DRAGON_CHARACTER_WISE"),
                LocaleController.get("DRAGON_CHARACTER_GOOD"),
                LocaleController.get("DRAGON_CHARACTER_FICKLE")
        }));
        loadModel();
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

        nameLabel = new javax.swing.JLabel();
        coordsXLabel = new javax.swing.JLabel();
        coordsYLabel = new javax.swing.JLabel();
        ageLabel = new javax.swing.JLabel();
        descriptionLabel = new javax.swing.JLabel();
        characteristicLabel = new javax.swing.JLabel();
        wingspanLabel = new javax.swing.JLabel();
        treasuresLabel = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        descriptionField = new javax.swing.JTextField();
        coordsXField = new javax.swing.JFormattedTextField();
        coordsYField = new javax.swing.JFormattedTextField();
        ageField = new javax.swing.JFormattedTextField();
        characteristicBox = new javax.swing.JComboBox<>();
        titleLabel = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        wingspanField = new javax.swing.JFormattedTextField();
        treasuresField = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Создание дракона");
        setResizable(false);

        nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        nameLabel.setText("Название:");

        coordsXLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        coordsXLabel.setText("Координата X:");

        coordsYLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        coordsYLabel.setText("Координата Y:");

        ageLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ageLabel.setText("Возраст");

        descriptionLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        descriptionLabel.setText("Описание");

        characteristicLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        characteristicLabel.setText("Характеристика:");

        wingspanLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        wingspanLabel.setText("Размах:");

        treasuresLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        treasuresLabel.setText("Сокровища:");

        coordsXField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        coordsYField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        ageField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        characteristicBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Создание дракона");

        saveButton.setText("Сохранить");
        saveButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveButtonMouseClicked(evt);
            }
        });

        cancelButton.setText("Отмена");
        cancelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelButtonMouseClicked(evt);
            }
        });

        wingspanField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        treasuresField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(coordsYLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(coordsXLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(treasuresLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(wingspanLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(characteristicLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(descriptionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(coordsXField)
                    .addComponent(coordsYField)
                    .addComponent(ageField)
                    .addComponent(descriptionField)
                    .addComponent(characteristicBox, 0, 177, Short.MAX_VALUE)
                    .addComponent(wingspanField)
                    .addComponent(nameField)
                    .addComponent(treasuresField))
                .addContainerGap(99, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 184, Short.MAX_VALUE)
                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(coordsXLabel)
                    .addComponent(coordsXField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(coordsYLabel)
                    .addComponent(coordsYField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ageLabel)
                    .addComponent(ageField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descriptionLabel)
                    .addComponent(descriptionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(characteristicLabel)
                    .addComponent(characteristicBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(wingspanLabel)
                    .addComponent(wingspanField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(treasuresLabel)
                    .addComponent(treasuresField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(cancelButton))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelButtonMouseClicked
        dispose();
    }//GEN-LAST:event_cancelButtonMouseClicked

    private void saveButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveButtonMouseClicked
        Dragon dragon = model;
        try {
            dragon.setName(nameField.getText());
            Coordinates coordinates = new Coordinates(
                    Long.valueOf(coordsXField.getText()),
                    Double.parseDouble(coordsYField.getText().replace(",", "."))
            );
            dragon.setCoordinates(coordinates);
            dragon.setAge(Integer.valueOf(ageField.getText()));
            dragon.setDescription(descriptionField.getText());
            dragon.setCharacter(DragonCharacter.values()[characteristicBox.getSelectedIndex()]);
            dragon.setWingspan(Double.valueOf(wingspanField.getText().replace(",", ".")));
            dragon.setCave(new DragonCave(Long.parseLong(treasuresField.getText())));
            
            dragon = new Dragon(dragon.getId(), dragon.getName(), dragon.getCoordinates(), dragon.getCreationDate(), dragon.getAge(), dragon.getDescription(), dragon.getWingspan(), dragon.getCharacter(), dragon.getCave(), dragon.getOwner());
        } catch(IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, LocaleController.get("ITEM_SAVE_ERROR")+ex.getMessage(), LocaleController.get("ERROR_HEADER"), JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            dragon.setOwner(Main.getCurrentUser());
            if(modelId < 0)
                Main.getCollectionController().add(dragon);
            else
                Main.getCollectionController().updateById(modelId, dragon);
            JOptionPane.showMessageDialog(this, modelId < 0 ? LocaleController.get("ITEM_SAVE_ADD") : LocaleController.get("ITEM_SAVE_UPDATE"), LocaleController.get("SUCCESS_HEADER"), JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } catch(Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, LocaleController.get("SERVER_CONNECTION_ERROR"), LocaleController.get("ERROR_HEADER"), JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_saveButtonMouseClicked

    public static void main(int args) {
        if(instance != null) {
            instance.modelId = args;
            instance.loadModel();
            instance.toFront();
            return;
        }
        instance = new ItemView(args);
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ItemView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ItemView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ItemView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ItemView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    instance.setVisible(true);
                } catch(Exception ex) {}
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField ageField;
    private javax.swing.JLabel ageLabel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JComboBox<String> characteristicBox;
    private javax.swing.JLabel characteristicLabel;
    private javax.swing.JFormattedTextField coordsXField;
    private javax.swing.JLabel coordsXLabel;
    private javax.swing.JFormattedTextField coordsYField;
    private javax.swing.JLabel coordsYLabel;
    private javax.swing.JTextField descriptionField;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JFormattedTextField treasuresField;
    private javax.swing.JLabel treasuresLabel;
    private javax.swing.JFormattedTextField wingspanField;
    private javax.swing.JLabel wingspanLabel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void updateLocale() {
        try {
            ImageIcon icon = new ImageIcon(getClass().getResource("/resources/dragon/head.png"));
            setIconImage(icon.getImage());
            setTitle(LocaleController.get("ITEM_TITLE_ADD"));
            titleLabel.setText(LocaleController.get("ITEM_TITLE_ADD"));
            if(modelId > -1)
                if(model.getOwner().getId() != Main.getCurrentUser().getId()) {
                    titleLabel.setText(LocaleController.get("ITEM_TITLE_WATCH"));
                    setTitle(LocaleController.get("ITEM_TITLE_WATCH"));
                }
                else {
                    titleLabel.setText(LocaleController.get("ITEM_TITLE_UPDATE"));
                    setTitle(LocaleController.get("ITEM_TITLE_UPDATE"));
                }
            nameLabel.setText(LocaleController.get("DRAGON_NAME")+": ");
            coordsXLabel.setText(LocaleController.get("DRAGON_COORDINATES")+", X:");
            coordsYLabel.setText(LocaleController.get("DRAGON_COORDINATES")+", Y:");
            ageLabel.setText(LocaleController.get("DRAGON_AGE")+": ");
            descriptionLabel.setText(LocaleController.get("DRAGON_DESCRIPTION")+": ");
            characteristicLabel.setText(LocaleController.get("DRAGON_CHARACTER")+": ");
            wingspanLabel.setText(LocaleController.get("DRAGON_WINGSPAN")+": ");
            treasuresLabel.setText(LocaleController.get("DRAGON_TREASURES")+": ");
            saveButton.setText(LocaleController.get("SAVE"));
            cancelButton.setText(LocaleController.get("CLOSE"));
            int selected = characteristicBox.getSelectedIndex();
            characteristicBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {
                    LocaleController.get("DRAGON_CHARACTER_CUNNING"),
                    LocaleController.get("DRAGON_CHARACTER_WISE"),
                    LocaleController.get("DRAGON_CHARACTER_GOOD"),
                    LocaleController.get("DRAGON_CHARACTER_FICKLE")
            }));
            characteristicBox.setSelectedIndex(selected);
        } catch(Exception ex) {
            setVisible(false);
            dispose();
            return;
        }
    }
    
    public void loadModel() {
        titleLabel.setText(LocaleController.get("ITEM_TITLE_ADD"));
        nameField.setText("");
        coordsXField.setText("");
        coordsYField.setText("");
        ageField.setText("");
        descriptionField.setText("");
        characteristicBox.setSelectedIndex(0);
        wingspanField.setText("");
        treasuresField.setText("");
        nameField.setEnabled(true);
        coordsXField.setEnabled(true);
        coordsYField.setEnabled(true);
        ageField.setEnabled(true);
        descriptionField.setEnabled(true);
        characteristicBox.setEnabled(true);
        wingspanField.setEnabled(true);
        treasuresField.setEnabled(true);
        saveButton.setEnabled(true);
        model = new Dragon();
        if(modelId < 0) return;
        try {
            model = Main.getCollectionController().getById(modelId);
            if(model == null) throw new IllegalArgumentException();
        } catch(Exception ex) {
            setVisible(false);
            dispose();
            return;
        }
        titleLabel.setText(LocaleController.get("ITEM_TITLE_UPDATE"));
        nameField.setText(model.getName());
        coordsXField.setText((model.getCoordinates().getX()+"").replaceAll("\\.", ","));
        coordsYField.setText((model.getCoordinates().getY()+"").replaceAll("\\.", ","));
        ageField.setText(model.getAge()+"");
        descriptionField.setText(model.getDescription());
        characteristicBox.setSelectedIndex(model.getCharacter().ordinal());
        wingspanField.setText(model.getWingspan().toString().replaceAll("\\.", ","));
        treasuresField.setText(model.getCave().getNumberOfTreasures()+"");
        if(model.getOwner().getId() != Main.getCurrentUser().getId()) {
            titleLabel.setText(LocaleController.get("ITEM_TITLE_WATCH"));
            nameField.setEnabled(false);
            coordsXField.setEnabled(false);
            coordsYField.setEnabled(false);
            ageField.setEnabled(false);
            descriptionField.setEnabled(false);
            characteristicBox.setEnabled(false);
            wingspanField.setEnabled(false);
            treasuresField.setEnabled(false);
            saveButton.setEnabled(false);
        }
    }
}
