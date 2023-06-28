package lab6.controllers.locale;

import java.util.Locale;
import java.util.ResourceBundle;

public class EsLocale extends AbstractLocale {
    ResourceBundle bundle = null;
    public EsLocale() {
        this.setName("es");
        bundle = ResourceBundle.getBundle("resources/locale/es_pr");
    }
    @Override
    public String getKey(String key) {
        return bundle.getString(key);
    }
    @Override
    public Locale getLocale() {
        return new Locale("es-PR");
    }
}
