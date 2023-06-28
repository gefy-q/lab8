package lab6.controllers.locale;

import java.util.Locale;
import java.util.ResourceBundle;

public class RuLocale extends AbstractLocale {
    ResourceBundle bundle = null;
    public RuLocale() {
        this.setName("ru");
        bundle = ResourceBundle.getBundle("resources/locale/ru_ru");
    }
    @Override
    public String getKey(String key) {
        return bundle.getString(key);
    }
    @Override
    public Locale getLocale() {
        return new Locale("ru");
    }
}
