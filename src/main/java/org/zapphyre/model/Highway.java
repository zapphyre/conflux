package org.zapphyre.model;

import lombok.Builder;
import lombok.Value;
import org.zapphyre.intf.Configurator;

import java.util.Map;

@Value
@Builder
public class Highway implements Configurator {

    Car car;

    @Builder.Default
    Lorry lorry = Lorry.builder().build();

    @Override
    public Map<String, String> getProperties() {
        return Map.of(
                "Highway", "high_val1",
                "merge2", "merge_val2"
        );
    }
}
