package streetdavid.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import streetdavid.DeliveryManagementApplication;
import streetdavid.domain.ChangeDeliveryStatus;
import streetdavid.domain.DeliveryCanceled;
import streetdavid.domain.DeliveryCollectionProcessing;
import streetdavid.domain.DeliveryCompleted;
import streetdavid.domain.DeliveryHasStarted;

@Entity
@Table(name = "ProductDelivery_table")
@Data
//<<< DDD / Aggregate Root
public class ProductDelivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long orderId;

    private String productName;

    private Long productId;

    private Integer qty;

    private String status;

    private Date deliveryDt;

    @PostPersist
    public void onPostPersist() {
        DeliveryHasStarted deliveryHasStarted = new DeliveryHasStarted(this);
        deliveryHasStarted.publishAfterCommit();

        DeliveryCompleted deliveryCompleted = new DeliveryCompleted(this);
        deliveryCompleted.publishAfterCommit();

        ChangeDeliveryStatus changeDeliveryStatus = new ChangeDeliveryStatus(
            this
        );
        changeDeliveryStatus.publishAfterCommit();

        DeliveryCollectionProcessing deliveryCollectionProcessing = new DeliveryCollectionProcessing(
            this
        );
        deliveryCollectionProcessing.publishAfterCommit();
    }

    @PostUpdate
    public void onPostUpdate() {
        DeliveryCanceled deliveryCanceled = new DeliveryCanceled(this);
        deliveryCanceled.publishAfterCommit();
    }

    @PreUpdate
    public void onPreUpdate() {}

    public static ProductDeliveryRepository repository() {
        ProductDeliveryRepository productDeliveryRepository = DeliveryManagementApplication.applicationContext.getBean(
            ProductDeliveryRepository.class
        );
        return productDeliveryRepository;
    }

    //<<< Clean Arch / Port Method
    public static void deliveryRequest(Ordered ordered) {
        //implement business logic here:

        /** Example 1:  new item 
        ProductDelivery productDelivery = new ProductDelivery();
        repository().save(productDelivery);

        */

        /** Example 2:  finding and process
        
        repository().findById(ordered.get???()).ifPresent(productDelivery->{
            
            productDelivery // do something
            repository().save(productDelivery);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void cancellationRequest(Canceled canceled) {
        //implement business logic here:

        /** Example 1:  new item 
        ProductDelivery productDelivery = new ProductDelivery();
        repository().save(productDelivery);

        */

        /** Example 2:  finding and process
        
        repository().findById(canceled.get???()).ifPresent(productDelivery->{
            
            productDelivery // do something
            repository().save(productDelivery);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
