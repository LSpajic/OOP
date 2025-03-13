package Zad1;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class JavaProjectFileVisitor extends SimpleFileVisitor<Path> {

    private Set<String> extensionFilter;
    private Map<String, Set<Path>> projectPathsPerExtension;

    public JavaProjectFileVisitor(Set<String> extensionFilter){
        this.extensionFilter = extensionFilter;
        projectPathsPerExtension = new LinkedHashMap<>();
    }


    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (attrs.isDirectory()){
            return FileVisitResult.CONTINUE;
        }

        String fileName = file.getFileName().toString();
        String fileExtension = fileName.substring(fileName.lastIndexOf("."));

        if (extensionFilter.contains(fileExtension)){
            return FileVisitResult.CONTINUE;
        }

        if (!projectPathsPerExtension.containsKey(fileExtension)){
            projectPathsPerExtension.put(fileExtension, new LinkedHashSet<>());
        }

        projectPathsPerExtension.get(fileExtension).add(file);

        return FileVisitResult.CONTINUE;
    }

    public Map<String, Set<Path>> getProjectPathsPerExtension(){
        return projectPathsPerExtension;
    }
}
