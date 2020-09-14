import java.io.File;
import java.lang.reflect.Field;
import java.nio.file.Files;

public class Main {

    public static void main(String args[]) {

        System.out.println("starting...");

        System.out.println("creating out directory...");
        File outFolder = new File("OUT");
        outFolder.mkdir();

        String foldername = args[0];
        File folder = new File(foldername);
        if(folder.isDirectory()) {
            takeFilesOut(folder, outFolder);
        }

        System.out.println("FINISHED !!!");
    }

    private static void takeFilesOut(File folder, File outFolder) {

        for(File file : folder.listFiles()) {
            System.out.println(file.getName());
            if(file.isDirectory()) {
                takeFilesOut(file, outFolder);
            }else {
                file.renameTo(new File(outFolder + File.separator + file.getName()));
            }
        }

    }

}
