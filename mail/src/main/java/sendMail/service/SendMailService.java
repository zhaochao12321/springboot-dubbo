package sendMail.service;

import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.util.Date;
import java.util.Properties;

@Service
public class SendMailService {

    // 发送邮件的账号
    public static String ownEmailAccount = "woshizhaochao123@126.com";
    // 发送邮件的密码------》授权码
    public static String ownEmailPassword = "610685287";
    // 发送邮件的smtp 服务器 地址
    public static String myEmailSMTPHost = "smtp.126.com";
    // 发送邮件对方的邮箱
    public static String receiveMailAccount = "610685287@qq.com";

    public static void main(String[] args) throws Exception {

    }


    public static void  sendMail() {
        try {
            Properties prop = new Properties();
            // 设置邮件传输采用的协议smtp
            prop.setProperty("mail.transport.protocol", "smtp");
            // 设置发送人邮件服务器的smtp地址
            // 这里以网易的邮箱smtp服务器地址为例
            prop.setProperty("mail.smtp.host", myEmailSMTPHost);
            // 设置验证机制
            prop.setProperty("mail.smtp.auth", "true");

            // SMTP 服务器的端口 (非 SSL 连接的端口一般默认为 25, 可以不添加, 如果开启了 SSL 连接,
            // 需要改为对应邮箱的 SMTP 服务器的端口, 具体可查看对应邮箱服务的帮助,
            // QQ邮箱的SMTP(SLL)端口为465或587, 其他邮箱自行去查看)

        /*final String smtpPort = "465";
        prop.setProperty("mail.smtp.port", smtpPort);
        prop.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        prop.setProperty("mail.smtp.socketFactory.fallback", "false");
        prop.setProperty("mail.smtp.socketFactory.port", smtpPort);*/

            // 创建对象回话跟服务器交互
            Session session = Session.getInstance(prop);
            // 会话采用debug模式
            session.setDebug(true);
            // 创建邮件对象
            Message message = createSimpleMail(session);

            Transport trans = session.getTransport();
            // 链接邮件服务器
            trans.connect(ownEmailAccount, ownEmailPassword);
            // 发送信息
            trans.sendMessage(message, message.getAllRecipients());
            // 关闭链接
            trans.close();

        }
        catch (Exception exception){

            exception.printStackTrace();
        }



    }


    /**
     * @Title: createSimpleMail
     * @Description: 创建邮件对象
     * @author: chengpeng
     * @param @param session
     * @param @return
     * @param @throws Exception    设定文件
     * @return Message    返回类型
     * @throws
     */
    public static Message createSimpleMail(Session session) throws Exception {
        MimeMessage message = new MimeMessage(session);
        // 设置发送邮件地址,param1 代表发送地址 param2 代表发送的名称(任意的) param3 代表名称编码方式
        message.setFrom(new InternetAddress("woshizhaochao123@126.com", "小毛毛", "utf-8"));
        // 代表收件人
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(receiveMailAccount, "李小明", "utf-8"));
        // Cc: 抄送（可选）
        message.setRecipient(MimeMessage.RecipientType.CC, new InternetAddress("woshizhaochao123@126.com", "自己", "UTF-8"));
        // To: 增加收件人（可选）
        /*message.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress("dd@receive.com", "USER_DD", "UTF-8"));
        // Cc: 抄送（可选）
         message.setRecipient(MimeMessage.RecipientType.CC, new InternetAddress("ee@receive.com", "USER_EE", "UTF-8"));
        // Bcc: 密送（可选）
        message.setRecipient(MimeMessage.RecipientType.BCC, new InternetAddress("ff@receive.com", "USER_FF", "UTF-8"));*/
        // 设置邮件主题
        InetAddress addr = InetAddress.getLocalHost();
        String ip=addr.getHostAddress().toString(); //获取本机ip
        String hostName=addr.getHostName().toString(); //获取本机计算机名称
        String messageTo="现在是： "+new Date().toString()+"。"+"本机ip"+ip+"用户名"+hostName;
        message.setSubject("转发邮件");
        // 设置邮件内容
        message.setContent(messageTo, "text/html;charset=utf-8");
        // 设置发送时间
        message.setSentDate(new Date());
        // 保存上面的编辑内容
        message.saveChanges();
        // 将上面创建的对象写入本地
        OutputStream out = new FileOutputStream("xiaobai.eml");
        message.writeTo(out);
        out.flush();
        out.close();
        return message;

    }

}
