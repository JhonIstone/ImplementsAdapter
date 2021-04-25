package Ui;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

import client.client;
import concretFactory.PDFDocument;

public class fileSelectorScreen extends JFrame{
    public fileSelectorScreen() throws IOException{
        JFileChooser fileChooser = new JFileChooser();
        int response = fileChooser.showOpenDialog(null);
        
        if (response == JFileChooser.APPROVE_OPTION){
            File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
            
            /*File currentDir = new File("./src/plugins");
            String[] plugins = currentDir.list();
            int i;
            URL[] jars = new URL[plugins.length];
            for (i = 0; i < plugins.length; i++) {
                System.out.println(i + 1 + " - " + plugins[i].split("\\.")[0]);
                jars[i] = (new File("./src/plugins" + plugins[i])).toURL();
            }
            URLClassLoader ulc = new URLClassLoader(jars);
            System.out.println(i + 1 + " - Plugin refresh");
            System.out.println("Escolha sua opcao ou 0 para sair: ");
            Scanner sc = new Scanner(System.in);
            op = sc.nextInt();

            if (op != 0 && op != i + 1){
                String factoryName = plugins[op - 1].split("\\.")[0];
                Class metaClasse = Class.forName(factoryName.toLowerCase() + "." + factoryName, true, ulc);
                Method instancedFactory = metaClasse.getDeclaredMethod("getInstance");
                Object factory = (IFactory) instancedFactory.invoke(metaClasse);
				new MenuUi((IFactory) factory);
            }*/
            
            if(file.getName().endsWith(".pdf")){
            	new client(new PDFDocument(), file);
            }                
        }
    }
}
