package cz.cuni.mff.saritapokhrel;

import cz.cuni.mff.saritapokhrel.util.DirectoryScanner;
import junit.framework.TestCase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DirectoryScannerTest extends TestCase {

    private Path tempDir;

    protected void setUp() throws Exception {
        tempDir = Files.createTempDirectory("testDir");
    }

    protected void tearDown() throws Exception {
        Files.walk(tempDir)
                .map(Path::toFile)
                .forEach(file -> file.delete());
    }

    public void testGetExtension() throws IOException {
        Path file = tempDir.resolve("test.txt");
        Files.createFile(file);
        assertEquals("txt", DirectoryScanner.getExtension(file));

        Path noExtFile = tempDir.resolve("README");
        Files.createFile(noExtFile);
        assertEquals("no_extension", DirectoryScanner.getExtension(noExtFile));
    }

    public void testMakeDirectory() {
        Path newDir = tempDir.resolve("NewFolder");
        DirectoryScanner.makeDirectory(tempDir, "NewFolder");
        assertTrue(Files.exists(newDir));
    }

    public void testMoveFile() throws IOException {
        Path file = tempDir.resolve("test.txt");
        Files.createFile(file);
        Path targetDir = tempDir.resolve("target");
        DirectoryScanner.makeDirectory(tempDir, "target");

        DirectoryScanner.moveFile(file, targetDir);
        assertTrue(Files.exists(targetDir.resolve("test.txt")));
    }

}
