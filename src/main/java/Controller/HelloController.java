package Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import Entity.User;
import Service.HelloService;

@Controller
public class HelloController {
	public HelloController() {
		System.out.println("加载!");
	}
	// 自动注入以下参数
	@Autowired
	private HelloService helloService;
	public void setHelloService(HelloService helloService) {
		this.helloService = helloService;
	}
	
	@RequestMapping("/hello")
	public String hello(ModelMap modelMap){
		modelMap.addAttribute("msg", helloService.sayHello());
		System.out.println(helloService.sayHello()+" too");
		return "hello";
	}
	
	@RequestMapping("/list")
	public String list(ModelMap modelMap) {
		List<User> list = helloService.getUser();
		modelMap.addAttribute("list",list);
		System.out.println(list);
		return "index";
	}
	
	@RequestMapping("/add")
	public String add(User user) {
		helloService.addUser(user);
		return "redirect:/list.do";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		helloService.deleteUser(id);
		return "redirect:/list.do";
	}

}