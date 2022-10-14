package dev.shtanko.multithreading.monitor;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class FinalMap {
    private final ConcurrentHashMap<Long, Long> locations;
    private final Map<Long, Long> unmodifiableMap;

    public FinalMap(ConcurrentHashMap<Long, Long> points) {
        locations = new ConcurrentHashMap<>(points);
        unmodifiableMap = Collections.unmodifiableMap(locations);
    }

    public Map<Long, Long> getLocations() {
        return unmodifiableMap;
        // return Collections.unmodifiableMap(new HashMap<>(locations));
    }

    public Long getLocation(Long i) {
        return locations.get(i);
    }

    public void setLocation(Long x, Long y) {
        if (locations.replace(x, y) == null) {
            throw new IllegalArgumentException("invalid arguments: " + x + " " + y);
        }
    }
}
