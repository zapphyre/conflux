package org.zapphyre;

import org.zapphyre.model.*;
import org.zapphyre.monad.Katabasis;

import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Transportation transportation = Transportation.builder().build();

        Katabasis<Load> loadKatabasis = new Katabasis<>(transportation)
                .deepens(Transportation::getHighway)
                .deepens(Highway::getLorry)
                .deepens(Lorry::getLoad);
//                .addSupplier(Transportation::getRailway)
//                .addSupplier(Railway::getTrain)
//                .addSupplier(Train::getLoad);

        Map<String, String> stringStringMap = loadKatabasis.resolveSettings();
    }
}
