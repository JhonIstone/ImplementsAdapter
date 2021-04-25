package client;

import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;

import interfaces.IDocument;

public class client implements IDocument{
    
    private IDocument tDocument;

    public client(IDocument tDocument, File file) throws IOException {
        this.tDocument = tDocument;
        this.tDocument.open(file);
    }
    @Override
    public void open(File file) throws IOException {
        // TODO Auto-generated method stub
        this.tDocument.open(file);
    }

    @Override
    public JFrame getEditor() throws IOException {
        // TODO Auto-generated method stub
        this.tDocument.getEditor();
        return null;
    }
    
}
