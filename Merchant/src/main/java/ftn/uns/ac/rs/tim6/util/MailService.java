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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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

@Service
public class MailService {

	private static final Logger LOG = LoggerFactory.getLogger(MailService.class);

	@Autowired
	private JavaMailSender javaMailSender;

	public MailService() {

	}

	public void sendMail(String to, String message) {

		LOG.debug("Sending mail to {} with message: {}", to, message);
		MimeMessage mailtest = javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mailtest, true);
			helper.setFrom("sistemielektronskog@gmail.com");
			helper.setTo(to);
			helper.setSubject("Insurances");
			helper.setText(message);
			javaMailSender.send(mailtest);
		} catch (MessagingException e) {
			
			e.printStackTrace();
		}
		// SimpleMailMessage mail = new SimpleMailMessage();
		// mail.setFrom("sistemielektronskog@gmail.com");
		// mail.setTo(to);
		// mail.setSubject("Insurances");
		// mail.setText(message);
		// javaMailSender.send(mail);
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
			Image image = Image
					.getInstance("/Users/Milos/git/SEP_2016/Merchant/src/main/webapp/assets/img/travel2pdf.jpg");
			image.setAlignment(Element.ALIGN_CENTER);
			document.add(image);
			// document.add(new Paragraph("Chuck Norris Insurance"));
			document.add(new Paragraph(new Date().toString()));

			document.addAuthor("SEP2016/17");
			document.addCreationDate();
			document.addCreator("Sep2016/2017");
			document.addTitle("Sample PDF");

			// Create Paragraph
			Paragraph paragraph = new Paragraph("Insurance policy",
					new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD));
			paragraph.setAlignment(Element.ALIGN_CENTER);
			// New line
			paragraph.add(new Paragraph(" "));
			// paragraph.add("Informacije o osiguranju");
			paragraph.add(new Paragraph(" "));
			paragraph.add(new Paragraph(" "));
			document.add(paragraph);

			// Create a table in PDF
			PdfPTable pdfTable = new PdfPTable(2);
			Paragraph par1 = new Paragraph("Insurance carrier informations",
					new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD));
			PdfPCell cell1 = new PdfPCell(par1);
			cell1.setColspan(4);
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			pdfTable.addCell(cell1);

			pdfTable.addCell("First name");
			pdfTable.addCell(i.getBuyer().getFirstName());

			pdfTable.addCell("Last name");
			pdfTable.addCell(i.getBuyer().getLastName());

			pdfTable.addCell("Address");
			pdfTable.addCell(i.getBuyer().getAddress());

			document.add(pdfTable);
			document.add(Chunk.NEWLINE);

			PdfPTable pdfTable2 = new PdfPTable(2);
			Paragraph par2 = new Paragraph("Insuranced person informations",
					new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD));
			PdfPCell cell2 = new PdfPCell(par2);
			cell2.setColspan(4);
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			pdfTable2.addCell(cell2);

			pdfTable2.addCell("First name");
			pdfTable2.addCell(i.getPersons().get(0).getFirstName());

			pdfTable2.addCell("Last name");
			pdfTable2.addCell(i.getPersons().get(0).getLastName());

			pdfTable2.addCell("Address");
			pdfTable2.addCell(i.getPersons().get(0).getAddress());

			document.add(pdfTable2);

			document.add(Chunk.NEWLINE);

			PdfPTable pdfTable3 = new PdfPTable(2);
			Paragraph par3 = new Paragraph("Policy informations", new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD));
			PdfPCell cell3 = new PdfPCell(par3);
			cell3.setColspan(4);
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			pdfTable3.addCell(cell3);

			pdfTable3.addCell("Destination");
			// pdfTable3.addCell(i.getInsuranceTypes().get(0).getRiskCategories().get(1).getName());
			i.getPricelist().getPricelistItems().get(0).getRiskSubcategory();
			pdfTable3.addCell("North America");

			pdfTable3.addCell("Start date");
			pdfTable3.addCell(i.getStartDate().toString());

			pdfTable3.addCell("End date");
			pdfTable3.addCell(i.getEndDate().toString());

			pdfTable3.addCell("Insurance price");
			pdfTable3.addCell(i.getTotalPrice().toString());

			document.add(pdfTable3);

			/*
			 * com.itextpdf.text.List list = new com.itextpdf.text.List();
			 * list.add("Start date" + "\t\t\t\t\t\t\t\t\t\t\t\t\t" +
			 * i.getStartDate().toString()); list.add("End date" +
			 * "\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + i.getEndDate().toString());
			 * list.add("Total price" + "\t\t\t\t\t\t\t\t\t\t\t\t\t" +
			 * i.getTotalPrice().toString()); document.add(list);
			 */

			// cell1 = new PdfPCell(new
			// Phrase(i.getBuyer().getFirstName()));
			// cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			// pdfTable.addCell(cell1);

			// pdfTable.setHeaderRows(1);

			// pdfTable.addCell("Prezime osgiuranika");
			// pdfTable.addCell(i.getBuyer().getLastName());

			// pdfTable.addCell("Adresa osiguranika");
			// pdfTable.addCell(i.getBuyer().getAddress());

			// document.add(pdfTable2);
			// document.add(pdfTable3);

			document.close();
			file.close();

			try {

				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress("sistemielektronskog@gmail.com"));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(i.getBuyer().getEmail()));
				message.setSubject("Chuck Norris Insurance");
				message.setText("Tekst");

				MimeBodyPart messageBodyPart = new MimeBodyPart();

				Multipart multipart = new MimeMultipart();

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