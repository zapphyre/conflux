package org.zapphyre.model;

import lombok.Builder;
import lombok.Value;
import org.zapphyre.intf.ConfigNode;

import java.util.Map;

@Value
@Builder
public class Railway implements ConfigNode {

    Train train = Train.builder().build();

    @Override
    public Map<String, String> getProperties() {
        return Map.of("railway", "railroad");
    }
}
