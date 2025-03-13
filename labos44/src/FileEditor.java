import java.nio.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class FileEditor {
    /**
     * Reads input file encoded in UTF-8, process content and writes it to output file.
     * @param inputFile input file
     * @param outputFile output file
     * @throws IOException
     */
    public static void processFile(Path inputFile, Path outputFile) throws IOException{

        BufferedWriter izlaz = Files.newBufferedWriter(outputFile, StandardCharsets.UTF_8);
        for (String line: Files.readAllLines(inputFile)){
            izlaz.write(line+"\n");
        }
        izlaz.close();
    }
}
