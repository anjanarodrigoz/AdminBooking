package com.example.adminbooking.JavaMail;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

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

public class JavaMailAPI extends AsyncTask<Void,Void,Void> {



    private Context mContext;
    private Session mSession;
    private String mMail;
    private String mTemplate;
    private String pdfPath;
    public int messageSent =0;





    private ProgressDialog mProgressDialog;



    //Constructor
    public JavaMailAPI(Context mContext, String mMail, String mTemplate, String mPdfPath) {

        this.mContext = mContext;
        this.mMail = mMail;
        this.mTemplate = mTemplate;
        this.pdfPath = mPdfPath;





    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        //Show progress dialog while sending email
        mProgressDialog = ProgressDialog.show(mContext,"Sending message", "Please wait...",false,false);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        //Dismiss progress dialog when message successfully send
        mProgressDialog.dismiss();

        //Show success toast
        if(messageSent == 1){
            Toast.makeText(mContext,"Message Sent",Toast.LENGTH_SHORT).show();



        }else{
            Toast.makeText(mContext,"Message Not Sent",Toast.LENGTH_SHORT).show();


        }

    }



    @Override
    protected Void doInBackground(Void... params) {
        //Creating properties
        Properties props = new Properties();

        //Configuring properties for gmail
        //If you are not using gmail you may need to change the values
        props.put("mail.smtp.ssl.protocols","TLSv1.2");
        props.put("mail.smtp.host", "premium134.web-hosting.com");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        //Creating a new session
        mSession = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    //Authenticating the password
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(Utils.EMAIL, Utils.PASSWORD);
                    }
                });

        try {
            //Creating MimeMessage object
            Message mm = new MimeMessage(mSession);

            //Setting sender address
            mm.setFrom(new InternetAddress(Utils.EMAIL,"MELBOURNE MOVER"));
            //Adding receiver
            mm.addRecipient(Message.RecipientType.TO, new InternetAddress(mMail));
            mm.addRecipient(Message.RecipientType.CC,new InternetAddress("mover9m@yahoo.com"));
            //Adding subject
            mm.setSubject("BOOKING DETAILS");

            MimeBodyPart bodyTemplate = new MimeBodyPart();

            bodyTemplate.setContent(mTemplate, "text/html");


            Multipart multipart = new MimeMultipart();




            // adds attachments
            if(pdfPath != null){
                MimeBodyPart attachPart = new MimeBodyPart();

                try {

                    attachPart.attachFile(pdfPath);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }



                multipart.addBodyPart(attachPart);
            }

            multipart.addBodyPart(bodyTemplate);
            mm.setContent(multipart);
            //set body

            //Sending email
            Transport.send(mm);
            messageSent = 1;


//            BodyPart messageBodyPart = new MimeBodyPart();
//
//            messageBodyPart.setText(message);
//
//            Multipart multipart = new MimeMultipart();
//
//            multipart.addBodyPart(messageBodyPart);
//
//            messageBodyPart = new MimeBodyPart();
//
//            DataSource source = new FileDataSource(filePath);
//
//            messageBodyPart.setDataHandler(new DataHandler(source));
//
//            messageBodyPart.setFileName(filePath);
//
//            multipart.addBodyPart(messageBodyPart);

//            mm.setContent(multipart);

        } catch (MessagingException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }


}
