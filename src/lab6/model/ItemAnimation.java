package lab6.model;

import java.util.List;
import java.util.Objects;
import java.util.Random;

public class ItemAnimation {
    private Dragon dragon;
    private int x;
    private int y;
    private int size;
    private int angle;
    private boolean alive = true;
    private int i = 0;
    public ItemAnimation(Dragon dragon) {
        x = 10+(new Random()).nextInt(580);
        y = 10+(new Random()).nextInt(580);
        size = 30;
        angle = (new Random()).nextInt(8);
        this.dragon = dragon;
    }
    public void updateAnimation(List<ItemAnimation> allDragons) {
        i++;
        if(i%4 == 0) {
            angle++;
            i = 0;
        }
        if(angle >= 8) angle = 0;
        ItemAnimation target = findNearbyDragon(allDragons);
        if(target != null) {
            if(target.x > x)
                x += 2;
            else if (target.x < x)
                x -= 2;
            if(target.y > y)
                y += 2;
            else if (target.y < y)
                y -= 2;
        } else {
            x += Math.random() > 0.5 ? 1 : -1;
            y += Math.random() > 0.5 ? 1 : -1;
        }
        if(x < 0) x = 0;
        if(y < 0) y = 0;
        if(x > 600-size) x = 600-size;
        if(y > 600-size) y = 600-size;
    }
    public double calculateDistance(ItemAnimation otherDragon) {
        return Math.sqrt(
                Math.pow(x-otherDragon.x, 2)
                +
                Math.pow(y-otherDragon.y, 2)
        );
    }
    public ItemAnimation findNearbyDragon(List<ItemAnimation> allDragons) {
        double minDistance = Double.MAX_VALUE;
        ItemAnimation result = null;
        for(ItemAnimation item : allDragons) {
            if(Objects.equals(item.dragon.getId(), dragon.getId())) continue;
            double distance = calculateDistance(item);
            if(distance < minDistance) {
                minDistance = distance;
                result = item;
            }
        }
        return result;
    }
    
    public boolean checkCollision(ItemAnimation target) {
        if(Objects.equals(dragon.getId(), target.dragon.getId())) return false;
        if(!alive) return false;
        boolean bottomRight = checkDotInBox(target.x, target.y, x, y, size);
        boolean bottomLeft = checkDotInBox(target.x + target.size, target.y, x, y, size);
        boolean topRight = checkDotInBox(target.x, target.y + target.size, x, y, size);
        boolean topLeft = checkDotInBox(target.x + target.size, target.y + target.size, x, y, size);
        return ((angle == 0 && (topLeft || topRight)) ||
                (angle == 1 && topRight) ||
                (angle == 2 && (topRight || bottomRight)) ||
                (angle == 3 && bottomRight) ||
                (angle == 4 && (bottomLeft || bottomRight)) ||
                (angle == 5 && bottomLeft) ||
                (angle == 6 && (bottomLeft || topLeft)) ||
                (angle == 7 && topLeft)) && size >= target.size;
    }
    
    public static boolean checkDotInBox(int x, int y, int boxX, int boxY, int size) {
        return boxX <= x && x <= boxX+size &&
                boxY <= y && y <= boxY+size;
    }

    public Dragon getDragon() {
        return dragon;
    }

    public void setDragon(Dragon dragon) {
        this.dragon = dragon;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
    
}
