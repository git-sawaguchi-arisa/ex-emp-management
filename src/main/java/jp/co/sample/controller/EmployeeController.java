package jp.co.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Employee;
import jp.co.sample.service.EmployeeService;

/**
 * @author sawaguchiarisa
 *従業員情報を検索する処理を記述します
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {
	/**
	 *EmployeeServiceを呼び出す 
	 *
	 */
	@Autowired
	private EmployeeService employeeService;
	/**
	 *従業員一覧を出力するメソッド
	 *
	 */
	@RequestMapping("/showList")
	public String showList(Model model) {
		List<Employee> emploList= employeeService.showList();
		model.addAttribute("employeeList",emploList);
		return "employee/list";
	}
}
