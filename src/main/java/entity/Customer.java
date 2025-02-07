package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity //map to table
@Table(name = "customer_table") //set database table name
public class Customer {
    @Id //primary key
//    @GeneratedValue(strategy = GenerationType.AUTO) // auto generate
    @GeneratedValue(strategy = GenerationType.IDENTITY) //manual add id
//    @GeneratedValue(strategy = GenerationType.UUID) //Random id generate
    private int id;
    private String name;
    @Column(name = "email_address" , nullable = true)
    //nullable true = can null
    //nullable false = cannot null
    private String email;

    @Column(nullable = false)
    private String phone;

    @Transient // for sensitive data
    //non persist
    private String cardNumber;

    @Lob // for large data or binary data
    private String description;

    @Embedded
    private CustomerFullName customerFullName;
}


// image --> byte[] --> base64 encoded string
