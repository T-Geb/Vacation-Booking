package com.Project.Bootstrap;

import com.Project.Dao.CustomerRepository;
import com.Project.Dao.DivisionRepository;
import com.Project.Entities.Customer;
import com.Project.Entities.Division;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class BootStrapData implements CommandLineRunner { /*CommandLineRunner tells spring when it finds these commands, to run them.*/

    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;

    public BootStrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }

    @Override
    public void run(String... args) throws Exception {

       if(customerRepository.count() <= 1) {

           Division division1 = divisionRepository.getReferenceById(32L);
           Customer timothy = new Customer("Timothy", "Harry", "123 Main Street", "45334","(343)675-8787",division1);
           customerRepository.save(timothy);

           Division division2 = divisionRepository.getReferenceById(23L);
           Customer sarah = new Customer("Sarah", "Williams", "456 Oak Lane", "98234","(343)545-2343",division2);
           customerRepository.save(sarah);

           Division division3 = divisionRepository.getReferenceById(3L);
           Customer michael = new Customer("Michael", "Johnson","789 Pine Road","45783","(555)987-6543",division3);
           customerRepository.save(michael);

           Division division4 = divisionRepository.getReferenceById(67L);
           Customer emily = new Customer("Emily","Smith","321 Maple Street","12456","(555)456-7890",division4);
           customerRepository.save(emily);

           Division division5 = divisionRepository.getReferenceById(12L);
           Customer james = new Customer("James","Brown","654 Cedar Avenue","68593","(234)543-1323",division5);
           customerRepository.save(james);

           System.out.println("Customers have been added");

       }
       else {
           System.out.println("Customers have already been added");
       }

    }
}
