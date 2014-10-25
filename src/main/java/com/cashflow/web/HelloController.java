package com.cashflow.web;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.sql.DataSource;

@Controller
@RequestMapping("/")
public class HelloController {

    public static final Logger logger = Logger.getLogger(HelloController.class);

    @Autowired
    DataSource dataSource;

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
        DateTime d = new DateTime();
        logger.debug("hello");
		model.addAttribute("message", "Buna iubit2a33!");
        JdbcTemplate jdbc = new JdbcTemplate(dataSource);
        jdbc.execute("select * from dual");
		return "hello";
	}
}