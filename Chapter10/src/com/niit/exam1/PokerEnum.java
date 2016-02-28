package com.niit.exam1;
/**
 * 扑克牌花色枚举类型
 * 枚举的值写在枚举类型中，多个值使用逗号间隔
 * 枚举是类的一种特殊类型
 * @author Administrator
 *
 */
public enum PokerEnum {
	
	spade("黑桃"),
	heart("红桃"),
	club("梅花"),
	diamond("方块");
	
	private String name;
	
	private PokerEnum(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
