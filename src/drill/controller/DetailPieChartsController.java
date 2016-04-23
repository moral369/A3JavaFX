package drill.controller;

import drill.ControlledScreen;
import drill.ScreensController;
import drill.ScreensFramework;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Chan-Ju on 2015-08-23.
 */
public class DetailPieChartsController implements Initializable, ControlledScreen {

    ScreensController myController;

    @FXML
    private Button btn_back;

    @FXML
    private PieChart detail_pie;

    private String labelPrefix = "a";
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        detail_pie.setData(FXCollections.observableArrayList(
                new PieChart.Data(labelPrefix + "-1", 7),
                new PieChart.Data(labelPrefix + "-2", 2),
                new PieChart.Data(labelPrefix + "-3", 5),
                new PieChart.Data(labelPrefix + "-4", 3),
                new PieChart.Data(labelPrefix + "-5", 2)));
    }

    public void setScreenParent(ScreensController screenParent){
        myController = screenParent;
    }

    @FXML
    private void handleButtonAction (ActionEvent event){
        myController.setScreen(ScreensFramework.screen4ID);
    }


/*
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        MyLog.i("");
        if(event.getSource()==btn_back){
            //get reference to the button's stage
            stage=(Stage) btn_back.getScene().getWindow();
            //load up OTHER FXML document
            root = FXMLLoader.load(getClass().getResource("../fxml/all_group_display.fxml"));

        } else{
        }
        //create a new scene with root and set the stage
        scene = new Scene(root, stage.getWidth(), stage.getHeight());
        stage.setScene(scene);
        stage.show();
    }
*/
}
