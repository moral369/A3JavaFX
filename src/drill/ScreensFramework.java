package drill;

import drill.controller.SmishingTabController;
import drill.utils.MyLog;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class ScreensFramework extends Application {

    SmishingTabController controller;

    public static String screen1ID = "main";
    public static String screen1File = "/drill/fxml/Screen1.fxml";
    public static String screen2ID = "screen2";
    public static String screen2File = "/drill/fxml/Screen2.fxml";
    public static String screen3ID = "screen3";
    public static String screen3File = "/drill/fxml/Screen3.fxml";

    public static String screen4ID = "main_window";
    public static String screen4File = "/drill/fxml/all_group_display.fxml";

    public static String screen5ID = "shb_detail_screen";
    public static String screen5File = "/drill/fxml/DetailPieCharts.fxml";

    public static String screen6ID = "apt_table_screen";
    public static String screen6File = "/drill/fxml/ScreenAPTtable.fxml";


    //public static String screen3ID = "screen3";
    //public static String screen3File = "Screen3.fxml";

    private void init(Stage primaryStage) throws Exception {

        MyLog.i("");

        //for MultiScreen
        ScreensController mainContainer = new ScreensController();
        mainContainer.loadScreen(ScreensFramework.screen1ID, ScreensFramework.screen1File);
        mainContainer.loadScreen(ScreensFramework.screen2ID, ScreensFramework.screen2File);
        mainContainer.loadScreen(ScreensFramework.screen3ID, ScreensFramework.screen3File);
        mainContainer.loadScreen(ScreensFramework.screen4ID, ScreensFramework.screen4File);
        mainContainer.loadScreen(ScreensFramework.screen5ID, ScreensFramework.screen5File);
        mainContainer.loadScreen(ScreensFramework.screen6ID, ScreensFramework.screen6File);

        mainContainer.setScreen(ScreensFramework.screen4ID);

        Group root = new Group();
        root.getChildren().addAll(mainContainer);

        //Parent root = FXMLLoader.load(getClass().getResource("/drill/fxml/smishingTest.fxml"));
        //FXMLLoader loader = new FXMLLoader(getClass().getResource("/drill/fxml/smishingTest.fxml"));
        //Parent root = loader.load();
        //controller = loader.getController();
        //controller.setStage(primaryStage);

        //display screen size를 구하기 위한 부분
        javafx.geometry.Rectangle2D r = Screen.getPrimary().getVisualBounds();
        MyLog.i("" + r.getWidth() + "  " + r.getHeight());

        Scene scene = new Scene(root, r.getWidth(), r.getHeight());
        primaryStage.setScene(scene);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        init(primaryStage);
        primaryStage.setTitle("Shinhan Group APT DashBoard");
        primaryStage.show();
    }

    public static void main(String[] args) {
        MyLog.i("");
        launch(args);
    }

}
