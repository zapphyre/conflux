package org.zapphyre.monad;

import org.junit.jupiter.api.Test;
import org.zapphyre.conflux.model.Highway;
import org.zapphyre.conflux.model.Load;
import org.zapphyre.conflux.model.Lorry;
import org.zapphyre.conflux.model.Transportation;
import org.zapphyre.conflux.monad.Katabasis;

import java.util.Map;

public class KatabasisTest {

    @Test
    void testConfigMerge() {
        Transportation transportation = Transportation.builder().build();

        Katabasis<Load> loadKatabasis = Katabasis.configBase(transportation)
                .deepens(Transportation::getHighway)
                .deepens(Highway::getLorry)
                .deepens(Lorry::getLoad);
//                .addSupplier(Transportation::getRailway)
//                .addSupplier(Railway::getTrain)
//                .addSupplier(Train::getLoad);

        Map<String, String> stringStringMap = loadKatabasis.resolve();
    }
}
