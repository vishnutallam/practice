package com.ID_Website.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;




public class Mailing  {
	
	static String key,data,from,to,password;
	static String[] AllToAdress;
	static String host = "smtp.gmail.com";
	
	
	public void GetData() throws IOException{
		
		File prop = new File("Input/credentials.properties");
		FileInputStream input =new FileInputStream(prop);
		Properties props = new Properties();
		props.load(input);
	    
		Enumeration value = props.keys();
		
		while(value.hasMoreElements()){
			key = (String) value.nextElement();
			data = props.getProperty(key);
			
			if(key.equals("to")){
				to=data;
			}
			if(key.equals("from")){
				from=data;
			}
			if(key.equals("password")){
				password=data;
			}
			
		}
		
		AllToAdress = to.split(",");
		
	}
	
public void mail() throws IOException, AddressException, MessagingException{

	GetData();
	
	try{
//	System properties	
	Properties SysmProp = System.getProperties();
	SysmProp.put("mail.smtp.starttls.enable", "true");
	SysmProp.put("mail.smtp.host", host);
	SysmProp.put("mail.smtp.user", from);
	SysmProp.put("mail.smtp.password", password);
	SysmProp.put("mail.smtp.port", "587");      //465
	SysmProp.put("mail.smtp.auth", "true");
	
	
//	Creating session and mime message object	
	Session session = Session.getInstance(SysmProp);
	MimeMessage message = new MimeMessage(session) ;
	message.setFrom(new InternetAddress(from)); 
		
//	Form Internet address array
	InternetAddress[] ia = new InternetAddress[AllToAdress.length];
	
	for(int i=0; i<AllToAdress.length;i++){
		ia[i] = new InternetAddress(AllToAdress[i]);		
	}
	
	for(int j=0;j<AllToAdress.length;j++){
		message.addRecipient(Message.RecipientType.TO, ia[j]);		
	}
	
	Date dt = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
    String strDate= formatter.format(dt);  
	
//	Set subject and body and adding attachments.
	message.setSubject("Execution report on "+strDate);	
	BodyPart messageBodyPart = new MimeBodyPart();	
	messageBodyPart.setText("Hello, Good day! \n"
			+ "\n"
			+ "All scenarios have been executed. Please find the attached report of the execution.  \n"
			+ "\n"
			+ "Thanks,\n"
			+ "Vishnupriya.");
	Multipart multipart = new MimeMultipart();
	multipart.addBodyPart(messageBodyPart);
	
	
	// Add Extent Report
    File emailableReport = new File(System.getProperty("user.dir") + "./test-output/emailable-report.html");
    addAttachment(multipart, emailableReport);

    // Add emailable report
    File extentReport = new File(System.getProperty("user.dir") + "./Screenshots/Test-Report.html");
    addAttachment(multipart, extentReport);

    message.setContent(multipart);



	
	//File file2 = new File(System.getProperty("user.dir")+"./test-output/emailable-report.html");// when execute from eclipse
	
	//File file2 = new File(System.getProperty("user.dir")+"./target/surefire-reports/emailable-report.html"); // when execute from Jenkins
	
	//File file2 = new File(System.getProperty("user.dir")+ "./log/application.html"); //log/application.html

	//File file2 = new File(System.getProperty("user.dir")+"./log/testlog.log");//log/testlog.log
	
//	File file2 = new File(System.getProperty("user.dir")+"./Screenshots/Test-Report.html");//Screenshots/Test-Report
//	
//	messageBodyPart = new MimeBodyPart();
//	DataSource source = new FileDataSource(file2.getAbsolutePath());
//    messageBodyPart.setDataHandler(new DataHandler(source));
//    messageBodyPart.setFileName("Report_"+strDate+".html");
//    multipart.addBodyPart(messageBodyPart);
//    message.setContent(multipart);
	
//	Start transportation of message
	Transport trans = session.getTransport("smtp");
	trans.connect(host, from, password);
	trans.sendMessage(message, message.getAllRecipients());
	
	for(String address:AllToAdress){
		System.out.println("Mail has been sent to "+address);		
	}
	
	trans.close();
	}catch(AddressException ae ){
		System.out.println("Address exception: "+ae);
	}catch(MessagingException me){
		System.out.println("Messaging exception: "+me);
	}catch(Exception e){
		
		System.out.println(e);
	}
	

}
private void addAttachment(Multipart multipart, File file) throws MessagingException {
	
	Date dt = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
    String strDate= formatter.format(dt); 
    
    BodyPart messageBodyPart = new MimeBodyPart();
    DataSource source = new FileDataSource(file.getAbsolutePath());
    messageBodyPart.setDataHandler(new DataHandler(source));
    messageBodyPart.setFileName(file.getName()+" "+strDate+".html");
    multipart.addBodyPart(messageBodyPart);
}

}   


