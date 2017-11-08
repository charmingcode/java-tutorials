package com.mycompany.kafka;

import java.util.Properties;

import kafka.admin.AdminUtils;
import kafka.utils.ZkUtils;

public class KafkaTopicDeleteFunc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Properties props = new Properties();
	    props.put("bootstrap.servers", "10.210.214.72:9192");
	    props.put("acks", "all");
	    props.put("retries", 3);
	    props.put("batch.size", 16384);
	    props.put("linger.ms", 1);
	    props.put("buffer.memory", 33554432);
	    
	   
	    KafkaProduceFunc instance = new KafkaProduceFunc();
	    ZkUtils zkUtils = ZkUtils.apply("10.210.214.72,10.210.214.73", 15 * 1000, 10 * 1000, false);
	    
	    String topic = "topic-charming-test1";
	    AdminUtils.deleteTopic(zkUtils, topic);
	    if (AdminUtils.topicExists(zkUtils, topic)) {
	    		System.out.println("topic delete failed, topic=" + topic);
        } else {
        		System.out.println("topic delete ok, topic=" + topic);	
        }
	}

}
