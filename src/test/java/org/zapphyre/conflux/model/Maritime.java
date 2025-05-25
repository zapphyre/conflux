package org.zapphyre.conflux.model;

import org.zapphyre.conflux.intf.ConfigNode;

import java.util.Map;

public class Maritime implements ConfigNode {

    CruiseShip cruiseShip;
    Traject traject;

    @Override
    public Map<String, String> getConfig() {
        return Map.of();
    }
}
