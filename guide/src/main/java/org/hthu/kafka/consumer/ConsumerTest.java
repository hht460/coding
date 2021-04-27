package org.hthu.kafka.consumer;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class ConsumerTest {

    public static void main(String[] args) {
        String topicName = "kafka-test-topic";
        String groupId = "test-consumer-group-busService";
        //构造java.util.Properties对象
        Properties props = new Properties();
        // 必须指定属性。集群
        //props.put("bootstrap.servers", "192.168.110.130:9092,192.168.110.131:9092,192.168.110.132:9092");
        props.put("bootstrap.servers", "localhost:9092");
        // 必须指定属性。
        props.put("group.id", groupId);
        // 是否自动提交偏移量,true(默认)
        props.put("enable.auto.commit", "false");
        props.put("auto.commit.interval.ms", "1000");
        // 从最早的消息开始读取
        // earliest :当各分区下有已提交的offset时，从提交的offset开始消费；无提交的offset时，从头开始消费；(一般设置earliest) 
        // latest :当各分区下有已提交的offset时，从提交的offset开始消费；无提交的offset时，消费新产生的该分区下的数据 
        // none :topic各分区都存在已提交的offset时，从offset后开始消费；只要有一个分区不存在已提交的offset，则抛出异常
        props.put("auto.offset.reset", "earliest"); //   
        // 必须指定
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        // 必须指定
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        // 使用创建的Properties实例构造consumer实例
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);
        // 订阅topic。调用kafkaConsumer.subscribe方法订阅consumer group所需的topic列表
        consumer.subscribe(Arrays.asList(topicName));
        try {
            while (true) {
                //循环调用kafkaConsumer.poll方法获取封装在ConsumerRecord的topic消息。
                ConsumerRecords<String, String> records = consumer.poll(1000);
                //获取到封装在ConsumerRecords消息以后，处理获取到ConsumerRecord对象。
                for (ConsumerRecord<String, String> record : records) {
                    //简单的打印输出
                    System.out.println("offset = " + record.offset() + ",key = " + record.key() + ",value =" + record.value());
                }
                consumer.commitAsync();
            }
        } catch (Exception e) {
            //关闭kafkaConsumer
            System.out.println("消息消费结束......");
            consumer.close();
        } finally {
            try{
                consumer.commitSync();
            }finally {
                consumer.close();
            }
        }
        System.out.println("关闭消费者......");
        consumer.close();
    }

}
