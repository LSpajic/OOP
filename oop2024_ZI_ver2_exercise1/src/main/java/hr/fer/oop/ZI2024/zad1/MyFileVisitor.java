package hr.fer.oop.ZI2024.zad1;

import java.io.*;
import java.nio.BufferOverflowException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class MyFileVisitor implements FileVisitor<Path> {

    List<Item> items = new ArrayList<>();
    int totalQuantity = 0;

    public int getTotalQuantity(){
        return totalQuantity;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (file.getFileName().toString().endsWith(".txt")) {
            try (BufferedReader br = Files.newBufferedReader(file)) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] lines = line.split("#");
                    if (lines.length != 3)
                        return FileVisitResult.CONTINUE;
                    int quantity = Integer.parseInt(lines[1]);
                    double price = Double.parseDouble(lines[2]);
                    items.add(new Item(lines[0], quantity, price));
                    totalQuantity += quantity;

                }
            }
        }

        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return null;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    public List<Item> getItems() {
        return items;
    }
    public double getTotalPrice(){
        double totalSum = 0.0;
        for (int i = 0; i < items.size(); ++i) {
            totalSum += items.get(i).getTotalPrice();
        }
        return totalSum;
    }


}



