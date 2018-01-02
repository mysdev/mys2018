package com.jing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

//	@Autowired
//	private JavaMailSender mailSender;

	@Test
	public void sendSimpleMail() throws Exception {
		/* MimeMessage mimeMessage = mailSender.createMimeMessage();
		 MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		 helper.setFrom("chenshihua2710@sina.com");
		 helper.setTo("411461507@qq.com");
		 helper.setSubject("主题：有附件");
		 helper.setText("有附件的邮件");
//		 FileSystemResource file = new FileSystemResource(new File("weixin.jpg"));
//		 helper.addAttachment("附件-1.jpg", file);
//		 helper.addAttachment("附件-2.jpg", file);
		 mailSender.send(mimeMessage);*/
	}
}
