package org.zapphyre.model;

import lombok.Builder;
import lombok.Value;
import org.zapphyre.intf.ConfigNode;

import java.util.Map;

@Value
@Builder
public class Highway implements ConfigNode {

    @Builder.Default
    Car car = Car.builder().build();

    @Builder.Default
    Forklift forklift = Forklift.builder().build();

    @Builder.Default
    Lorry lorry = Lorry.builder().build();

    @Override
    public Map<String, String> getConfig() {
        return Map.of(
                "Highway", "high_val1",
                "merge2", "merge_val2"
        );
    }
}
