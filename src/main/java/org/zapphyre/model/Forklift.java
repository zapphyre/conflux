package org.zapphyre.model;

import lombok.Builder;
import lombok.Value;
import org.zapphyre.intf.ConfigNode;

import java.util.Map;

@Value
@Builder
public class Forklift implements ConfigNode {

    @Builder.Default
    Load load = Load.builder().build();

    @Override
    public Map<String, String> getProperties() {
        return Map.of();
    }
}
