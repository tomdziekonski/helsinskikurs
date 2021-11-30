package textstatistics;

import java.util.Arrays;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TextStatisticsApplication extends Application {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch();
    }

    @Override
    public void start(Stage window) {
        Label labelOne = new Label("Letters: 0");
        Label labelTwo = new Label("Words: 0");
        Label labelThree = new Label("The longest word is:");
        TextArea centerText = new TextArea("");

        HBox vertical = new HBox();
        vertical.getChildren().add(labelOne);
        vertical.getChildren().add(labelTwo);
        vertical.getChildren().add(labelThree);

        BorderPane layout = new BorderPane();
        layout.setBottom(vertical);
        layout.setCenter(centerText);

        Scene scene = new Scene(layout);

        window.setScene(scene);
        window.show();
        
      
            centerText.textProperty().addListener((change, oldValue, newValue) -> {
            int characters = newValue.length();
            String[] parts = newValue.split(" ");

            labelOne.setText("Letters: " + characters);
            labelTwo.setText("Words: " + parts.length);

            String longest = Arrays.stream(parts)
                    .sorted((s1, s2) -> s2.length() - s1.length())
                    .findFirst()
                    .get();

            labelThree.setText("The longest word is: " + longest);
        });
    }
}
