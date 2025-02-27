package main.java.cz.homeproject;

import java.nio.file.Files;
import  java.nio.file.Path;

class FileOrganizer
{
    // public static void printingFiles(Path directory)
    // {
    //     List<Path> theFiles = DirectoryScanner.takeFiles(directory);

    //     for (Path path : theFiles) {
    //             System.out.println(path);
    //     }
    // }

    public static void main(String[] args) 
    {
        if (args.length==0)
        {
            System.out.println("Enter the path to the directory");
        }
        else
        {
            Path path = Path.of(args[0]);
            if (Files.exists(path))
                DirectoryScanner.processFiles(path);

            else
                System.out.println("there is no such directory :(");
        }
    }
}