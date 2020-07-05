package com.pack.service;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.pack.dao.DocumentDao;
import com.pack.vo.DocumentVO;

@Service
public class DocumentServiceImpl implements DocumentService {

	@Autowired
	private DocumentDao docDao;
	
	@Transactional
	public void addPdf(DocumentVO documentVO) {
		Document document = new Document();
		byte[] targetDoc = null;
		String path = "/Users/jedahmadia/Desktop/testpath/" + documentVO.getDocName() + ".pdf";
		try {
			PdfWriter pdfWriter = PdfWriter.getInstance(document,
					new FileOutputStream(path));
			document.open();

			Paragraph paragraph = new Paragraph();
			paragraph.add(documentVO.getDocContent());
			paragraph.setAlignment(Element.ALIGN_CENTER);

			document.add(paragraph);
			document.close();
			

			File file = new File(path);
			PDDocument pdDocument = PDDocument.load(file);
			// Instantiate PDFTextStripper class
			PDFTextStripper pdfStripper = new PDFTextStripper();
			// Retrieving text from PDF document
			String text = pdfStripper.getText(pdDocument);
			System.out.println(text);
			// Closing the document
			pdDocument.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//docDao.addPdf(doc);
	}

}
