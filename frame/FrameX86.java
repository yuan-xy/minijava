package frame;

import java.util.ArrayList;
import java.util.List;

public class FrameX86 implements Frame {
	
	private Label lable;
	private List<Access> params;

	private int localOffset;
	public Access allocLocal(boolean b) {
		Access acc=null;
		if(b){
			acc=new InReg(new Temp());
		}else{
			acc=new InFrame(localOffset);
			localOffset-=4;
		}
		return null;
	}

	public Frame newFrame(String method, List<Boolean> formal) {
		FrameX86 frame=new FrameX86();
		frame.lable=new Label(method);
		frame.params=new ArrayList<Access>(formal.size());
		int offset=8;//对于x86的机器，方法的第一个参数相对于帧指针的位移是8
		for(Boolean b : formal){
			params.add(new InFrame(offset));
			offset+=4;
		}
		return frame;
	}

}
