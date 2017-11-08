package com.mycompany.kafka;

import java.sql.Time;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLException;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.BytesDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.utils.Bytes;

public class KafkaConsumerFunc {
	
	private Iterator<ConsumerRecord<String, Bytes>> recordItr = null;
	public String next(KafkaConsumer consumer, long timeout, TimeUnit unit) {
	      if (recordItr == null) {
	        // 记录迭代器为null，要重新拉取下一批数据
	        ConsumerRecords<String, Bytes> records = consumer.poll(unit.toMillis(timeout));
	        if (records.isEmpty()) {
	          // 在指定的时间内没有拉取到数据
	          return null;
	        } else {
	          // 得到迭代器，下面的代码会用这个迭代器拿到数据
	          recordItr = records.iterator();
	        }
	      }

	      if (recordItr.hasNext()) {
	        ConsumerRecord<String, Bytes> record = recordItr.next();
	        return new String(record.value().get());
	      } else {
	        // 本次拉取的数据已经处理完了，设置iterator为null，拉取一批数据
	        recordItr = null;
	        return next(consumer, timeout, unit);
	      }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Properties props = new Properties();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "10.210.214.72:9192");
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "druidrecover");
		props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true"); //　不需要commit
		props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "30000");
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, BytesDeserializer.class.getName());
		props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
	
		KafkaConsumer consumer = new KafkaConsumer<String, Bytes>(props);
		String topic1 = "topic-charming-test1";
	    String topic2 = "topic-charming-test2";
	    
	    String topic = "topic-charming-test";
	    
	    String[] strings = new String[500];
	    for (int i = 0; i < strings.length; i++) {
	    		strings[i] = topic + i;
	    }
		consumer.subscribe(Arrays.asList(strings));
		
		KafkaConsumerFunc func = new KafkaConsumerFunc();
		int i=0;
		while (true) {
			i++;
			String ret = func.next(consumer, 5, TimeUnit.SECONDS);
			System.out.println(ret);
//			if(i==10) {
//				consumer.subscribe(Arrays.asList(topic1));
//			}
		}
	}

}
