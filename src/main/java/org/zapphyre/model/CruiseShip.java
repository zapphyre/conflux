package org.zapphyre.model;

import org.zapphyre.intf.ConfigNode;

import java.util.Map;

public class CruiseShip implements ConfigNode {

    Load load;

    @Override
    public Map<String, String> getProperties() {
        return Map.of();
    }
}
