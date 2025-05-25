package org.zapphyre.conflux.model;

import lombok.Builder;
import lombok.Value;
import org.zapphyre.conflux.intf.ConfigNode;

import java.util.Map;

@Value
@Builder
public class Forklift implements ConfigNode {

    @Builder.Default
    Load load = Load.builder().build();

    @Override
    public Map<String, String> getConfig() {
        return Map.of();
    }
}
