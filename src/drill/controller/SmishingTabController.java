package drill.controller;

import drill.ControlledScreen;
import drill.ScreensController;
import drill.ScreensFramework;
import drill.utils.DBObject;
import drill.utils.MyLog;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 * Created by cross on 2015-06-23.
 */
//public class SmishingTabController extends Applet implements Initializable , ControlledScreen {
public class SmishingTabController implements Initializable , ControlledScreen {

    ScreensController myController;

    public void setScreenParent(ScreensController screenParent){
        myController = screenParent;
    }

    @FXML
    private AnchorPane ransomMain;

    //Main View - Pie Chart Metrix
    @FXML
    private PieChart main_pie_metrix00;
    @FXML
    private PieChart main_pie_metrix01;
    @FXML
    private PieChart main_pie_metrix02;
    @FXML
    private PieChart main_pie_metrix03;
    @FXML
    private PieChart main_pie_metrix10;
    @FXML
    private PieChart main_pie_metrix11;
    @FXML
    private PieChart main_pie_metrix12;
    @FXML
    private PieChart main_pie_metrix13;
    @FXML
    private PieChart main_pie_metrix20;
    @FXML
    private PieChart main_pie_metrix21;
    @FXML
    private PieChart main_pie_metrix22;
    @FXML
    private PieChart main_pie_metrix23;

    //그룹사 파이차트 밑에 리스트뷰
    @FXML
    private ListView<String> listviewtemp;

    private int DB_TABLE_FLAG_BANK = 1;




    PieChart.Data data1;
    PieChart.Data data2;
    PieChart.Data data3;

    ObservableList<PieChart.Data> pieCharts00;
    ObservableList<PieChart.Data> pieCharts01;
    ObservableList<PieChart.Data> pieCharts02;
    ObservableList<PieChart.Data> pieCharts03;
    ObservableList<PieChart.Data> pieCharts10;
    ObservableList<PieChart.Data> pieCharts11;
    ObservableList<PieChart.Data> pieCharts12;
    ObservableList<PieChart.Data> pieCharts13;
    ObservableList<PieChart.Data> pieCharts20;
    ObservableList<PieChart.Data> pieCharts21;
    ObservableList<PieChart.Data> pieCharts22;
    ObservableList<PieChart.Data> pieCharts23;


    //Stage stage;
    //Scene scene;
    //FXMLLoader loader;
    //Parent root;
    //public void setStage(Stage stage){ this.stage = stage; }


    private final String LAYOUT_FXML_RANSOM_MAIN = "all_group_display.fxml";

    @FXML
    private void OnMouseClicked_00(MouseEvent event){
        myController.setScreen(ScreensFramework.screen5ID);
    }
    @FXML
    private void OnMouseClicked_01(MouseEvent event){
        myController.setScreen(ScreensFramework.screen5ID);
    }
    @FXML
    private void OnMouseClicked_02(MouseEvent event){
        myController.setScreen(ScreensFramework.screen5ID);
    }
    @FXML
    private void OnMouseClicked_03(MouseEvent event){
        myController.setScreen(ScreensFramework.screen5ID);
    }
    @FXML
    private void OnMouseClicked_10(MouseEvent event){
        myController.setScreen(ScreensFramework.screen5ID);
    }
    @FXML
    private void OnMouseClicked_11(MouseEvent event){
        myController.setScreen(ScreensFramework.screen5ID);
    }
    @FXML
    private void OnMouseClicked_12(MouseEvent event){
        myController.setScreen(ScreensFramework.screen5ID);
    }
    @FXML
    private void OnMouseClicked_13(MouseEvent event){
        myController.setScreen(ScreensFramework.screen5ID);
    }
    @FXML
    private void OnMouseClicked_20(MouseEvent event){
        myController.setScreen(ScreensFramework.screen5ID);
    }
    @FXML
    private void OnMouseClicked_21(MouseEvent event){
        myController.setScreen(ScreensFramework.screen5ID);
    }
    @FXML
    private void OnMouseClicked_22(MouseEvent event){
        myController.setScreen(ScreensFramework.screen5ID);
    }
    @FXML
    private void OnMouseClicked_23(MouseEvent event){
        myController.setScreen(ScreensFramework.screen6ID);
    }

    /*
    private void setDrilldownData(final PieChart pie, PieChart.Data data, final String labelPrefix)
    {
        data.getNode().setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event) {
                try {

                    loader = new FXMLLoader(getClass().getResource("../fxml/DetailPieCharts.fxml"));
                    stage = (Stage) pie.getScene().getWindow();
                    Group gr = new Group();
                    root = loader.load();
                    gr.getChildren().addAll(pie, root);
                    scene = new Scene(gr, stage.getWidth(), stage.getHeight());
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e) {
                    MyLog.i("e = " + e.getMessage());
                    e.printStackTrace();
                }

                pie.setData(FXCollections.observableArrayList(
                        new PieChart.Data(labelPrefix + "-1", 7),
                        new PieChart.Data(labelPrefix + "-2", 2),
                        new PieChart.Data(labelPrefix + "-3", 5),
                        new PieChart.Data(labelPrefix + "-4", 3),
                        new PieChart.Data(labelPrefix + "-5", 2)));
            }
        });
    }
    */

    private ObservableList<String> getPhoneNumList(int flags) throws SQLException, ClassNotFoundException {
        Connection con = getConnection();
        ObservableList<String> phoneNum = FXCollections.observableArrayList();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select PH from info");
        while (rs.next()) {
        phoneNum.add(rs.getString("PH"));
        }
        return phoneNum;
    }

    /**
     * Initializes the controller class.
     */
    //@Override public void initialize(URL url, ResourceBundle rb) {}

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        String[] str = location.getPath().split("/");
        String temp = str[str.length - 1];

        //if(temp.equals(LAYOUT_FXML_RANSOM_MAIN)){

        data1 = new PieChart.Data("URL access", getUrlClickCount(DB_TABLE_FLAG_BANK));
        data2 = new PieChart.Data("APP install", getAppInstallCount(DB_TABLE_FLAG_BANK));
        data3 = new PieChart.Data("APP execute", getAppExecuteCount(DB_TABLE_FLAG_BANK));
        pieCharts00 = FXCollections.observableArrayList(data1, data2, data3);
        main_pie_metrix00.setData(pieCharts00);

        //setDrilldownData(main_pie_metrix00, data1, "a");
        //setDrilldownData(main_pie_metrix00, data2, "b");
        //setDrilldownData(main_pie_metrix00, data3, "c");

        ObservableList<PieChart.Data> pieCharts2 = FXCollections.observableArrayList(
                new PieChart.Data("SMS received", 1),
                new PieChart.Data("SMS Click", 1),
                new PieChart.Data("Ransom Infected", 1));

        ObservableList<PieChart.Data> pieCharts3 = FXCollections.observableArrayList(
                new PieChart.Data("SMS received", 1),
                new PieChart.Data("SMS Click", 1),
                new PieChart.Data("Ransom Infected", 1));

        ObservableList<PieChart.Data> pieCharts4 = FXCollections.observableArrayList(
                new PieChart.Data("SMS received", 1),
                new PieChart.Data("SMS Click", 1),
                new PieChart.Data("Ransom Infected", 1));

        ObservableList<PieChart.Data> pieCharts5 = FXCollections.observableArrayList(
                new PieChart.Data("SMS received", 1),
                new PieChart.Data("SMS Click", 1),
                new PieChart.Data("Ransom Infected", 1));

        ObservableList<PieChart.Data> pieCharts6 = FXCollections.observableArrayList(
                new PieChart.Data("SMS received", 1),
                new PieChart.Data("SMS Click", 1),
                new PieChart.Data("Ransom Infected", 1));
        ObservableList<PieChart.Data> pieCharts7 = FXCollections.observableArrayList(
                new PieChart.Data("SMS received", 1),
                new PieChart.Data("SMS Click", 1),
                new PieChart.Data("Ransom Infected", 1));
        ObservableList<PieChart.Data> pieCharts8 = FXCollections.observableArrayList(
                new PieChart.Data("SMS received", 1),
                new PieChart.Data("SMS Click", 1),
                new PieChart.Data("Ransom Infected", 1));
        ObservableList<PieChart.Data> pieCharts9 = FXCollections.observableArrayList(
                new PieChart.Data("SMS received", 1),
                new PieChart.Data("SMS Click", 1),
                new PieChart.Data("Ransom Infected", 1));
        ObservableList<PieChart.Data> pieCharts10 = FXCollections.observableArrayList(
                new PieChart.Data("SMS received", 1),
                new PieChart.Data("SMS Click", 1),
                new PieChart.Data("Ransom Infected", 1));
        ObservableList<PieChart.Data> pieCharts11 = FXCollections.observableArrayList(
                new PieChart.Data("SMS received", 1),
                new PieChart.Data("SMS Click", 1),
                new PieChart.Data("Ransom Infected", 1));
        ObservableList<PieChart.Data> pieCharts12 = FXCollections.observableArrayList(
                new PieChart.Data("SMS received", 1),
                new PieChart.Data("SMS Click", 1),
                new PieChart.Data("Ransom Infected", 1));

        main_pie_metrix00.setTitle("SHINHAN BANK");
        main_pie_metrix01.setTitle("SHINHAN CARD");
        main_pie_metrix02.setTitle("SHINHAN LIFE");
        main_pie_metrix03.setTitle("SHINHAN GROUP");
        main_pie_metrix10.setTitle("SHINHAN SAVINGS");
        main_pie_metrix11.setTitle("SHINHAN BNPP");
        main_pie_metrix12.setTitle("SHINHAN AITAS");
        main_pie_metrix13.setTitle("SHINHAN CAPITAL");
        main_pie_metrix20.setTitle("SHINHAN DATA SYSTEM");
        main_pie_metrix21.setTitle("SHINHAN JEJU BANK");
        main_pie_metrix22.setTitle("SHINHAN INVEST");
        main_pie_metrix23.setTitle("SHINHAN CI");

        main_pie_metrix01.setData(pieCharts2);
        main_pie_metrix02.setData(pieCharts3);
        main_pie_metrix03.setData(pieCharts4);
        main_pie_metrix10.setData(pieCharts5);
        main_pie_metrix11.setData(pieCharts6);
        main_pie_metrix12.setData(pieCharts7);
        main_pie_metrix13.setData(pieCharts8);
        main_pie_metrix20.setData(pieCharts9);
        main_pie_metrix21.setData(pieCharts10);
        main_pie_metrix22.setData(pieCharts11);
        main_pie_metrix23.setData(pieCharts12);

        Task task = new Task<Void>() {
            @Override
            public Void call() throws Exception {
                //int i = 0;
                while (true) {
                    //final int finalI = i;
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            data1.setPieValue(getUrlClickCount(DB_TABLE_FLAG_BANK));
                            data2.setPieValue(getAppInstallCount(DB_TABLE_FLAG_BANK));
                            data3.setPieValue(getAppExecuteCount(DB_TABLE_FLAG_BANK));
                            pieCharts00 = FXCollections.observableArrayList(data1, data2, data3);

                            System.out.println("=======thread run ===========!!! \n");
                        }
                    });
                    //i++;
                    Thread.sleep(3000);
                }
            }
        };
        Thread th = new Thread(task);
        th.setDaemon(true);
        th.start();
        /*executor = Executors.newCachedThreadPool(new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setDaemon(true);
                return thread;
            }
        });
        addToQueue = new AddToQueue();
        executor.execute(addToQueue);*/
        //-- Prepare Timeline

        ObservableList<String> names = FXCollections.observableArrayList();
        names.add("First Column");
        names.add("Second Column");
        names.add("Third Column");
        listviewtemp.setItems(names);


    //}else{ MyLog.i(""); }


    }



    private int getUrlClickCount(int flag) {
        //System.out.println("=======getUrlClickCount ===========!!! \n");
        ResultSet a = null;
        int count = 0;
        switch (flag) {

            case 1:
            //    System.out.println("=======getUrlClickCount ===case 1: ========!!! \n");
                try (Connection con = getConnection()) {
                    //테이블이 존재하지 않으면 생성 낄낄
                    if (!DBObject.getInstance().urlClickSchemaExists(con)) {
                        MyLog.i("");
                        DBObject.getInstance().createUrlClickSchema(con);
                    }
                    Statement st = null;
                    st = con.createStatement();
                    ResultSet rs = st.executeQuery("select count(*) from urlclick");
                    rs.next();
                    count = rs.getInt(1);

                 //   System.out.println("=======getUrlClickCount ===case 1: cournt : %d " + count);


                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
             //   System.out.println("=======getUrlClickCount ===case 2: ========!!! \n");
                break;
            default:
             //   System.out.println("=======getUrlClickCount ===default ========!!! \n");
                break;
        }
        return count;
    }

    private int getAppExecuteCount(int flag) {
  //      System.out.println("=======getAppExecuteCount ===========!!!");
        ResultSet a = null;
        int count = 0;
        try (Connection con = getConnection()) {
            //테이블이 존재하지 않으면 생성 낄낄
            if (!DBObject.getInstance().appExecuteSchemaExists(con)) {
                MyLog.i("");
                DBObject.getInstance().createAppExecuteSchema(con);
            }

            Statement st = null;
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select count(*) from info");
            rs.next();
//            MyLog.i("getAppExecuteCount = " + rs.getInt(1));
            count = rs.getInt(1);
//            System.out.println("=======getAppExecuteCount ========count : "+count);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    private int getAppInstallCount(int flag) {
    //    System.out.println("=======getAppInstallCount ===========!!! \n");
        ResultSet a = null;
        int count = 0;
        try (Connection con = getConnection()) {
            //테이블이 존재하지 않으면 생성 낄낄
            if (!DBObject.getInstance().appInstallSchemaExists(con)) {
                MyLog.i("");
                DBObject.getInstance().createAppInstallSchema(con);
            }

            Statement st = null;
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select count(*) from install");
            rs.next();
//            MyLog.i("getAppInstallCount = " + rs.getInt(1));
            count = rs.getInt(1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    //hard coding
    //implement not yet!!
    private double getNetworkOwner(){return 2;}
    private double getCountry(){return 3; }
    private double getLocationInfo(){return 1;}
    private double getEmailAddr(){return 3;}
    private double getPhoneNum(){return 6;}
    private double getAccessorCount(){return 10;}
    private double getDownloadCount() {return 20;}
    private Connection getConnection() throws ClassNotFoundException, SQLException {
        return DBObject.getInstance().getConnection();
    }
}


//=폐기처리=========================================================================
/*private class AddToQueue implements Runnable {
        public void run() {
            try {
                MyLog.i("run");
                // add a item of random data to queue
                ObservableList<PieChart.Data> pieCharts1 = FXCollections.observableArrayList(
                        new PieChart.Data("SMS URL Click", getUrlClickCount()),
                        new PieChart.Data("SMS Click", 0),
                        new PieChart.Data("Ransom Infected", 0));
                ObservableList<PieChart.Data> pieCharts2 = FXCollections.observableArrayList(
                        new PieChart.Data("SMS received", 0),
                        new PieChart.Data("SMS Click", 0),
                        new PieChart.Data("Ransom Infected", 0));
                ObservableList<PieChart.Data> pieCharts3 = FXCollections.observableArrayList(
                        new PieChart.Data("SMS received", 0),
                        new PieChart.Data("SMS Click", 0),
                        new PieChart.Data("Ransom Infected", 0));
                ObservableList<PieChart.Data> pieCharts4 = FXCollections.observableArrayList(
                        new PieChart.Data("SMS received", 7),
                        new PieChart.Data("SMS Click", 5),
                        new PieChart.Data("Ransom Infected", 5));
                ObservableList<PieChart.Data> pieCharts5 = FXCollections.observableArrayList(
                        new PieChart.Data("SMS received", 3),
                        new PieChart.Data("SMS Click", 9),
                        new PieChart.Data("Ransom Infected", 9));
                ObservableList<PieChart.Data> pieCharts6 = FXCollections.observableArrayList(
                        new PieChart.Data("SMS received", 7),
                        new PieChart.Data("SMS Click", 4),
                        new PieChart.Data("Ransom Infected", 4));
                ObservableList<PieChart.Data> pieCharts7 = FXCollections.observableArrayList(
                        new PieChart.Data("SMS received", 5),
                        new PieChart.Data("SMS Click", 3),
                        new PieChart.Data("Ransom Infected", 2));
                ObservableList<PieChart.Data> pieCharts8 = FXCollections.observableArrayList(
                        new PieChart.Data("SMS received", 2),
                        new PieChart.Data("SMS Click", 3),
                        new PieChart.Data("Ransom Infected", 3));
                ObservableList<PieChart.Data> pieCharts9 = FXCollections.observableArrayList(
                        new PieChart.Data("SMS received", 7),
                        new PieChart.Data("SMS Click", 4),
                        new PieChart.Data("Ransom Infected", 4));
                ObservableList<PieChart.Data> pieCharts10 = FXCollections.observableArrayList(
                        new PieChart.Data("SMS received", 7),
                        new PieChart.Data("SMS Click", 3),
                        new PieChart.Data("Ransom Infected", 8));
                ObservableList<PieChart.Data> pieCharts11 = FXCollections.observableArrayList(
                        new PieChart.Data("SMS received", 2),
                        new PieChart.Data("SMS Click", 6),
                        new PieChart.Data("Ransom Infected", 9));
                ObservableList<PieChart.Data> pieCharts12 = FXCollections.observableArrayList(
                        new PieChart.Data("SMS received", 1),
                        new PieChart.Data("SMS Click", 2),
                        new PieChart.Data("Ransom Infected", 3));

                p1.setData(pieCharts1);

                Thread.sleep(500);
                executor.execute(this);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }*/