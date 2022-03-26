package toto.xdev.modet;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "lastmessage")
public class LastMessage {
	
	@Id
	private String id;
	
	private String name;
	private Long temperature;
	private Long humidity;
	private Date updateDate; 

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getTemperature() {
		return temperature;
	}
	public void setTemperature(Long temperature) {
		this.temperature = temperature;
	}
	public Long getHumidity() {
		return humidity;
	}
	public void setHumidity(Long humidity) {
		this.humidity = humidity;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}
