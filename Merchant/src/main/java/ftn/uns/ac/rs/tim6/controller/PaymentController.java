package ftn.uns.ac.rs.tim6.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import ftn.uns.ac.rs.tim6.dto.ResponseMessageDto;
import ftn.uns.ac.rs.tim6.dto.ResponseMessageDto.TransactionResult;
import ftn.uns.ac.rs.tim6.dto.URLDto;
import ftn.uns.ac.rs.tim6.model.Insurance;
import ftn.uns.ac.rs.tim6.model.Payment;
import ftn.uns.ac.rs.tim6.model.Payment.Status;
import ftn.uns.ac.rs.tim6.service.InsuranceService;
import ftn.uns.ac.rs.tim6.service.PaymentService;

@RestController
@RequestMapping("/api")
public class PaymentController {

	@Autowired
	PaymentService paymentService;
	
	@Autowired
	InsuranceService insuranceService;

	@RequestMapping(value = "/payments", method = RequestMethod.GET)
	public ResponseEntity<List<Payment>> handleGetAllPayments() {
		List<Payment> payments = (List<Payment>) paymentService.getAll();
		return new ResponseEntity<List<Payment>>(payments, HttpStatus.OK);
	}

	@RequestMapping(value = "/incomingresult", method = RequestMethod.POST)
	public ResponseEntity<URLDto> handleIncomingMessage(@RequestBody ResponseMessageDto rmdto) {

		URLDto urldto = new URLDto();

		System.out.println("PaymentController paymentID: ");
		System.out.println(rmdto.getPaymentId());

		// TODO korak 11

		TransactionResult rezultat = rmdto.getResult();

		System.out.println("paymentID: " + rmdto.getPaymentId());

		if (rezultat.equals(TransactionResult.SUCCESSFUL)) {
			urldto.setUrl("https://localhost:8080/paymentSuccessful?paymentId=" + rmdto.getPaymentId());
			urldto.setStatus(Status.SUCCESSFUL);

		} else if (rezultat.equals(TransactionResult.CVC_INVALID)) {
			urldto.setUrl("https://localhost:8080/paymentFailed?paymentId=" + rmdto.getPaymentId());
			urldto.setStatus(Status.FAILED);

		} else if (rezultat.equals(TransactionResult.INSUFFICIENT_FUNDS)) {
			urldto.setUrl("https://localhost:8080/paymentFailed?paymentId=" + rmdto.getPaymentId());
			urldto.setStatus(Status.FAILED);

		} else if (rezultat.equals(TransactionResult.INVALID_DATE)) {
			urldto.setUrl("https://localhost:8080/paymentFailed?paymentId=" + rmdto.getPaymentId());
			urldto.setStatus(Status.FAILED);

		} else if (rezultat.equals(TransactionResult.ERROR)) {
			urldto.setUrl("https://localhost:8080/paymentError?paymentId=" + rmdto.getPaymentId());
			urldto.setStatus(Status.ERROR);

		}
		setAndSavePayment(rmdto, urldto);
		
		//TODO e-mail
		if (rezultat.equals(TransactionResult.SUCCESSFUL)) {
			Insurance i = insuranceService.findByPaymentId(rmdto.getPaymentId());
			//kreiraj dokument
			//posalji mail
			System.out.println("usao");
			
			final String username = "sistemielektronskog@gmail.com";
		    final String password = "poslovanja";
		    
			Properties props = new Properties();
			props.put("mail.smtp.auth", true);
		    props.put("mail.smtp.starttls.enable", true);
		    props.put("mail.smtp.host", "smtp.gmail.com");
		    props.put("mail.smtp.port", "587");

			
			
			Session session = Session.getInstance(props,
		            new javax.mail.Authenticator() {
		                protected PasswordAuthentication getPasswordAuthentication() {
		                    return new PasswordAuthentication(username, password);
		                }
		            });
			
			
		try {
	        OutputStream file = new FileOutputStream(new File("Insurance" + i.getId() + ".pdf"));

	        Document document = new Document();
	        PdfWriter.getInstance(document, file);

	        document.open();
	        
	        //Dodajem sliku
	        Image image = Image.getInstance("/Users/Milos/git/SEP_2016/Merchant/src/main/webapp/assets/img/travel2pdf.jpg");
	        image.setAlignment(Element.ALIGN_CENTER);
	        document.add(image);
	       // document.add(new Paragraph("Chuck Norris Insurance"));
	        document.add(new Paragraph(new Date().toString()));

	        document.addAuthor("SEP2016/17");
	        document.addCreationDate();
	        document.addCreator("Sep2016/2017");
	        document.addTitle("Sample PDF");

	        //Create Paragraph
	        Paragraph paragraph = new Paragraph("Insurance policy",new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD));
	        paragraph.setAlignment(Element.ALIGN_CENTER);
	        //New line
	        paragraph.add(new Paragraph(" "));
	        //paragraph.add("Informacije o osiguranju");
	        paragraph.add(new Paragraph(" "));
	        paragraph.add(new Paragraph(" "));	
	        document.add(paragraph);	

	        //Create a table in PDF
	        PdfPTable pdfTable = new PdfPTable(2);
	        Paragraph par1 = new Paragraph("Insurance carrier informations",new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD));
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
	        document.add( Chunk.NEWLINE );
	        

	        
	        
	        PdfPTable pdfTable2 = new PdfPTable(2);
	        Paragraph par2 = new Paragraph("Insuranced person informations",new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD));
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
	        
	        document.add( Chunk.NEWLINE );	
	        
	        
	        PdfPTable pdfTable3 = new PdfPTable(2);
	        Paragraph par3 = new Paragraph("Policy informations",new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD));
	        PdfPCell cell3 = new PdfPCell(par3);
	        cell3.setColspan(4);
	        cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
	        pdfTable3.addCell(cell3);
	        
	        pdfTable3.addCell("Destination");
	        //pdfTable3.addCell(i.getInsuranceTypes().get(0).getRiskCategories().get(1).getName());
	        i.getPricelist().getPricelistItems().get(0).getRiskSubcategory();
	        pdfTable3.addCell("North America");
	        
	        pdfTable3.addCell("Start date");
	        pdfTable3.addCell(i.getStartDate().toString());
	        
	        pdfTable3.addCell("End date");
	        pdfTable3.addCell(i.getEndDate().toString());
	        
	        pdfTable3.addCell("Insurance price");
	        pdfTable3.addCell(i.getTotalPrice().toString());
	        
	        document.add(pdfTable3);
	        
	        
	       /* com.itextpdf.text.List list = new com.itextpdf.text.List();
	        list.add("Start date" + "\t\t\t\t\t\t\t\t\t\t\t\t\t" + i.getStartDate().toString());
	        list.add("End date" + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + i.getEndDate().toString());
	        list.add("Total price" + "\t\t\t\t\t\t\t\t\t\t\t\t\t" + i.getTotalPrice().toString());
	        document.add(list);*/
	        
	        

	        //cell1 = new PdfPCell(new Phrase(i.getBuyer().getFirstName()));
	        //cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
	        //pdfTable.addCell(cell1);

	        
	        //pdfTable.setHeaderRows(1);

	        //pdfTable.addCell("Prezime osgiuranika");
	        //pdfTable.addCell(i.getBuyer().getLastName());

	        //pdfTable.addCell("Adresa osiguranika");
	        //pdfTable.addCell(i.getBuyer().getAddress());
	        

	        
	        //document.add(pdfTable2);
	        //document.add(pdfTable3);

	        document.close();
	        file.close();
	        
	        
	        try {

	            Message message = new MimeMessage(session);
	            message.setFrom(new InternetAddress("sistemielektronskog@gmail.com"));
	            message.setRecipients(Message.RecipientType.TO,
	                    InternetAddress.parse(i.getBuyer().getEmail()));
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
		System.out.println("poslat mail");
		}
		

		return new ResponseEntity<URLDto>(urldto, HttpStatus.OK);
	}

	@RequestMapping(value = "/paymentMessage", method = RequestMethod.POST)
	public ResponseEntity<URLDto> handlePaymentID(@RequestBody Integer paymentId) {

		Payment p = paymentService.findByPaymentId(paymentId);
		URLDto urldto = new URLDto();

		urldto.setResult(p.getTransactionResult());
		urldto.setStatus(p.getPaymentStatus());

		return new ResponseEntity<URLDto>(urldto, HttpStatus.OK);
	}

	private void setAndSavePayment(ResponseMessageDto rmdto, URLDto urldto) {

		Payment p = paymentService.findByPaymentId(rmdto.getPaymentId());
		p.setTransactionResult(rmdto.getResult());
		p.setPaymentStatus(urldto.getStatus());
		paymentService.save(p);
	}

}
