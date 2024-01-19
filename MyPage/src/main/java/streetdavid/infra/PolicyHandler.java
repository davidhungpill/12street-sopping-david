package streetdavid.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import streetdavid.config.kafka.KafkaProcessor;
import streetdavid.domain.*;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    MessageRepository messageRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ChangeOrderStatus'"
    )
    public void wheneverChangeOrderStatus_RequestToSendSms(
        @Payload ChangeOrderStatus changeOrderStatus
    ) {
        ChangeOrderStatus event = changeOrderStatus;
        System.out.println(
            "\n\n##### listener RequestToSendSms : " +
            changeOrderStatus +
            "\n\n"
        );

        // Sample Logic //
        Message.requestToSendSms(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
