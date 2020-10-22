//package com.dna.gym;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//
//import com.dna.gym.model.Subscriber;
//import org.junit.Ignore;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.web.server.LocalServerPort;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.web.client.HttpClientErrorException;
//
//import java.time.LocalDate;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class SubscriberControllerIntegrationTest {
//	@Autowired
//	private TestRestTemplate restTemplate;
//
//	@LocalServerPort
//	private int port;
//
//	private String getRootUrl() {
//		return "http://localhost:" + port;
//	}
//
//	@Test
//	public void contextLoads() {
//
//	}
//
//	@Test
//	public void testGetAllEmployees() {
//		HttpHeaders headers = new HttpHeaders();
//		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
//
//		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/employees",
//				HttpMethod.GET, entity, String.class);
//
//		assertNotNull(response.getBody());
//	}
//
//	@Test
//	public void testGetEmployeeById() {
//		Subscriber subscriber = restTemplate.getForObject(getRootUrl() + "/employees/1", Subscriber.class);
//		System.out.println(subscriber.getFirstName());
//		assertNotNull(subscriber);
//	}
//
//	@Test
//	public void testCreateEmployee() {
//		Subscriber subscriber = new Subscriber();
//		subscriber.setEndOfSubscription(LocalDate.now());
//		subscriber.setFirstName("admin");
//
//
//		ResponseEntity<Subscriber> postResponse = restTemplate.postForEntity(getRootUrl() + "/employees", subscriber, Subscriber.class);
//		assertNotNull(postResponse);
//		assertNotNull(postResponse.getBody());
//	}
//
//	@Test
//	public void testUpdateEmployee() {
//		int id = 1;
//		Subscriber subscriber = restTemplate.getForObject(getRootUrl() + "/employees/" + id, Subscriber.class);
//		subscriber.setFirstName("admin1");
//
//
//		restTemplate.put(getRootUrl() + "/employees/" + id, subscriber);
//
//		Subscriber updatedSubscriber = restTemplate.getForObject(getRootUrl() + "/employees/" + id, Subscriber.class);
//		assertNotNull(updatedSubscriber);
//	}
//
//	@Test
//	public void testDeleteEmployee() {
//		int id = 2;
//		Subscriber subscriber = restTemplate.getForObject(getRootUrl() + "/employees/" + id, Subscriber.class);
//		assertNotNull(subscriber);
//
//		restTemplate.delete(getRootUrl() + "/employees/" + id);
//
//		try {
//			subscriber = restTemplate.getForObject(getRootUrl() + "/employees/" + id, Subscriber.class);
//		} catch (final HttpClientErrorException e) {
//			assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
//		}
//	}
//}
