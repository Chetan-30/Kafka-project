package com.example.demo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Msg_Controller {
@Autowired
private KafkaTemplate<String, String> kafka_temp;

@GetMapping("/{id}/{name}/{add}/{phno}")
public String publishhall(@PathVariable String id,@PathVariable String name,@PathVariable String add,@PathVariable String phno) {
	kafka_temp.send("Employee_Topic",id);
	kafka_temp.send("Employee_Topic",name);
	kafka_temp.send("Employee_Topic",add);
	kafka_temp.send("Employee_Topic",phno);
	return "Id: "+id +" Name: "+name +"Address: "+add+" Phno:"+phno;
 
}
}