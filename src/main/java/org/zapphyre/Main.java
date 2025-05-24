package org.zapphyre;

import org.zapphyre.model.Highway;
import org.zapphyre.model.Load;
import org.zapphyre.model.Lorry;
import org.zapphyre.model.Transportation;
import org.zapphyre.monad.Priorite;

import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Transportation transportation = Transportation.builder().build();

        Priorite<Load> loadPriorite = new Priorite<>(transportation)
                .addSupplier(Transportation::getHighway)
                .addSupplier(Highway::getLorry)
                .addSupplier(Lorry::getLoad);


        Map<String, String> stringStringMap = loadPriorite.scrapeProps();
    }
}
