package org.zapphyre.monad;

import lombok.Builder;
import lombok.Value;
import lombok.With;
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
//    List<Map<String, String>> settings;
    Map<String, String> merged;

//    public Katabasis(T root, List<Map<String, String>> configs) {
//        this.node = root;
//        this.settings = new ArrayList<>(configs);
//        this.settings.add(root.getConfig());
//    }

    private Katabasis(T root, Map<String, String> configs) {
        this.node = root;
        this.merged = configs;
    }

    public static <Q extends ConfigNode> Katabasis<Q> configBase(Q root) {
        return new Katabasis<>(root, root.getConfig());
    }

//    public Katabasis(T node) {
//        this(node, new ArrayList<>());
//    }

//    public Katabasis(T root) {
//        this(root, merged);
//    }

    Katabasis<T> chained(Map<String, String> old) {

        HashMap<String, String> map = new HashMap<>(old);
        map.putAll(merged);

        return new Katabasis<>(this.node, map);
    }

    public <DEEPER extends ConfigNode> Katabasis<DEEPER> deepens(Function<? super T, ? extends DEEPER> nextLevelMapper) {
        DEEPER deeperNode = nextLevelMapper.apply(node);


//        merged = new HashMap<>(merged);
//        return new Katabasis<>(deeperNode);
//        return new Katabasis<>(deeperNode, merged)
        return configBase(deeperNode)
                .chained(merged);
    }

    public Map<String, String> resolveSettings() {
        return merged;
//        return settings.stream()
////                .flatMap(map -> map.entrySet().stream())
////                .collect(Collectors.toMap(
////                        Map.Entry::getKey,
////                        Map.Entry::getValue,
////                        (v1, v2) -> v2, // Merge function: keep the latest value for duplicate keys
////                        HashMap::new
////                ));
//                .reduce(new HashMap<>(), (acc, map) -> {
//                    acc.putAll(map);
//                    return acc;
//                });
    }
}