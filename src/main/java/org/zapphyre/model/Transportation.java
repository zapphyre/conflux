package org.zapphyre.model;

import lombok.Builder;
import lombok.Value;
import org.zapphyre.intf.ConfigNode;

import java.util.Map;

@Value
@Builder
public class Transportation implements ConfigNode {

    @Builder.Default
    Highway highway = Highway.builder().build();
    Railway railway = Railway.builder().build();
    Airway airway;

    @Override
    public Map<String, String> getProperties() {
        return Map.of(
                "transp", "val1",
                "qwer", "val1",
                "merge1", "merge_val1"
        );
    }
}
