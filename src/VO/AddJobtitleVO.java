package vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class AddJobtitleVO {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int jobtitle_id;
	private String jobtitlename;
	
	@OneToOne
	private AttachmentVO attachment;

	public int getJobtitle_id() {
		return jobtitle_id;
	}

	public void setJobtitle_id(int jobtitle_id) {
		this.jobtitle_id = jobtitle_id;
	}

	public String getJobtitlename() {
		return jobtitlename;
	}

	public void setJobtitlename(String jobtitlename) {
		this.jobtitlename = jobtitlename;
	}

	public AttachmentVO getAttachment() {
		return attachment;
	}

	public void setAttachment(AttachmentVO attachment) {
		this.attachment = attachment;
	}
	
	

}
