package org.zapphyre.model;

import lombok.Builder;
import lombok.Value;
import org.zapphyre.intf.ConfigNode;

import java.util.Map;

@Value
@Builder
public class Car implements ConfigNode {

    Load load = Load.builder().build();

    @Override
    public Map<String, String> getConfig() {
        return Map.of();
    }
}
