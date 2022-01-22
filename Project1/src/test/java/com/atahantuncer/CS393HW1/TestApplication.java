package com.atahantuncer.CS393HW1;

import com.atahantuncer.CS393HW1.model.*;
import com.atahantuncer.CS393HW1.repository.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class TestApplication {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	AddressRepository addressRepository;

	@Autowired
	ShopRepository shopRepository;

	@Autowired
	ProductRepository productRepository;

	@Autowired
	OrderRepository orderRepository;

	@Test
	void test() {


		Address address1=new Address();
		address1.setCity("Istanbul");
		address1.setText("Caddebostan Migros");

		Address address2 = new Address();
		address2.setCity("Istanbul");
		address2.setText("Özyeğin Üniversitesi Yurt 1");

		Address address3 =new Address();
		address3.setCity(address1.getCity());
		address3.setText(address1.getText());


		Customer customer1=new Customer();
		customer1.setFirstName("Atahan");;
		customer1.setLastName("Tuncer");

		Customer customer2=new Customer();
		customer2.setFirstName("Mehmet");;
		customer2.setLastName("Deniz");


		customer1.setAddress(address1);
		customer2.setAddress(address2);


		Product product1 = new Product();
		product1.setName("Macbook Pro M1 Max");
		product1.setPrice(2999.99);

		Product product2 = new Product();
		product2.setName("Apple Watch 7");
		product2.setPrice(699.99);

		Shop shop = new Shop();
		shop.setName("Apple Store");
		shop.setAddress("Istanbul");

		product1.setShop(shop);
		product2.setShop(shop);
		shop.getProducts().add(product1);
		shop.getProducts().add(product2);

		customer1.setShop(shop);
		customer2.setShop(shop);
		shop.getCustomers().add(customer1);
		shop.getCustomers().add(customer2);

		Order order1 = new Order();
		order1.setAmount(2);
		order1.setDate(new Date());
		product1.getOrders().add(order1);
		order1.getProducts().add(product1);

		order1.setCustomer(customer1);
		customer1.getOrders().add(order1);

		Order order2 = new Order();
		order2.setAmount(1);
		order2.setDate(new Date());
		order1.getProducts().get(0).getOrders().add(order2);  // product1.getOrders().add(order2);
		order2.getProducts().add(order1.getProducts().get(0));  // order2.getProducts().add(product1);
		product2.getOrders().add(order2);
		order2.getProducts().add(product2);

		order2.setCustomer(customer2);
		customer2.getOrders().add(order2);


		shopRepository.save(shop);

		// Lines below works only with 'spring.jpa.properties.hibernate.enable_lazy_load_no_trans=true' inside properties file
		Order orderFetchedFromDatabase = orderRepository.getById(customer1.getOrders().get(0).getId());

		Address tempAdr = new Address();
		tempAdr.setCity("Antalya");
		tempAdr.setText("Konyaaltı");
		orderFetchedFromDatabase.getCustomer().setAddress(tempAdr);

		shop.getCustomers().removeIf(obj -> obj.getId() == orderFetchedFromDatabase.getCustomer().getId());
		shop.getCustomers().add(orderFetchedFromDatabase.getCustomer());
		shopRepository.save(shop);

	}

}
