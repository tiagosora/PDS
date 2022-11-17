package Ex5;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicLong;

public class Main {
    public static void main(String args[]) {
        if (args.length < 1 || args.length > 2) {
            System.out.println("ERROR: Invalid number of arguments!");
            System.exit(0);
        }

        final boolean recursion = (args.length != 2) ? false : true;

        String dirName = args[0];
        Path path = Paths.get(dirName);
        AtomicLong size = new AtomicLong(0);

        try{
            Files.walkFileTree(path, new SimpleFileVisitor<Path>() {

                @Override public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

                    if (recursion) {
                        if (Files.isDirectory(file)) {
                            System.out.println("DIR -> " + file + ": " + attrs.size() + " bytes");
                            size.addAndGet(attrs.size());
                        } else {
                            System.out.println("FILE -> " + file + ": " + attrs.size() + " bytes");
                            size.addAndGet(attrs.size());
                        }
                    } else {
                        if (Files.isRegularFile(file)) {
                            System.out.println("FILE -> " + file + ": " + attrs.size() + " bytes");
                            size.addAndGet(attrs.size());
                        }
                    }
                    System.out.println("Total: " + size + " bytes");
                    return FileVisitResult.CONTINUE;
                }
            });

        } catch(Exception e) {
            System.out.println("ERROR: Can't walk though the tree!");
            System.exit(0);
        }
    }
}