package org.zapphyre.conflux.model;

import org.zapphyre.conflux.intf.ConfigNode;

import java.util.Map;

public class JumboJet implements ConfigNode {

    Load load;


    @Override
    public Map<String, String> getConfig() {
        return Map.of();
    }
}
