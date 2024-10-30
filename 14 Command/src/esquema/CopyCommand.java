package esquema;

public class CopyCommand implements Command {
String editor;


	public CopyCommand(String editor) {
	super();
	this.editor = editor;
}


	@Override
	public void execute() {
		System.out.println(editor);

	}

}
