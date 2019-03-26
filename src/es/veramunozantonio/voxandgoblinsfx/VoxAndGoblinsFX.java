/*
Este gran videojuego pertenece a Antonio Juan Vera Muñoz
No comparto la ideología mostrada en el videojuego, se trata de una parodia
que hay que abordar desde el punto de vista del humor.
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
import javafx.scene.shape.Shape;
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
    int feminaziX = echeniqueX + 500;
    int cristoX = -480;
    int cristoY = 20;
    int aleatorio;
    int scoreSize;
    int rotacionCristo = 10;
    int marcador = -1;
    Group cristo;
    Group echeniqueGroup;
    Group feminaziGroup;
    Group toreroGroup;
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
        // Creamos el grupo para Echenique y su hitbox
        echeniqueGroup = new Group();
        // Cremos el rectángulo que atuará como hitbox y le damos posición tamaño y color
        Rectangle echeniqueHB = new Rectangle(echeniqueX + 60, echeniqueY, 30, 100);
        echeniqueHB.setFill(Color.TRANSPARENT);
        // Lo añadimos al grupo 
        echeniqueGroup.getChildren().add(echeniqueHB);
        // Añadimos la imagen de Echenique
        imgEchenique = new Image(getClass().getResourceAsStream("images/Echenique.gif"));
        // La convertimos a ImageView
        echeniquegif = new ImageView();
        echeniquegif.setImage(imgEchenique);
        // Le damos unas coordenadas
        echeniquegif.setX(echeniqueX);
        echeniquegif.setY(echeniqueY);
        // La añadimos al grupo
        echeniqueGroup.getChildren().add(echeniquegif);
        // Añadimos el grupo compleo al panel 
        root.getChildren().add(echeniqueGroup);
    }
    
    //Obstaculo2
    public void obst2 () {
        // Creamos el grupo para el obstáculo del símbolo Feminazi
        feminaziGroup = new Group();
        // Creamos el rectángulo que actuará como hitbox y le damos posición, tamaño y color
        Rectangle feminaziHB = new Rectangle (feminaziX + 100, feminaziY + 125, 100, 50);
        feminaziHB.setFill(Color.TRANSPARENT);
        // Lo añadimos al gurpo
        feminaziGroup.getChildren().add(feminaziHB);
        // Añadimos la imagen Feminazi
        imgFeminazi = new Image(getClass().getResourceAsStream("images/Feminazi.png"));
        // La convertimos a ImageView
        feminazi = new ImageView();
        feminazi.setImage(imgFeminazi);
        // Le damos una escala, rotación y posición
        feminazi.setScaleX(0.3);
        feminazi.setScaleY(0.3);
        feminazi.setRotate(270);
        feminazi.setX(feminaziX);
        feminazi.setY(feminaziY);
        // La añadimos al grupo
        feminaziGroup.getChildren().add(feminazi);
        // Y añadimos el grupo al panel
        root.getChildren().add(feminaziGroup);
    }
    
    //Switch case de los obstáculos
    public void obstRandom () {
      // Utilizamos la función random para que el juego decida que obstáculo aparece 
      Random random = new Random();
      // Hacemos que coja un valo entero aleatorio entre 0 y 1 
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
          // Trabajamos con el grupo echenique y modificamos su posición con AnimationTimer para simular movimiento
          echeniqueGroup.setLayoutX(echeniqueX);
          echeniquegif.setY(echeniqueY);
          echeniqueX += velocidad;
          // Trabajamos con el grupo feminazi y modificamos su posición con AnimationTimer para simular movimiento
          feminaziGroup.setLayoutX(feminaziX);
          feminazi.setY(feminaziY);
          feminaziX += velocidad;
          // Definimos los límites en la pantalla que alcanzarán los obstáculos para luego volver al punto de partida
          if (echeniqueX <= -1700) {
              echeniqueX = 1500;
          }
          if (feminaziX <= -2000) {
            feminaziX = 1500;
          }
      }
      };
      obstaculos.start();
    }
       
    //Método de la imagen SCORE
    public void scoreImg () {
        // Creamos la imagen score y la convertimos a ImageView para trabajar con ella
        Image imageScore;
        imageScore = new Image(getClass().getResourceAsStream("images/Score.png"));
        ImageView imageViewScore;
        imageViewScore = new ImageView();
        // Declaramos las variables que nos harán falta para la posición
        int scoreX = -460;
        int scoreY = -100;
        // Definimos la imagen y le damos escala y posición
        imageViewScore.setImage(imageScore);
        imageViewScore.setScaleX(0.2);
        imageViewScore.setScaleY(0.2); 
        imageViewScore.setX(scoreX);
        imageViewScore.setY(scoreY);     
        //La añadimos al panel
        root.getChildren().add(imageViewScore);
    }
             
    //Método del reinicio
    public void reinicio () {  
        // En este método basicamente hacemos que todas las variables se queden como en el punto de partida para simular un comienzo
        toreroY = 380;
        toreroX = 45;
        imageView1.setX(posicion1);
        imageView2.setX(posicion2);
        echeniquegif.setX(echeniqueX);
        echeniquegif.setY(echeniqueY);
        feminazi.setX(feminaziX);
        feminazi.setY(feminaziY);
    } 
    
    //Método del fondo
    public void fondo () {
        // Añadimos la dos imagenes de fondo (que son iguales) y las convertimos a ImageView para trabajar con ellas
        Image fondo1;
        Image fondo2;
        fondo1 = new Image(getClass().getResourceAsStream("images/Fondo.jpg"));
        fondo2 = new Image(getClass().getResourceAsStream("images/Fondo.jpg"));
        imageView1 = new ImageView();
        imageView2 = new ImageView();
        imageView1.setImage(fondo1);
        imageView2.setImage(fondo2);
        // Les damos un tamaño 
        imageView1.setFitHeight(720);
        imageView1.setFitWidth(1280);
        imageView2.setFitHeight(720);
        imageView2.setFitWidth(1280);
        // Agregamos ambas imágenes al panel
        root.getChildren().add(imageView1);
        root.getChildren().add(imageView2);
    }  
   
    //Método de la intro
    public void intro () {
        // Añadimos la imagen correspondiente a la intro 
        intro = new Image(getClass().getResourceAsStream("images/Intro.jpg"));
        intro1 = new ImageView();
        intro1.setImage(intro);
        // Le damos su tamaño para ajustarlo al tamaño de la pantalla
        intro1.setFitHeight(720);
        intro1.setFitWidth(1280);
        // La añadimos al panel 
        root.getChildren().add(intro1);
    }   
    
    //Método del gif del torero
    public void torero () {
        // Creamos el grupo del torero y su correspondiente hitbox
        toreroGroup = new Group();
        // Creamos el rectángulo que actuará como hitbox con sus coordenadas, dimensiones y color
        Rectangle toreroHB = new Rectangle (45 + 50, 380 + 15, 150, 225);
        toreroHB.setFill(Color.BLACK);
        // Lo añadimos al grupo
        toreroGroup.getChildren().add(toreroHB);
        // Añadimos la imgaen y la convertimos a ImageView para trabajar con ella
        torero = new Image(getClass().getResourceAsStream("images/Ole.gif"));
        torerogif = new ImageView();
        torerogif.setImage(torero);
        // Le damos unas coordenadas que determinarán su posición
        torerogif.setX(toreroX);
        torerogif.setY(toreroY);
        // La añadimos al grupo
        toreroGroup.getChildren().add(torerogif);
        // Añadimos el grupo al panel 
        root.getChildren().add(toreroGroup);
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
        // Creamos los 4 rectángulos que formarán el grupo y los añadimos al mismo
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
        // Le damos unas coordenadas que determinarán su posición inicial
        cristo.setLayoutX(cristoX);
        cristo.setLayoutY(cristoY);
        // Lo añadimos al panel
        root.getChildren().add(cristo);
        //Con esta función haremos que el cristo se mueva por la pantalla
        AnimationTimer cruz = new AnimationTimer () {
            @Override
            public void handle(long now) {
                // Con esto conseguiremos que el cristo se mueva
                cristoX += cristoSpeed;
                // Con esto conseguiremos que el cristo vaya rotando 
                rotacionCristo += 2;
                cristo.setRotate(rotacionCristo);
                cristo.setLayoutX(cristoX);
                if (cristoX >= 1300) {
                    cristoSpeed = 0;
                    cristoX = -1000;
                    cristo.setVisible(false);
                }               
            }
            };
            cruz.start();
    }
    
    @Override
    public void start(Stage primaryStage) {
        // Añadimos el panel y la escena
        root = new Pane();
        primaryStage.setTitle("Vox and Goblins");
        scene = new Scene(root, 1280, 720);
        primaryStage.setScene(scene);
        primaryStage.show();
        // Invocamos todos los métodos necesarios teniendo en cuenta el orden en el que los colocamos
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
        
        // Creamos el score dentro del start
        Text marcadorText = new Text ("0");
                // Le damos tamaño de fuente y coordenadas
                marcadorText.setFont(Font.font(65));
                marcadorText.setX(275);
                marcadorText.setY(65);
                    marcadorText.setFill(Color.RED);
        // Creamos el grupo marcador y lo ponemos en innvisible en un principio            
        Group groupMarcador = new Group ();
                groupMarcador.getChildren().addAll(marcadorText);
                groupMarcador.setVisible(false);
        // Declaración del comportamiento de las teclas
        scene.setOnKeyPressed((KeyEvent event) -> {
            switch(event.getCode()) {
                // Hacemos que al pulsar la W y si la velocidad del Torero es igual a 0, el torero salte (aún no con su hitbox no se por qué)
                case W:
                   if (velocidadTorero == 0) {
                   velocidadTorero = toreroY;
                   velocidadTorero = upSpeed;
                   toreroGroup.setLayoutY(velocidadTorero);
                   }
                    break;
//                case S:
//                   torerogif.setVisible(false);
//                   toreroAgachado1.setVisible(true);
//                    break;
                // Hacemos que al pulsar Enter, la intro deje de mostrarse, la velocidad sea -4 y el marcador se ponga a 0
                case ENTER:
                    intro1.setVisible(false);
                    velocidad = -4;
                    marcador = 0;
                    groupMarcador.setVisible(true);
                    break;
                // Hacemos que al pulsar la D, la velocidad del Cristo se ponga a 6 y lo pongamos en visible    
                case D:
                    cristo();
                    cristoSpeed = 6;
                    cristo.setVisible(true);
                    break;
                // Hacemos que al presionar el espacio se     
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
                marcador ++;
                marcadorText.setText(String.valueOf(marcador));
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
            root.getChildren().add(groupMarcador);
        
//        AnimationTimer colisiones = new AnimationTimer () {
//            @Override
//            public void handle (long now) { 
//              //--------------------------Colision Torero echenique------------------------------------------------------
//              Shape shapeColision = Shape.intersect(torerogif , echenique);
//              boolean colisionShapeA = shapeColision.getBoundsInLocal().isEmpty();
//              if(colisionShapeA == false){
//        };
        
    }       
};