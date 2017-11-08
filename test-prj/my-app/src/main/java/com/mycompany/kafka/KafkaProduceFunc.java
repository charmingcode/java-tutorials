package com.mycompany.kafka;

import java.util.Arrays;
import java.util.Properties;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLException;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.BytesSerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.kafka.common.utils.Bytes;

import kafka.admin.AdminUtils;
import kafka.utils.ZkUtils;
import scala.Array;

public class KafkaProduceFunc {
	
	public ZkUtils zkUtils;
	
	public void createTopic(String topic, int partitions, int replicants) {
		if (!AdminUtils.topicExists(zkUtils, topic)) {
		       
	        try {
	          AdminUtils.createTopic(zkUtils, topic, partitions, replicants, new Properties(), null);
	          System.out.println("topic create ok, topic=" + topic);
	        } catch (Exception e) {
	          // 创建topic失败，可能是另外一台机器在刚刚已经创建过，这里先判断topic是否存在
	          if (AdminUtils.topicExists(zkUtils, topic)) {
	           
	          }
	        }
	      } else {
	    	  	System.out.println("topic exist, topic=" + topic);
	      }
	}
	
	public static void main(String[] args) throws Exception{
		KafkaProducer<String, Bytes> producer;
		// TODO Auto-generated method stub
		Properties props = new Properties();
	    props.put("bootstrap.servers", "10.210.214.72:9192");
	    props.put("acks", "all");
	    props.put("retries", 3);
	    props.put("batch.size", 16384);
	    props.put("linger.ms", 1);
	    props.put("buffer.memory", 33554432);
	    
	   
	    KafkaProduceFunc instance = new KafkaProduceFunc();
	    instance.zkUtils = ZkUtils.apply("10.210.214.72,10.210.214.73", 15 * 1000, 10 * 1000, false);
//	    if (logger.isInfoEnabled()) {
//	      logger.info("init KafkaRedoLogger with properties:{}", props);
//	    }
	    producer = new KafkaProducer<String, Bytes>(props, new StringSerializer(), new BytesSerializer());
	 
	    String topic = "topic-charming-test";
	    
	    String[] strings = new String[5];
	    for (int i = 0; i < strings.length; i++) {
	    		strings[i] = "sfdfgfdgfgfh";
	    		instance.createTopic(topic + i, 2, 1);
	    }
	    
	    while(true) {
	    		TimeUnit.SECONDS.sleep(3);
	    		  for (int i = 0; i < strings.length; i++) {
	  	    		strings[i] += i;
	  	    		producer.send(new ProducerRecord<String, Bytes>(topic+i, new Bytes(strings[i].getBytes())));
	  		}
	    }
	    
	}
}
