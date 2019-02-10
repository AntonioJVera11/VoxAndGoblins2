/*
Este gran videojuego pertenece a Antonio Juan Vera Muñoz
No comparto la ideología mostrada en el videojuego, se trata de una parodia
que hay que entender desde el punto de vista del humor.
Copyright 2019 Antonio Juan Vera Muñoz
 */
package es.veramunozantonio.voxandgoblinsfx;

//Aquí guardamos todos los import necesarios
import java.util.Random;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
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
    int toreroY = 380;
    int toreroX = 45;
    int downSpeed = 5;
    int upSpeed = -15;
    int cristoSpeed = 6;
    int echeniqueX = 1500;
    int echeniqueY = 475;
    int feminaziY = 250;
    int feminaziX = 2500;
    int cristoX = -480;
    int cristoY = 20;
    int aleatorio;
    int scoreSize;
    int rotacionCristo = 10;
    Group cristo;
    Group echeniqueGroup;
    Image image;
    Image torero;
    Image imgEchenique;
    Image imgFeminazi;
    Image toreroAgachado;
    Image intro;
    ImageView imageView1;
    ImageView imageView2;
    ImageView torerogif;
    ImageView obstaculo = new ImageView();
    ImageView toreroAgachado1;
    ImageView echeniquegif;
    ImageView feminazi;
    ImageView intro1;
    Scene scene;
    
    //Obstaculo1
    public void obst1 () {       
        echeniqueGroup = new Group();
        Rectangle echeniqueHB = new Rectangle(echeniqueX, echeniqueY, 120, 158);
        echeniqueHB.setFill(Color.BLACK);
        echeniqueGroup.getChildren().add(echeniqueHB);
        imgEchenique = new Image(getClass().getResourceAsStream("images/Echenique.gif"));
        echeniquegif = new ImageView();
        echeniquegif.setImage(imgEchenique);
        echeniquegif.setX(echeniqueX);
        echeniquegif.setY(echeniqueY);
        echeniqueGroup.getChildren().add(echeniquegif);
        root.getChildren().add(echeniqueGroup);
    }
    
    //Obstaculo2
    public void obst2 () {
        imgFeminazi = new Image(getClass().getResourceAsStream("images/Feminazi.png"));
        feminazi = new ImageView();
        feminazi.setImage(imgFeminazi);
        feminazi.setScaleX(0.3);
        feminazi.setScaleY(0.3);
        feminazi.setRotate(270);
        feminazi.setX(feminaziX);
        feminazi.setY(feminaziY);
        root.getChildren().add(feminazi);
    }
    
    //Switch case de los obstáculos
    public void obstRandom () {
      Random random = new Random();
      aleatorio = random.nextInt(2);
      switch (aleatorio) {
        case 0:
            obst1();
            break;
        case 1:
            obst2();
            break;
        }
    }
    
    //Método para los obstáculos
    public void obstaculos () {
      //Con esta función haremos que los obstaculos vayan apareciendo en pantalla  
      AnimationTimer obstaculos = new AnimationTimer () {
      @Override
      public void handle(long now) {
          echeniqueX += velocidad;
          feminaziX += velocidad;
          echeniqueGroup.setLayoutX(echeniqueX);
          System.out.println("La X de echenique:" + echeniqueX);
          feminazi.setX(feminaziX);
          echeniquegif.setY(echeniqueY);
          feminazi.setY(feminaziY);
          feminaziX += velocidad;
          if (echeniqueX <= 0) {
              echeniqueX = 1500;
          }
          if (feminaziX <= 0) {
            feminaziX = 2500;
          }
      }
      };
      obstaculos.start();
    }
       
    //Método de la imagen SCORE
    public void scoreImg () {
        Image imageScore;
        imageScore = new Image(getClass().getResourceAsStream("images/Score.png"));
        ImageView imageViewScore;
        imageViewScore = new ImageView();
        int scoreX = -460;
        int scoreY = -100;
        imageViewScore.setImage(imageScore);
        imageViewScore.setScaleX(0.2);
        imageViewScore.setScaleY(0.2); 
        imageViewScore.setX(scoreX);
        imageViewScore.setY(scoreY);       
        root.getChildren().add(imageViewScore);
    }
    
    //Método del reinicio
    public void reinicio () {    
        toreroY = 380;
        toreroX = 45;
        imageView1.setX(posicion1);
        imageView2.setX(posicion2);
        intro();   
    } 
    
    //Método del fondo
    public void fondo () {
        Image fondo1;
        Image fondo2;
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
   
    //Método de la intro
    public void intro () {
        intro = new Image(getClass().getResourceAsStream("images/Intro.jpg"));
        intro1 = new ImageView();
        intro1.setImage(intro);
        intro1.setFitHeight(720);
        intro1.setFitWidth(1280);
        root.getChildren().add(intro1);
    }   
    
    //Método del gif del torero
    public void torero () {
        torero = new Image(getClass().getResourceAsStream("images/Ole.gif"));
        torerogif = new ImageView();
        torerogif.setImage(torero);
        torerogif.setX(toreroX);
        torerogif.setY(toreroY);
        root.getChildren().add(torerogif);
    }
    
    //Método del toreroAbajo
    /*public void toreroAbajo () {
        toreroAgachado = new Image(getClass().getResourceAsStream("images/Agachado.png"));
        toreroAgachado1 = new ImageView();
        int agachadoX = -50;
        int agachadoY = 373;
        toreroAgachado1.setImage(toreroAgachado);
        toreroAgachado1.setX(agachadoX);
        toreroAgachado1.setY(agachadoY);
        toreroAgachado1.setScaleX(0.4);
        toreroAgachado1.setScaleY(0.4);
        root.getChildren().add(toreroAgachado1);
    }*/
    
    //Método del grupo cristo
    public void cristo () {
        //Primero creamos la imagen a partir de un grupo llamado cristo
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
        root.getChildren().add(cristo);
        //Con esta función haremos que el cristo se mueva por la pantalla
        AnimationTimer cruz = new AnimationTimer () {
            @Override
            public void handle(long now) {
                cristoX += cristoSpeed;
                rotacionCristo += 2;
                cristo.setRotate(rotacionCristo);
                cristo.setLayoutX(cristoX);
                if (cristoX >= 1300) {
//                    cristoSpeed = 6;
//                    cristoX = -480;
//                    System.out.println("cristoX:" + cristoX);
                    root.getChildren().remove(cristo);
                }               
            }
            };
            cruz.start();
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
//        this.toreroAbajo();
//        toreroAgachado1.setVisible(false);
        this.obstRandom();
        this.obstaculos();
        this.obst1();
        this.obst2();
        this.scoreImg();
        this.intro();
        
        //Declaración del comportamiento de las teclas
        scene.setOnKeyPressed((KeyEvent event) -> {
            switch(event.getCode()) {
                case W:
                   if (velocidadTorero == 0) {
                   velocidadTorero = upSpeed;
                   }
                    break;
//                case S:
//                   torerogif.setVisible(false);
//                   toreroAgachado1.setVisible(true);
//                    break;
                case ENTER:
                    intro1.setVisible(false);
                    velocidad = -4;
                    break;
                case D:
                    cristo();
                    cristoSpeed = 6;
                    cristo.setVisible(true);
                    break;
                case SPACE:
                   reinicio();
                    break;
            }         
        });
        scene.setOnKeyReleased((KeyEvent event) -> {
            torerogif.setVisible(true);
            echeniquegif.setVisible(true);
            feminazi.setVisible(true);
//            toreroAgachado1.setVisible(false);
            intro1.setVisible(false);
            velocidadTorero = downSpeed;  
            cristoSpeed = 6;
        });
        //Método del scroll del fondo
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
                //Límites para la posición del torero
                if (toreroY >= 380) {
                    velocidadTorero = 0;
                }
                if (toreroY <= 100) {
                    velocidadTorero = downSpeed;
                }
            };                   
        };
            movimiento.start(); 
    }       
};