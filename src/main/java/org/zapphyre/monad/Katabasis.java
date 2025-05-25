package org.zapphyre.monad;

import lombok.Value;
import org.zapphyre.intf.ConfigNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Value
/*
* 	“Descent into the underworld” – elegant metaphor for going deep into object graphs.
*   Greek Mythology Inspired
* */
public class Katabasis<T extends ConfigNode> {

    T node;
    List<Map<String, String>> settings;

    public Katabasis(T root, List<Map<String, String>> priorites) {
        this.node = root;
        this.settings = priorites;
        this.settings.add(root.getProperties());
    }

    public Katabasis(T node) {
        this(node, new ArrayList<>());
    }

    public <R extends ConfigNode> Katabasis<R> deepens(Function<? super T, ? extends R> nextLevelMapper) {
        R apply = nextLevelMapper.apply(node);

//        ArrayList<Map<String, String>> list = new ArrayList<>(settings);
//        list.add(apply.getProperties());

        return new Katabasis<>(apply, settings);
    }

    public Map<String, String> resolveSettings() {
        return settings.stream()
//                .flatMap(map -> map.entrySet().stream())
//                .collect(Collectors.toMap(
//                        Map.Entry::getKey,
//                        Map.Entry::getValue,
//                        (v1, v2) -> v2, // Merge function: keep the latest value for duplicate keys
//                        HashMap::new
//                ));
                .reduce(new HashMap<>(), (acc, map) -> {
                    acc.putAll(map);
                    return acc;
                });
    }
}