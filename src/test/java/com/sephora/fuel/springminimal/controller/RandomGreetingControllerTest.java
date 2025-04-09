package com.sephora.fuel.springminimal.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.InjectMocks;
import java.util.Random;

public class RandomGreetingControllerTest {

    private Random r;

    @InjectMocks
    private RandomGreetingController controller;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        r = Mockito.mock(Random.class);
    }

    @Nested
    class Greeting {

        @Test
        public void testRandomOddInteger() {
            Mockito.when(r.nextInt()).thenReturn(1);
            Assertions.assertEquals("Hello World!", controller.greeting(r));
        }

        @Test
        public void testRandomEvenInteger() {
            Mockito.when(r.nextInt()).thenReturn(0);
            Assertions.assertEquals("Hey there!", controller.greeting(r));
        }

    }
}
