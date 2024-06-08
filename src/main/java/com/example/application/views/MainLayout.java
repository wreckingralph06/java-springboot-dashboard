package com.example.application.views;

import com.example.application.views.about.AboutView;


import com.example.application.views.list.ListView;
import com.example.application.views.DashboardView;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.lumo.LumoUtility;
import org.vaadin.lineawesome.LineAwesomeIcon;

/**
 * The main view is a top-level placeholder for other views.
 */
public class MainLayout extends AppLayout {

    private H1 viewTitle;

    public MainLayout() {
    	createHeader();
    	createDrawer();
    }
    
    private void createHeader() {
    	H1 logo = new H1("Vaadin CRM");
    	logo.addClassNames("text-l", "m-m");
    	
    	HorizontalLayout header = new HorizontalLayout(new DrawerToggle(), logo);
    	header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
    	header.expand(logo);
    	header.setWidthFull();
    	header.addClassNames("py-0", "px-m");
    	
    	addToNavbar(header);
    }
    
    private void createDrawer() {
    	RouterLink listView = new RouterLink("List", ListView.class);
    	RouterLink dashboardView = new RouterLink("Dashboard", DashboardView.class);
        
    	listView.setHighlightCondition(HighlightConditions.sameLocation());
    	addToDrawer(
            new VerticalLayout(listView),
            new VerticalLayout(dashboardView)
        );
    }
}
