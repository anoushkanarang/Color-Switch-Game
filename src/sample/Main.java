package sample;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Main extends Application {
    @Override
    public void start(Stage playStage) throws Exception{
        Level level=new Level();
        App getApp=new App(0,0);

        try{
            ObjectInputStream in=new ObjectInputStream(new FileInputStream("file.txt"));
            getApp=(App)in.readObject();
            in.close();
        }
        catch(Exception e){
            System.out.println(e);
        }

        App app=getApp;

        Stage exitStage = new Stage();
        Stage stageHome=new Stage();
        Stage pauseStage = new Stage();
        Stage savedStage = new Stage();
        Stage helpStage = new Stage();
        Stage settingStage = new Stage();

        Game game=new Game(app);

        Text highScoreText = new Text(app.getHighScore()+"");
        Text totalStarsText = new Text(app.getTotalStars()+"");

        highScoreText.setFont(Font.font ("Verdana",FontWeight.BOLD, 15));
        highScoreText.setFill(Color.WHITE);
        highScoreText.setX(410);
        highScoreText.setY(20);
        totalStarsText.setFont(Font.font ("Verdana",FontWeight.BOLD, 15));
        totalStarsText.setFill(Color.WHITE);
        totalStarsText.setX(460);
        totalStarsText.setY(20);

        pauseStage.setTitle("Color Switch | Pause");
        stageHome.setTitle("Color Switch | Home");
        playStage.setTitle("Color Switch | Play");
        exitStage.setTitle("Color Switch | Exit");
        savedStage.setTitle("Color Switch | Saved Games");
        helpStage.setTitle("Color Switch | Help");
        settingStage.setTitle("Color Switch | Settings");

        final TextField textField = new TextField("help@example.com");
        final Button MailBtn = new Button();
        EventHandler<ActionEvent> goHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            { getHostServices().showDocument("mailto:"+textField.getText());}
        };
        textField.setOnAction(goHandler);
        MailBtn.setOnAction(goHandler);

        String link = "https://www.youtube.com/watch?v=-KV35ZXSW8s";

        Img logo=new Img("logo.png",50,35,400,400);
        Img icon=new Img("icon.png",50,10,400,400);
        Img C1=new Img("c1.png",50,5,100,100);
        Img C2=new Img("c2.png",50,5,150,150);
        Img C3=new Img("c3.png",50,5,190,190);
        Img upImg=new Img("fingerup.png",50,5,35,35);
        Img pauseImg=new Img("pause_icon.png",5,5,25,25);
        Img resumeImg=new Img("resumeicon.png",5,5,100,100);
        Img homeImg=new Img("homeicon.png",5,5,50,50);
        Img saveImg=new Img("saveicon.png",5,5,50,50);
        Img starImgHome=new Img("star.png",50,5,60,50);
        Img TotstarImg =new Img("star.png",430,5,30,30);
        Img highscore =new Img("trophy.png",365,5,50,40);
        Img gameEnd = new Img("gameEnd.png",50,10,400,400);
        Img feedbackImg = new Img("feedback.png",5,5,90,120);
        Img settingsImg = new Img("settingsbtn.png",5,5,30,60);
        Img restartImg = new Img("restart_icon.png",5,5,30,60);
        Img lightmodeImg = new Img("lightmode.jpg",5,5,50,50);
        Img darkmodeImg = new Img("darkmode.png",5,5,50,50);
        Img logolite=new Img("logolite.png",50,10,400,400);
        Img upImglite=new Img("fingeruplite.png",50,5,35,35);
        Img pauseImglite=new Img("pause_iconlite.png",5,5,25,25);
        Img resumeImglite=new Img("resumeiconlite.png",5,5,100,100);
        Img saveImglite=new Img("saveiconlite.png",5,5,50,50);
        Img restartImglite = new Img("restart_iconlite.png",5,5,30,60);
        Img lightmodeImglite = new Img("lightmodelite.jpg",5,5,50,50);
        Img darkmodeImglite = new Img("darkmodelite.png",5,5,50,50);
        Img settingsImglite = new Img("settingsbtnlite.png",5,5,30,60);
        Img feedbackImglite = new Img("feedbacklite.png",5,5,90,120);
        Img homeImg1=new Img("homeicon.png",5,5,50,50);
        Img homeImg2=new Img("homeicon.png",5,5,50,50);
        Img homeImglite=new Img("homeiconlite.png",5,5,50,50);
        Img homeImg1lite=new Img("homeiconlite.png",5,5,50,50);
        Img homeImg2lite=new Img("homeiconlite.png",5,5,50,50);
        Text pauseText = new Text("PAUSE");
        Text saveText = new Text("Save Game?");
        Text scoreText = new Text("0");
        Text helpText1 = new Text("COLOR SWITCH\n Ultimate Guide\n");
        Text helpText2 = new Text("\t  Color Switch has a very simple goal.\n\n" +
                "-- Tap, Tap, Tap to get the ball past each obstacle.\n" +
                "-- Follow the color pattern to cross each obstacle.\n" +
                "-- Timing and Patience are the keys to victory.\n"+
                "-- Earn stars to unlock new balls.\n" +
                "-- Beat Every Challenge to get a High Score!\n");
        Text helpText3 = new Text("We'd love to hear your feedback!\n \tYou can write to us below");
        Text settingsText0 = new Text("Customize Your Way!\n");
        Text settingsText1 = new Text("SELECT MODE");
        Text settingsText2 = new Text("CURRENT LEVEL");
        pauseText.setFont(Font.font ("Verdana", 80));
        pauseText.setFill(Color.WHITE);

        saveText.setFont(Font.font ("Verdana", 25));
        saveText.setFill(Color.WHITE);

        helpText1.setFont(Font.font ("Verdana", FontWeight.BOLD,30));
        helpText1.setFill(Color.WHITE);
        helpText2.setFont(Font.font ("Roboto", 20));
        helpText2.setFill(Color.WHITE);
        helpText3.setFont(Font.font ("Verdana",FontWeight.BOLD, 20));
        helpText3.setFill(Color.WHITE);

        settingsText0.setFont(Font.font ("Verdana",FontWeight.BOLD, 30));
        settingsText0.setFill(Color.WHITE);
        settingsText1.setFont(Font.font ("Verdana",FontWeight.BOLD, 20));
        settingsText1.setFill(Color.WHITE);
        settingsText2.setFont(Font.font ("Verdana",FontWeight.BOLD, 20));
        settingsText2.setFill(Color.WHITE);


        scoreText.setFont(Font.font ("Verdana", 25));
        scoreText.setFill(Color.WHITE);
        scoreText.setX(550);
        scoreText.setY(30);

        C1.rotate(1);
        C2.rotate(-1);
        C3.rotate(1);

        StackPane homeAnimation=new StackPane();
        homeAnimation.getChildren().addAll(starImgHome.getIview(),C1.getIview(),C2.getIview(),C3.getIview());

        Group playLayout=new Group();
        Group homegrp = new Group();
        ToggleGroup tg1 = new ToggleGroup();
        ToggleGroup tg2 = new ToggleGroup();

        VBox homeLayout=new VBox();
        homeLayout.setAlignment(Pos.CENTER);
        homeLayout.setSpacing(10);

        VBox pauseLayout = new VBox();
        pauseLayout.setAlignment(Pos.CENTER);
        pauseLayout.setSpacing(10);

        VBox exitLayout = new VBox();
        exitLayout.setAlignment(Pos.CENTER);
        exitLayout.setSpacing(10);

        VBox savedGLayout = new VBox();
        savedGLayout.setAlignment(Pos.CENTER);
        savedGLayout.setSpacing(5);

        VBox helpLayout = new VBox();
        helpLayout.setAlignment(Pos.CENTER);
        helpLayout.setSpacing(10);

        VBox settingsLayout = new VBox();
        settingsLayout.setAlignment(Pos.CENTER);
        settingsLayout.setSpacing(15);

        HBox h1 = new HBox();
        HBox h2 = new HBox();

        h1.setAlignment(Pos.CENTER);
        h1.setSpacing(10);
        h2.setAlignment(Pos.CENTER);
        h2.setSpacing(10);
        Button homeBtnSaved = new Button();
        savedGLayout.getChildren().add(homeBtnSaved);

        for (int i =0; i<app.getSize();i++) {
            SaveableGame g = app.getGame(i);
            Button b = new Button("Game"+(i+1)+"(Score : "+g.getScore()+")");
            b.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent){
                    game.startAgain();
                    game.setScore(g.getScore());
                    game.setObstacleDuration(g.getObstacleDuration());
                    savedStage.close();
                    playStage.show();
                }
            });
            b.setStyle( "-fx-text-fill: grey; " + "-fx-background-color: black;"+"-fx-outer-border:1;"+ "-fx-inner-border:1;" +"-fx-border-color:white;");
            b.setPrefSize(300,40);
            b.setFont(Font.font("Roboto Condensed", FontWeight.BOLD, 15));
            savedGLayout.getChildren().add(b);
        }

        Button loadGame= new Button("LOAD GAME");
        Button exitGame= new Button("EXIT GAME");
        Button newGame= new Button("NEW GAME");
        Button resurrectGame = new Button("RESURRECT");
        Button exit = new Button("EXIT");
        Button helpBtn = new Button("HELP");
        Button bounceBtn=new Button();
        Button pauseBtn=new Button();
        Button resumeBtn= new Button();
        Button homeBtnPause = new Button();
        Button homeBtnHelp = new Button();
        Button saveBtn = new Button();
        Button restartBtn = new Button();
        Button tutorialBtn = new Button("TUTORIAL VIDEO");
        Button homeBtnSettings = new Button();
        Button settingsBtn = new Button();
        RadioButton lightMode = new RadioButton();
        RadioButton darkMode = new RadioButton();
        RadioButton easy = new RadioButton("EASY");
        RadioButton med = new RadioButton("MEDIUM");
        RadioButton diff = new RadioButton("DIFFICULT");

        easy.setPrefSize(80,20);
        med.setPrefSize(100,20);
        diff.setPrefSize(120,20);
        easy.setToggleGroup(tg1);
        med.setToggleGroup(tg1);
        diff.setToggleGroup(tg1);
        lightMode.setToggleGroup(tg2);
        darkMode.setToggleGroup(tg2);

        h1.getChildren().addAll(lightMode,darkMode);
        h2.getChildren().addAll(easy, med, diff);
        bounceBtn.setGraphic(upImg.getIview());
        pauseBtn.setGraphic(pauseImg.getIview());
        resumeBtn.setGraphic(resumeImg.getIview());
        homeBtnPause.setGraphic(homeImg.getIview());
        homeBtnSaved.setGraphic(homeImg.getIview());
        saveBtn.setGraphic(saveImg.getIview());
        MailBtn.setGraphic(feedbackImg.getIview());
        homeBtnHelp.setGraphic(homeImg.getIview());
        homeBtnSettings.setGraphic(homeImg.getIview());
        settingsBtn.setGraphic(settingsImg.getIview());
        restartBtn.setGraphic(restartImg.getIview());
        lightMode.setGraphic(lightmodeImg.getIview());
        darkMode.setGraphic(darkmodeImg.getIview());

        homeAnimation.setLayoutX(160);
        homeAnimation.setLayoutY(240);
        newGame.setLayoutX(180);
        newGame.setLayoutY(450);
        loadGame.setLayoutX(180);
        loadGame.setLayoutY(480);
        exitGame.setLayoutX(180);
        exitGame.setLayoutY(540);
        helpBtn.setLayoutX(180);
        helpBtn.setLayoutY(510);
        settingsBtn.setLayoutX(5);
        settingsBtn.setLayoutY(5);

        bounceBtn.setStyle( "-fx-text-fill: white; " + "-fx-background-color: black;"+"-fx-outer-border:1;"+ "-fx-inner-border:1;" +"-fx-border-color:black;");
        pauseBtn.setStyle( "-fx-text-fill: white; " + "-fx-background-color: black;"+"-fx-outer-border:1;"+ "-fx-inner-border:1;" +"-fx-border-color:black;");
        resumeBtn.setStyle( "-fx-text-fill: white; " + "-fx-background-color: grey;"+"-fx-outer-border:1;"+ "-fx-inner-border:1;" +"-fx-border-color:white;"+"-fx-background-size: 100% 100%;"+"-fx-background-radius: 16.4, 15;"+"-fx-background-insets: -1.4, 0;"+ "-fx-border-radius: 15;");
        homeBtnPause.setStyle("-fx-background-color: black;"+"-fx-border-color:black;");
        homeBtnSaved.setStyle("-fx-background-color: black;"+"-fx-border-color:black;");
        homeBtnHelp.setStyle("-fx-background-color: black;"+"-fx-border-color:black;");
        MailBtn.setStyle("-fx-background-color: black;"+"-fx-border-color:black;");
        homeBtnSettings.setStyle("-fx-background-color: black;"+"-fx-border-color:black;");
        settingsBtn.setStyle( "-fx-text-fill: white; " + "-fx-background-color: black;"+"-fx-outer-border:1;"+ "-fx-inner-border:1;" +"-fx-border-color:black;");
        saveBtn.setStyle("-fx-background-color: black;"+"-fx-border-color:black;");
        newGame.setStyle( "-fx-text-fill: white; " + "-fx-background-color: black;"+"-fx-outer-border:1;"+ "-fx-inner-border:1;" +"-fx-border-color:white;");
        loadGame.setStyle( "-fx-text-fill: white; " + "-fx-background-color: black;"+"-fx-outer-border:1;"+ "-fx-inner-border:1;" +"-fx-border-color:white;");
        exitGame.setStyle( "-fx-text-fill: white; " + "-fx-background-color: black;"+"-fx-outer-border:1;"+ "-fx-inner-border:1;" +"-fx-border-color:white;");
        resurrectGame.setStyle( "-fx-text-fill: white; " + "-fx-background-color: black;"+"-fx-outer-border:1;"+ "-fx-inner-border:1;" +"-fx-border-color:white;");
        exit.setStyle( "-fx-text-fill: white; " + "-fx-background-color: black;"+"-fx-outer-border:1;"+ "-fx-inner-border:1;" +"-fx-border-color:white;");
        restartBtn.setStyle( "-fx-text-fill: white; " + "-fx-background-color: black;"+"-fx-outer-border:1;"+ "-fx-inner-border:1;" +"-fx-border-color:black;");
        helpBtn.setStyle( "-fx-text-fill: white; " + "-fx-background-color: black;"+"-fx-outer-border:1;"+ "-fx-inner-border:1;" +"-fx-border-color:white;");
        exit.setStyle( "-fx-text-fill: white; " + "-fx-background-color: black;"+"-fx-outer-border:1;"+ "-fx-inner-border:1;" +"-fx-border-color:black;");
        resurrectGame.setStyle( "-fx-text-fill: white; " + "-fx-background-color: black;"+"-fx-outer-border:1;"+ "-fx-inner-border:1;" +"-fx-border-color:black;");
        tutorialBtn.setStyle( "-fx-text-fill: white; " + "-fx-background-color: black;"+"-fx-outer-border:1;"+ "-fx-inner-border:1;" +"-fx-border-color:white;");
        tutorialBtn.setFont(Font.font ("Verdana", 15));

        newGame.setPrefSize(160,20);
        loadGame.setPrefSize(160,20);
        exitGame.setPrefSize(160,20);
        resurrectGame.setPrefSize(160,20);
        exit.setPrefSize(160,20);
        resumeBtn.setPrefSize(40,40);
        helpBtn.setPrefSize(160,20);
        tutorialBtn.setPrefSize(200,25);

        BackgroundFill bgfill1=new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY);
        BackgroundFill bgfill2=new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
        Background BG1=new Background(bgfill1);
        Background BG2=new Background(bgfill2);

        Font f1= Font.font("Roboto Condensed", FontWeight.BOLD, 10);
        Font f2= Font.font("Roboto Condensed", FontWeight.BOLD, 15);
        newGame.setFont(f1);
        loadGame.setFont(f1);
        exitGame.setFont(f1);
        helpBtn.setFont(f1);
        exit.setFont(f1);
        resurrectGame.setFont(f1);
        easy.setFont(f2);
        med.setFont(f2);
        diff.setFont(f2);

        Text exitScore=new Text();
        Text exitHighScore=new Text();
        Text Compliment=new Text();
        exitScore.setFill(Color.WHITE);
        exitHighScore.setFill(Color.WHITE);
        Compliment.setFill(Color.WHITE);

        exitLayout.getChildren().addAll(gameEnd.getIview(),resurrectGame,exit,exitScore,exitHighScore,Compliment);
        pauseLayout.getChildren().addAll(homeBtnPause,pauseText,resumeBtn,saveText,saveBtn);
        homegrp.getChildren().addAll(settingsBtn,highscore.getIview(),highScoreText,TotstarImg.getIview(),totalStarsText, logo.getIview(),homeAnimation,newGame,loadGame,helpBtn,exitGame);
        settingsLayout.getChildren().addAll(homeBtnSettings,settingsText0,settingsText1,h1,settingsText2,h2);
        helpLayout.getChildren().addAll(homeBtnHelp,helpText1,tutorialBtn,helpText2,helpText3, MailBtn);

        pauseLayout.setBackground(BG1);
        homeLayout.setBackground(BG1);
        exitLayout.setBackground(BG1);
        savedGLayout.setBackground(BG1);
        helpLayout.setBackground(BG1);
        settingsLayout.setBackground(BG1);

        settingStage.setScene(new Scene(settingsLayout, 500, 600));
        helpStage.setScene(new Scene(helpLayout, 500, 600));
        Scene stageScene = new Scene(homegrp, 500, 600, Color.BLACK);
        stageHome.setScene((stageScene));
        pauseStage.setScene(new Scene(pauseLayout, 500, 600));
        exitStage.setScene(new Scene(exitLayout, 600, 600));
        savedStage.setScene(new Scene(savedGLayout, 500, 600, Color.BLACK));

        settingStage.getIcons().add(icon.getI());
        stageHome.getIcons().add(icon.getI());
        helpStage.getIcons().add(icon.getI());
        pauseStage.getIcons().add(icon.getI());
        playStage.getIcons().add(icon.getI());
        exitStage.getIcons().add(icon.getI());
        savedStage.getIcons().add(icon.getI());

        bounceBtn.setLayoutX(550);
        bounceBtn.setLayoutY(450);
        pauseBtn.setLayoutX(5);
        pauseBtn.setLayoutY(5);
        restartBtn.setLayoutX(550);
        restartBtn.setLayoutY(350);

        bounceBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                game.buttonPressed();
            }
        });

        playLayout.getChildren().addAll(pauseBtn,bounceBtn,scoreText,restartBtn,game.getAll());
        Scene playScene = new Scene(playLayout, 600, 500,Color.BLACK);
        playStage.setScene(playScene);

        newGame.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                game.startAgain();
                game.setScore(0);
                if(level.get()==1)
                    game.setObstacleDuration(8000);
                else if(level.get()==2)
                    game.setObstacleDuration(6000);
                else
                    game.setObstacleDuration(4000);
                stageHome.close();
                playStage.show();
            }
        });
        loadGame.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stageHome.close();
                savedStage.show();
            }
        });
        exitGame.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                save(app);
                stageHome.close();
            }
        });
        restartBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                game.startAgain();
                game.setScore(0);
                if(level.get()==1)
                    game.setObstacleDuration(8000);
                else if(level.get()==2)
                    game.setObstacleDuration(6000);
                else
                    game.setObstacleDuration(4000);
                pauseStage.close();
                playStage.show();
            }
        });
        homeBtnPause.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                pauseStage.close();
                stageHome.show();
            }
        });
        homeBtnHelp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                helpStage.close();
                stageHome.show();
            }
        });
        homeBtnSettings.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                settingStage.close();
                stageHome.show();
            }
        });
        homeBtnSaved.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                savedStage.close();
                stageHome.show();
            }
        });
        settingsBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stageHome.close();
                settingStage.show();
            }
        });
        helpBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stageHome.close();
                helpStage.show();
            }
        });
        tutorialBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                getHostServices().showDocument(link);
            }
        });
        saveBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(game.getScore()>app.getHighScore())
                    app.setHighScore(game.getScore());
                app.setTotalStars(app.getTotalStars()+game.getScore());
                SaveableGame g=new SaveableGame(game.getObstacleDuration(), game.getScore());
                app.addGame(g);
                Button btn = new Button("Game "+(app.getSize())+" (Score: "+g.getScore()+")");
                btn.setOnAction((event) -> {
                    game.startAgain();
                    game.setScore(g.getScore());
                    game.setObstacleDuration(g.getObstacleDuration());
                    savedStage.close();
                    playStage.show();
                });
                btn.setStyle("-fx-text-fill: white; " + "-fx-background-color: black;" + "-fx-outer-border:1;" + "-fx-inner-border:1;" + "-fx-border-color:white;");
                btn.setPrefSize(300, 40);
                btn.setFont(Font.font("Roboto Condensed", FontWeight.BOLD, 15));
                savedGLayout.getChildren().add(btn);
            }
        });
        pauseBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                game.pause();
                playStage.close();
                pauseStage.show();
            }
        });
        resumeBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                game.resume();
                pauseStage.close();
                playStage.show();
            }
        });

        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                game.exit();
                exitStage.close();
                stageHome.show();
            }
        });

        easy.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                level.set(1);
            }
        });
        med.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                level.set(2);
            }
        });
        diff.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                level.set(3);
            }
        });
        lightMode.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                bounceBtn.setGraphic(upImglite.getIview());
                pauseBtn.setGraphic(pauseImglite.getIview());
                resumeBtn.setGraphic(resumeImglite.getIview());
                restartBtn.setGraphic(restartImglite.getIview());
                homeBtnPause.setGraphic(homeImglite.getIview());
                homeBtnSaved.setGraphic(homeImg1lite.getIview());
                homeBtnHelp.setGraphic(homeImg2lite.getIview());
                homeBtnSettings.setGraphic(homeImglite.getIview());

                saveBtn.setGraphic(saveImglite.getIview());
                lightMode.setGraphic(lightmodeImglite.getIview());
                darkMode.setGraphic(darkmodeImglite.getIview());
                settingsBtn.setGraphic(settingsImglite.getIview());
                MailBtn.setGraphic(feedbackImglite.getIview());

                bounceBtn.setStyle( "-fx-text-fill: black; " + "-fx-background-color: white;"+"-fx-outer-border:1;"+ "-fx-inner-border:1;" +"-fx-border-color:white;");
                pauseBtn.setStyle( "-fx-text-fill: black; " + "-fx-background-color: white;"+"-fx-outer-border:1;"+ "-fx-inner-border:1;" +"-fx-border-color:white;");
                settingsBtn.setStyle( "-fx-text-fill:  black; " + "-fx-background-color: white;"+"-fx-outer-border:1;"+ "-fx-inner-border:1;" +"-fx-border-color:white;");
                restartBtn.setStyle( "-fx-text-fill: black; " + "-fx-background-color: white;"+"-fx-outer-border:1;"+ "-fx-inner-border:1;" +"-fx-border-color:white;");
                resumeBtn.setStyle( "-fx-text-fill:black; " + "-fx-background-color: grey;"+"-fx-outer-border:1;"+ "-fx-inner-border:1;" +"-fx-border-color:black;"+"-fx-background-size: 100% 100%;"+"-fx-background-radius: 16.4, 15;"+"-fx-background-insets: -1.4, 0;"+ "-fx-border-radius: 15;");
                homeBtnPause.setStyle("-fx-background-color: white;"+"-fx-border-color:white;");
                homeBtnSaved.setStyle("-fx-background-color: white;"+"-fx-border-color:white;");
                homeBtnSettings.setStyle("-fx-background-color: white;"+"-fx-border-color:white;");
                homeBtnHelp.setStyle("-fx-background-color: white;"+"-fx-border-color:white;");
                saveBtn.setStyle("-fx-background-color: white;"+"-fx-border-color:white;");
                newGame.setStyle( "-fx-text-fill: black; " + "-fx-background-color: white;"+"-fx-outer-border:1;"+ "-fx-inner-border:1;" +"-fx-border-color:black;");
                loadGame.setStyle( "-fx-text-fill: black; " + "-fx-background-color: white;"+"-fx-outer-border:1;"+ "-fx-inner-border:1;" +"-fx-border-color:black;");
                exitGame.setStyle( "-fx-text-fill: black; " + "-fx-background-color: white;"+"-fx-outer-border:1;"+ "-fx-inner-border:1;" +"-fx-border-color:black;");
                helpBtn.setStyle( "-fx-text-fill: black; " + "-fx-background-color: white;"+"-fx-outer-border:1;"+ "-fx-inner-border:1;" +"-fx-border-color:black;");
                tutorialBtn.setStyle( "-fx-text-fill: black; " + "-fx-background-color: white;"+"-fx-outer-border:1;"+ "-fx-inner-border:1;" +"-fx-border-color:black;");
                MailBtn.setStyle( "-fx-text-fill: black; " + "-fx-background-color: white;"+"-fx-outer-border:1;"+ "-fx-inner-border:1;" +"-fx-border-color:white;");
                homegrp.getChildren().remove(logo.getIview());
                homegrp.getChildren().add(logolite.getIview());
                settingsText0.setFill(Color.BLACK);
                settingsText1.setFill(Color.BLACK);
                settingsText2.setFill(Color.BLACK);

                pauseText.setFill(Color.BLACK);
                saveText.setFill(Color.BLACK);
                helpText1.setFill(Color.BLACK);
                helpText2.setFill(Color.BLACK);
                helpText3.setFill(Color.BLACK);
                scoreText.setFill(Color.BLACK);
                highScoreText.setFill(Color.BLACK);
                totalStarsText.setFill(Color.BLACK);

                pauseLayout.setBackground(BG2);
                helpLayout.setBackground(BG2);
                settingsLayout.setBackground(BG2);
                savedGLayout.setBackground(BG2);
                playScene.setFill(Color.GREY);
                stageScene.setFill(Color.GREY);

            }
        });

        darkMode.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                bounceBtn.setGraphic(upImg.getIview());
                pauseBtn.setGraphic(pauseImg.getIview());
                resumeBtn.setGraphic(resumeImg.getIview());
                restartBtn.setGraphic(restartImg.getIview());
                homeBtnPause.setGraphic(homeImg.getIview());
                homeBtnHelp.setGraphic(homeImg1.getIview());
                homeBtnSaved.setGraphic(homeImg2.getIview());
                saveBtn.setGraphic(saveImg.getIview());
                lightMode.setGraphic(lightmodeImg.getIview());
                darkMode.setGraphic(darkmodeImg.getIview());
                settingsBtn.setGraphic(settingsImg.getIview());
                MailBtn.setGraphic(feedbackImg.getIview());
                homeBtnSettings.setGraphic(homeImg.getIview());

                bounceBtn.setStyle( "-fx-text-fill: white; " + "-fx-background-color: black;"+"-fx-outer-border:1;"+ "-fx-inner-border:1;" +"-fx-border-color:black;");
                pauseBtn.setStyle( "-fx-text-fill: white; " + "-fx-background-color: black;"+"-fx-outer-border:1;"+ "-fx-inner-border:1;" +"-fx-border-color:black;");
                settingsBtn.setStyle( "-fx-text-fill: white; " + "-fx-background-color: black;"+"-fx-outer-border:1;"+ "-fx-inner-border:1;" +"-fx-border-color:black;");
                restartBtn.setStyle( "-fx-text-fill: white; " + "-fx-background-color: black;"+"-fx-outer-border:1;"+ "-fx-inner-border:1;" +"-fx-border-color:black;");
                resumeBtn.setStyle( "-fx-text-fill: white; " + "-fx-background-color: grey;"+"-fx-outer-border:1;"+ "-fx-inner-border:1;" +"-fx-border-color:white;"+"-fx-background-size: 100% 100%;"+"-fx-background-radius: 16.4, 15;"+"-fx-background-insets: -1.4, 0;"+ "-fx-border-radius: 15;");
                homeBtnPause.setStyle("-fx-background-color: black;"+"-fx-border-color:black;");
                homeBtnSaved.setStyle("-fx-background-color: black;"+"-fx-border-color:black;");
                homeBtnHelp.setStyle("-fx-background-color: black;"+"-fx-border-color:black;");
                homeBtnSettings.setStyle("-fx-background-color: black;"+"-fx-border-color:black;");
                saveBtn.setStyle("-fx-background-color: black;"+"-fx-border-color:black;");
                newGame.setStyle( "-fx-text-fill: white; " + "-fx-background-color: black;"+"-fx-outer-border:1;"+ "-fx-inner-border:1;" +"-fx-border-color:white;");
                loadGame.setStyle( "-fx-text-fill: white; " + "-fx-background-color: black;"+"-fx-outer-border:1;"+ "-fx-inner-border:1;" +"-fx-border-color:white;");
                exitGame.setStyle( "-fx-text-fill: white; " + "-fx-background-color: black;"+"-fx-outer-border:1;"+ "-fx-inner-border:1;" +"-fx-border-color:white;");
                helpBtn.setStyle( "-fx-text-fill: white; " + "-fx-background-color: black;"+"-fx-outer-border:1;"+ "-fx-inner-border:1;" +"-fx-border-color:white;");
                tutorialBtn.setStyle( "-fx-text-fill: white; " + "-fx-background-color: black;"+"-fx-outer-border:1;"+ "-fx-inner-border:1;" +"-fx-border-color:white;");
                tutorialBtn.setFont(Font.font ("Verdana", 15));
                MailBtn.setStyle( "-fx-text-fill: white; " + "-fx-background-color: black;"+"-fx-outer-border:1;"+ "-fx-inner-border:1;" +"-fx-border-color:black;");

                homegrp.getChildren().remove(logolite.getIview());
                homegrp.getChildren().add(logo.getIview());

                settingsText0.setFill(Color.WHITE);
                settingsText1.setFill(Color.WHITE);
                settingsText2.setFill(Color.WHITE);
                pauseText.setFill(Color.WHITE);
                saveText.setFill(Color.WHITE);
                helpText1.setFill(Color.WHITE);
                helpText2.setFill(Color.WHITE);
                helpText3.setFill(Color.WHITE);
                scoreText.setFill(Color.WHITE);
                highScoreText.setFill(Color.WHITE);
                totalStarsText.setFill(Color.WHITE);
                pauseLayout.setBackground(BG1);
                helpLayout.setBackground(BG1);
                settingsLayout.setBackground(BG1);
                savedGLayout.setBackground(BG1);
                playScene.setFill(Color.BLACK);
                stageScene.setFill(Color.BLACK);
            }
        });

        resurrectGame.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (game.resurrect()==1) {
                    exitStage.close();
                    playStage.show();
                }
                else{
                    Alert a = new Alert(Alert.AlertType.INFORMATION);
                    a.setContentText("YOU NEED ATLEAST 20 stars TO CONTINUE. GAME OVER");
                    a.setTitle("INSUFFICIENT STARS");
                    a.showAndWait().filter(ButtonType.OK::equals).ifPresent(b -> {
                        exitStage.close();
                        stageHome.show();
                    });
                }
            }
        });

        stageHome.show();

        AnimationTimer timer=new AnimationTimer() {
            @Override
            public void handle(long l) {
                scoreText.setText(String.valueOf(game.getScore()));
                highScoreText.setText(app.getHighScore()+"");
                totalStarsText.setText(app.getTotalStars()+"");
                if(game.isOver()){
                    game.setOver(false);
                    exitScore.setText("Score: "+game.getScore());
                    exitHighScore.setText(("High Score: "+app.getHighScore()));
                    if(game.getScore()==app.getHighScore())
                        Compliment.setText("NEW HIGH SCORE");
                    else
                        Compliment.setText("");
                    playStage.close();
                    exitStage.show();
                }
            }
        };
        timer.start();

        stageHome.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                save(app);
            }
        });
        pauseStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                save(app);
            }
        });
        playStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                save(app);
            }
        });
        savedStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                save(app);
            }
        });
        exitStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                save(app);
            }
        });
        helpStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                save(app);
            }
        });
    }
    public void save(App A){
        try{
            FileOutputStream fout=new FileOutputStream("file.txt");
            ObjectOutputStream out=new ObjectOutputStream(fout);
            out.writeObject(A);
            out.flush();
            out.close();
            System.out.println("success");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}

class App implements java.io.Serializable{
    private ArrayList<SaveableGame> gameList=new ArrayList<>();
    private int highScore, totalStars;
    public App(int hs, int ts){
        highScore=hs;
        totalStars=ts;
    }
    public int getHighScore() {
        return highScore;
    }
    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }
    public int getTotalStars() {
        return totalStars;
    }
    public void setTotalStars(int totalStars) {
        this.totalStars = totalStars;
    }
    public void addGame(SaveableGame G){
        gameList.add(G);
    }
    public SaveableGame getGame(int i){
        return gameList.get(i);
    }
    public int getSize(){
        return gameList.size();
    }
}

class Level{
    private int x;
    public Level(){
        x=1;
    }
    public void set(int a){
        x=a;
    }
    public int get(){
        return x;
    }
}

class SaveableGame implements java.io.Serializable{
    private int obstacleDuration;
    private int score;
    public SaveableGame(int od, int s){
        obstacleDuration=od;
        score=s;
    }
    public int getScore() {
        return score;
    }
    public int getObstacleDuration() {
        return obstacleDuration;
    }
}

class Game{
    private int obstacleDuration;
    private transient Ball ball;
    private transient ArrayList<Obstacle> obstacles;
    private transient ArrayList<Star> stars;
    private transient ArrayList<Switch> switches;
    private transient Group all;
    private transient AnimationTimer camMove,manageCam;
    private double middle;
    private int upTime,score;
    private App app;
    private boolean over;
    public Game(App app) throws FileNotFoundException{
        this.app=app;
        over=false;
        obstacleDuration=8000;
        Obstacle.setDuration(obstacleDuration);
        middle=250;
        score=0;
        ball=new Ball();
        all=new Group();
        all.getChildren().add(ball.getBall());
        obstacles=new ArrayList<>();
        upTime=-1;
        for(int i=0;i<4;i++) {
            Obstacle A=generateObstacle((300 - (300 * i)));
            all.getChildren().add(A.getObstacle());
            obstacles.add(A);
        }
        stars=new ArrayList<>();
        for(int i=0;i<4;i++) {
            Star A=new Star(285 - (300 * i));
            all.getChildren().add(A.getImg().getIview());
            stars.add(A);
        }
        switches=new ArrayList<>();
        for(int i=0;i<4;i++) {
            Switch A=new Switch(185 - (300 * i));
            all.getChildren().add(A.getImg().getIview());
            switches.add(A);
        }
        camMove=new AnimationTimer() {
            @Override
            public void handle(long l) {
                all.setTranslateY((all.getTranslateY()+1.5));
                middle-=1.5;
            }
        };
        manageCam=new AnimationTimer(){
            @Override
            public void handle(long l) {
                if(ball.getBall().getTranslateY()+200>=middle){
                    gameOver();
                    stop();
                }
                for(int i=0;i<4;i++){
                    if(obstacles.get(i).checkCollision()) {
                        obstacles.get(i).setCollision(false);
                        gameOver();
                        stop();
                    }
                }
                if(ball.getBall().getTranslateY()+450<=stars.get(0).getY()){
                    score++;
                    obstacleDuration-=20;
                    Obstacle.setDuration(obstacleDuration);
                    all.getChildren().remove(stars.get(0).getImg().getIview());
                    int a=stars.get(3).getY()-300;
                    Star A=stars.get(0);
                    stars.remove(0);
                    A.setY(a);
                    stars.add(A);
                    all.getChildren().add(A.getImg().getIview());
                }
                if(ball.getBall().getTranslateY()+450<=switches.get(0).getY()){
                    ball.getBall().setFill(switches.get(0).getColor());
                    all.getChildren().remove(switches.get(0).getImg().getIview());
                    int a=switches.get(3).getY()-300;
                    Switch A=switches.get(0);
                    switches.remove(0);
                    A.setY(a);
                    switches.add(A);
                    all.getChildren().add(A.getImg().getIview());
                }
                if(upTime==-1) {
                    if (((int)(ball.getBall().getTranslateY()) + 450) <= middle) {
                        ball.getBall().setTranslateY(middle-450);
                        upTime = ball.getUpDist();
                        camMove.start();
                    }
                }
                else{
                    if(upTime==15){
                        camMove.stop();
                        upTime=-1;
                    }
                    else
                        upTime++;
                }
                if((obstacles.get(0).getY()+(int)(all.getTranslateY()))>=550){
                    all.getChildren().remove(obstacles.get(0).getObstacle());
                    int a=obstacles.get(3).getY()-300;
                    obstacles.remove(0);
                    Obstacle A=generateObstacle(a);
                    obstacles.add(A);
                    all.getChildren().add(A.getObstacle());
                }
            }
        };
        manageCam.start();
    }
    public void pause(){
        ball.pause();
        camMove.stop();
        manageCam.stop();
    }
    public void resume(){
        ball.resume();
        manageCam.start();
    }
    public void startAgain(){
        over=false;
        middle=250;
        upTime=-1;
        ball.startAgain();
        ball.getBall().setTranslateY(0);
        ball.resume();
        for(int i=0;i<4;i++)
            all.getChildren().remove(obstacles.get(i).getObstacle());
        obstacles=new ArrayList<>();
        for(int i=0;i<4;i++) {
            Obstacle A=generateObstacle((300 - (300 * i)));
            all.getChildren().add(A.getObstacle());
            obstacles.add(A);
        }
        for(int i=0;i<4;i++)
            stars.get(i).setY(285 - (300 * i));
        for(int i=0;i<4;i++)
            switches.get(i).setY(185 - (300 * i));
        all.setTranslateY(0);
        manageCam.start();
    }
    public boolean isOver() {
        return over;
    }
    public void setOver(boolean over) {
        this.over = over;
    }
    public void gameOver(){
        ball.pause();
        camMove.stop();
        manageCam.stop();
        over=true;
        if(score>app.getHighScore())
            app.setHighScore(score);
        ball.startAgain();
    }
    public int resurrect(){
        if(app.getTotalStars()<3) {
            exit();
            return 0;
        }
        app.setTotalStars(app.getTotalStars()-3);
        startAgain();
        manageCam.start();
        return 1;
    }
    public void exit(){
        app.setTotalStars(app.getTotalStars()+score);
    }
    public int getObstacleDuration() {
        return obstacleDuration;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public void setObstacleDuration(int obstacleDuration) {
        this.obstacleDuration = obstacleDuration;
        Obstacle.setDuration(obstacleDuration);
    }
    public int getScore() {
        return score;
    }
    public Group getAll(){
        return all;
    }
    public void buttonPressed(){
        ball.buttonPressed();
    }
    public Obstacle generateObstacle(int y){
        Random r=new Random();
        int a=r.nextInt(4);
        if(a==0)
            return new Cross(y,ball);
        else if(a==1)
            return new lineObstacle(y,ball);
        else if(a==2)
            return new Square(y,ball);
        else
            return new Plus(y,ball);
    }
}

class Ball{
    private Circle ball;
    private int upDist,updown;
    private AnimationTimer timer;
    public Ball(){
        upDist=0;
        updown=0;
        ball=new Circle();
        ball.setCenterX(300);
        ball.setCenterY(450);
        ball.setRadius(6.5);
        ball.setFill(Color.DEEPPINK);
        timer=new AnimationTimer() {
            @Override
            public void handle(long l) {
                ball.setTranslateY((ball.getTranslateY()+((double)(updown)*1.5)));
                if(updown!=-1)
                    return;
                if(upDist==15){
                    upDist=0;
                    updown=1;
                }
                else
                    upDist++;
            }
        };
        timer.start();
    }
    public int getUpDist() {
        return upDist;
    }
    public void startAgain(){
        ball.setCenterY(450);
        upDist=0;
        updown=0;
    }
    public void resume(){
        timer.start();
    }
    public void pause(){
        timer.stop();
    }
    public void buttonPressed(){
        updown=-1;
    }
    public Circle getBall(){
        return ball;
    }
}

class Obstacle{
    private static int duration;
    private Group G;
    private int Y;
    private boolean collision;
    public Obstacle(){
        collision=false;
        duration=8000;
        G=new Group();
    }
    public void setY(int y) {
        Y = y;
    }
    public int getY() {
        return Y;
    }
    public void setCollision(boolean c){
        collision=c;
    }
    public boolean checkCollision() {
        return collision;
    }
    public Group getObstacle(){
        return G;
    }
    public static void setDuration(int d){
        duration=d;
    }
    public static int getDuration() {
        return duration;
    }
}

class Square extends Obstacle{
    private  Line line1,line2,line3,line4;
    private  RotateTransition rotate;
    private  AnimationTimer timer;
    private Ball ball;
    public Square(int y,Ball b){
        super();
        setY(y);
        ball=b;
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
        rotate.setDuration(Duration.millis(getDuration()));
        rotate.setNode(getObstacle());
        rotate.play();
        rotate.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                rotate.play();
            }
        });
        timer=new AnimationTimer() {
            @Override
            public void handle(long l) {
                rotate.setDuration(Duration.millis(getDuration()));
                if(line1.getStroke()!=ball.getBall().getFill() && !Shape.intersect(line1,ball.getBall()).getBoundsInLocal().isEmpty())
                    setCollision(true);
                if(line2.getStroke()!=ball.getBall().getFill() && !Shape.intersect(line2,ball.getBall()).getBoundsInLocal().isEmpty())
                    setCollision(true);
                if(line3.getStroke()!=ball.getBall().getFill() && !Shape.intersect(line3,ball.getBall()).getBoundsInLocal().isEmpty())
                    setCollision(true);
                if(line4.getStroke()!=ball.getBall().getFill() && !Shape.intersect(line4,ball.getBall()).getBoundsInLocal().isEmpty())
                    setCollision(true);
            }
        };
        timer.start();
    }
}

class Plus extends Obstacle{
    private  Line line1,line2,line3,line4;
    private  RotateTransition rotate;
    private  AnimationTimer timer;
    private Ball ball;
    public Plus(int y,Ball b){
        super();
        setY(y);
        ball=b;
        line1=new Line(350,y,400,y);
        line1.setStrokeWidth(10);
        line2=new Line(350,y,350,y+50);
        line2.setStrokeWidth(10);
        line3=new Line(350,y,300,y);
        line3.setStrokeWidth(10);
        line4=new Line(350,y,350,y-50);
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
        rotate.setDuration(Duration.millis(getDuration()));
        rotate.setNode(getObstacle());
        rotate.play();
        rotate.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                rotate.play();
            }
        });
        timer=new AnimationTimer() {
            @Override
            public void handle(long l) {
                rotate.setDuration(Duration.millis(getDuration()));
                if(line1.getStroke()!=ball.getBall().getFill() && !Shape.intersect(line1,ball.getBall()).getBoundsInLocal().isEmpty())
                    setCollision(true);
                if(line2.getStroke()!=ball.getBall().getFill() && !Shape.intersect(line2,ball.getBall()).getBoundsInLocal().isEmpty())
                    setCollision(true);
                if(line3.getStroke()!=ball.getBall().getFill() && !Shape.intersect(line3,ball.getBall()).getBoundsInLocal().isEmpty())
                    setCollision(true);
                if(line4.getStroke()!=ball.getBall().getFill() && !Shape.intersect(line4,ball.getBall()).getBoundsInLocal().isEmpty())
                    setCollision(true);
            }
        };
        timer.start();
    }
}

class lineObstacle extends Obstacle{
    private  Line line1,line2,line3,line4;
    private  TranslateTransition Oline;
    private  AnimationTimer timer;
    private  Ball ball;
    public lineObstacle(int y, Ball b){
        super();
        setY(y);
        ball=b;
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
        Oline.setDuration(Duration.millis(getDuration()));
        Oline.setCycleCount(Animation.INDEFINITE);
        Oline.setAutoReverse(true);
        Oline.setNode(getObstacle());
        Oline.play();
        Oline.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Oline.play();
            }
        });
        timer=new AnimationTimer() {
            @Override
            public void handle(long l) {
                Oline.setDuration(Duration.millis(getDuration()));
                if(line1.getStroke()!=ball.getBall().getFill() && !Shape.intersect(line1,ball.getBall()).getBoundsInLocal().isEmpty())
                    setCollision(true);
                if(line2.getStroke()!=ball.getBall().getFill() && !Shape.intersect(line2,ball.getBall()).getBoundsInLocal().isEmpty())
                    setCollision(true);
                if(line3.getStroke()!=ball.getBall().getFill() && !Shape.intersect(line3,ball.getBall()).getBoundsInLocal().isEmpty())
                    setCollision(true);
                if(line4.getStroke()!=ball.getBall().getFill() && !Shape.intersect(line4,ball.getBall()).getBoundsInLocal().isEmpty())
                    setCollision(true);
            }
        };
        timer.start();
    }
}

class Cross extends Obstacle{
    private Line line1,line2,line3,line4,line5,line6;
    private TranslateTransition Oline1,Oline2;
    private Group G1,G2;
    private AnimationTimer timer;
    private Ball ball;
    private int leftright,updown;
    public Cross(int y, Ball b){
        super();
        setY(y);
        ball=b;
        leftright=1;
        updown=-1;
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
        timer=new AnimationTimer() {
            @Override
            public void handle(long l) {
                Oline1.setDuration(Duration.millis(getDuration()));
                Oline2.setDuration(Duration.millis(getDuration()));
                if(line1.getStroke()!=ball.getBall().getFill() && !Shape.intersect(line1,ball.getBall()).getBoundsInLocal().isEmpty())
                    setCollision(true);
                if(line2.getStroke()!=ball.getBall().getFill() && !Shape.intersect(line2,ball.getBall()).getBoundsInLocal().isEmpty())
                    setCollision(true);
                if(line3.getStroke()!=ball.getBall().getFill() && !Shape.intersect(line3,ball.getBall()).getBoundsInLocal().isEmpty())
                    setCollision(true);
                if(line4.getStroke()!=ball.getBall().getFill() && !Shape.intersect(line4,ball.getBall()).getBoundsInLocal().isEmpty())
                    setCollision(true);
                if(line5.getStroke()!=ball.getBall().getFill() && !Shape.intersect(line5,ball.getBall()).getBoundsInLocal().isEmpty())
                    setCollision(true);
                if(line6.getStroke()!=ball.getBall().getFill() && !Shape.intersect(line6,ball.getBall()).getBoundsInLocal().isEmpty())
                    setCollision(true);
            }
        };
        timer.start();
        Oline1.setByX(300);
        Oline1.setByY(-50);
        Oline1.setDuration(Duration.millis(getDuration()));
        Oline1.setCycleCount(Animation.INDEFINITE);
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
        Oline2.setDuration(Duration.millis(getDuration()));
        Oline2.setCycleCount(Animation.INDEFINITE);
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
    private Img img;
    private int y;
    public Collectables(int a){
        y=a;
    }
    public void setY(int y) {
        this.y = y;
        img.getIview().setY(y);
    }
    public int getY(){
        return y;
    }
    public void setImg(Img img) {
        this.img = img;
    }
    public Img getImg(){
        return img;
    }
}

class Star extends Collectables{
    public Star(int a) throws FileNotFoundException{
        super(a);
        setImg(new Img("star.png",50,5,60,50));
        getImg().getIview().setFitWidth(30);
        getImg().getIview().setFitHeight(30);
        getImg().getIview().setX(285);
        getImg().getIview().setY(getY());
    }
}

class Switch extends Collectables{
    public Switch(int a) throws FileNotFoundException{
        super(a);
        setImg(new Img("switch.png",5,5,30,30));
        getImg().getIview().setFitWidth(30);
        getImg().getIview().setFitHeight(30);
        getImg().getIview().setX(285);
        getImg().getIview().setY(getY());
    }
    public Color getColor(){
        Random r=new Random();
        int x=r.nextInt(3);
        if(x==0)
            return Color.DEEPPINK;
        if(x==1)
            return Color.AQUA;
        return Color.YELLOW;
    }
}