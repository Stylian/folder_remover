import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.net.URISyntaxException;

public class FileChooser {

    public String askForFolderPath(String title) throws Exception {

        JFileChooser jfc = new JFileChooser(getJarPath());
        jfc.setDialogTitle(title);
        jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int returnValue = jfc.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            return selectedFile.getAbsolutePath();
        }
        throw new Exception("a folder was not selected");
    }

    private static String getJarPath() {
        try {
            return new File(
                    FileChooser
                            .class
                            .getProtectionDomain()
                            .getCodeSource()
                            .getLocation()
                            .toURI())
                    .getPath();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        // ELSE
        return FileSystemView.getFileSystemView().getHomeDirectory().getPath();
    }

}
