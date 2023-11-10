package com.luv2code.aopdemo.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TrafficFortuneServiceImpl implements TrafficFortuneService {
    @Override
    public String fortune() {

        // simulate a delay.
        try {

            TimeUnit.SECONDS.sleep(5);
        }
        catch (InterruptedException exe) {

            throw new RuntimeException(exe);
        }

        // return the fortune.
        return "Expect heavy traffic in the morning";
    }

    @Override
    public String fortune(boolean tripWire) {

        if (tripWire) {

            throw new RuntimeException("Major accident!! highway is closed");
        }
        return fortune();
    }
}

























