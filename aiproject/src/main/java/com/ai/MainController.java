package com.ai;

import java.util.ArrayList;

import com.ai.test.TestDao;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	TestDao testDao = new TestDao();
	@RequestMapping("/")
	public ModelAndView main() {
		ModelAndView mav = new ModelAndView();
		ArrayList arr = new ArrayList();
		arr = testDao.DBConnection();
		mav.addObject("list", arr);
		mav.setViewName("main");
		return mav;
	}
}
