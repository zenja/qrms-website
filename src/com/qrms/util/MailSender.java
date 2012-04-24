package com.qrms.util;

import java.util.ArrayList;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * Description: This class sends email to a group of or single person. by smtp
 * protocol.
 * 
 * @author Zhaolu & Zhangzu
 * @version 1.0
 */

public class MailSender {

	String host = "software.nju.edu.cn";
	String from = "ysm08@software.nju.edu.cn";
	String password = "14789632ysm";
	String validateLink = null;
	ArrayList<String> to = new ArrayList<String>();
	ArrayList<String> files = new ArrayList<String>();

	/**
	 * Description: Add the receivers of email.
	 * 
	 * @param args
	 */
	public void addReceivers(String... args) {
		for (int i = 0; i < args.length; i++) {
			to.add(args[i]);
		}
	}

	/**
	 * Description: Add appendix files if any to email.
	 * 
	 * @param args
	 */
	public void addFileAffix(String... args) {
		for (int i = 0; i < args.length; i++) {
			files.add(args[i]);
		}
	}

	/**
	 * Description: Add a link as content of email.
	 */
	public void setValidateLink() {
		MD5 md5 = MD5.getMD5Instance();
		this.validateLink = md5.creatValidateLink();
	}

	/**
	 * Description: Use the java mail to send email.
	 * 
	 * @exception MessagingException
	 */
	public String sendTextMail() {
		setValidateLink();
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.auth", true);
		Session session = Session.getDefaultInstance(props, null);
		MimeMessage message = new MimeMessage(session);
		MimeMultipart mp = new MimeMultipart();
		try {
			MimeBodyPart html = new MimeBodyPart();
			html
					.setContent(
							"<p><strong>Dear User:</strong></p> "
									+ "<p>You recently registered for QR Marks the Spot using this email address. Please complete your registration by following the link below"
									+ "<p><a href="
									+ validateLink
									+ ">Click here to activate your account</a></p>"
									+ "<p>If you did not recently register, or believe you have received this email in error, please disregard this message. </p>"
									+ "<p>Thanks! </p>"
									+ "<p> the QR Marks the Spot Team</p>",
							"text/html;charset=UTF-8");
			mp.addBodyPart(html);
			InternetAddress[] toAddr = new InternetAddress[to.size()];
			for (int i = 0; i < to.size(); i++) {
				toAddr[i] = new InternetAddress(to.get(i));
			}
			message.setContent(mp);
			message.setFrom(new InternetAddress(from));
			message.addRecipients(Message.RecipientType.TO, toAddr);
			message.setSubject("Activating your account -- QRMS");
			message.saveChanges();
			Transport transport = session.getTransport("smtp");
			transport.connect(host, from, password);
			transport.sendMessage(message, message.getAllRecipients());
		} catch (MessagingException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}

}
