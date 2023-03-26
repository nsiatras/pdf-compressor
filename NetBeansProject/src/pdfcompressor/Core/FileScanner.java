package pdfcompressor.Core;

import java.io.File;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Nikos Siatras
 */
public class FileScanner
{

    private final File fDirectory;

    public FileScanner(File directory)
    {
        fDirectory = directory;
    }

    /**
     * Returns a list with the files, of the given extension, inside the given
     * directory of this FileScanner.
     *
     * @param extension file extension (ex. ".txt")
     * @return
     */
    public ArrayList<File> getFiles(String extension)
    {
        ArrayList<File> result = new ArrayList<>();
        File[] files = fDirectory.listFiles((File pathname) -> pathname.getName().toLowerCase().endsWith(extension));
        result.addAll(Arrays.asList(files));
        return result;
    }

    public File getDirectory()
    {
        return fDirectory;
    }

}
