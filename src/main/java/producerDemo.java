
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class producerDemo {
    public static void main(String[] args) {
        String bootstarpServers = "localhost:9092";

 rohit
        //Samarth
        //CHess

        //SAmarth Branch>>>>>>> master
      // create properties file for kafka
        Properties properties = new Properties();
 samarth
/* This is the old way of setting properties
chnaged
=======
/* This is the old way of setting prmastermasteroperties

 master
        properties.setProperty("bootstrap.servers", bootstarpServers);
        properties.setProperty("key.serializer",StringSerializer.class.getName());
        properties.setProperty("value.serializer",StringSerializer.class.getName());
        properties.setProperty("acks","all");
*/
//ROHIT PUSH INTO SAMARTH
        //issue reso;ve

properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstarpServers);
properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName() );
properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
properties.setProperty(ProducerConfig.ACKS_CONFIG,"all");
        //create producer for kafaka

        KafkaProducer<String,String> producer = new KafkaProducer<String, String>(properties);

        //Create Record
        ProducerRecord<String,String>record = new ProducerRecord<String, String>("first_topic","Intelleji");

        //send records

        producer.send(record);
        producer.close();

    }
}
