package org.zapphyre.monad;

import lombok.Value;
import lombok.With;
import org.zapphyre.intf.Configurator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@With
@Value
public class Priorite<T extends Configurator> {

    T root;
    List<Map<String, String>> settings;

    public Priorite(T root, List<Map<String, String>> priorites) {
        this.root = root;
        this.settings = priorites;
    }

    public Priorite(T root) {
        this(root, new ArrayList<>());
    }

    public <R extends Configurator> Priorite<R> addSupplier(Function<? super T, ? extends R> nextLevelMapper) {

        R apply = nextLevelMapper.apply(root);

        ArrayList<Map<String, String>> list = new ArrayList<>(settings);
        list.add(apply.getProperties());

        return new Priorite<>(apply, list);
    }

    public Map<String, String> scrapeProps() {
        return settings.reversed().stream()
                .flatMap(map -> map.entrySet().stream())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (v1, v2) -> v2, // Merge function: keep the latest value for duplicate keys
                        HashMap::new
                ));
//                .reduce(new HashMap<>(), (acc, map) -> {
//                    acc.putAll(map);
//                    return acc;
//                });
    }
}