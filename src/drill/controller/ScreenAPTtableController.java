package drill.controller;

import drill.ControlledScreen;
import drill.ScreensController;
import drill.ScreensFramework;
import drill.data.TBL_APT;
import drill.utils.DBObject;
import drill.utils.MyLog;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

/**
 * Created by Chan-Ju on 2015-08-24.
 */
public class ScreenAPTtableController implements Initializable, ControlledScreen {

    ScreensController myController;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        getAPTTableContent();
    }

    public void setScreenParent(ScreensController screenParent){
        myController = screenParent;
    }

 @FXML
 private void backButtonAction(ActionEvent event)
 {
     myController.setScreen(ScreensFramework.screen4ID);
 }
//@FXML private void goToScreen3(ActionEvent event){ myController.setScreen(ScreensFramework.screen3ID);}


    //TBL_APT(SEQ , ACTDATE, IPADDR, PHTYPE, PHNUM, ACTDIV,ETC, GROUPTYPE, USERAGENT) -->
    @FXML private TableView<TBL_APT> tableView;
    @FXML private TextField SEQField;
    @FXML private TextField ACTDATEField;
    @FXML private TextField IPADDRField;
    @FXML private TextField PHTYPEField;
    @FXML private TextField PHNUMField;
    @FXML private TextField ACTDIVField;
    @FXML private TextField ETCField;
    @FXML private TextField GROUPTYPEField;
    @FXML private TextField USERAGENTField;

    //TBL_APT(SEQ , ACTDATE, IPADDR, PHTYPE, PHNUM, ACTDIV,ETC, GROUPTYPE, USERAGENT)

    @FXML
    protected void addAPTTable(ActionEvent event) {
        ObservableList<TBL_APT> data = tableView.getItems();
        data.add(new TBL_APT(SEQField.getText(),
                ACTDATEField.getText(),
                IPADDRField.getText(),
                PHTYPEField.getText(),
                PHNUMField.getText(),
                ACTDIVField.getText(),
                ETCField.getText(),
                GROUPTYPEField.getText(),
                USERAGENTField.getText()
        ));

        //���������
        SEQField.setText("");
        ACTDATEField.setText("");
        IPADDRField.setText("");
        PHTYPEField.setText("");
        PHNUMField.setText("");
        ACTDIVField.setText("");
        ETCField.setText("");
        GROUPTYPEField.setText("");
        USERAGENTField.setText("");
    }

    private Connection getConnection() throws ClassNotFoundException, SQLException {
        MyLog.i("");
        return DBObject.getInstance().getConnection();
    }

    private int getAPTTableContent()
    {
        String lSEQString;
        String lACTDATEString;
        String lIPADDRString;
        String lPHTYPEString;
        String lPHNUMString;
        String lACTDIVString;
        String lETCString;
        String lGROUPTYPEString;
        String lUSERAGENTString;

        TextField lSEQField;
        TextField lACTDATEField;
        TextField lIPADDRField;
        TextField lPHTYPEField;
        TextField lPHNUMField;
        TextField lACTDIVField;
        TextField lETCField;
        TextField lGROUPTYPEField;
        TextField lUSERAGENTField;

        ResultSet a = null;
        PreparedStatement pstmt = null;
        int count = 0;
        try (Connection conn = getConnection()) {
            //���̺��� �������� ������ ���� ����

            //Statement st = null;
            //st = conn.createStatement();
            //ResultSet rs = st.executeQuery("select * from TBL_APT where SEQ >=4 ");
            //rs.next();

            String sql = "select * from TBL_APT where SEQ >= ?";                        // sql ����
            pstmt = conn.prepareStatement(sql);                          // prepareStatement���� �ش� sql�� �̸� �������Ѵ�.
            pstmt.setString(1, String.valueOf(3));

            ResultSet rs = pstmt.executeQuery();                                        // ������ �����ϰ� ����� ResultSet ��ü�� ��´�.

            ObservableList<TBL_APT> data = tableView.getItems();

            while(rs.next()) {                                                        // ����� �� �྿ ���ư��鼭 �����´�.
//TBL_APT(SEQ , ACTDATE, IPADDR, PHTYPE, PHNUM, ACTDIV,ETC, GROUPTYPE, USERAGENT)

                lSEQString = rs.getString("SEQ");
                lACTDATEString = rs.getString("ACTDATE");82
                lIPADDRString= rs.getString("IPADDR");
                lPHTYPEString= rs.getString("PHTYPE");
                lPHNUMString= rs.getString("PHNUM");
                lACTDIVString= rs.getString("ACTDIV");
                lETCString= rs.getString("ETC");
                lGROUPTYPEString= rs.getString("GROUPTYPE");
                lUSERAGENTString= rs.getString("USERAGENT");


                data.add(new TBL_APT(
                        lSEQString,
                        lACTDATEString,
                        lIPADDRString,
                        lPHTYPEString,
                        lPHNUMString,
                        lACTDIVString,
                        lETCString,
                        lGROUPTYPEString,
                        lUSERAGENTString
                ));

            }

            //count = rs.getInt(1);






            if(conn!=null)
            {
                conn.close();
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }






        return count;
    }

}