import java.util.List;
import java.util.*;

public class Pacer implements Pager {
	
	public String name;
	public String role;
	public List<Message> inbox;
	public Message[] last3;
	public Pacer[] last3dest;
	Hospital hospital;
	int messagecount;
	
	public Pacer(String role, Hospital hospital) {
		this.name = "";
		this.role = role;
		this.inbox = new ArrayList<Message>();
		this.hospital = hospital;
		this.last3 = new Message[3];
		this.last3dest = new Pacer[3];
		this.messagecount =0;
	}

	public void register(String name) {
		
		if(hospital.activepagers.containsKey(name)) {
			throw new IllegalArgumentException();
		}
			if(this.name!="") {
				hospital.activepagers.remove(this.name);
				hospital.paused.remove(this.name);
			}
			hospital.activepagers.put(name, this);
			hospital.paused.put(name, false);
			this.name = name;
	}
	
	public List<Message> inbox(){
		return inbox;
	}
	
	
	
	
	
	public void command(String destination, Message msg) {
		messagecount++;
		
		if(!hospital.activepagers.containsKey(destination)) {
			if(this.role.equals("admin")) {
				for(String currentName: hospital.activepagers.keySet()) {
					System.out.println(currentName);
					Pager current = hospital.activepagers.get(currentName);
					current.inbox().add(msg);
					System.out.println("added" +msg.toString()+ " to inbox of "+currentName);
				}
			}
			else {
			PagerNotRegisteredMessage m = new PagerNotRegisteredMessage(destination);
			this.inbox.add(m);
			
			if(this.role.equals("slow")) {
			if(!hospital.paused.get(name)) {
			if(this.messagecount%3==0) {
				try {
				last3dest[0].inbox.add(last3[0]);
				} catch(Exception e) {}
				try {
				last3dest[1].inbox.add(last3[1]);
				}catch(Exception e) {}
				}
				messagecount=0;
			}
			}
			}
		}
		
		else {
		Pacer d = hospital.activepagers.get(destination);
		if(this.role.equals("normal")) {
			if(!hospital.paused.get(name)) {
			d.inbox().add(msg);
			}
		}
		else if (this.role.equals("slow")){
			if(this.messagecount%3==0) {
				if(!hospital.paused.get(name)) {
				last3[messagecount-1]=msg;
				try {
				last3dest[0].inbox.add(last3[0]);
				}catch (Exception e) {}
				try {
				last3dest[1].inbox.add(last3[1]);
				}catch(Exception e) {}
				try {
				d.inbox.add(last3[2]);
				}catch(Exception e) {}
				messagecount=0;
				} else {}
			}
			else {
				last3[messagecount-1]=msg;
				last3dest[messagecount-1]=d;
			}
		}
		
		else {
			if(msg.getPayload().equals("pause")) {
				if(hospital.paused.get(destination)) {
					hospital.paused.put(destination, false);
				}
				else {
					hospital.paused.put(destination,  true);
				}
			}
			else {
			for(String currentName: hospital.activepagers.keySet()) {
				System.out.println(currentName);
				Pager current = hospital.activepagers.get(currentName);
				current.inbox().add(msg);
				System.out.println("added" +msg.toString()+ " to inbox of "+currentName);
			}
			}
		}
	}
	}
}
