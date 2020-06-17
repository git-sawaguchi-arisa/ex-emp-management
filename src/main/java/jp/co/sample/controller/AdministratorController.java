package jp.co.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Administer;
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
	@ModelAttribute
	public InsertAdministratorForm setUpInsertAdministratorForm() {
		return new InsertAdministratorForm();
	}
	@RequestMapping("/toInsert")
	public String toInsert() {
		return "administrator/insert";
	}
	@RequestMapping("/insert")
	public String insert(InsertAdministratorForm form) {
		Administer administer = new Administer();
		administer.setName(form.getName());
		administer.setMailAddress(form.getMailAddress());
		administer.setPassword(form.getPassword());
		administratorService.insert(administer);
		return "redirect:/";
	}
}
