package concretFactory;

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import interfaces.IDocument;

public class PDFDocument implements IDocument{
	
	private PDDocument pdf;
	private JFrame jframe;
	private JPanel[] panelImage;
	private JPanel footerJPanel = new JPanel();
	private int indexPage = 0;
	private JButton buttonBack = new JButton("Back");
	private JButton buttonNext = new JButton("Next");

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

		this.panelImage = new JPanel[pdf.getNumberOfPages()];

		this.jframe = new JFrame();
		this.jframe.setLayout(new BorderLayout());
		
		this.footerJPanel.setLayout(new FlowLayout());
		if(pdf.getNumberOfPages() > 1){
			this.footerJPanel.add(buttonBack);
			this.footerJPanel.add(buttonNext);
			buttonBack.setVisible(false);
		}

		this.buttonNext.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jframe.remove(panelImage[indexPage]);
				indexPage++;
				jframe.add(panelImage[indexPage], BorderLayout.CENTER);
				jframe.repaint();
				jframe.revalidate();

				if(indexPage >= 1){
					buttonBack.setVisible(true);
					jframe.repaint();
					jframe.revalidate();
				}

				if(indexPage + 1 == pdf.getNumberOfPages()){
					buttonNext.setVisible(false);
					jframe.repaint();
					jframe.revalidate();
				}
			}
		});

		this.buttonBack.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jframe.remove(panelImage[indexPage]);
				indexPage--;
				jframe.add(panelImage[indexPage], BorderLayout.CENTER);
				jframe.repaint();
				jframe.revalidate();
				
				if (indexPage == 0){
					buttonBack.setVisible(false);
					jframe.repaint();
					jframe.revalidate();
				}

				if(indexPage < pdf.getNumberOfPages()){
					buttonNext.setVisible(true);
					jframe.repaint();
					jframe.revalidate();
				}
			}
		});

		int i;
		for (i = 0; i < pdf.getNumberOfPages(); i++) {
			images[i] = render.renderImage(i);
			panelImage[i] = new JPanel();
			panelImage[i].add(new JLabel(new ImageIcon(images[i])), BorderLayout.CENTER);
		}
		
		jframe.add(this.panelImage[indexPage], BorderLayout.CENTER);
		jframe.add(this.footerJPanel, BorderLayout.SOUTH);
		jframe.pack();
		jframe.setVisible(true);
		pdf.close();
		return jframe;
	}
	
}
