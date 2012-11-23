package cn.fyg.qt.infrastructure.mail;

public interface EmailService {

	void sendMail(String to, String subject, String htmlText)
			throws EmailException;

}
