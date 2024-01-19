package streetdavid.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import streetdavid.MyPageApplication;

@Entity
@Table(name = "Message_table")
@Data
//<<< DDD / Aggregate Root
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public static MessageRepository repository() {
        MessageRepository messageRepository = MyPageApplication.applicationContext.getBean(
            MessageRepository.class
        );
        return messageRepository;
    }

    //<<< Clean Arch / Port Method
    public static void requestToSendSms(ChangeOrderStatus changeOrderStatus) {
        //implement business logic here:

        /** Example 1:  new item 
        Message message = new Message();
        repository().save(message);

        */

        /** Example 2:  finding and process
        
        repository().findById(changeOrderStatus.get???()).ifPresent(message->{
            
            message // do something
            repository().save(message);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
