package ftn.uns.ac.rs.tim6.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//SimpleMailMessage mail = new SimpleMailMessage();
		//mail.setFrom("sistemielektronskog@gmail.com");
		//mail.setTo(to);
		//mail.setSubject("Insurances");
		//mail.setText(message);
		//javaMailSender.send(mail);
	}
}