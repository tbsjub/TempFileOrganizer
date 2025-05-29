package cz.cuni.mff.saritapokhrel.program;

import cz.cuni.mff.saritapokhrel.util.*;
import java.nio.file.Files;
import  java.nio.file.Path;
import static java.nio.file.Path.of;

public class FileOrganizer {
    public static void main(String[] args) {
        if (args.length==0)
        {
            System.out.println("Enter the path to the directory");
        }
        else
        {
            Path path = of(args[0]);
            if (Files.exists(path))
                DirectoryScanner.processFiles(path);

            else
                System.out.println("there is no such directory :(");
        }
    }
}