package tests.Scheduler;

import Sheduler.Config;
import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class ConfigTest {
    @Test
    public void testConfig() {
        Date date = new Date();
        Config config = new Config("configPath", "storagePath", "backupPath", date, date, 1);

        // Test getters
        assertEquals("configPath", config.getConfigFilePath());
        assertEquals("storagePath", config.getStorageFilePath());
        assertEquals("backupPath", config.getBackupFilePath());
        assertEquals(date, config.getLastDateOpened());
        assertEquals(date, config.getBackupDate());
        assertEquals(1, config.getOpenNumber());

        // Test setters
        Date newDate = new Date();
        config.setConfigFilePath("newConfigPath");
        config.setStorageFilePath("newStoragePath");
        config.setBackupFilePath("newBackupPath");
        config.setLastDateOpened(newDate);
        config.setBackupDate(newDate);
        config.setOpenNumber(2);

        assertEquals("newConfigPath", config.getConfigFilePath());
        assertEquals("newStoragePath", config.getStorageFilePath());
        assertEquals("newBackupPath", config.getBackupFilePath());
        assertEquals(newDate, config.getLastDateOpened());
        assertEquals(newDate, config.getBackupDate());
        assertEquals(2, config.getOpenNumber());

        // Test null values
        config.setConfigFilePath(null);
        config.setStorageFilePath(null);
        config.setBackupFilePath(null);
        config.setLastDateOpened(null);
        config.setBackupDate(null);

        assertNull(config.getConfigFilePath());
        assertNull(config.getStorageFilePath());
        assertNull(config.getBackupFilePath());
        assertNull(config.getLastDateOpened());
        assertNull(config.getBackupDate());

        // Test invalid openNumber
        assertThrows(IllegalArgumentException.class, () -> config.setOpenNumber(-1));
    }
}

