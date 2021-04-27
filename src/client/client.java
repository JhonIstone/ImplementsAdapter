package client;

import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;

import interfaces.IDocument;

public class client implements IDocument{
    
    private IDocument tDocument;
    
    public client(IDocument tDocument) throws IOException {
        this.tDocument = tDocument;
    }
    @Override
    public void open(File file) throws IOException {
        this.tDocument.open(file);
    }

    @Override
    public JFrame getEditor() throws IOException {
        return this.tDocument.getEditor();
    }
    
}
