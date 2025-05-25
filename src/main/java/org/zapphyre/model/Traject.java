package org.zapphyre.model;

import org.zapphyre.intf.ConfigNode;

import java.util.Map;

public class Traject implements ConfigNode {

    Load load;

    @Override
    public Map<String, String> getConfig() {
        return Map.of();
    }
}
