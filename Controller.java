package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label label_field;

    @FXML
    private Button btn_clear;

    @FXML
    private Button btn_pm;

    @FXML
    private Button btn_percent;

    @FXML
    private Button btn_div;

    @FXML
    private Button btn_4;

    @FXML
    private Button btn_5;

    @FXML
    private Button btn_8;

    @FXML
    private Button btn_7;

    @FXML
    private Button btn_9;

    @FXML
    private Button btn_mult;

    @FXML
    private Button btn_6;

    @FXML
    private Button btn_minus;

    @FXML
    private Button btn_1;

    @FXML
    private Button btn_2;

    @FXML
    private Button btn_3;

    @FXML
    private Button btn_plus;

    @FXML
    private Button btn_0;

    @FXML
    private Button btn_commar;

    @FXML
    private Button btn_eq;

    private String strnum = "";
    private float num1 = 0f;
    private char operation;

    @FXML
    void initialize() {
        btn_0.setOnAction(event ->{
            addNumber(0);
        });
        btn_1.setOnAction(event ->{
            addNumber(1);
        });
        btn_2.setOnAction(event ->{
            addNumber(2);
        });
        btn_3.setOnAction(event ->{
            addNumber(3);
        });
        btn_4.setOnAction(event ->{
            addNumber(4);
        });
        btn_5.setOnAction(event ->{
            addNumber(5);
        });
        btn_6.setOnAction(event ->{
            addNumber(6);
        });
        btn_7.setOnAction(event ->{
            addNumber(7);
        });
        btn_8.setOnAction(event ->{
            addNumber(8);
        });
        btn_9.setOnAction(event ->{
            addNumber(9);
        });
        btn_plus.setOnAction(event ->{
            mathAction('+');
        });
        btn_minus.setOnAction(event ->{
            mathAction('-');
        });
        btn_mult.setOnAction(event ->{
            mathAction('*');
        });
        btn_div.setOnAction(event ->{
            mathAction('/');
        });
        btn_eq.setOnAction(event ->{
            if(this.operation == '+' || this.operation == '-' ||
                    this.operation == '*' || this.operation == '/');
            equalMethod();
        });
        btn_commar.setOnAction(event ->{
            if(!this.strnum.contains(".")){
                this.strnum += ".";
                label_field.setText(strnum);
            }
        });
        btn_percent.setOnAction(event ->{
            if (this.strnum != ""){
                float num = Float.parseFloat(this.strnum) * 0.1f;
                this.strnum = Float.toString(num);
                label_field.setText(strnum);
            }
        });
        btn_pm.setOnAction(event ->{
            if (this.strnum != ""){
                float num = Float.parseFloat(this.strnum) * -1;
                this.strnum = Float.toString(num);
                label_field.setText(strnum);
            }
        });
        btn_clear.setOnAction(event -> {
            label_field.setText("0");
            this.strnum = "";
            this.num1 = 0;
            this.operation = 'a';
        });

    }

    void equalMethod() {
        float res = 0;
        switch (this.operation){
            case '+':
                res = this.num1 + Float.parseFloat(strnum);
                break;
            case '-':
                res = this.num1 - Float.parseFloat(strnum);
                break;
            case '*':
                res = this.num1 * Float.parseFloat(strnum);
                break;
            case '/':
                if (Integer.parseInt(strnum) != 0) {
                    res = this.num1 / Float.parseFloat(strnum);
                }
                break;

        }

        label_field.setText(Float.toString(res));
        this.strnum = "";
        this.operation = 'a';
        this.num1 = 0;

    }

    void mathAction(char operation) {
        if(this.operation != '+' && this.operation != '-' &&
                this.operation != '*' && this.operation != '/') {
            this.num1 = Float.parseFloat(this.strnum);
            label_field.setText(String.valueOf(operation));
            this.strnum = "";
            this.operation = operation;
        }
    }

    void addNumber(int number){
        this.strnum += Integer.toString(number);
        label_field.setText(strnum);

    }

}
