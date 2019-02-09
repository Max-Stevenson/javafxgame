package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("My Game");

        Group root = new Group();
        Scene firstScene  = new Scene(root);
        primaryStage.setScene(firstScene);

        Canvas canvas = new Canvas(580, 370);
        root.getChildren().add(canvas);

        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

        graphicsContext.setFill(Color.RED);
        graphicsContext.setStroke(Color.BLACK);
        graphicsContext.setLineWidth(2);
        Font theFont = javafx.scene.text.Font.font("Times New Roman", FontWeight.BOLD, 48);
        graphicsContext.setFont( theFont );
        graphicsContext.fillText( "Hello, World!", 60, 50 );
        graphicsContext.strokeText( "Hello, World!", 60, 50 );

        Image earth = new Image("./earth.png", 100, 100, false, false);
        Image space = new Image("./space.png");
        Image sun = new Image("./sun.png",200, 200, false, false);


        final long startNanoTime = System.nanoTime();

        new AnimationTimer()
        {
            public void handle(long currentNanoTime)
            {
                double t = (currentNanoTime - startNanoTime) / 1000000000.0;

                double x = 232 + 128 * Math.cos(t);
                double y = 232 + 128 * Math.sin(t);

                // background image clears canvas
                graphicsContext.drawImage( space, 0, 0 );
                graphicsContext.drawImage( earth, x, y );
                graphicsContext.drawImage( sun, 190, 85 );
            }
        }.start();

        primaryStage.show();
    }
}
