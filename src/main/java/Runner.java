import java.io.File;
import java.lang.reflect.Field;
import java.nio.file.Files;

public class Runner {

    public static void main(String args[]) throws Exception {

        FileChooser fileChooser = new FileChooser();
        String inputFolder = null;
        String outputFolder = null;
        if(args.length < 1) {
            // run the ui
            inputFolder = fileChooser.askForFolderPath("select folder to get files from");
            outputFolder = fileChooser.askForFolderPath("select folder to put files to");
        }else {
            // run the console
            inputFolder = args[0];
            if(args.length < 2) {
                // create output folder as "OUT"
                outputFolder = "OUT"; // will be created where the jar file is
            }else {
                outputFolder = args[1];
            }
        }

        System.out.println("starting...");

        File outFolder = new File(outputFolder);
        if(!Files.exists(outFolder.getAbsoluteFile().toPath())) {
            System.out.println("creating output directory...");
            outFolder.mkdir();
        }

        File folder = new File(inputFolder);
        if (folder.isDirectory()) {
            Utils.takeFilesOut(folder, outFolder);
        }

        System.out.println("FINISHED !!!");
    }


}
