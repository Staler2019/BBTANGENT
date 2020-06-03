# 計算機概論 期末專題 BBTANGENT

## Content

參考 111% 公司出品的「BBTAN」，重製一個不包含功能球的致敬作品。前期只有打算製作方格下降的類型。

## Author

name: 楊佳峻
class: B

## Framework

| Package | Class |
| ------- | ------------------------------- |
| Game | GameController<br/>DifficultyController(fin)<br/>BBTANGENTController(fin)<br/>Ball(in consideration)<br/>Block<br/>Global |
---
| Class | SubClass |
| ----- | ---------------------- |
| Block | Rectangle<br/>Triangle |
---
(undone modifying)
| Class | Member |
| ----- | ------ |
| BBTANGENTController | -public static Stage currStage<br/>-public static Scene startScene<br/>-@FXML private AnchorPane _start_pane<br/>-@FXML private Label _tap_word<br/>-@FXML private Button _info_btn<br/>-@FXML private GridPane _score_pane<br/>-@FXML private Label _title<br/>-@FXML private Label _scoreboard<br/><br/>+public static void main(String[] args)<br/><br/>+@Override public void initialize(URL arg0, ResourceBundle arg1)<br/>+@Override public void start(Stage primaryStage)<br/>+@FXML public void onStartPressed()<br/>+@FXML public void checkEnterPressed(KeyEvent k)<br/>@FXML public void onInfoPressed()<br/>@FXML public void onHyperPressed()[UNIMPLEMENTED]<br/> - problem: controllerClass, press link to outside browser |
| DifficultyController | -@FXML private Button diff_1<br/>-@FXML private Button diff_2<br/>-@FXML private Button diff_3<br/><br/>+@Override public void initialize(URL arg0, ResourceBundle arg1)<br/>+public void turnToGame()<br/>+@FXML public void diff_1Pressed()<br/>+@FXML public void diff_2Pressed()[UNIMPLEMENTED]<br/>+@FXML public void diff_3Pressed()[UNIMPLEMENTED] |
| GameController |  |
| Ball | -private double dir_x<br/>-private double dir_y<br/>-public ImageView imageView<br/><br/>-public Ball(ImageView image)<br/><br/>-public void setDirection(double x, double y)<br/>-public double getDirX()<br/>-public double getDirY()<br/>-public double revertX()<br/>-public double revertY() |
| Block |  |
| +Rectangle |  |
| +Triangle |  |

## Documentary

### v1.0.0  initialization

2020/05/16

1. initialization of MAIN: game OTHERS: ball, block
2. create README.md and the assets folder

2020/05/18

1. rectangle inherit abstract block
2. create some member and member functions

2020/05/19

1. global variable manager class: "global"

### v1.0.1 rename class name

2020/05/20

1. class' first letter turn into capital
2. create some "Block" members
3. "Triangle" inherit abstract "Block"
4. totally 13 TODOs

### v1.0.2 make up sceneControllers

2020/05/26

1. problem with balls' 分身問題
2. establish playerData to store highestScorePlayer and its score
3. launcher change to BBTANGENT.java

### v1.0.3 finish class Ball's things

2020/06/01

1. finish class Ball's
2. make up Timeline in GameController to manage Balls' movement(with no consideration with blocks)
3. edit FXMLs
4. rename controllers
5. add status of classes now to see if edits needed

### v1.0.4 finish class BBTANGENTController, DifficultyController

1. finish class BBTANGENTController and test ok
2. attempt to make balls and block drawing instead of using ImageView
3. finish class DifficultyController and test ok
4. difficulty system isn't implemented

### v1.1.0 finish declarations of members and member functions

### v1.2.0 finish assets

### v1.3.0 finish debugging

### v1.4.0 finish optimization
