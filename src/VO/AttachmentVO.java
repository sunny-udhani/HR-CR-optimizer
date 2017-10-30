package vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AttachmentVO {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int attachmentID;
	private String attachment_name;
	private String path;
	public int getAttachmentID() {
		return attachmentID;
	}
	public void setAttachmentID(int attachmentID) {
		this.attachmentID = attachmentID;
	}
	public String getAttachment_name() {
		return attachment_name;
	}
	public void setAttachment_name(String attachment_name) {
		this.attachment_name = attachment_name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	
}
