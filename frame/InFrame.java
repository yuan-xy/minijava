package frame;

public class InFrame implements Access {
	/**
	 * 该变量相对于Frame基地址的偏移
	 */
	private int offset;
	
	public InFrame(int offset){
		this.offset=offset;
	}

}
