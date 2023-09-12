package exception;

public class IncorrectOption extends Exception{
	private static final long serialVersionUID = 1L;
		public IncorrectOption() {
		}
			public IncorrectOption(String name){
				super(name);
			}
}
