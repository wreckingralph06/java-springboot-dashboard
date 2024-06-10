package com.example.application.views.list;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.application.data.entity.Contact;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.data.provider.ListDataProvider;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ListViewTest {
	@Autowired
	private ListView listView;
	
	@Test
	public void formShownWhenContactSelected() {
		Grid<Contact> grid = listView.grid;
		Contact firstContact = getFirstItem(grid);
		
		ContactForm form = listView.form;
		
		assertFalse(form.isVisible());
		grid.asSingleSelect().setValue(firstContact);
		
		assertTrue(form.isVisible());
		assertEquals(firstContact.getFirstName(), form.firstName.getValue());
	}

	@SuppressWarnings("unchecked")
	private Contact getFirstItem(Grid<Contact> grid) {
		return( (ListDataProvider<Contact>) grid.getDataProvider()).getItems().iterator().next();
	}
}
