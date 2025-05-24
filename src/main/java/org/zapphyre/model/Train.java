package org.zapphyre.model;

import org.zapphyre.intf.Configurator;

import java.util.Map;

public class Train implements Configurator {

    Load load;

    @Override
    public Map<String, String> getProperties() {
        return Map.of();
    }
}
