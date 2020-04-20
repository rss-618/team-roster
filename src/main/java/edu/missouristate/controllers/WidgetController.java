package edu.missouristate.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import edu.missouristate.model.Widget;
import edu.missouristate.services.WidgetService;
import edu.missouristate.util.Helper;

@Controller
public class WidgetController {

	@Autowired
	WidgetService widgetService;
	
	@GetMapping("/widgets")
	public String getWidgetTable(Model model, HttpServletRequest request, HttpSession session) {
		List<Widget> widgetList = widgetService.getWidgets();
		model.addAttribute("widgetList", widgetList);
		return "widgets";
	}
	
	@GetMapping("/widgets/addEditWidget")
	public String getAddEditWidget(HttpSession session, Model model, String id) {
		// Default the next page to addEditWidget
		String page = "addEditWidget";
		
		// If the ID is an integer, we need to load the "edit widget" page
		// Otherwise, we need to load the "add widget" page
		if (Helper.isInteger(id)) {
			page = widgetService.prepareEditWidget(session, model, Integer.parseInt(id));
		} else {
			page = widgetService.prepareAddWidget(model);
		}
		
		// Return the Add JSP, Edit JSP, or Widget's Page (Table)
		return page;
	}
	
	@PostMapping("/widgets/addEditWidget")
	public String postAddEditWidget(HttpSession session, Model model, Widget widget) {
		
		if (widget != null && widget.getId() != null) {
			widgetService.updateWidget(model, widget);
		} else {
			// TODO: replace the word "widget" with the name of your topic
			Helper.addSessionMessage(session, "Sorry, could not find widget");
		}
		
		return "redirect:/widgets";
	}
	
	@GetMapping("/widgets/deleteWidget")
	public String getDeleteWidget(HttpSession session, Model model, String id) {
		
		if (Helper.isInteger(id)) {
			int deleteCount = widgetService.deleteWidget(model, Integer.parseInt(id));
			Helper.addSessionMessage(session, "Records Deleted: " + deleteCount);
		} else {
			String idString = ((id == null) ? "''" : ("'"+id+"'"));
			
			// TODO: replace "widget" with the name of your topic
			Helper.addSessionMessage(session, "Sorry, could not find widget with id = " + idString);
		}
		
		return "redirect:/widgets";
	}
}
