package jp.co.sample.form;

public class InsertAdministratorForm {

	/**
	 * 名前
	 *メールアドレス
	 *パスワード
	 */
	private String name;
	
	private String mailAddress;
	
	private String password;

	@Override
	public String toString() {
		return "InsertAdministratorForm [name=" + name + ", mailAddress=" + mailAddress + ", password=" + password
				+ "]";
	}
}
