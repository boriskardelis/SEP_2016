package ftn.uns.ac.rs.tim6.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.stereotype.Service;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import ftn.uns.ac.rs.tim6.model.Insurance;
import ftn.uns.ac.rs.tim6.model.Person;
import ftn.uns.ac.rs.tim6.model.RiskSubcategory;

@Service
public class MailService {

	public MailService() {

	}

	public void sendMail(Insurance i) {

		final String username = "sistemielektronskog@gmail.com";
		final String password = "poslovanja";

		Properties props = new Properties();
		props.put("mail.smtp.auth", true);
		props.put("mail.smtp.starttls.enable", true);
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			OutputStream file = new FileOutputStream(new File("Insurance" + i.getId() + ".pdf"));

			Document document = new Document();
			PdfWriter.getInstance(document, file);

			document.open();

			// Dodajem sliku
			Image image = Image.getInstance("../Merchant/src/main/webapp/assets/img/travel2pdf.jpg");
			image.setAlignment(Element.ALIGN_CENTER);
			document.add(image);
			document.add(new Paragraph(DateConverter.convertToDataBase(new Date())));
			document.addAuthor("SEP2016/17");
			document.addCreationDate();
			document.addCreator("Sep2016/2017");
			document.addTitle("Sample PDF");

			// Create Paragraph
			if (i.getLanguage().equals("English")) {
				Paragraph paragraph = new Paragraph("Insurance policy",
						new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD));
				paragraph.setAlignment(Element.ALIGN_CENTER);
				paragraph.add(new Paragraph(" "));
				paragraph.add(new Paragraph(" "));
				document.add(paragraph);

			} else {
				Paragraph paragraph = new Paragraph("Polisa osiguranja",
						new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD));
				paragraph.setAlignment(Element.ALIGN_CENTER);
				paragraph.add(new Paragraph(" "));
				paragraph.add(new Paragraph(" "));
				document.add(paragraph);
			}

			if (i.getLanguage().equals("English")) {
				PdfPTable pdfTable2 = new PdfPTable(2);
				Paragraph par2 = new Paragraph("Insuranced persons informations",
						new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD));
				PdfPCell cell2 = new PdfPCell(par2);
				cell2.setColspan(4);
				cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
				pdfTable2.addCell(cell2);
				if (i.getBuyer().isInsured() == false) {
					for (Person p : i.getPersons()) {

						pdfTable2.addCell("First name");
						pdfTable2.addCell(p.getFirstName());

						pdfTable2.addCell("Last name");
						pdfTable2.addCell(p.getLastName());

						pdfTable2.addCell("Address");
						pdfTable2.addCell(p.getAddress());

					}

				} else {
					pdfTable2.addCell("First name");
					pdfTable2.addCell(i.getBuyer().getFirstName());

					pdfTable2.addCell("Last name");
					pdfTable2.addCell(i.getBuyer().getLastName());

					pdfTable2.addCell("Address");
					pdfTable2.addCell(i.getBuyer().getAddress());

					for (Person p : i.getPersons()) {

						pdfTable2.addCell("First name");
						pdfTable2.addCell(p.getFirstName());

						pdfTable2.addCell("Last name");
						pdfTable2.addCell(p.getLastName());

						pdfTable2.addCell("Address");
						pdfTable2.addCell(p.getAddress());

					}
				}

				document.add(pdfTable2);

				document.add(Chunk.NEWLINE);
			} else {
				PdfPTable pdfTable2 = new PdfPTable(2);
				Paragraph par2 = new Paragraph("Podaci o osiguranicima",
						new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD));
				PdfPCell cell2 = new PdfPCell(par2);
				cell2.setColspan(4);
				cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
				pdfTable2.addCell(cell2);
				if (i.getBuyer().isInsured() == false) {
					for (Person p : i.getPersons()) {

						pdfTable2.addCell("Ime");
						pdfTable2.addCell(p.getFirstName());

						pdfTable2.addCell("Prezime");
						pdfTable2.addCell(p.getLastName());

						pdfTable2.addCell("Adresa");
						pdfTable2.addCell(p.getAddress());

					}

				} else {
					pdfTable2.addCell("Ime");
					pdfTable2.addCell(i.getBuyer().getFirstName());

					pdfTable2.addCell("Prezime");
					pdfTable2.addCell(i.getBuyer().getLastName());

					pdfTable2.addCell("Adresa");
					pdfTable2.addCell(i.getBuyer().getAddress());

					for (Person p : i.getPersons()) {

						pdfTable2.addCell("Ime");
						pdfTable2.addCell(p.getFirstName());

						pdfTable2.addCell("Prezime");
						pdfTable2.addCell(p.getLastName());

						pdfTable2.addCell("Adresa");
						pdfTable2.addCell(p.getAddress());

					}
				}

				document.add(pdfTable2);

				document.add(Chunk.NEWLINE);

			}

			/*
			 * PdfPTable pdfTable3 = new PdfPTable(2);
			 * 
			 * pdfTable3.addCell("Sum insured to"); for (RiskSubcategory r :
			 * i.getRiskSubategories()) { if
			 * (r.getRiskCategory().getName().equals("sumTo")){
			 * pdfTable3.addCell(r.getNameTranslate().getName()); } }
			 */
			if (i.getLanguage().equals("English")) {
				PdfPTable pdfTable3 = new PdfPTable(2);
				Paragraph par3 = new Paragraph("Policy informations",
						new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD));
				PdfPCell cell3 = new PdfPCell(par3);
				cell3.setColspan(4);
				cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
				pdfTable3.addCell(cell3);

				pdfTable3.addCell("Insurance carrier");
				pdfTable3.addCell(i.getBuyer().getFirstName() + " " + i.getBuyer().getLastName());

				for (RiskSubcategory r : i.getRiskSubategories()) {
					System.out.println(r.getRiskCategory().getName());
					pdfTable3.addCell(r.getRiskCategory().getName());
					pdfTable3.addCell(r.getNameTranslate().getName());

				}

				pdfTable3.addCell("Total price");
				pdfTable3.addCell(i.getTotalPrice().toString() + " RSD");
				// DateConverter.convertToDataBase
				pdfTable3.addCell("Validity of insurance");
				pdfTable3.addCell(DateConverter.convertToDataBase(i.getStartDate()) + " - "
						+ DateConverter.convertToDataBase(i.getEndDate()));

				document.add(pdfTable3);
			} else {
				PdfPTable pdfTable3 = new PdfPTable(2);
				Paragraph par3 = new Paragraph("Informacije o polisi osiguranja",
						new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD));
				PdfPCell cell3 = new PdfPCell(par3);
				cell3.setColspan(4);
				cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
				pdfTable3.addCell(cell3);

				pdfTable3.addCell("Nosilac osiguranja");
				pdfTable3.addCell(i.getBuyer().getFirstName() + " " + i.getBuyer().getLastName());

				for (RiskSubcategory r : i.getRiskSubategories()) {
					if (r.getRiskCategory().getName().equals("Sum insured")) {
						pdfTable3.addCell("Osigurana suma");
						pdfTable3.addCell(r.getNameTranslate().getName());
					} else {
						System.out.println(r.getRiskCategory().getName());
						pdfTable3.addCell(r.getRiskCategory().getName());
						pdfTable3.addCell(r.getNameTranslate().getName());
					}

				}

				pdfTable3.addCell("Ukupna cena");
				pdfTable3.addCell(i.getTotalPrice().toString() + " RSD");
				// DateConverter.convertToDataBase
				pdfTable3.addCell("Važenje osiguranja");
				pdfTable3.addCell(DateConverter.convertToDataBase(i.getStartDate()) + " - "
						+ DateConverter.convertToDataBase(i.getEndDate()));

				document.add(pdfTable3);
			}

			document.close();
			file.close();

			try {

				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress("sistemielektronskog@gmail.com"));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(i.getBuyer().getEmail()));
				if (i.getLanguage().equals("English")) {
					message.setSubject("Chuck Norris Insurance policy");
				} else {
					message.setSubject("Chuck Norris Insurance polisa osiguranja");
				}
				message.setText("Zasto mi ne ispises ovaj tekst?!");

				MimeBodyPart messageBodyPart = new MimeBodyPart();
				MimeBodyPart messageBodyPart1 = new MimeBodyPart();

				Multipart multipart = new MimeMultipart();

				// tekst
				// messageBodyPart1 = new MimeBodyPart();
				if (i.getLanguage().equals("English")) {

					messageBodyPart1.setText(
							"Dear customer,\n\n\tYou can see your insurance policy in attachment.\n\nKind regards,\n\nChuck Norris Insurance");

				} else {
					messageBodyPart1.setText(
							"Poštovani,\n\nU prilogu se nalazi vaša polisa osiguranja.\n\nSrdačan pozdrav,\n\nChuck Norris Insurance");
				}
				multipart.addBodyPart(messageBodyPart1);
				// atachment
				messageBodyPart = new MimeBodyPart();
				String filee = "Insurance" + i.getId() + ".pdf";
				String fileName = "Insurance" + i.getId() + ".pdf";
				DataSource source = new FileDataSource(filee);
				messageBodyPart.setDataHandler(new DataHandler(source));
				messageBodyPart.setFileName(fileName);
				multipart.addBodyPart(messageBodyPart);

				message.setContent(multipart);

				System.out.println("Sending");

				Transport.send(message);

				System.out.println("Done");

			} catch (MessagingException e) {
				e.printStackTrace();
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}