import javax.naming.PartialResultException;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

class JavaProjectFileVisitor extends SimpleFileVisitor<Path> {

    public Set<Path> filesAbove  = new LinkedHashSet<>();
    public Set<Path> dirsBelow = new LinkedHashSet<>();

    int fileSizeFilter;
    int dirSizeFilter;

    public JavaProjectFileVisitor(int fileSizeFilter, int dirSizeFilter) {
        this.fileSizeFilter = fileSizeFilter;
        this.dirSizeFilter = dirSizeFilter;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (attrs.isDirectory()) {

            if (attrs.toString().length() < dirSizeFilter){
                dirsBelow.add(file);
                System.out.println(file);
            }
        }

        String fileName = file.getFileName().toString();
        if (fileName.length() > fileSizeFilter) {
            filesAbove.add(file);
        }
        return FileVisitResult.CONTINUE;
    }

    public Set<Path> getFilesAboveFilter(){
        return filesAbove;
    }
    public Set<Path> getDirsAboveFilter(){
        return  dirsBelow;
    }


}


class Main {
    public static void main(String[] args) throws IOException {
        JavaProjectFileVisitor visitor = new JavaProjectFileVisitor(5,7);
        File f = new File("folder1");
        Files.walkFileTree(f.toPath(), visitor);
        Set<Path> filteredFiles = visitor.getFilesAboveFilter();
        for(Path p : filteredFiles)
            System.out.println(p.toString());

        System.out.println("-------");

        Set<Path> filteredDirs = visitor.getDirsAboveFilter();
        for(Path p : filteredDirs)
            System.out.println(p.toString());


    }
}