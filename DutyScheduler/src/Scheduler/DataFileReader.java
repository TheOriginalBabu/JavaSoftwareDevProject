package Scheduler;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * The type File reader. TODO: Add description
 *
 * @author: Griffin, Izaan, Ronit, Shahmeer
 * @date: 2023 -05-17
 * @File: FileReader
 */
public class DataFileReader {//todo: Error Trapping/Handling
    /**
     * The Config path.
     */
    private File configPath;
    /**
     * The Backup path.
     */
    private File backUpPath;
    /**
     * The Storage path.
     */
    private File storagePath;
    /**
     * The History path.
     */
    private File historyPath;
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
     * List of times.
     */
    private ArrayList<Time> times;
    /**
     * List of supervision duties.
     */
    private ArrayList<SupervisionDuty> supervisionDuties;
    /**
     * List of teachers.
     */
    private ArrayList<Teacher> teachers;
    /**
     * List of on call duties.
     */
    private ArrayList<OnCallDuty> onCallDuties;

    /**
     * Instantiates a new File reader.
     *
     * @param configFile the config file
     */
    public DataFileReader(File configFile) {
        this.configPath = configFile;
        // file = new File("Path"); Example of how to initialize a file
    }

    /**
     * Read config.
     */
    public void readConfig() {
        try (BufferedReader br = new BufferedReader(new FileReader(configPath))) {
            String line;
            SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy"); // Format to convert string to date
            int i = 0;

            while ((line = br.readLine()) != null) { // Read each line of the file
                String[] values = line.split(","); // Split each line into an array of strings

                if (i == 1) {// Reading and assigning the file paths
                    storagePath = new File(values[1]);
                    backUpPath = new File(values[2]);
                    historyPath = new File(values[3]);

                } else if (i == 2) {// Reading and assigning the last date opened
                    lastDateOpened = dateFormatter.parse(values[1]);

                } else if (i == 3) {// Reading and assigning the back up date
                    backupDate = dateFormatter.parse(values[1]);

                } else if (i == 4) {// Reading and assigning the open number
                    openNumber = Integer.parseInt(values[1]);

                } else if (i == 5) {// Reading and assigning the number of periods
                    numOfPeriods = Integer.parseInt(values[1]);
                }

                i++;
            }
        } catch (IOException e) { // Catching exceptions
            e.printStackTrace();
        } catch (ParseException e) { // Catching exceptions
            throw new RuntimeException(e);
        }
        /*
        System.out.println("Storage Path: " + storagePath);
        System.out.println("Backup Path: " + backUpPath);
        System.out.println("History Path: " + historyPath);
        System.out.println("Last Date Opened: " + lastDateOpened);
        System.out.println("Backup Date: " + backupDate);
        System.out.println("Open Number: " + openNumber);
        System.out.println("Number of Periods: " + numOfPeriods);
         */
    }

    /**
     * Read backup.
     */
    public void readBackup() {
        //todo: Read backup file, assign data to objects and save to storage. Needs to send date to config object then to controller
    }

    /**
     * Read storage.
     */
    public void readStorage() { //todo: Read storage file and assign data to objects. Needs to send date to config object then to controller
        try (BufferedReader br = new BufferedReader(new FileReader(configPath))) {
            String line;
            SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy"); // Format to convert string to date
            int i = 0;

            while ((line = br.readLine()) != null) { // Read each line of the file
                String[] values = line.split(","); // Split each line into an array of strings

                if (i == 1) {// Reading and assigning the file paths

                } else if (i == 2) {

                } else if (i == 3) {

                } else if (i == 4) {

                } else if (i == 5) {

                }

                i++;
            }
        } catch (IOException e) { // Catching exceptions
            e.printStackTrace();
        }
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
     * Get history path File.
     *
     * @return the File
     */
    public File getHistoryPath() {
        return historyPath;
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

    /**
     * Set history path.
     *
     * @param historyPath the history path
     */
    public void setHistoryPath(File historyPath) {
        this.historyPath = historyPath;
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
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        DataFileReader dataFileReader = new DataFileReader(new File("src/resources/configCSVDEMO.csv"));
        dataFileReader.readConfig();
    }

    /**
     * Gets times.
     *
     * @return the times
     */
    public ArrayList<Time> getTimes() {
        return times;
    }

    /**
     * Gets supervision duties.
     *
     * @return the supervision duties
     */
    public ArrayList<SupervisionDuty> getSupervisionDuties() {
        return supervisionDuties;
    }

    /**
     * Gets teachers.
     *
     * @return the teachers
     */
    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    /**
     * Gets on call duties.
     *
     * @return the on call duties
     */
    public ArrayList<OnCallDuty> getOnCallDuties() {
        return onCallDuties;
    }
}
