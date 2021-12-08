package com.gkg.bridge.poc.configuration;

import net.openhft.affinity.AffinityLock;
import org.springframework.context.annotation.Configuration;

import java.util.BitSet;

@Configuration
public class AffinityConfiguration {

    public AffinityLock acquireLock(String desc) {
        return AffinityLock.acquireLock(desc);
    }

    /**
     * [DE20210409] Reserved (Isolated) CPU Id List on the machine.
     * Example: 2, 3, 4, 5
     *
     * @return
     */
    public BitSet getReservedAffinity() {
        return AffinityLock.RESERVED_AFFINITY;
    }

    /**
     * [DE20210409] CPU List of the machine.
     * Example: 0, 1, 2, 3, 4, 5
     *
     * @return BitSet including the list of cpu Ids on the machine.
     */
    public BitSet getBaseAffinity() {
        return AffinityLock.BASE_AFFINITY;
    }

}
