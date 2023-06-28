package lab6.model;

import java.io.Serializable;
import java.text.NumberFormat;
import lab6.Main;

public class Coordinates implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;
    private final Long x;
    private final double y;

    public Coordinates(Long x, double y) {
        if (x == null) {
            throw new NullPointerException("X coordinate cannot be null");
        }

        this.x = x;
        this.y = y;
    }

    public Long getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return x + ", " + NumberFormat.getNumberInstance(Main.getLocaleController().getLocale().getLocale()).format(y);
    }
}
