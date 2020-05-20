# 計算機概論 期末專題 BBTANGENT
## Content
參考 111% 公司出品的「BBTAN」，重製一個不包含功能球的致敬作品。前期只有打算製作方格下降的類型。

## Author
name: 楊佳峻<br/>
student ID: 108502571<br/>
class: B

## Framework
| Package | Class |
| ------- | ------------------------------- |
| Game | Game<br/>Ball<br/>Block<br/>Global |
---
| Class | SubClass |
| ----- | ---------------------- |
| Block | Rectangle<br/>Triangle |
---
(undone modifying)
| Class | Member |
| ----- | ------ |
| game | -public void start<br/>-public void initialize<br/><br/>-public void shoot<br/>-public static void main |
| ball | +private int num<br/>+private double dir_x<br/>+private double dir_y<br/>+private double posi_x<br/>+private double posi_y<br/><br/>-public ball<br/>-public int getNum<br/>-public double getDir_x<br/>-public double getDir_y |
| block | + protected int num<br/>+private int level<br/><br/>-public block<br/><br/>-public void addLevel<br/>-public int getLevel |
| -rectangle |  |

## Documentary
### v1.0.0  initialization
2020/05/16 1. initialization of MAIN: game OTHERS: ball, block
           2. create README.md and the assets folder

2020/05/18 1. rectangle inherit abstract block
           2. create some member and member functions

2020/05/19 1. global variable manager class: "global"
---
### v1.0.1 rename class name
2020/05/20 1. class' first letter turn into capital
           2. create some "Block" members
           3. "Triangle" inherit abstract "Block"
           4. totally 13 TODOs
---
### v1.1.0 finish declarations of members and member functions
---
### v1.2.0 finish assets
---
### v1.3.0 finish debugging
---
### v1.4.0 finish optimization
