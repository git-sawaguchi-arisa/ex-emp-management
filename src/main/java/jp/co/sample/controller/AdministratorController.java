package jp.co.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.form.InsertAdministratorForm;
import jp.co.sample.service.AdministratorService;

/**
 * @author sawaguchiarisa
 *Controllerクラスです
 */
@Controller
@RequestMapping("/")
public class AdministratorController {
	/**
	 * AdministratorServiceを宣言
	 */
	@Autowired
	private AdministratorService administratorService;
	/**
	 * InsertAdministratorFormをインスタンス化
	 * InsertAdministratorFormオブジェクトをModelオブジェクトに格納
	 */
	public InsertAdministratorForm setUpInsertAdministratorForm() {
		return new InsertAdministratorForm();
	}
	@RequestMapping("/toInsert")
	public String toInsert() {
		return "administer/insert";
	}
}
