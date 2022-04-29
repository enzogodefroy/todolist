package modele;

import java.io.DataOutputStream;

public class SaveBinary implements Operation {
	private DataOutputStream s;
	public SaveBinary(DataOutputStream s) {
		this.s = s;
	}
	public void doItOn(ToDoList l) throws Exception {
		s.writeInt(l.size());
		for(Task t : l) { doItOn(t); }
	}
	public void doItOn(Task t) throws Exception {
		s.writeUTF(t.getName());
		s.writeUTF(t.getComment());
		s.writeByte(t.getStatus().ordinal());
	}
}
