package org.example.lab_worklab2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HelloApplication extends Application {

     Label annualInterestRatelabel;
     Label numberOfYearsLabel;
     Label loanAmountLabel;
     Label monthlyPaymentLabel;
     Label totalPaymentLabel;
     TextField annualInterestRateTextField;
     TextField numberOfYearsTextField;
     TextField loanAmountTextField;
    TextField monthlyPaymentTextField;
     TextField totalPaymentOutput;

   // @Override
   /* public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }*/
@Override
public void start(Stage primaryStage) {
    //labels
    annualInterestRatelabel = new Label("Annual Interest Rate:");
    annualInterestRatelabel.setLayoutX(50);
    annualInterestRatelabel.setLayoutY(50);

    numberOfYearsLabel = new Label("Number of Years:");
    numberOfYearsLabel.setLayoutX(50);
    numberOfYearsLabel.setLayoutY(100);

    loanAmountLabel = new Label("Loan Amount:");
    loanAmountLabel.setLayoutX(50);
    loanAmountLabel.setLayoutY(150);

    monthlyPaymentLabel = new Label("Monthly Payment:");
    monthlyPaymentLabel.setLayoutX(50);
    monthlyPaymentLabel.setLayoutY(200);

    totalPaymentLabel = new Label("Total Payment:");
    totalPaymentLabel.setLayoutX(50);
    totalPaymentLabel.setLayoutY(250);

    totalPaymentOutput = new TextField();
    totalPaymentOutput.setLayoutX(200);
    totalPaymentOutput.setLayoutY(250);


    //textfields
    annualInterestRateTextField = new TextField();
    annualInterestRateTextField.setLayoutX(200);
    annualInterestRateTextField.setLayoutY(50);

    numberOfYearsTextField = new TextField();
    numberOfYearsTextField.setLayoutX(200);
    numberOfYearsTextField.setLayoutY(100);

    loanAmountTextField = new TextField();

    loanAmountTextField.setLayoutX(200);
    loanAmountTextField.setLayoutY(150);

    monthlyPaymentTextField = new TextField();
    monthlyPaymentTextField.setLayoutX(200);
    monthlyPaymentTextField.setLayoutY(200);


    //button to calculate
    Button btn = new Button("Calculator");
    btn.setLayoutX(285);
    btn.setLayoutY(300);


    btn.setOnAction(this:: doSomething);
    Group grp = new Group(annualInterestRatelabel,numberOfYearsLabel,
            loanAmountLabel,monthlyPaymentLabel,totalPaymentLabel,
            annualInterestRateTextField,numberOfYearsTextField,
            loanAmountTextField,monthlyPaymentTextField, totalPaymentOutput,btn);//stored the labels into a group

    Scene scene = new Scene(grp,400,350);//scene with the group of labels

    primaryStage.setTitle("Loan Calculator");// set the title of the scene
    primaryStage.setScene(scene);
    primaryStage.show();

}

    private void doSomething(ActionEvent actionEvent) { //method to calculate the monthly payment and total payment
    //Stored the values in to variables to use for calculation
    double annualInterestRate = Double.parseDouble(annualInterestRateTextField.getText());
    int numberOfYears = Integer.parseInt(numberOfYearsTextField.getText());
    double loanAmount = Double.parseDouble(loanAmountTextField.getText());

    double monthlyInterestRate = annualInterestRate / 1200;//calculate the monthly interest rate
    double monthlyPayment = loanAmount * monthlyInterestRate / (1-(1/Math.pow(1 +
            monthlyInterestRate, numberOfYears*12)));//calculate the monthly payment
    double totalPayment = monthlyPayment * numberOfYears * 12;//calculate the total payment

    monthlyPaymentTextField.setText(String.format("$%.2f",monthlyPayment));
    totalPaymentOutput.setText(String.format("$%.2f",totalPayment));



    }


    public static void main(String[] args) {
        launch();
    }
}