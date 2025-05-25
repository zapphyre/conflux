package org.zapphyre.model;

import lombok.Builder;
import lombok.Value;
import org.zapphyre.intf.Configurator;

import java.util.Map;

@Value
@Builder
public class Railway implements Configurator {

    Train train = Train.builder().build();

    @Override
    public Map<String, String> getProperties() {
        return Map.of("railway", "railroad");
    }
}
