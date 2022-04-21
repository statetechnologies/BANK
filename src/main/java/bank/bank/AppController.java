package bank.bank;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class AppController implements Initializable {


    @FXML
    private ProgressBar progress;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        IntegerProperty seconds = new SimpleIntegerProperty();
//        progress.progressProperty().bind(seconds.divide(10.0));
//        Timeline timeline = new Timeline(
//                new KeyFrame(Duration.ZERO, new KeyValue(seconds, 0)),
//                new KeyFrame(Duration.seconds(10.0), event -> {
//                    System.out.println("10 SECONDS");
//                }, new KeyValue(seconds,10)));
//        timeline.setCycleCount(1);
//        timeline.play();
//        try {
//
//
//            if (seconds.getValue().equals(10)) {
//                DBUtils.refreshpage(event, "BANK SYSTEM", "Home.fxml");
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//
//
//
//

        IntegerProperty seconds = new SimpleIntegerProperty();
        progress.progressProperty().bind(seconds.divide(10.0));
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(seconds, 0)),
                new KeyFrame(Duration.seconds(10.0), new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
//                        Stage stage = new Stage();
//                        Parent root = null;
//                        try {
//                            root = FXMLLoader.load(getClass().getResource("Home.fxml"));
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                        stage.setTitle("HOME");
//                        stage.setScene(new Scene(root));
//                        stage.show();
                     DBUtils.appPage(event, "BANK SYSTEM");
                    }
                }, new KeyValue(seconds, 10)));
        timeline.setCycleCount(1);
        timeline.play();

//        ActionEvent events = null;
//        progressbar(events);

    }

//    public void progressbar(ActionEvent event) {
//
////        for (int i = 0; i<=100; i++){
////
////            int x = i/100;
////
////            try {
////                Thread.sleep(100);
////                progress.setProgress(x);
////            } catch (InterruptedException e) {
////                e.printStackTrace();
////            }
////
////
////            if (x == 1){
////              //  DBUtils.refreshpage(mouseEvent, "Home", "Home.fxml");
////            }
//
////        Timer tm = new Timer();
////        tm.schedule(new TimerTask() {
////            @Override
////            public void run() {
////
////            }
////        }, 2000);
////        progress.progressProperty().bind((ObservableValue<? extends Number>) tm);
//
//


}


