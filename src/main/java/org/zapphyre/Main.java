package org.zapphyre;

import org.zapphyre.model.*;
import org.zapphyre.monad.Priorite;

import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Transportation transportation = Transportation.builder().build();

        Priorite<Load> loadPriorite = new Priorite<>(transportation)
//                .addSupplier(Transportation::getHighway)
//                .addSupplier(Highway::getLorry)
//                .addSupplier(Lorry::getLoad);
                .addSupplier(Transportation::getRailway)
                .addSupplier(Railway::getTrain)
                .addSupplier(Train::getLoad);


        Map<String, String> stringStringMap = loadPriorite.scrapeProps();
    }
}
