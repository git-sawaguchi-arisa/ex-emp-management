package jp.co.sample.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Administer;
import jp.co.sample.form.InsertAdministratorForm;
import jp.co.sample.form.LoginForm;
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
	 * session変数を宣言
	 */
	@Autowired
	private HttpSession session;
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
		System.out.println("Controller");
		return "redirect:/";
	}
	@ModelAttribute
	public LoginForm setUpLoginForm() {
		return new LoginForm();
	}
	/**
	 * administrator/loginへフォワード
	 */
	@RequestMapping("/")
	public String toLogin() {
		return "administrator/login";
	}
	@RequestMapping("/login")
	public String login(LoginForm form, Model model) {
		Administer administer = administratorService.login(form.getMailAddress(), form.getPassword());
		if (administer == null) {
			model.addAttribute("fault", "メールアドレスまたはパスワードが不正です");
			return toLogin();
		}else {
			session.setAttribute("administratorName", administer);
		}
		 return "forward:/employee/showList";
	}
}
