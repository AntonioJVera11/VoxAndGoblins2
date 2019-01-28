/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.veramunozantonio.voxandgoblinsfx;

//Aquí guardamos todos los import necesarios
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

//Copyright
/**
 *
 * @author AntonioJuan
 * 1º DAW
 */

//Declaración de todas las variables
public class VoxAndGoblinsFX extends Application {
    Pane root;
    int velocidadTorero = 0;
    int posicion1 = 0;
    int posicion2 = 1280;
    int velocidad = 0;
    int velocidadCristo = -10;
    int toreroY = 383;
    int toreroX = 45;
    int agachadoX = 30;
    int agachadoY = 350;
    int scoreX = -460;
    int scoreY = -100;
    int cristoX = -480;
    int cristoY = 160;
    int downSpeed = 5;
    int upSpeed = -20;
    Group cristo;
    Image fondo1;
    Image fondo2;
    Image imageScore;
    Image image;
    Image torero;
    Image toreroAgachado;
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageViewScore;
    ImageView torerogif;
    ImageView toreroAgachado1;
    Scene scene;
    
    //Método de la puntuación
    public void score () {
        imageScore = new Image(getClass().getResourceAsStream("images/Score.png"));
        imageViewScore = new ImageView();
        imageViewScore.setImage(imageScore);
        imageViewScore.setScaleX(0.2);
        imageViewScore.setScaleY(0.2); 
        imageViewScore.setX(scoreX);
        imageViewScore.setY(scoreY);       
        root.getChildren().add(imageViewScore);
    }
    
    //Método del reinicio
    public void reinicio () {    
        
    }  
    
    //Método del fondo
    public void fondo () {
        fondo1 = new Image(getClass().getResourceAsStream("images/Fondo.jpg"));
        fondo2 = new Image(getClass().getResourceAsStream("images/Fondo.jpg"));
        imageView1 = new ImageView();
        imageView2 = new ImageView();
        imageView1.setImage(fondo1);
        imageView2.setImage(fondo2);
        imageView1.setFitHeight(720);
        imageView1.setFitWidth(1280);
        imageView2.setFitHeight(720);
        imageView2.setFitWidth(1280);
        root.getChildren().add(imageView1);
        root.getChildren().add(imageView2);
    }  
    
    //Método del gif del torero
    public void torero () {
        torero = new Image(getClass().getResourceAsStream("images/Ole.gif"));
        torerogif = new ImageView();
        torerogif.setImage(torero);
        torerogif.setX(toreroX);
        torerogif.setY(toreroY);
        torerogif.setScaleX(1);
        torerogif.setScaleY(1);
        root.getChildren().add(torerogif);
    }
    
    //Método del toreroAbajo
    public void toreroAbajo () {
        toreroAgachado = new Image(getClass().getResourceAsStream("images/Agachado.png"));
        toreroAgachado1 = new ImageView();
        toreroAgachado1.setImage(toreroAgachado);
        toreroAgachado1.setX(agachadoX);
        toreroAgachado1.setY(agachadoY);
        toreroAgachado1.setScaleX(0.5);
        toreroAgachado1.setScaleY(0.5);
        root.getChildren().add(toreroAgachado1);
    }
    
    //Método del grupo cristo
    public void cristo () {
        cristo = new Group();
        Rectangle cristo1 = new Rectangle(640, 360, 6, 30);
        cristo1.setFill(Color.BROWN);
        cristo.getChildren().add(cristo1);
        Rectangle cristo2 = new Rectangle(640, 360, 20, 6);
        cristo2.setFill(Color.BROWN);
        cristo.getChildren().add(cristo2);
        Rectangle cristo3 = new Rectangle(640, 350, 6, 30);
        cristo3.setFill(Color.BROWN);
        cristo.getChildren().add(cristo3);
        Rectangle cristo4 = new Rectangle(627, 360, 20, 6);
        cristo4.setFill(Color.BROWN);
        cristo.getChildren().add(cristo4);
        cristo.setLayoutX(cristoX);
        cristo.setLayoutY(cristoY);
        cristo.setScaleX(0.8);
        cristo.setScaleY(0.8);
        root.getChildren().add(cristo);        
    }
    
    @Override
    public void start(Stage primaryStage) {
        root = new Pane();
        primaryStage.setTitle("Vox and Goblins");
        scene = new Scene(root, 1280, 720);
        primaryStage.setScene(scene);
        primaryStage.show();
        this.fondo();
        this.torero();       
        this.score();
        scene.setOnKeyPressed((KeyEvent event) -> {
            switch(event.getCode()) {
                case W:
                   if (velocidadTorero == 0) {
                   velocidadTorero = upSpeed;
                   }
                    break;
                case S:
                   torerogif.setVisible(false);
                    break;
                case ENTER:
                    this.toreroAbajo();
                    velocidad = -4;
                    break;
                case D:
                    cristo = new Group();
                    Rectangle cristo1 = new Rectangle(640, 360, 6, 30);
                    cristo1.setFill(Color.BROWN);
                    cristo.getChildren().add(cristo1);
                    Rectangle cristo2 = new Rectangle(640, 360, 20, 6);
                    cristo2.setFill(Color.BROWN);
                    cristo.getChildren().add(cristo2);
                    Rectangle cristo3 = new Rectangle(640, 350, 6, 30);
                    cristo3.setFill(Color.BROWN);
                    cristo.getChildren().add(cristo3);
                    Rectangle cristo4 = new Rectangle(627, 360, 20, 6);
                    cristo4.setFill(Color.BROWN);
                    cristo.getChildren().add(cristo4);
                    cristo.setLayoutX(cristoX);
                    cristo.setLayoutY(cristoY);
                    cristo.setScaleX(0.8);
                    cristo.setScaleY(0.8);
                    root.getChildren().add(cristo);
                    break;
            }         
        });
        scene.setOnKeyReleased((KeyEvent event) -> {
            torerogif.setVisible(true);
            toreroAgachado1.setVisible(false);
            velocidadTorero = downSpeed;
        });   
        AnimationTimer movimiento = new AnimationTimer () {
            @Override
            public void handle (long now) {                
                imageView1.setX(posicion1);
                imageView2.setX(posicion2);
                posicion1+=velocidad;
                posicion2+=velocidad;
                if (posicion1==0) {
                    posicion2=1280;
                }
                if (posicion2==0) {
                    posicion1=1280;
                }                          
            toreroY+=velocidadTorero;
            torerogif.setY(toreroY);
            
            if (toreroY >= 383) {
                velocidadTorero = 0;
            }
            if (toreroY <= 203) {
                velocidadTorero = downSpeed;
            }
        };                   
        };
        movimiento.start(); 
    }
};