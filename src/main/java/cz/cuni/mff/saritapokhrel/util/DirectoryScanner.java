package cz.cuni.mff.saritapokhrel.util;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class DirectoryScanner {

    private static int successCount = 0;
    private static int failureCount = 0;

    public static String getExtension(Path file) {
        String fileName = file.getFileName().toString();
        int lastDot = fileName.lastIndexOf('.');
        if (lastDot == 0 || lastDot == -1)
            return "no_extension";
        else
            return fileName.substring(lastDot + 1);
    }

    public static void makeDirectory(Path directory, String dName) {
        try {
            Path newDirectory = Files.createDirectories(directory.resolve(dName));
            System.out.println("Directory created: " + newDirectory);
        } catch (Exception e) {
            System.err.println("Error creating directory: " + e.getMessage());
        }
    }

    public static void moveFile(Path file, Path directory) {
        try {
            Files.move(file, directory.resolve(file.getFileName().toString()), StandardCopyOption.REPLACE_EXISTING);
            successCount++;
        } catch (Exception e) {
            System.err.println("Error moving file: " + file.getFileName() + " - " + e.getMessage());
            failureCount++;
        }
    }

    public static void processFiles(Path directory) {
        successCount = 0; // Reset counters before each run
        failureCount = 0;

        try {
            Files.walkFileTree(directory, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                    String extension = getExtension(file);
                    String subDirr = DirectorySetting.getSubDir(extension);
                    Path subDir = directory.resolve(subDirr);

                    if (!Files.exists(subDir)) {
                        makeDirectory(directory, subDirr);
                    }

                    moveFile(file, subDir);
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            System.err.println("Error reading directory: " + e.getMessage());
        }

        // Summary
        System.out.println("\n=== Transfer Summary ===");
        System.out.println("Files successfully moved: " + successCount);
        System.out.println("Files failed to move: " + failureCount);
    }
}
