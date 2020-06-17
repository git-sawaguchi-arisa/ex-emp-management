package jp.co.sample.form;

/**
 * @author sawaguchiarisa
 *従業員更新時に使用するフォーム
 */
public class UpdateEmployeeForm {
	/**
	 *従業員ID 
	 *扶養人数
	 */
	private String id;
	
	private String dependentsCount;
	
	@Override
	public String toString() {
		return "UpdateEmployeeForm [id=" + id + ", dependentsCount=" + dependentsCount + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDependentsCount() {
		return dependentsCount;
	}

	public void setDependentsCount(String dependentsCount) {
		this.dependentsCount = dependentsCount;
	}

}
