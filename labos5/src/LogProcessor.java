import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

class LogProcessor {
    /**
     * Creates object and set file.
     * @param file file name
     */
    public LogProcessor(Path file){
        this.file = file;
        logs = new LinkedList<>();
    }

    /**
     * Load file and populate list of loaded objects (LogEntry).
     * @throws IOException if can not load file
     */
    public void load() throws IOException{
        for(String line: Files.readAllLines(file, StandardCharsets.UTF_8)){
            logs.add(parseLog(line));
        }
    }

    /**
     * Returns list of log entries.
     * @return list of log entries
     */
    public List<LogEntry> getLogs(){
        return logs;
    }

    /**
     * Extracts elementsof line and creates LogEntry.
     * @param line one line og log file
     * @return created log entry object
     */
    public static LogEntry parseLog(String line){

    }
    class LogEntry{
    private String time;
    private String level;
    private String thread;
    private String text;

    public LogEntry(String time, String level, String thread, String text) {
        this.time = time;
        this.level = level;
        this.thread = thread;
        this.text = text;
    }

    public String getTime() {
        return time;
    }

    public String getLevel() {
        return level;
    }

    public String getThread() {
        return thread;
    }

    public String getText() {
        return text;
    }

}
