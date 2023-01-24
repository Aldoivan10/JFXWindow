package com.aldoivan10.jfxwindow_demo;

import com.jfoenix.controls.*;
import com.jfoenix.controls.cells.editors.TextFieldEditorBuilder;
import com.jfoenix.controls.cells.editors.base.GenericEditableTreeTableCell;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import com.jfoenix.effects.JFXDepthManager;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Modality;
import javafx.util.Duration;


public class JFXComponents extends ScrollPane
{
    private final GridPane grid = new GridPane();

    public JFXComponents(BorderPane parent)
    {
        final ObservableList<String> items = FXCollections.observableArrayList();

        this.grid.setVgap(15);
        this.grid.setHgap(15);
        this.grid.setPadding(new Insets(15));
        for(int i = 0;i < 3;i++) { this.grid.getColumnConstraints().add(this.columnConstraints()); }
        for(int i = 1;i <= 50;i++) { items.add(String.format("Item %s", i)); }

        JFXButton button = new JFXButton("Button");
        button.setStyle("-fx-text-fill: -jfx-primary-color");
        this.addComponent(button, 0,0);

        JFXToggleNode toggleNode = new JFXToggleNode("Toggle node");
        this.addComponent(toggleNode,1,0);

        JFXCheckBox checkBox = new JFXCheckBox("Checkbox");
        this.addComponent(checkBox, 2,0);

        JFXToggleButton toggleButton = new JFXToggleButton();
        toggleButton.setText("Toggle button");
        this.addComponent(toggleButton,3,0);

        JFXTextField textField = new JFXTextField();
        textField.setLabelFloat(true);
        textField.setPromptText("Text field");
        this.addComponent(textField, 0,1);

        JFXTextArea textArea = new JFXTextArea();
        textArea.setPromptText("Text area");
        textArea.setPrefSize(200,50);
        textArea.setLabelFloat(true);
        this.addComponent(textArea, 1,1);

        JFXComboBox<String> comboBox = new JFXComboBox<>();
        comboBox.setPromptText("Combobox");
        comboBox.getItems().addAll(items);
        comboBox.setLabelFloat(true);
        this.addComponent(comboBox, 2,1);

        JFXDatePicker datePicker = new JFXDatePicker();
        this.addComponent(datePicker, 3,1);

        JFXTimePicker timePicker = new JFXTimePicker();
        this.addComponent(timePicker, 0,2);

        JFXSpinner spinner = new JFXSpinner();
        spinner.setProgress(0.5);
        this.addComponent(spinner,1,2);

        JFXSlider slider = new JFXSlider();
        this.addComponent(slider, 2,2);

        JFXColorPicker colorPicker = new JFXColorPicker();
        this.addComponent(colorPicker, 3,2);

        JFXListView<String> listView = new JFXListView<>();
        listView.setMaxHeight(300);
        listView.getItems().addAll(items);
        this.addComponent(listView, 0,3);

        JFXTreeTableView<User> treeTableRow = this.getTreeTable();
        treeTableRow.setMaxHeight(300);
        this.addComponent(new StackPane(treeTableRow),1,3);

        JFXChipView<String> chipView = new JFXChipView<>();
        chipView.setMaxHeight(300);
        chipView.getChips().add("Chipview");
        this.addComponent(chipView, 3,3);

        JFXButton btnSnackBar = new JFXButton("Snackbar");
        btnSnackBar.setOnAction(event ->
        {
            JFXSnackbar snackbar = new JFXSnackbar(parent);
            snackbar.enqueue(new JFXSnackbar.SnackbarEvent(new JFXSnackbarLayout("This is a snackbar message","Action",event1 -> {}), Duration.seconds(2)));
        });

        JFXButton btnDialog = new JFXButton("Dialog");
        btnDialog.setOnAction(event ->
        {
            JFXAlert<Void> alert = new JFXAlert<>(parent.getScene().getWindow());
            alert.initModality(Modality.NONE);
            alert.setOverlayClose(false);

            JFXDialogLayout layout = new JFXDialogLayout();
            layout.setHeading(new Label("Prueba de alerta"));

            TextFlow txtFlow = new TextFlow();
            txtFlow.setTextAlignment(TextAlignment.JUSTIFY);
            txtFlow.getChildren().add(new Text("Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quis autem magni odio veritatis consectetur nostrum libero sed obcaecati similique ad aliquid repellendus aperiam fuga quidem at inventore, assumenda aliquam ea"));
            layout.setBody(txtFlow);

            JFXButton closeButton = new JFXButton("Aceptar");
            closeButton.setOnAction(event1 -> alert.close());
            closeButton.setDefaultButton(true);
            layout.setActions(closeButton);
            alert.setContent(layout);
            alert.show();
        });

        JFXRadioButton radioButton = new JFXRadioButton("Radio button");

        VBox vBox = new VBox(btnSnackBar, btnDialog, radioButton);
        vBox.setSpacing(15);
        vBox.setAlignment(Pos.CENTER);

        this.addComponent(vBox,2,3);
        this.setContent(this.grid);
        this.setFitToWidth(true);
    }

    private void addComponent(Node node, int col, int row)
    {
        StackPane container = new StackPane(node);
        container.getStyleClass().add("pane");
        container.setPadding(new Insets(15));
        this.grid.add(container,col,row);
        JFXDepthManager.setDepth(container,1);
    }

    private void addComponent(Pane container, int col, int row)
    {
        container.getStyleClass().add("pane");
        container.setPadding(new Insets(15));
        this.grid.add(container,col,row);
        JFXDepthManager.setDepth(container,1);
    }

    private ColumnConstraints columnConstraints()
    {
        ColumnConstraints constraints = new ColumnConstraints();
        constraints.setHgrow(Priority.SOMETIMES);
        return constraints;
    }

    private JFXTreeTableView<User> getTreeTable()
    {
        final String COMPUTER_DEPARTMENT = "Computer Department";
        final String SALES_DEPARTMENT = "Sales Department";
        final String IT_DEPARTMENT = "IT Department";
        final String HR_DEPARTMENT = "HR Department";

        JFXTreeTableColumn<User, String> deptColumn = new JFXTreeTableColumn<>("Department");
        deptColumn.setPrefWidth(150);
        deptColumn.setCellValueFactory((TreeTableColumn.CellDataFeatures<User, String> param) -> {
            if (deptColumn.validateValue(param)) {
                return param.getValue().getValue().department;
            } else {
                return deptColumn.getComputedValue(param);
            }
        });

        JFXTreeTableColumn<User, String> empColumn = new JFXTreeTableColumn<>("Employee");
        empColumn.setPrefWidth(150);
        empColumn.setCellValueFactory((TreeTableColumn.CellDataFeatures<User, String> param) -> {
            if (empColumn.validateValue(param)) {
                return param.getValue().getValue().userName;
            } else {
                return empColumn.getComputedValue(param);
            }
        });

        JFXTreeTableColumn<User, String> ageColumn = new JFXTreeTableColumn<>("Age");
        ageColumn.setPrefWidth(150);
        ageColumn.setCellValueFactory((TreeTableColumn.CellDataFeatures<User, String> param) -> {
            if (ageColumn.validateValue(param)) {
                return param.getValue().getValue().age;
            } else {
                return ageColumn.getComputedValue(param);
            }
        });

        ageColumn.setCellFactory((TreeTableColumn<User, String> param) -> new GenericEditableTreeTableCell<>(
                new TextFieldEditorBuilder()));
        ageColumn.setOnEditCommit((TreeTableColumn.CellEditEvent<User, String> t) -> t.getTreeTableView()
                .getTreeItem(t.getTreeTablePosition()
                        .getRow())
                .getValue().age.set(t.getNewValue()));

        empColumn.setCellFactory((TreeTableColumn<User, String> param) -> new GenericEditableTreeTableCell<>(
                new TextFieldEditorBuilder()));
        empColumn.setOnEditCommit((TreeTableColumn.CellEditEvent<User, String> t) -> t.getTreeTableView()
                .getTreeItem(t.getTreeTablePosition()
                        .getRow())
                .getValue().userName.set(t.getNewValue()));

        deptColumn.setCellFactory((TreeTableColumn<User, String> param) -> new GenericEditableTreeTableCell<>(
                new TextFieldEditorBuilder()));
        deptColumn.setOnEditCommit((TreeTableColumn.CellEditEvent<User, String> t) -> t.getTreeTableView()
                .getTreeItem(t.getTreeTablePosition()
                        .getRow())
                .getValue().department.set(t.getNewValue()));


        // data
        ObservableList<User> users = FXCollections.observableArrayList();
        users.add(new User(COMPUTER_DEPARTMENT, "23", "CD 1"));
        users.add(new User(SALES_DEPARTMENT, "22", "Employee 1"));
        users.add(new User(SALES_DEPARTMENT, "24", "Employee 2"));
        users.add(new User(SALES_DEPARTMENT, "25", "Employee 4"));
        users.add(new User(SALES_DEPARTMENT, "27", "Employee 5"));
        users.add(new User(IT_DEPARTMENT, "42", "ID 2"));
        users.add(new User(HR_DEPARTMENT, "21", "HR 1"));
        users.add(new User(HR_DEPARTMENT, "28", "HR 2"));

        for (int i = 0; i < 40000; i++) {
            users.add(new User(HR_DEPARTMENT, Integer.toString(i % 10), "HR 3" + i));
        }
        for (int i = 0; i < 40000; i++) {
            users.add(new User(COMPUTER_DEPARTMENT, Integer.toString(i % 20), "CD 2" + i));
        }

        for (int i = 0; i < 40000; i++) {
            users.add(new User(IT_DEPARTMENT, Integer.toString(i % 5), "HR 4" + i));
        }

        // build tree
        final TreeItem<User> root = new RecursiveTreeItem<>(users, RecursiveTreeObject::getChildren);

        JFXTreeTableView<User> treeView = new JFXTreeTableView<>(root);
        treeView.setShowRoot(false);
        treeView.setEditable(true);
        treeView.getColumns().setAll(deptColumn, ageColumn, empColumn);

        return treeView;
    }

    private static final class User extends RecursiveTreeObject<User>
    {
        final StringProperty userName;
        final StringProperty age;
        final StringProperty department;

        User(String department, String age, String userName) {
            this.department = new SimpleStringProperty(department);
            this.userName = new SimpleStringProperty(userName);
            this.age = new SimpleStringProperty(age);
        }
    }
}
