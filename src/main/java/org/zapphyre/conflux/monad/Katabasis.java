package org.zapphyre.conflux.monad;

import lombok.Value;
import org.zapphyre.conflux.intf.ConfigNode;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/*
 * 	“Descent into the underworld” – elegant metaphor for going deep into object graphs.
 *   Greek Mythology Inspired
 * */
@Value
public class Katabasis<T extends ConfigNode> {

    T node;
    Map<String, String> merged;

    private Katabasis(T root, Map<String, String> configs) {
        this.node = root;
        this.merged = configs;
    }

    Katabasis<T> chained(Map<String, String> old) {
        HashMap<String, String> map = new HashMap<>(old);
        map.putAll(merged);

        return new Katabasis<>(node, map);
    }

    public static <R extends ConfigNode> Katabasis<R> configBase(R root) {
        return new Katabasis<>(root, root.getConfig());
    }

    public <DEEPER extends ConfigNode> Katabasis<DEEPER> deepens(Function<? super T, ? extends DEEPER> nextLevelMapper) {
        DEEPER deeperNode = nextLevelMapper.apply(node);

        return configBase(deeperNode)
                .chained(merged);
    }

    public Map<String, String> resolve() {
        return merged;
    }
}