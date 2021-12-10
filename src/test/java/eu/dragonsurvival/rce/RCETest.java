package eu.dragonsurvival.rce;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RCETest {

    @Test
    void testApp() {
        assertEquals(RCE.fix("a"), "a");
        assertEquals(RCE.fix("a ${a}"), "a a");
        assertEquals(RCE.fix("a ${${a}}"), "a a");
        assertEquals(RCE.fix("a ${${a}} ${x}"), "a a x");
    }
}
