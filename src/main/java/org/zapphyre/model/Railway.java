package org.zapphyre.model;

import org.zapphyre.intf.Configurator;

import java.util.Map;

public class Railway implements Configurator {

    Train train;

    @Override
    public Map<String, String> getProperties() {
        return Map.of();
    }
}
