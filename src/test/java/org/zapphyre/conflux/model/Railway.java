package org.zapphyre.conflux.model;

import lombok.Builder;
import lombok.Value;
import org.zapphyre.conflux.intf.ConfigNode;

import java.util.Map;

@Value
@Builder
public class Railway implements ConfigNode {

    Train train = Train.builder().build();

    @Override
    public Map<String, String> getConfig() {
        return Map.of("railway", "railroad");
    }
}
