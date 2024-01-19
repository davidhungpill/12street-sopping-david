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
    ProductDeliveryRepository productDeliveryRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Ordered'"
    )
    public void wheneverOrdered_DeliveryRequest(@Payload Ordered ordered) {
        Ordered event = ordered;
        System.out.println(
            "\n\n##### listener DeliveryRequest : " + ordered + "\n\n"
        );

        // Comments //
        //1. create delivery aggregation
        // 2. send delivery request to CJ
        // 3. notify delivery start to customer
        // 4. ---
        -//

        // Sample Logic //
        ProductDelivery.deliveryRequest(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Canceled'"
    )
    public void wheneverCanceled_CancellationRequest(
        @Payload Canceled canceled
    ) {
        Canceled event = canceled;
        System.out.println(
            "\n\n##### listener CancellationRequest : " + canceled + "\n\n"
        );

        // Sample Logic //
        ProductDelivery.cancellationRequest(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
