package org.zapphyre.model;

import lombok.Value;
import org.zapphyre.intf.Configurator;

import java.util.Map;

@Value
public class Train implements Configurator {

    Load load;

    @Override
    public Map<String, String> getProperties() {
        return Map.of();
    }
}
