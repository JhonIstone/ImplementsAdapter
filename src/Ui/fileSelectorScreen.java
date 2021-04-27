package Ui;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

import client.client;
import interfaces.IDocument;

public class fileSelectorScreen extends JFrame{

    public fileSelectorScreen() throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException{
        JFileChooser fileChooser = new JFileChooser();
        int response = fileChooser.showOpenDialog(null);

        if (response == JFileChooser.APPROVE_OPTION){
            File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
            String extension = file.getAbsolutePath().split("\\.")[1];

            File currentDir = new File("./src/plugins");
            String[] plugins = currentDir.list();
            int i;

            URL[] jars = new URL[plugins.length];

            for (i = 0; i < plugins.length; i++) {
                jars[i] = (new File("./src/plugins" + plugins[i])).toURL();
            }
            URLClassLoader ulc = new URLClassLoader(jars);
            
            for (i = 0; i < plugins.length; i++)
                if(plugins[i].toLowerCase().contains(extension.toLowerCase())){
                    String documentName = plugins[i].split("\\.")[0];
                    IDocument factory = (IDocument) Class.forName("concretFactory" + "." + documentName, true, ulc).newInstance();
                    client pdf = new client(factory);
                    pdf.open(file);
                    JFrame framePdf = pdf.getEditor();
                    framePdf.setVisible(true);
                }
        }
    }
}
