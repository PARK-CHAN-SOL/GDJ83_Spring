package com.sol.app.boards.qnas;

import com.sol.app.boards.BoardDTO;

public class QnaDTO extends BoardDTO {
	private Long ref;
	private Long step;
	private Long depth;
	
	public Long getRef() {
		return ref;
	}
	public void setRef(Long ref) {
		this.ref = ref;
	}
	public Long getStep() {
		return step;
	}
	public void setStep(Long step) {
		this.step = step;
	}
	public Long getDepth() {
		return depth;
	}
	public void setDepth(Long depth) {
		this.depth = depth;
	}
}
