package com.example.application.views.list;
import com.example.application.data.entity.Contact;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.component.grid.Grid;

@PageTitle("Contacts | Vaadin CRM")
@Route(value = "", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class ListView extends VerticalLayout {
	Grid<Contact> grid = new Grid<>(Contact.class);
	TextField filterText = new TextField();


    public ListView() {
    	addClassName("list-view");
    	setSizeFull();
    	
    	configureGrid();
    	
    	add(getToolBar(), grid);
    }
    
    private void configureGrid() {
    	grid.addClassName("contact-grid");
    	grid.setSizeFull();
    	grid.setColumns("firstName", "lastName", "email");
    }
    
    private Component getToolBar() {
    	filterText.setPlaceholder("Filter by name...");
    	filterText.setClearButtonVisible(true);
    	filterText.setValueChangeMode(ValueChangeMode.LAZY);
    	
    	Button addContactButton = new Button("Add Contact");
    	HorizontalLayout toolbar = new HorizontalLayout(filterText, addContactButton);
    	toolbar.addClassName("toolbar");
    	return toolbar;
    }
 
}
