package Scheduler;

import java.io.File;
import java.util.ArrayList;
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
    private String configFilePath;
    /**
     * The Storage file path.
     */
    private String storageFilePath;
    /**
     * The Backup file path.
     */
    private String backupFilePath;
    /**
     * The History file path.
     */
    private String historyFilePath;
    /**
     * The Last date opened.
     */
    private Date lastDateOpened;
    /**
     * The Backup date.
     */
    private Date backupDate;
    /**
     * The Open number.
     */
    private int openNumber;
    /**
     * The Num of periods.
     */
    private int numOfPeriods;
    /**
     * The File reader.
     */
    private DataFileReader dataFileReader;

    /**
     * Instantiates a new Config.
     *
     * @param configFilePath the config file path
     */
    public Config(String configFilePath) {
        this.configFilePath = configFilePath;
        try {
            dataFileReader = new DataFileReader(new File(configFilePath));
            dataFileReader.readConfig();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //todo: use file reader to read config file and set variables/Objects then send to controller

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
     * Gets history file path.
     *
     * @return history file path
     */
    public String getHistoryFilePath() {
        return historyFilePath;
    }

    /**
     * Sets history file path.
     *
     * @param historyFilePath the history file path
     */
    public void setHistoryFilePath(String historyFilePath) {
        this.historyFilePath = historyFilePath;
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

    /**
     * Gets num of periods.
     *
     * @return num of periods
     */
    public int getNumOfPeriods() {
        return numOfPeriods;
    }

    /**
     * Sets num of periods.
     *
     * @param numOfPeriods the num of periods
     */
    public void setNumOfPeriods(int numOfPeriods) {
        this.numOfPeriods = numOfPeriods;
    }

    /**
     * Gets times.
     *
     * @return the times
     */
    public ArrayList<Time> getTimes() {
        return dataFileReader.getTimes();
    }

    /**
     * Gets supervision duties.
     *
     * @return the supervision duties
     */
    public ArrayList<SupervisionDuty> getSupervisionDuties() {
        return dataFileReader.getSupervisionDuties();
    }

    /**
     * Gets teachers.
     *
     * @return the teachers
     */
    public ArrayList<Teacher> getTeachers() {
        return dataFileReader.getTeachers();
    }

    /**
     * Gets on call duties.
     *
     * @return the on call duties
     */
    public ArrayList<OnCallDuty> getOnCallDuties() {
        return dataFileReader.getOnCallDuties();
    }

    public ArrayList<Location> getLocations() {
        return dataFileReader.getLocations();
    }
}
