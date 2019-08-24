
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;
//change

public class producerDemoWithCallback {
    public static void main(String[] args) {
        String bootstarpServers = "localhost:9092";
        final Logger logger = LoggerFactory.getLogger(producerDemoWithCallback.class);
      // create properties file for kafka
        Properties properties = new Properties();
/* This is the old way of setting properties

        properties.setProperty("bootstrap.servers", bootstarpServers);
        properties.setProperty("key.serializer",StringSerializer.class.getName());
        properties.setProperty("value.serializer",StringSerializer.class.getName());
        properties.setProperty("acks","all");
*/

properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstarpServers);
properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName() );
properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
properties.setProperty(ProducerConfig.ACKS_CONFIG,"all");
        //create producer for kafaka

        KafkaProducer<String,String> producer = new KafkaProducer<String, String>(properties);

        //Create Record
        ProducerRecord<String,String>record = new ProducerRecord<String, String>("first_topic","Monket");

        //send records

        producer.send(record, new Callback() {
            public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                if (e == null) {
                    logger.info("Record Topic        " + recordMetadata.topic() + "\n");
                    logger.info("Record Partition    " + recordMetadata.partition() + "\n");
                    logger.info("Record Offset       " + recordMetadata.offset() + "\n");
                } else {
                    logger.info("Error orcurred due to " + e);
                }
            }});

    //producer.flush();

    //System.out.println("Rohit");


    }
}
