package org.zapphyre.model;

import org.zapphyre.intf.Configurator;

import java.util.Map;

public class Traject implements Configurator {

    Load load;

    @Override
    public Map<String, String> getProperties() {
        return Map.of();
    }
}
