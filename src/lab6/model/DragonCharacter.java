package lab6.model;

import java.io.Serializable;
import lab6.Main;
import lab6.controllers.LocaleController;

public enum DragonCharacter implements Serializable {
    CUNNING,
    WISE,
    GOOD,
    FICKLE;
    
    @Override
    public String toString() {
        return LocaleController.get("DRAGON_CHARACTER_"+this.name());
    }
}
