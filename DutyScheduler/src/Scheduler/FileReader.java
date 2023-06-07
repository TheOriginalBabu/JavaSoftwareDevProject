package Scheduler;

import java.io.File;

/**
 * The type File reader. TODO: Add description
 *
 * @author: Griffin, Izaan, Ronit, Shahmeer
 * @date: 2023 -05-17
 * @File: FileReader
 */
public class FileReader {//todo: Error Trapping/Handling
    /**
     * The Config path.
     */
    File configPath;
    /**
     * The Backup path.
     */
    File backUpPath;
    /**
     * The Storage path.
     */
    File storagePath;

    /**
     * Instantiates a new File reader.
     */
    public FileReader(File configFile) {
        this.configPath = configFile;
        //todo: initialize other paths
    }

    /**
     * Read config.
     */
    public void readConfig() {
        //todo: Read config file and assign data to objects
    }

    /**
     * Read backup.
     */
    public void readBackup() {
        //todo: Read backup file, assign data to objects and save to storage
    }

    /**
     * Read storage.
     */
    public void readStorage() {
        //todo: Read storage file and assign data to objects
    }

    /**
     * Get config path File.
     *
     * @return the File
     */
    public File getConfigPath() {
        return configPath;
    }

    /**
     * Get backup path File.
     *
     * @return the File
     */
    public File getBackupPath() {
        return backUpPath;
    }

    /**
     * Get storage path File.
     *
     * @return the File
     */
    public File getStoragePath() {
        return storagePath;
    }

    /**
     * Set config path.
     *
     * @param configPath the config path
     */
    public void setConfigPath(File configPath) {
        this.configPath = configPath;
    }

    /**
     * Set backup path.
     *
     * @param backUpPath the backup path
     */
    public void setBackupPath(File backUpPath) {
        this.backUpPath = backUpPath;
    }

    /**
     * Set storage path.
     *
     * @param storagePath the storage path
     */
    public void setStoragePath(File storagePath) {
        this.storagePath = storagePath;
    }
}
