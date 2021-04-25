package concretFactory;

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import interfaces.IDocument;

public class PDFDocument implements IDocument{
	
	PDDocument pdf;
	
	@Override
	public void open(File file) throws IOException {
		// TODO Auto-generated method stub
        this.pdf = PDDocument.load(file);
		getEditor();
	}

	@Override
	public JFrame getEditor() throws IOException {
		// TODO Auto-generated method stub
		PDFRenderer render = new PDFRenderer(pdf);
		BufferedImage[] images = new BufferedImage[pdf.getNumberOfPages()];
		
		JFrame jframe = new JFrame();
		JPanel[] jpanel = new JPanel[pdf.getNumberOfPages()];
		JScrollPane[] scrPanel = new JScrollPane[pdf.getNumberOfPages()];
		
		int i;
		for (i = 0; i < pdf.getNumberOfPages(); i++) {
			images[i] = render.renderImage(i);
			jpanel[i] = new JPanel();
			jpanel[i].add(new JLabel(new ImageIcon(images[i])), BorderLayout.CENTER);
			scrPanel[i] = new JScrollPane(jpanel[i]);
		}
		
		jframe.add(scrPanel[1]);
		jframe.pack();
		jframe.setVisible(true);
		pdf.close();
		return jframe;
	}
	
}
