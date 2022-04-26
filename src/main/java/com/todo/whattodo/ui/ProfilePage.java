package com.todo.whattodo.ui;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;


@Route("/Profile")
@PageTitle("What To Do | Profile")
public class ProfilePage extends VerticalLayout {

    public ProfilePage() {
        add(new Text("Welcome to Profile Page"));
    }
}
