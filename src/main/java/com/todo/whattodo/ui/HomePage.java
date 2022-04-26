package com.todo.whattodo.ui;

import com.todo.whattodo.contract.HomePageContract;
import com.todo.whattodo.presenter.HomePagePresenter;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.textfield.TextArea;

import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import javax.annotation.security.PermitAll;



@Route("")
@PageTitle("What To Do")
@PermitAll
public class HomePage extends VerticalLayout implements HomePageContract {

    private final HomePagePresenter homePagePresenter = new HomePagePresenter(this);
    private final TextArea toDoTextField = new TextArea();

    private final String textFieldWidth = "1000px";
    public HomePage() {
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        Header();
        TodoText();
        SubmitButton();
        taskList();
    }

    private void Header() {

        H1 headerTitle = new H1("What too do");
        headerTitle.setHeight("50px");
        Icon moreIcon = new Icon(VaadinIcon.MENU);
        moreIcon.addClickListener(event ->{
            System.out.println("Clicked the menu button");
            moreIcon.getUI().ifPresent(ui -> ui.navigate(ProfilePage.class));
        });

        VerticalLayout headerLayout = new VerticalLayout(moreIcon, headerTitle);
        headerLayout.setAlignSelf(Alignment.CENTER, headerTitle);
        headerLayout.setAlignSelf(Alignment.END, moreIcon);
        add(headerLayout);
    }

    private void TodoText() {
        toDoTextField.setClearButtonVisible(true);
        toDoTextField.setPlaceholder("Add your task for the day");
        toDoTextField.setWidth(textFieldWidth);
        toDoTextField.setMaxLength(150);
        add(toDoTextField);
    }


    private void SubmitButton() {
        Button addTaskButton = new Button("Add Task");
        addTaskButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        add(addTaskButton);
    }

    private void taskList() {
        TextArea textArea = new TextArea();
        textArea.setLabel("25/04/2022");
        textArea.setValue("Task Data");
        textArea.setWidth(textFieldWidth);
        add(textArea);
    }

    @Override
    public void sampleData() {}
}
