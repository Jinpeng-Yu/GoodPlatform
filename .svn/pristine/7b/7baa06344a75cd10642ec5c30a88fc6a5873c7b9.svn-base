package com.hitwh.shop.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.io.File;
import java.util.List;


/**
 * @ClassName MailService
 * @Description 提供邮件发送服务
 * @Author 孙一恒
 * @Date 2019/6/15 20:49
 * @Version 1.0
 **/
@Service
public class MailService {
    @Value("${spring.mail.username}")
    private String from;

    @Autowired
    JavaMailSender mailSender;

    private Logger logger = LoggerFactory.getLogger(MailService.class);

    // 发送一封普通的邮件
    public void sendMail(String to, String subject, String content) {
        logger.info("To:" + to + ",Subject:" + subject + ",content:" + content);
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(from);
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(content);
        mailSender.send(mailMessage);
        logger.info("邮件发送成功");
    }

    // 发送带有附件的邮件
    public void sendAttachmentsMail(String to, String title, String cotent, List<File> fileList){
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message,true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(title);
            helper.setText(cotent);
            String fileName = null;
            for (File file:fileList) {
                fileName = MimeUtility.encodeText(file.getName(), "GB2312", "B");
                helper.addAttachment(fileName, file);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        mailSender.send(message);
        logger.info("邮件发送成功");
    }
}
