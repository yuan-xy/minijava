package tree;

public class EX_P extends Stm {
	public Exp exp;

	public EX_P(Exp e) {
		exp = e;
	}

	public ExpList kids() {
		return new ExpList(exp, null);
	}

	public Stm build(ExpList kids) {
		return new EX_P(kids.head);
	}
}
