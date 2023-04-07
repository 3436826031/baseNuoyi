import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.jms.*;
import javax.xml.soap.Text;


/***
 * ActiveMQ 消息队列
 */




@RestController
@RequestMapping("/xxdl")
//消息的发送者
public class Sender {


    @Autowired
    private  JmsTemplate jmsTemplate;


    @GetMapping("/send")
    public void sendMsg() {
        jmsTemplate.send("ceshi",session -> {
                    TextMessage textMessage=session.createTextMessage("23213213");
                    return textMessage;
                });
    }







    public void send(){

        try {
            // 1. 获取连接工厂
            ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(
                    ActiveMQConnectionFactory.DEFAULT_USER,
                    ActiveMQConnectionFactory.DEFAULT_PASSWORD,
                    "tcp://124.222.141.27:61616"
                    //                "tcp://http://124.222.141.27/:61616"
            );

            //获取一个连接
            Connection connection=factory.createConnection();
            //获取一个session会话
            Session session=connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
            Queue user = session.createQueue("user");

            MessageProducer producer = session.createProducer(user);

            TextMessage test = session.createTextMessage("测试信息");
            producer.send(test);



            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }finally{


        }


    }

}
