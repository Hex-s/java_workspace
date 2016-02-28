package com.niit.exam10;
/**
 * 打印机接口
 * @author Administrator
 *
 */
public interface IPrinter {
	/**
	 * 打印的方法
	 * @param info 信息对象
	 * @return 打印的结果
	 */
	public String print(IInfo info);
}
