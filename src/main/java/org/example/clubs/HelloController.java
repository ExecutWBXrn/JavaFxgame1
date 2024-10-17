package org.example.clubs;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.GridPane;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn1;

    @FXML
    private Button btn2;

    @FXML
    private Button btn3;

    @FXML
    private Button btn4;

    @FXML
    private Button btn5;

    @FXML
    private Button btn6;

    @FXML
    private Button btn7;

    @FXML
    private Button btn8;

    @FXML
    private Button btn9;

    String nowSymb = "X";

    byte draw = 0;

    boolean isFisnish = false;

    String[][] GridPos = new String[3][3];
    @FXML
    void btn_main(ActionEvent event) {
        if(isFisnish) {
            Alert finalert = new Alert(Alert.AlertType.CONFIRMATION, "Are you ready to new game???", ButtonType.YES);
            finalert.showAndWait();
            isFisnish=false;
            draw=0;
            nowSymb="X";
            GridPos = new String[3][3];
            btn1.setText("");
            btn2.setText("");
            btn3.setText("");
            btn4.setText("");
            btn5.setText("");
            btn6.setText("");
            btn7.setText("");
            btn8.setText("");
            btn9.setText("");
            return;
        }
        Button btn = (Button)event.getSource();

        int rowindex = GridPane.getRowIndex(btn) == null ? 0 : GridPane.getRowIndex(btn);
        int colindex = GridPane.getColumnIndex(btn) == null ? 0 : GridPane.getColumnIndex(btn);

        if(GridPos[rowindex][colindex]!=null) return;

        GridPos[rowindex][colindex] = nowSymb;

        btn.setText(nowSymb);


        draw++;
        Alert alertwin = new Alert(Alert.AlertType.INFORMATION, "Congratualtions lady and gentlemans! Winner today is "+ nowSymb +"!");
        for(int i = 0; i < 3; i++){
            if((GridPos[i][0]==GridPos[i][1] && GridPos[i][0] == GridPos[i][2] && GridPos[i][0]!=null) || (GridPos[0][i]==GridPos[1][i] && GridPos[0][i] == GridPos[2][i] && GridPos[0][i]!=null)){
                alertwin.showAndWait();
                isFisnish=true;
                btn_main(event);
            }
        }

        if((GridPos[0][0]==GridPos[1][1] && GridPos[0][0] == GridPos[2][2] && GridPos[0][0]!=null) || (GridPos[0][2]==GridPos[1][1] && GridPos[0][2] == GridPos[2][0] && GridPos[0][2]!=null)){
            alertwin.showAndWait();
            isFisnish=true;
            btn_main(event);
        }

        nowSymb = nowSymb == "X" ? "O" : "X";

        if(draw>=9){
            Alert alert = new Alert(Alert.AlertType.WARNING, "Draw today ladies and gentelmans!", ButtonType.FINISH);
            alert.showAndWait();
            isFisnish=true;
            btn_main(event);
        }
    }

    @FXML
    void initialize() {

    }

}
