package cz.cuni.mff.saritapokhrel.util;

import java.util.HashMap;

public class DirectorySetting
{
    private static final HashMap<String,String> hashMap = new HashMap<>();

    static
    {
        String[][] mappings =
                {
                        {"Documents", "txt", "doc", "pdf", "xls", "xlsx", "ppt", "pptx", "odt", "rtf", "epub", "azw",
                        "docx"},
                        {"Images", "jpg", "jpeg", "png", "bmp", "gif", "tiff", "tif", "tif", "svg", "webp"},
                        {"Videos", "mp4", "avi", "mkv", "mov", "wmv", "flv", "webm"},
                        {"Audios", "mp3", "wav", "aac", "flac", "ogg", "wma"},
                        {"Archives", "zip", "rar", "7z", "tar", "gz", "bz2"},
                        {"Executable", "exe", "msi", "dmg", "app", "deb", "rpm"},
                        {"Codes","py", "java", "cpp", "c", "html", "css", "php", "sh", "sql"}
                };

        for (String[] mapping : mappings)
        {
            String category = mapping[0];

            for (int i = 1; i < mapping.length; ++i)
            {
                hashMap.put(mapping[i], category);
            }
        }
    }

    public static String getSubDir(String extension)
    {
        return hashMap.getOrDefault(extension.toLowerCase(), "Unknown");
    }

}
