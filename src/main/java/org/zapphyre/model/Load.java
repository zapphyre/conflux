package org.zapphyre.model;

import lombok.Builder;
import lombok.Value;
import org.zapphyre.intf.Configurator;

import java.util.Map;

@Value
@Builder
public class Load implements Configurator {

    @Override
    public Map<String, String> getProperties() {
        return Map.of(
                "Highway", "high_val1",
                "merge1", "overriden_val"
        );
    }
}
