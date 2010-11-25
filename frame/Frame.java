package frame;

import java.util.List;

public interface Frame {
	/**
	 * 分配一个新的帧
	 * @param method 为该方法建立Frame
	 * @param formal 该方法的参数是否escape
	 * @return 新分配的Frame
	 */
	public Frame newFrame(String method,List<Boolean> formal);
	/**
	 * 分配一个局部变量
	 * @param b 该局部变量是否escape
	 * @return 返回一个Access指明其偏移
	 */
	public Access allocLocal(boolean b);

}
