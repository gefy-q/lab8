package lab6.controllers.locale;

import java.util.Locale;
import java.util.ResourceBundle;

public class ItLocale extends AbstractLocale {
    ResourceBundle bundle = null;
    public ItLocale() {
        this.setName("it");
        bundle = ResourceBundle.getBundle("resources/locale/it_it");
    }
    @Override
    public String getKey(String key) {
        return bundle.getString(key);
    }
    @Override
    public Locale getLocale() {
        return new Locale("it");
    }
}
