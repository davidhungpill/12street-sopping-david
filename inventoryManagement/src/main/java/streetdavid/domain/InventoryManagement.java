package streetdavid.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import streetdavid.InventoryManagementApplication;
import streetdavid.domain.InventoryDecreased;
import streetdavid.domain.InventoryIncreases;

@Entity
@Table(name = "InventoryManagement_table")
@Data
//<<< DDD / Aggregate Root
public class InventoryManagement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long productId;

    private String productName;

    private Integer qty;

    @PostUpdate
    public void onPostUpdate() {
        InventoryDecreased inventoryDecreased = new InventoryDecreased(this);
        inventoryDecreased.publishAfterCommit();

        InventoryIncreases inventoryIncreases = new InventoryIncreases(this);
        inventoryIncreases.publishAfterCommit();
    }

    public static InventoryManagementRepository repository() {
        InventoryManagementRepository inventoryManagementRepository = InventoryManagementApplication.applicationContext.getBean(
            InventoryManagementRepository.class
        );
        return inventoryManagementRepository;
    }

    //<<< Clean Arch / Port Method
    public static void inventoryChange(DeliveryCompleted deliveryCompleted) {
        //implement business logic here:

        /** Example 1:  new item 
        InventoryManagement inventoryManagement = new InventoryManagement();
        repository().save(inventoryManagement);

        InventoryDecreased inventoryDecreased = new InventoryDecreased(inventoryManagement);
        inventoryDecreased.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryCompleted.get???()).ifPresent(inventoryManagement->{
            
            inventoryManagement // do something
            repository().save(inventoryManagement);

            InventoryDecreased inventoryDecreased = new InventoryDecreased(inventoryManagement);
            inventoryDecreased.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void inventoryChange(
        DeliveryCollectionProcessing deliveryCollectionProcessing
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        InventoryManagement inventoryManagement = new InventoryManagement();
        repository().save(inventoryManagement);

        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryCollectionProcessing.get???()).ifPresent(inventoryManagement->{
            
            inventoryManagement // do something
            repository().save(inventoryManagement);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
