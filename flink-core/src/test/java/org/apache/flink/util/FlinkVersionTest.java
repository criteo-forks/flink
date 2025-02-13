package org.apache.flink.util;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/** Tests for the {@link FlinkVersion}. */
public class FlinkVersionTest extends TestLogger {
    @Test
    public void testGet() {
        String version = FlinkVersion.get();
        assertNotNull(version);
        assertTrue(version.matches("\\d.*"));
    }
}
