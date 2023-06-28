package lab6.controllers;

import lab6.Main;
import lab6.controllers.locale.AbstractLocale;
import lab6.controllers.locale.RuLocale;

public class LocaleController {
    private AbstractLocale locale;
    public LocaleController() {
        locale = new RuLocale();
    }
    public AbstractLocale getLocale() {
        return locale;
    }
    public void setLocale(AbstractLocale locale) {
        this.locale = locale;
    }
    public static String get(String key) {
        return Main.getLocaleController().getLocale().getKey(key);
    }
}
