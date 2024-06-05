package com.example.application.views.list;
import java.util.Collections;

import com.example.application.data.entity.Contact;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
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
	ContactForm form;

    public ListView() {
    	addClassName("list-view");
    	setSizeFull();
    	
    	configureGrid();
    	configureForm();
    	
    	add(getToolBar(), getContent());
    }
    
    private void configureGrid() {
    	grid.addClassName("contact-grid");
    	grid.setSizeFull();
    	grid.setColumns("firstName", "lastName", "email");
    }
    
    private void configureForm() {
    	form = new ContactForm(Collections.emptyList(), Collections.emptyList());
    	form.setWidth("25em");
    }
    
    private Component getContent() {
    	HorizontalLayout content = new HorizontalLayout(grid, form);
    	content.setFlexGrow(2, grid);
    	content.setFlexGrow(1, form);
    	content.addClassName("content");
    	content.setSizeFull();
    	
    	return content;
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
