package org.zapphyre.model;

import org.zapphyre.intf.ConfigNode;

import java.util.Map;

public class Maritime implements ConfigNode {

    CruiseShip cruiseShip;
    Traject traject;

    @Override
    public Map<String, String> getConfig() {
        return Map.of();
    }
}
