package org.zapphyre.model;

import org.zapphyre.intf.Configurator;

import java.util.Map;

public class Maritime implements Configurator {

    CruiseShip cruiseShip;
    Traject traject;

    @Override
    public Map<String, String> getProperties() {
        return Map.of();
    }
}
