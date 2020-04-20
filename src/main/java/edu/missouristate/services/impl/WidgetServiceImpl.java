package edu.missouristate.services.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import edu.missouristate.dao.WidgetRepository;
import edu.missouristate.model.Widget;
import edu.missouristate.services.WidgetService;
import edu.missouristate.util.Helper;

@Service("widgetService")
public class WidgetServiceImpl implements WidgetService {
    
    @Autowired
    WidgetRepository widgetRepo;

	@Override
	public List<Widget> getWidgets() {
		return widgetRepo.getWidgets();
	}

	@Override
	public String prepareAddWidget(Model model) {		
		// TODO: Create a new instance of Widget
		
		
		// TODO: Add the empty widget and title to the model
		
		
		// Return the addEditWidget Page
		return "addEditWidget";
	}

	@Override
	public String prepareEditWidget(HttpSession session, Model model, int id) {
		// Get the widget by ID
		Widget widget = getWidgetById(id);
		
		if (widget != null) {
			// TODO: Add the widget and title to the model 

			
			// Return the addEditWidget page 
			return "addEditWidget";
		} else {
			// Provide error message to the user and redirect to the widgets page
			// TODO: change the word "widget" to match your topic
			Helper.addSessionMessage(session, "Sorry, widget with ID = " + id + " not found.");
			return "redirect:/widgets";
		}
	}

	@Override
	public Widget getWidgetById(Integer id) {
		return widgetRepo.getWidgetById(id);
	}
	
	@Override
	public void updateWidget(Model model, Widget widget) {
		// TODO make a call to the widgetRepo to update the widget
		//      based on the new values passed into this method
		
	}

	@Override
	public int deleteWidget(Model model, int id) {
		// TODO Make a call to the widgetRepo to 
		//      delete the widget with the provided id.
		//      Return the number of records affected by the query
		
		return 0;
	}
   
}
