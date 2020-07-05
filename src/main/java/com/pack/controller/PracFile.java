package com.pack.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class PracFile {


	public static void main(String[] args) throws FileNotFoundException, DocumentException {
		Document document = new Document();
		PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream("Test.pdf"));
		document.open();

		Paragraph paragraph = new Paragraph();
		paragraph.add("sdfbdsf");
		paragraph.setAlignment(Element.ALIGN_CENTER);

		document.add(paragraph);
		document.close();

	}


}
