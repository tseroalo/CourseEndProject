package exception;

public class IncorrectChoice extends Exception{
	private static final long serialVersionUID = 1L;
		public IncorrectChoice() {
		}
			public IncorrectChoice(String name){
				super(name);
			}
}
