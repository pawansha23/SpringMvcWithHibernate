package com.pack.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.sql.rowset.serial.SerialBlob;

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
import com.pack.model.Documents;
import com.pack.vo.DocumentVO;

@Service
public class DocumentServiceImpl implements DocumentService {

	@Autowired
	private DocumentDao docDao;

	@Transactional
	public void addPdf(DocumentVO documentVO) {
		Document document = new Document();
		byte[] targetDoc = null;
		String path = "C:\\Users\\admin\\OneDrive\\Desktop\\New folder\\" + documentVO.getDocName() + ".pdf";
		File file = null;
		FileInputStream fis = null;
		Documents documents = new Documents();
		try {
			PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(path));
			document.open();

			Paragraph paragraph = new Paragraph();
			paragraph.add(documentVO.getDocContent());
			paragraph.setAlignment(Element.ALIGN_CENTER);

			document.add(paragraph);
			document.close();

			file = new File(path);
			PDDocument pdDocument = PDDocument.load(file);
			PDFTextStripper pdfStripper = new PDFTextStripper();
			String text = pdfStripper.getText(pdDocument);
			System.out.println(text);
			pdDocument.close();

			byte[] bArray = new byte[(int) file.length()];
			fis = new FileInputStream(file);
			fis.read(bArray);
			fis.close();

			documents.setDoc(new SerialBlob(bArray));
		} catch (Exception e) {
			e.printStackTrace();
		}

		docDao.addPdf(documents);
	}

}
