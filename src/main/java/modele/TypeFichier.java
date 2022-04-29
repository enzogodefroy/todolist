package modele;

public enum TypeFichier {
	BINARY ("tdl"),
	TEXT ("txt"),
	XML ("xml"),
	JSON ("json");

	public final String extension;

	TypeFichier(String ext) {
		extension = ext;
	}

	public String toString() {
		return name() + "(" + extension + ")";
	}
}
