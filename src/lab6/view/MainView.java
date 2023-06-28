package lab6.view;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import lab6.Main;
import lab6.controllers.LocaleController;
import lab6.controllers.locale.ILocaleLoader;
import lab6.model.Dragon;

public class MainView extends javax.swing.JFrame implements ILocaleLoader, ActionListener {
    public static MainView instance = null;
    private List<Dragon> source = new ArrayList<>();
    private List<Dragon> showed = new ArrayList<>();
    private Timer timer = null;
    private boolean timerActive = true;
    private int sortColumn = -1;
    private boolean sortColumnReversed = false;
    public MainView() {
        initComponents();
        additionalInit();
        updateLocale();
        loadData();
        timer = new Timer(200, this);
        timer.start();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        collectionTable = new javax.swing.JTable();
        userLabel = new javax.swing.JLabel();
        createButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        filterLabel = new javax.swing.JLabel();
        filterBox = new javax.swing.JComboBox<>();
        filterLabelDot = new javax.swing.JLabel();
        filterField = new javax.swing.JTextField();
        commandsButton = new javax.swing.JButton();
        visualizeButton = new javax.swing.JButton();
        languageButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Список драконов");
        setResizable(false);

        collectionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Название", "Координаты", "Дата создания", "Возраст", "Описание", "Размах", "Характеристика", "Пещера", "Владелец"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(collectionTable);

        userLabel.setText("Вы авторизовались как {USER}");

        createButton.setText("Создать");
        createButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                createButtonMouseClicked(evt);
            }
        });

        editButton.setText("Изменить");
        editButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editButtonMouseClicked(evt);
            }
        });

        deleteButton.setText("Удалить");
        deleteButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteButtonMouseClicked(evt);
            }
        });

        filterLabel.setText("Фильтрация по");

        filterBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        filterLabelDot.setText(":");

        filterField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                filterFieldKeyPressed(evt);
            }
        });

        commandsButton.setText("Команды");
        commandsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                commandsButtonMouseClicked(evt);
            }
        });

        visualizeButton.setText("Визуализация");
        visualizeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                visualizeButtonMouseClicked(evt);
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 859, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(createButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(visualizeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(commandsButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(languageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(userLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filterLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filterBox, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filterLabelDot)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filterField)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(userLabel)
                        .addComponent(filterLabel)
                        .addComponent(filterBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(filterLabelDot)
                        .addComponent(filterField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(languageButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createButton)
                    .addComponent(editButton)
                    .addComponent(deleteButton)
                    .addComponent(commandsButton)
                    .addComponent(visualizeButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createButtonMouseClicked
        ItemView.main(-1);
    }//GEN-LAST:event_createButtonMouseClicked

    private void filterFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filterFieldKeyPressed
        applyFilters();
    }//GEN-LAST:event_filterFieldKeyPressed

    private void commandsButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_commandsButtonMouseClicked
        CommandsView.main(null);
    }//GEN-LAST:event_commandsButtonMouseClicked

    private void visualizeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_visualizeButtonMouseClicked
        if(VisualizationView.instance != null)
            VisualizationView.instance.toFront();
        else
            VisualizationView.main(source);
    }//GEN-LAST:event_visualizeButtonMouseClicked

    private void editButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editButtonMouseClicked
        if(collectionTable.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(collectionTable, LocaleController.get("TABLE_CHOOSE_EDIT"));
            return;
        }
        Dragon clicked = showed.get(collectionTable.getSelectedRow());
        if(clicked.getOwner().getId() != Main.getCurrentUser().getId()) {
            JOptionPane.showMessageDialog(collectionTable, LocaleController.get("TABLE_EDIT_FAIL"), LocaleController.get("ERROR_HEADER"), JOptionPane.ERROR_MESSAGE);
            return;
        }
        ItemView.main(clicked.getId());
    }//GEN-LAST:event_editButtonMouseClicked

    private void deleteButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButtonMouseClicked
        if(collectionTable.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(collectionTable, LocaleController.get("TABLE_CHOOSE_DELETE"));
            return;
        }
        Dragon clicked = showed.get(collectionTable.getSelectedRow());
        if(clicked.getOwner().getId() != Main.getCurrentUser().getId()) {
            JOptionPane.showMessageDialog(collectionTable, LocaleController.get("TABLE_DELETE_FAIL"), LocaleController.get("ERROR_HEADER"), JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            Main.getCollectionController().removeById(clicked.getId());
            JOptionPane.showMessageDialog(collectionTable, LocaleController.get("TABLE_DELETE_SUCCESS"));
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(this, LocaleController.get("SERVER_CONNECTION_ERROR"), LocaleController.get("ERROR_HEADER"), JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_deleteButtonMouseClicked

    private void languageButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_languageButtonMouseClicked
        LanguageView.main(null);
    }//GEN-LAST:event_languageButtonMouseClicked

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                instance = new MainView();
                instance.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable collectionTable;
    private javax.swing.JButton commandsButton;
    private javax.swing.JButton createButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.JComboBox<String> filterBox;
    private javax.swing.JTextField filterField;
    private javax.swing.JLabel filterLabel;
    private javax.swing.JLabel filterLabelDot;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton languageButton;
    private javax.swing.JLabel userLabel;
    private javax.swing.JButton visualizeButton;
    // End of variables declaration//GEN-END:variables

    @Override
    public void updateLocale() {
        ImageIcon icon = new ImageIcon(getClass().getResource("/resources/dragon/head.png"));
        setIconImage(icon.getImage());
        setTitle(LocaleController.get("TABLE_TITLE"));

        filterLabel.setText(LocaleController.get("TABLE_FILTER"));
        createButton.setText(LocaleController.get("TABLE_CREATE_BUTTON"));
        editButton.setText(LocaleController.get("TABLE_EDIT_BUTTON"));
        deleteButton.setText(LocaleController.get("TABLE_DELETE_BUTTON"));
        commandsButton.setText(LocaleController.get("TABLE_COMMANDS_BUTTON"));
        visualizeButton.setText(LocaleController.get("TABLE_VISUALIZE_BUTTON"));
        collectionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                LocaleController.get("DRAGON_NAME"),
                LocaleController.get("DRAGON_COORDINATES"),
                LocaleController.get("DRAGON_CREATION_DATE"),
                LocaleController.get("DRAGON_AGE"),
                LocaleController.get("DRAGON_DESCRIPTION"),
                LocaleController.get("DRAGON_WINGSPAN"),
                LocaleController.get("DRAGON_CHARACTER"),
                LocaleController.get("DRAGON_TREASURES"),
                LocaleController.get("DRAGON_OWNER")
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        List<String> columns = new ArrayList<>();
        for(int i = 0; i < collectionTable.getModel().getColumnCount(); i++)
            columns.add(collectionTable.getModel().getColumnName(i));
        filterBox.setModel(new javax.swing.DefaultComboBoxModel<>(columns.toArray(String[]::new)));
        userLabel.setText(LocaleController.get("TABLE_USER").replace("{USER}", Main.getCurrentUser().getUsername()));
        jScrollPane1.setViewportView(collectionTable);
    }
    
    public void loadData() {
        try {
            Main.getCollectionController().updateCollection();
            source = (ArrayList<Dragon>)Main.getCollectionController().toList();
            applyFilters();
        } catch(Exception ex) {
            timerActive = false;
            JOptionPane.showMessageDialog(this, LocaleController.get("SERVER_CONNECTION_ERROR"), LocaleController.get("ERROR_HEADER"), JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void additionalInit() {
        collectionTable.getTableHeader().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent event) {
                Point point = event.getPoint();
                int column = collectionTable.columnAtPoint(point);
                if(column == sortColumn)
                    sortColumnReversed = !sortColumnReversed;
                else {
                    sortColumn = column;
                    sortColumnReversed = false;
                }
                applyFilters();
            }
        });
        filterBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                applyFilters();
            }
        });
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                timer.stop();
            }
        });
    }
    public void applyFilters() {
        showed.clear();
        for(Object o : source.stream()
                .filter(o -> getSortedFieldString(o, filterBox.getSelectedIndex()).toLowerCase().contains(filterField.getText().toLowerCase()))
                .sorted(Comparator.comparing(o -> sortColumn < 0 ? (float)o.getId() : getSortedFieldFloat(o, sortColumn)))
                .toArray()) {
            showed.add((Dragon) o);
        }
        if(sortColumnReversed)
            Collections.reverse(showed);
        int selectedRow = collectionTable.getSelectedRow();
        ((DefaultTableModel)collectionTable.getModel()).setRowCount(0);
        for(Dragon dragon : showed) {
                ((DefaultTableModel)collectionTable.getModel()).addRow(new Object[] {
                    dragon.getName(),
                    dragon.getCoordinates(),
                    dragon.getCreationDate().toLocalDate().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).withLocale(Main.getLocaleController().getLocale().getLocale())),
                    dragon.getAge(),
                    dragon.getDescription(),
                    NumberFormat.getNumberInstance(Main.getLocaleController().getLocale().getLocale()).format(dragon.getWingspan().doubleValue()),
                    dragon.getCharacter(),
                    dragon.getCave(),
                    dragon.getOwner()
                });
        }
        if(selectedRow > -1 && selectedRow < ((DefaultTableModel)collectionTable.getModel()).getRowCount())
            collectionTable.setRowSelectionInterval(selectedRow, selectedRow);
    }
    public String getSortedFieldString(Dragon dragon, int column) {
        switch (column) {
            case 0:
                return dragon.getName();
            case 1:
                return dragon.getCoordinates().toString();
            case 2:
                return dragon.getCreationDate().toLocalDate().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).withLocale(Main.getLocaleController().getLocale().getLocale()));
            case 3:
                return dragon.getAge().toString();
            case 4:
                return dragon.getDescription();
            case 5:
                return NumberFormat.getNumberInstance(Main.getLocaleController().getLocale().getLocale()).format(dragon.getWingspan().doubleValue());
            case 6:
                return dragon.getCharacter().toString();
            case 7:
                return dragon.getCave().toString();
            case 8:
                return dragon.getOwner().toString();
        }
        return dragon.toString();
    }
    public float getSortedFieldFloat(Dragon dragon, int column) {
        switch (column) {
            case 0:
                return dragon.getName().length();
            case 1:
                return (float)dragon.getCoordinates().getX() + (float)dragon.getCoordinates().getY();
            case 2:
                {
                    try {
                        return new SimpleDateFormat("yyyy-MM-dd").parse(dragon.getCreationDate().toString().split("T")[0]).getTime();
                    } catch (Exception ex) {
                        return 0;
                    }
                }
            case 3:
                return dragon.getAge();
            case 4:
                return dragon.getDescription().length();
            case 5:
                return dragon.getWingspan().floatValue();
            case 6:
                return dragon.getCharacter().ordinal();
            case 7:
                return dragon.getCave().getNumberOfTreasures();
            case 8:
                return dragon.getOwner().getId();
        }
        return dragon.getId();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(!timerActive) return;
        loadData();
    }
}
