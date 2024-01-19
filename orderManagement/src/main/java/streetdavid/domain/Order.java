package streetdavid.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import streetdavid.OrderManagementApplication;
import streetdavid.domain.Canceled;
import streetdavid.domain.ChangeOrderStatus;
import streetdavid.domain.Ordered;

@Entity
@Table(name = "Order_table")
@Data
//<<< DDD / Aggregate Root
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long userId;

    private String productName;

    private Long productId;

    private Integer qty;

    private String status;

    private Date orderDate;

    @PostPersist
    public void onPostPersist() {
        Ordered ordered = new Ordered(this);
        ordered.publishAfterCommit();
    }

    @PostUpdate
    public void onPostUpdate() {
        ChangeOrderStatus changeOrderStatus = new ChangeOrderStatus(this);
        changeOrderStatus.publishAfterCommit();
    }

    @PostRemove
    public void onPostRemove() {
        Canceled canceled = new Canceled(this);
        canceled.publishAfterCommit();
    }

    public static OrderRepository repository() {
        OrderRepository orderRepository = OrderManagementApplication.applicationContext.getBean(
            OrderRepository.class
        );
        return orderRepository;
    }

    //<<< Clean Arch / Port Method
    public static void stateChange(ChangeDeliveryStatus changeDeliveryStatus) {
        //implement business logic here:

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(changeDeliveryStatus.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void notifyToWaitingUser(
        InventoryIncreases inventoryIncreases
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(inventoryIncreases.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
