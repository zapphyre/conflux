package org.zapphyre.conflux.model;

import lombok.Builder;
import lombok.Value;
import org.zapphyre.conflux.intf.ConfigNode;

import java.util.Map;

@Value
@Builder
public class Load implements ConfigNode {

    @Override
    public Map<String, String> getConfig() {
        return Map.of(
                "Highway", "overriden_val",
                "merge1", "overriden_val"
        );
    }
}
