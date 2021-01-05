package com.axsos.displaydate;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/date")
public class DateController {
	@RequestMapping("")
    public String displayDate(Model model) {
        String datePattern = "EEEEE, dd MMMMM, yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(datePattern);
        String date = dateFormat.format(new Date());
        model.addAttribute("date", date);
        return "display.jsp";
    }
}
