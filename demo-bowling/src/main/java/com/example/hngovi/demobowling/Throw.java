package com.example.hngovi.demobowling;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class Throw {

    private static final Random fate = new Random();

    private int pins;

    public void knockdown() {
        pins = fate.nextInt(10);
        log.info(pins + " knocked down...");
    }
}
