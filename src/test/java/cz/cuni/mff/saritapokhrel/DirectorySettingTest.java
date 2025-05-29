package cz.cuni.mff.saritapokhrel;

import cz.cuni.mff.saritapokhrel.util.DirectorySetting;
import junit.framework.TestCase;

public class DirectorySettingTest extends TestCase {

    public void testGetSubDirKnownExtensions() {
        assertEquals("Documents", DirectorySetting.getSubDir("pdf"));
        assertEquals("Images", DirectorySetting.getSubDir("jpg"));
        assertEquals("Videos", DirectorySetting.getSubDir("mp4"));
        assertEquals("Audios", DirectorySetting.getSubDir("mp3"));
        assertEquals("Archives", DirectorySetting.getSubDir("zip"));
        assertEquals("Executable", DirectorySetting.getSubDir("exe"));
        assertEquals("Codes", DirectorySetting.getSubDir("java"));
    }

    public void testGetSubDirUnknownExtension() {
        assertEquals("Unknown", DirectorySetting.getSubDir("xyz"));
        assertEquals("Unknown", DirectorySetting.getSubDir(""));
    }

    public void testCaseInsensitive() {
        assertEquals("Images", DirectorySetting.getSubDir("JPG"));
        assertEquals("Documents", DirectorySetting.getSubDir("Doc"));
    }
}
