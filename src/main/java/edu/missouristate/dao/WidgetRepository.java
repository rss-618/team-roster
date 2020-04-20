package edu.missouristate.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import edu.missouristate.model.Widget;
import edu.missouristate.util.MSU;

@Repository
public class WidgetRepository {

	@Autowired
	JdbcTemplate template;

	public WidgetRepository() {
	}

	public List<Widget> getWidgets() {
		/**
		 * TODO: Add the SQL here to pull back a list of widgets
		 *       You can use MSU.WIDGET_BPRM to map the values if you like. 
		 *       /src/main/java/edu/missouristate/util/MSU.java
		 */

		return null;
	}

	public void addWidget(Widget widget) {
		/**
		 * TODO: Add the INSERT SQL here to add a new widget to the table 
		 */
		
	}

	public Widget getWidgetById(Integer id) {
		/**
		 * TODO: Add the SELECT SQL here to select the widget with the provided id 
		 */
		
		return null;
	}

	public void updateWidget(Widget widget) {
		/**
		 * TODO: Add the UPDATE SQL here to update the widget with the provided id: widget.getId() 
		 */		

	}

	public int deleteWidget(int id) {
		/**
		 * TODO: Add the DELETE SQL here to delete the widget with the provided id
		 *       Return the number of records deleted 
		 */

		return 0;
	}
	
}
