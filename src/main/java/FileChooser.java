import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.net.URISyntaxException;

public class FileChooser {

    public static void main(String[] args) {

        JFileChooser jfc = new JFileChooser(getJarPath());
        jfc.setDialogTitle("Select the parent folder");
        jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int returnValue = jfc.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            System.out.println(selectedFile.getAbsolutePath());
        }

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
