package org.zapphyre.model;

import lombok.Builder;
import lombok.Value;
import org.zapphyre.intf.Configurator;

import java.util.Map;

@Value
@Builder
public class Forklift implements Configurator {

    @Builder.Default
    Load load = Load.builder().build();

    @Override
    public Map<String, String> getProperties() {
        return Map.of();
    }
}
