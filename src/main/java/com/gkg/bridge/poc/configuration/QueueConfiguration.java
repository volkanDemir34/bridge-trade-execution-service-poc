package com.gkg.bridge.poc.configuration;


import com.conversantmedia.util.concurrent.SpinPolicy;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QueueConfiguration {
    private int capacity = 512;
    private SpinPolicy spinPolicy = SpinPolicy.BLOCKING;
}
