package lab6.view.component;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.geom.AffineTransform;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;
import lab6.model.Dragon;
import lab6.model.ItemAnimation;

public class VisualizationPanel extends JPanel {
    private List<Dragon> dragons;
    private Map<Integer, ItemAnimation> drawingById;
    private Graphics2D g2d = null;
    private Timer timer;
    public VisualizationPanel(List<Dragon> data) {
        this.dragons = data;
        drawingById = new HashMap<>();
        updatePanelData();
        setPreferredSize(new Dimension(600,600));
        timer = new Timer(25, (ActionEvent e) -> {
            if(g2d == null) return;
            repaint();
        });
        timer.start();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.g2d = (Graphics2D) g;
        drawElements();
    }
    public void updatePanelData() {
        for(Dragon dragon : dragons)
            if(!drawingById.containsKey(dragon.getId()))
                drawingById.put(dragon.getId(), new ItemAnimation(dragon));
    }
    public void drawElements() {
        try {
            drawingById.forEach((id, d) -> d.updateAnimation(new ArrayList<>(drawingById.values())));
            drawingById.forEach((id, d) -> 
                drawingById.forEach((ido, o) -> {
                    if(d.checkCollision(o)) {
                        o.setAlive(false);
                        d.setSize(d.getSize()+o.getSize()/2);
                    }
                })
            );
            for(Integer dragonId : drawingById.keySet()) {
                if(!drawingById.get(dragonId).isAlive()) drawingById.remove(dragonId);
                else {
                    drawDragon(drawingById.get(dragonId));
                }
            }
        } catch(Exception ex) {}
    }
    public Dragon getById(int id) {
        return dragons.stream().filter(o -> o.getId() == id).findFirst().get();
    }
    public void drawDragon(ItemAnimation animation) {
        try {
            Image body = ImageIO.read(getClass().getResource("/resources/dragon/body.png")).getScaledInstance(animation.getSize(), animation.getSize(), Image.SCALE_SMOOTH);
            g2d.drawImage(body, animation.getX(), animation.getY(), null);
            
            Image head = ImageIO.read(getClass().getResource("/resources/dragon/head.png")).getScaledInstance(animation.getSize(), animation.getSize(), Image.SCALE_SMOOTH);
            double rotationAngleRadians = Math.toRadians(animation.getAngle()*45-90);
            
            AffineTransform transform = new AffineTransform();
            transform.translate(animation.getX() + animation.getSize() * 0.2, animation.getY() - + animation.getSize() * 0.15);
            transform.rotate(rotationAngleRadians, animation.getSize() / 2.0, animation.getSize() / 2.0);

            g2d.drawImage(head, transform, null);
        } catch (IOException ex) {
            Logger.getLogger(VisualizationPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Timer getTimer() {
        return timer;
    }
    public void setDragons(List<Dragon> organizations) {
        this.dragons = organizations;
    }
}
