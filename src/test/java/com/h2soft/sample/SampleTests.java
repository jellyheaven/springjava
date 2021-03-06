package com.h2soft.sample;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.h2soft.springjava.config.RootConfig;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j
public class SampleTests {
	
	@Setter(onMethod_ = @Autowired )
	private Restaurant restaurant;
	
	@Test
	public void testExit() {		
		assertNotNull(restaurant);		
		log.info(restaurant);
		log.info("=====================");
		log.info(restaurant.getChef());
	}
}
