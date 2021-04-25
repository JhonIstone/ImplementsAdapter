package interfaces;

import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;

public interface IDocument {
	public abstract void open(File file) throws IOException;
	public abstract JFrame getEditor() throws IOException;
}
