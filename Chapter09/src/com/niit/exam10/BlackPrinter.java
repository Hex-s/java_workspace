package com.niit.exam10;
/**
 * ºÚ°×´òÓ¡»ú
 * @author Administrator
 *
 */
public class BlackPrinter implements IPrinter {

	@Override
	public String print(IInfo info) {
		// TODO Auto-generated method stub
		return "ºÚ°×´òÓ¡£º"+info.getData();
	}

}
