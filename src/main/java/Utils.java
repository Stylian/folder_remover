import java.io.File;

public class Utils {

    public static void takeFilesOut(File folder, File outFolder) {

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
