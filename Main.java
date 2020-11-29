package sample;

import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;

public class Main extends Application {
    @Override
    public void start(Stage playStage) throws Exception{
        Stage stageHome=new Stage();
        Stage pauseStage = new Stage();

        pauseStage.setTitle("Color Switch | Pause");
        stageHome.setTitle("Color Switch | Home");
        playStage.setTitle("Color Switch | Play");

        Img logo=new Img("logo.png",50,10,400,400);
        Img C1=new Img("c1.png",50,5,100,100);
        Img C2=new Img("c2.png",50,5,150,150);
        Img C3=new Img("c3.png",50,5,190,190);
        Img starImg1=new Img("star.png",50,5,60,50);
        Img upImg=new Img("fingerup.png",50,5,35,35);
        Img pauseImg=new Img("pause_icon.png",5,5,25,25);
        Img resumeImg=new Img("resumeicon.png",5,5,100,100);
        Img homeImg=new Img("homeicon.png",5,5,50,50);
        Img saveImg=new Img("saveicon.png",5,5,50,50);
        Img switchImg=new Img("switch.png",5,5,30,30);
        Img starImg2=new Img("star.png",50,5,60,50);
        Img starImgHome=new Img("star.png",50,5,60,50);

        Text pauseText = new Text("PAUSE");
        Text saveText = new Text("Save Game?");
        Text scoreText = new Text("0");

        pauseText.setFont(Font.font ("Verdana", 80));
        pauseText.setFill(Color.WHITE);

        saveText.setFont(Font.font ("Verdana", 25));
        saveText.setFill(Color.WHITE);

        scoreText.setFont(Font.font ("Verdana", 30));
        scoreText.setFill(Color.WHITE);
        scoreText.setX(550);
        scoreText.setY(30);

        C1.rotate(1);
        C2.rotate(-1);
        C3.rotate(1);

        switchImg.getIview().setFitWidth(30);
        switchImg.getIview().setFitHeight(30);
        switchImg.getIview().setX(285);
        switchImg.getIview().setY(185);

        StackPane homeAnimation=new StackPane();
        homeAnimation.getChildren().addAll(starImgHome.getIview(),C1.getIview(),C2.getIview(),C3.getIview());

        VBox homeLayout=new VBox();
        homeLayout.setAlignment(Pos.CENTER);
        homeLayout.setSpacing(10);

        VBox pauseLayout = new VBox();
        pauseLayout.setAlignment(Pos.CENTER);
        pauseLayout.setSpacing(10);

        Button loadGame= new Button("LOAD GAME");
        Button exitGame= new Button("EXIT GAME");
        Button newGame= new Button("NEW GAME");
        Button bounceBtn=new Button();
        Button pauseBtn=new Button();
        Button resumeBtn= new Button();
        Button homeBtn = new Button();
        Button saveBtn = new Button();

        bounceBtn.setGraphic(upImg.getIview());
        pauseBtn.setGraphic(pauseImg.getIview());
        resumeBtn.setGraphic(resumeImg.getIview());
        homeBtn.setGraphic(homeImg.getIview());
        saveBtn.setGraphic(saveImg.getIview());

        bounceBtn.setStyle( "-fx-text-fill: white; " + "-fx-background-color: black;"+"-fx-outer-border:1;"+ "-fx-inner-border:1;" +"-fx-border-color:black;");
        pauseBtn.setStyle( "-fx-text-fill: white; " + "-fx-background-color: black;"+"-fx-outer-border:1;"+ "-fx-inner-border:1;" +"-fx-border-color:black;");
        resumeBtn.setStyle( "-fx-text-fill: white; " + "-fx-background-color: grey;"+"-fx-outer-border:1;"+ "-fx-inner-border:1;" +"-fx-border-color:white;"+"-fx-background-size: 100% 100%;"+"-fx-background-radius: 16.4, 15;"+"-fx-background-insets: -1.4, 0;"+ "-fx-border-radius: 15;");
        homeBtn.setStyle("-fx-background-color: black;"+"-fx-border-color:black;");
        saveBtn.setStyle("-fx-background-color: black;"+"-fx-border-color:black;");
        newGame.setStyle( "-fx-text-fill: white; " + "-fx-background-color: black;"+"-fx-outer-border:1;"+ "-fx-inner-border:1;" +"-fx-border-color:white;");
        loadGame.setStyle( "-fx-text-fill: white; " + "-fx-background-color: black;"+"-fx-outer-border:1;"+ "-fx-inner-border:1;" +"-fx-border-color:white;");
        exitGame.setStyle( "-fx-text-fill: white; " + "-fx-background-color: black;"+"-fx-outer-border:1;"+ "-fx-inner-border:1;" +"-fx-border-color:white;");

        newGame.setPrefSize(160,20);
        loadGame.setPrefSize(160,20);
        exitGame.setPrefSize(160,20);
        resumeBtn.setPrefSize(40,40);

        Font font= Font.font("Roboto Condensed", FontWeight.BOLD, 10);
        newGame.setFont(font);
        loadGame.setFont(font);
        exitGame.setFont(font);

        homeLayout.getChildren().addAll(logo.getIview(),homeAnimation,newGame,loadGame,exitGame);
        pauseLayout.getChildren().addAll(homeBtn,pauseText,resumeBtn,saveText,saveBtn);

        BackgroundFill bgfill=new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY);
        Background bg=new Background(bgfill);
        homeLayout.setBackground(bg);
        pauseLayout.setBackground(bg);

        stageHome.setScene(new Scene(homeLayout, 500, 600));
        pauseStage.setScene(new Scene(pauseLayout, 500, 600));

        Group playLayout=new Group();

        starImg1.getIview().setFitWidth(30);
        starImg1.getIview().setFitHeight(30);
        starImg1.getIview().setX(285);
        starImg1.getIview().setY(5);

        starImg2.getIview().setFitWidth(30);
        starImg2.getIview().setFitHeight(30);
        starImg2.getIview().setX(285);
        starImg2.getIview().setY(285);

        Ball ball=new Ball(playStage,playLayout,bounceBtn,pauseBtn,scoreText,switchImg,starImg1,starImg2);

        bounceBtn.setLayoutX(550);
        bounceBtn.setLayoutY(450);
        pauseBtn.setLayoutX(5);
        pauseBtn.setLayoutY(5);

        Cross obstacle1=new Cross(100);
        Square obstacle2=new Square(300);

        bounceBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ball.buttonPressed();
            }
        });

        playLayout.getChildren().addAll(pauseBtn,bounceBtn,scoreText,obstacle1.getObstacle(),obstacle2.getObstacle(),starImg1.getIview(),starImg2.getIview(),switchImg.getIview(),ball.getBall());
        Scene playScene=new Scene(playLayout, 600, 500,Color.BLACK);
        playStage.setScene(playScene);

        newGame.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stageHome.close();
                playStage.show();
            }
        });

        exitGame.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stageHome.close();
            }
        });

        pauseBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ball.pause();
                playStage.close();
                pauseStage.show();
            }
        });

        resumeBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ball.resume();
                pauseStage.close();
                playStage.show();
            }
        });

        homeBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ball.startAgain();
                pauseStage.close();
                stageHome.show();
            }
        });

        stageHome.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}

class Obstacle{
    private Group G;
    public Obstacle(){
        G=new Group();
    }
    public Group getObstacle(){
        return G;
    }
}

class Square extends Obstacle{
    private Line line1,line2,line3,line4;
    private RotateTransition rotate;
    public Square(int y){
        super();
        line1=new Line(250,y-50,350,y-50);
        line1.setStrokeWidth(10);
        line2=new Line(350,y-50,350,y+50);
        line2.setStrokeWidth(10);
        line3=new Line(350,y+50,250,y+50);
        line3.setStrokeWidth(10);
        line4=new Line(250,y+50,250,y-50);
        line4.setStrokeWidth(10);
        line1.setStroke(Color.DEEPPINK);
        line2.setStroke(Color.AQUA);
        line3.setStroke(Color.YELLOW);
        line4.setStroke(Color.MEDIUMPURPLE);
        getObstacle().getChildren().addAll(line1,line2,line3,line4);
        rotate=new RotateTransition();
        rotate.setAxis(Rotate.Z_AXIS);
        rotate.setByAngle(360);
        rotate.setCycleCount(1);
        rotate.setDuration(Duration.millis(5000));
        rotate.setNode(getObstacle());
        rotate.play();
        rotate.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                rotate.play();
            }
        });
    }
}

class Triangle extends Obstacle{
    private Line line1,line2,line3;
    private RotateTransition rotate;
    public Triangle(int y){
        super();
        line1=new Line(300,y-35,350,y+50);
        line2=new Line(350,y+50,250,y+50);
        line3=new Line(250,y+50,300,y-35);
        line1.setStrokeWidth(10);
        line2.setStrokeWidth(10);
        line3.setStrokeWidth(10);
        line1.setStroke(Color.DEEPPINK);
        line2.setStroke(Color.AQUA);
        line3.setStroke(Color.YELLOW);
        getObstacle().getChildren().addAll(line1,line2,line3);
        rotate=new RotateTransition();
        rotate.setAxis(Rotate.Z_AXIS);
        rotate.setByAngle(360);
        rotate.setCycleCount(1);
        rotate.setDuration(Duration.millis(5000));
        rotate.setNode(getObstacle());
        rotate.play();
        rotate.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                rotate.play();
            }
        });
    }
}

class lineObstacle extends Obstacle{
    private Line line1,line2,line3,line4;
    private TranslateTransition Oline;
    public lineObstacle(int y){
        super();
        line1=new Line(0,y,75,y);
        line2=new Line(75,y,150,y);
        line3=new Line(150,y,225,y);
        line4=new Line(225,y,300,y);
        line1.setStrokeWidth(10);
        line2.setStrokeWidth(10);
        line3.setStrokeWidth(10);
        line4.setStrokeWidth(10);
        Oline=new TranslateTransition();
        line1.setStroke(Color.DEEPPINK);
        line2.setStroke(Color.AQUA);
        line3.setStroke(Color.YELLOW);
        line4.setStroke(Color.MEDIUMPURPLE);
        getObstacle().getChildren().addAll(line1,line2,line3,line4);
        Oline.setByX(300);
        Oline.setDuration(Duration.millis(5000));
        Oline.setCycleCount(2);
        Oline.setAutoReverse(true);
        Oline.setNode(getObstacle());
        Oline.play();
        Oline.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Oline.play();
            }
        });
    }
}

class Cross extends Obstacle{
    private Line line1,line2,line3,line4,line5,line6;
    private TranslateTransition Oline1,Oline2;
    private Group G1,G2;
    public Cross(int y){
        super();
        G1=new Group();
        G2=new Group();
        line1=new Line(0,y+50,100,y+34);
        line2=new Line(100,y+34,200,y+17);
        line3=new Line(200,y+17,300,y);
        line4=new Line(0,y-50,100,y-33);
        line5=new Line(100,y-33,200,y-16);
        line6=new Line(200,y-16,300,y);
        line1.setStrokeWidth(10);
        line2.setStrokeWidth(10);
        line3.setStrokeWidth(10);
        line4.setStrokeWidth(10);
        line5.setStrokeWidth(10);
        line6.setStrokeWidth(10);
        line1.setStroke(Color.DEEPPINK);
        line2.setStroke(Color.AQUA);
        line3.setStroke(Color.YELLOW);
        G1.getChildren().addAll(line1,line2,line3);
        line4.setStroke(Color.DEEPPINK);
        line5.setStroke(Color.AQUA);
        line6.setStroke(Color.YELLOW);
        G2.getChildren().addAll(line4,line5,line6);
        Oline1=new TranslateTransition();
        Oline2=new TranslateTransition();
        getObstacle().getChildren().addAll(G1,G2);
        Oline1.setByX(300);
        Oline1.setByY(-50);
        Oline1.setDuration(Duration.millis(5000));
        Oline1.setCycleCount(2);
        Oline1.setAutoReverse(true);
        Oline1.setNode(G1);
        Oline1.play();
        Oline1.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Oline1.play();
            }
        });
        Oline2.setByX(300);
        Oline2.setByY(50);
        Oline2.setDuration(Duration.millis(5000));
        Oline2.setCycleCount(2);
        Oline2.setAutoReverse(true);
        Oline2.setNode(G2);
        Oline2.play();
        Oline2.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Oline2.play();
            }
        });
    }
}

class Ball{
    private Circle ball;
    private TranslateTransition TTup, TTdown;
    private int upDist;
    public Ball(Stage ss,Group G,Button btn,Button pbtn,Text t,Img i1,Img i2,Img i3){
        ball=new Circle();
        TTup=new TranslateTransition();
        TTdown=new TranslateTransition();
        ball.setCenterX(300);
        ball.setCenterY(450);
        ball.setRadius(6.5);
        ball.setFill(Color.DEEPPINK);
        TTup.setByY(-1);
        TTup.setDuration(Duration.millis(10));
        TTup.setCycleCount(1);
        TTup.setNode(ball);
        TTup.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ball.setCenterY(ball.getCenterY()+ball.getTranslateY());
                ball.setTranslateY(0);
                if(upDist==20){
                    upDist=0;
                    TTdown.play();
                }
                else{
                    upDist++;
                    TTup.play();
                }
                if(ball.getCenterY()<=0) {
                    pause();
                    startAgain();
                    Random r=new Random();
                    int a=r.nextInt(4);
                    int b=r.nextInt(4);
                    while(b==a)
                        b=r.nextInt(4);
                    Obstacle[] O=new Obstacle[2];
                    if(a==0)
                        O[0]=new Cross(300);
                    if(a==1)
                        O[0]=new lineObstacle(300);
                    if(a==2)
                        O[0]=new Square(300);
                    if(a==3)
                        O[0]=new Triangle(300);
                    if(b==0)
                        O[1]=new Cross(100);
                    if(b==1)
                        O[1]=new lineObstacle(100);
                    if(b==2)
                        O[1]=new Square(100);
                    if(b==3)
                        O[1]=new Triangle(100);
                    G.getChildren().clear();
                    G.getChildren().addAll(btn,pbtn,t,O[0].getObstacle(),O[1].getObstacle(),i1.getIview(),i2.getIview(),i3.getIview(),ball);
                    ss.show();
                }
            }
        });
        TTdown.setByY(0.5);
        TTdown.setDuration(Duration.millis(10));
        TTdown.setCycleCount(1);
        TTdown.setNode(ball);
        TTdown.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ball.setCenterY(ball.getCenterY()+ball.getTranslateY());
                ball.setTranslateY(0);
                TTdown.play();
            }
        });
    }
    public void startAgain(){
        ball.setCenterY(450);
    }
    public void resume(){
        TTdown.play();
    }
    public void pause(){
        TTdown.stop();
        TTup.stop();
    }
    public void buttonPressed(){
        TTup.stop();
        TTdown.stop();
        TTup.play();
    }
    public Circle getBall(){
        return ball;
    }
}

class Img{
    private Image i;
    private ImageView iview;
    private RotateTransition r;
    public Img(String name, int x, int y, int h, int w) throws FileNotFoundException {
        i=new Image(new FileInputStream(name));
        iview=new ImageView(i);
        r = new RotateTransition();
        iview.setX(x);
        iview.setY(y);
        iview.setFitHeight(h);
        iview.setFitWidth(w);
        iview.setPreserveRatio(true);
    }
    public void rotate(int c){
        r.setAxis(Rotate.Z_AXIS);
        r.setByAngle(c*360);
        r.setCycleCount(500);
        r.setDuration(Duration.millis(2000));
        r.setNode(iview);
        r.play();
    }
    public ImageView getIview() {
        return iview;
    }
    public Image getI() {
        return i;
    }
}

class Collectables{
    private Img i;
    //Location l
}

class star extends Collectables{ }

class Switch extends Collectables{ }