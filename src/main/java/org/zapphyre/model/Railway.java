package org.zapphyre.model;

import lombok.Value;
import org.zapphyre.intf.Configurator;

import java.util.Map;

@Value
public class Railway implements Configurator {

    Train train;

    @Override
    public Map<String, String> getProperties() {
        return Map.of();
    }
}
