package modele;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.StringTokenizer;

public class Task implements Operable {
	private String name;
	private String comment;
	private Status status;
	public Task() {
		name = "sans nom";
		comment = "sans description";
		status = Status.TODO;
	}
	public Task(String taskName, String taskComment) {
		name = taskName;
		comment = taskComment;
		status = Status.TODO;
	}
	public Task(String taskName) {
		name = taskName;
		comment = "";
		status = Status.TODO;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Status getStatus() {
		return status;
	}
	public void setInProgress() {
		status = Status.IN_PROGRESS;
	}
	public void setDone() {
		status = Status.DONE;
	}
	public void charge(DataInputStream s) throws IOException {
		name = s.readUTF();
		comment = s.readUTF();
		switch(s.readByte()) {
			case  0: status = Status.TODO; break;
			case  1: status = Status.IN_PROGRESS; break;
			case  2: status = Status.DONE; break;
			default: status = Status.TODO;
		}
		/* ou alors
		status = Status.valueOf(s.readUTF());
		 */
	}
	public void importe(BufferedReader r) throws IOException {
		String s = r.readLine();
		StringTokenizer st = new StringTokenizer(s, "\t");
		name = st.nextToken();
		comment = st.nextToken();
		status = Status.valueOf(st.nextToken());
	}
	public void performs(Operation op) throws Exception {
		op.doItOn(this);
	}
}
