package lab6.controllers.locale;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public abstract class AbstractLocale {
    private String name = "";
    private Map<String, String> data = new HashMap<>();
    public String getKey(String key) {
        if(!data.containsKey(key)) return null;
        return data.get(key);
    }
    public void addKey(String key, String value) {
        data.put(key, value);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Locale getLocale() {return null;};
}
