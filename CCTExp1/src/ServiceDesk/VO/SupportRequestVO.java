package ServiceDesk.VO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class SupportRequestVO {
	private String creationText;
	private String ticketNumber;
	private Date creationDate;
	private Date closeDate;
	private String category;
	private String priority;
	private String description;
	private double slaHours;
	private SupportResponsibleVO assignedTo;
	private ClientVO client;
	
	public SupportRequestVO(Date creaationDate, String creationText) {
		super();
		this.creationText = creationText;
		this.creationDate = creaationDate;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		this.ticketNumber = sdf.format(this.creationDate);
		this.category = "";
		this.priority = "";
		this.description = "";
		this.slaHours = 0;
		this.assignedTo = null;
		this.client = null;
	}
	public SupportRequestVO(String creationText, Date creaationDate, String type, String priority, String description,
			ArrayList<String> attachments, double slaHours, SupportResponsibleVO assignedTo, ClientVO client) {
		super();
		this.creationText = creationText;
		this.creationDate = creaationDate;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		this.ticketNumber = sdf.format(this.creationDate);
		this.category = type;
		this.priority = priority;
		this.description = description;
		this.slaHours = slaHours;
		this.assignedTo = assignedTo;
		this.client = client;
	}

	public String getCreationText() {
		return creationText;
	}
	public void setCreationText(String creationText) {
		this.creationText = creationText;
	}
	public String getTicketNumber() {
		return ticketNumber;
	}
	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}
	public Date getCloseDate() {
		return closeDate;
	}
	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getSlaHours() {
		return slaHours;
	}
	public void setSlaHours(double slaHours) {
		this.slaHours = slaHours;
	}
	public SupportResponsibleVO getAssignedTo() {
		return assignedTo;
	}
	public void setAssignedTo(SupportResponsibleVO assignedTo) {
		this.assignedTo = assignedTo;
	}
	public ClientVO getClient() {
		return client;
	}
	public void setClient(ClientVO client) {
		this.client = client;
	}
	
}
