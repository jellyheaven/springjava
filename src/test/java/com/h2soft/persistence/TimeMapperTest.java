package com.h2soft.persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.h2soft.mapper.TimeMapper;
import com.h2soft.springjava.config.RootConfig;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j
public class TimeMapperTest {
	
	@Setter(onMethod_ = @Autowired)
	private TimeMapper timeMapper;
	
	@Test
	public void testGetTime() {
		log.info("timeMapper getClass().getName(): "+timeMapper.getClass().getName());
		log.info("timeMapper getTime(): "+timeMapper.getTime());
	}
	
	@Test
	public void testGetTime2() {
		log.info("timeMapper getTime2(): "+timeMapper.getTime2());
	}
	
}
