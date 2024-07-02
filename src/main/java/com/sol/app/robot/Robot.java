package com.sol.app.robot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Controller, @Service, @Repository, @Component
//Singleton 객체들은 Spring pool에 놓아놓는다.
//Autowired된 변수의 타입과 같은 타입을 갖는 객체를 Spring pool에서 찾는다.

@Component
public class Robot{
	
	// 같은 타입의 객체를 찾아서 집어 넣는데, 같은 타입이 여러개라면 변수명이 bean의 이름인 것을 찾아서 집어 넣는다.
	@Autowired
	@Qualifier("ra")
	private Arm rightArm;
	
	@Autowired
	@Qualifier("la")
	private Arm leftArm;

	public Arm getRightArm() {
		return rightArm;
	}

	public void setRightArm(Arm rightArm) {
		this.rightArm = rightArm;
	}

	public Arm getLeftArm() {
		return leftArm;
	}

	public void setLeftArm(Arm leftArm) {
		this.leftArm = leftArm;
	}


}
