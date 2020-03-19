package com.example.demo.repository;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Weight;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class WeightRepositoryTest {
	
	@Autowired
	private WeightRepository weightRepository;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFindAll() {
		List<Weight> weightList = weightRepository.findAll();
		assertEquals(weightList.get(0).getId(), 1);
	}

	@Test
	public void testLoad() {
		Weight w2 = weightRepository.load(1);
		assertEquals(w2.getId(), 1);
	}

}
