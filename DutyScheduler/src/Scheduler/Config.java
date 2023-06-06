package Scheduler;

import java.util.Date;

/**
 * The type Config. TODO: Add description
 *
 * @author: Griffin, Izaan, Ronit, Shahmeer
 * @date: 2023 -05-11
 * @File: Config
 */
public class Config {//todo: Error Trapping/Handling
    /**
     * The Config file path.
     */
    String configFilePath;
    /**
     * The Storage file path.
     */
    String storageFilePath;
    /**
     * The Backup file path.
     */
    String backupFilePath;
    /**
     * The Last date opened.
     */
    Date lastDateOpened;
    /**
     * The Backup date.
     */
    Date backupDate;
    /**
     * The Open number.
     */
    int openNumber;

    /**
     * Instantiates a new Config.
     *
     * @param configFilePath  the config file path
     * @param storageFilePath the storage file path
     * @param backupFilePath  the backup file path
     * @param lastDateOpened  the last date opened
     * @param backupDate      the backup date
     * @param openNumber      the open number
     */
    public Config(String configFilePath, String storageFilePath, String backupFilePath, Date lastDateOpened, Date backupDate, int openNumber) {
        this.configFilePath = configFilePath;
        this.storageFilePath = storageFilePath;
        this.backupFilePath = backupFilePath;
        this.lastDateOpened = lastDateOpened;
        this.backupDate = backupDate;
        this.openNumber = openNumber;
    }

    /**
     * Gets config file path.
     *
     * @return config file path
     */
    public String getConfigFilePath() {
        return configFilePath;
    }

    /**
     * Sets config file path.
     *
     * @param configFilePath the config file path
     */
    public void setConfigFilePath(String configFilePath) {
        this.configFilePath = configFilePath;
    }

    /**
     * Gets storage file path.
     *
     * @return storage file path
     */
    public String getStorageFilePath() {
        return storageFilePath;
    }

    /**
     * Sets storage file path.
     *
     * @param storageFilePath the storage file path
     */
    public void setStorageFilePath(String storageFilePath) {
        this.storageFilePath = storageFilePath;
    }

    /**
     * Gets backup file path.
     *
     * @return backup file path
     */
    public String getBackupFilePath() {
        return backupFilePath;
    }

    /**
     * Sets backup file path.
     *
     * @param backupFilePath the backup file path
     */
    public void setBackupFilePath(String backupFilePath) {
        this.backupFilePath = backupFilePath;
    }

    /**
     * Gets last date opened.
     *
     * @return last date opened
     */
    public Date getLastDateOpened() {
        return lastDateOpened;
    }

    /**
     * Sets last date opened.
     *
     * @param lastDateOpened the last date opened
     */
    public void setLastDateOpened(Date lastDateOpened) {
        this.lastDateOpened = lastDateOpened;
    }

    /**
     * Gets backup date.
     *
     * @return backup date
     */
    public Date getBackupDate() {
        return backupDate;
    }

    /**
     * Sets backup date.
     *
     * @param backupDate the backup date
     */
    public void setBackupDate(Date backupDate) {
        this.backupDate = backupDate;
    }

    /**
     * Gets open number.
     *
     * @return open number
     */
    public int getOpenNumber() {
        return openNumber;
    }

    /**
     * Sets open number.
     *
     * @param openNumber the open number
     */
    public void setOpenNumber(int openNumber) {
        this.openNumber = openNumber;
    }
}
