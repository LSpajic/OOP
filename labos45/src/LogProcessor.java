public class LogProcessor {

    /**
     * Creates object and set file.
     * @param file file name
     */
    public LogProcessor(Path file){}

    /**
     * Load file and populate list of loaded objects (LogEntry).
     * @throws IOException if can not load file
     */
    public void load() throws IOException{}

    /**
     * Returns list of log entries.
     * @return list of log entries
     */
    public List<LogEntry> getLogs(){}

    /**
     * Extracts elements of line and creates LogEntry.
     * @param line one line og log file
     * @return created log entry object
     */
    public static LogEntry parseLog(String line){}
}
