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
    InventoryManagementRepository inventoryManagementRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DeliveryCompleted'"
    )
    public void wheneverDeliveryCompleted_InventoryChange(
        @Payload DeliveryCompleted deliveryCompleted
    ) {
        DeliveryCompleted event = deliveryCompleted;
        System.out.println(
            "\n\n##### listener InventoryChange : " + deliveryCompleted + "\n\n"
        );

        // Sample Logic //
        InventoryManagement.inventoryChange(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DeliveryCollectionProcessing'"
    )
    public void wheneverDeliveryCollectionProcessing_InventoryChange(
        @Payload DeliveryCollectionProcessing deliveryCollectionProcessing
    ) {
        DeliveryCollectionProcessing event = deliveryCollectionProcessing;
        System.out.println(
            "\n\n##### listener InventoryChange : " +
            deliveryCollectionProcessing +
            "\n\n"
        );

        // Sample Logic //
        InventoryManagement.inventoryChange(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
