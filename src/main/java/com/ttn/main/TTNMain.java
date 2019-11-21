package com.ttn.main;

import com.ttn.test.TestLogin;

public class TTNMain {

	public static void main(String[] args) {

		Reports rr = new Reports();

		try {
			TestLogin login = new TestLogin();
			login.beginLoginTest(rr);
			
		} catch (Exception e) {
			// // Do nothing
		} finally {
			rr.Destruct();
		}
	}

}
