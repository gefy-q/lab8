package lab6.controllers.locale;

import java.util.Locale;
import java.util.ResourceBundle;

public class PtLocale extends AbstractLocale {
    ResourceBundle bundle = null;
    public PtLocale() {
        this.setName("pt");
        bundle = ResourceBundle.getBundle("resources/locale/pt_pt");
    }
    @Override
    public String getKey(String key) {
        return bundle.getString(key);
    }
    @Override
    public Locale getLocale() {
        return new Locale("pt");
    }
}
