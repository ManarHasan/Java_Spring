package com.axsos.displaydate;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/time")
public class TimeController {
	@RequestMapping("")
	public String time(Model model) {
		String timePattern = "HH:mm a";
        SimpleDateFormat timeFormat = new SimpleDateFormat(timePattern);
        String time = timeFormat.format(new Date());
        model.addAttribute("time", time);
		return "time.jsp";
	}
}
