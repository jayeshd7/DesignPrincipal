import java.util.ArrayList;
import java.util.List;

public class FacadeDesign {

    public static void main(String[] args) {
       /* Buffer buffer = new Buffer(30, 20);
        Viewport viewport = new Viewport(buffer, 30, 20, 0, 0);
        Console console = new Console(30, 20);
        console.addViewPort(viewport);
        console.render();*/

        Console console2 = Console.newConsole(3, 2);
        console2.render();

    }
}


class Buffer{


    private char [] characters;

    private int lineWidth;


    public Buffer(int lineHeight, int lineWidth) {
        characters = new char[lineHeight*lineWidth];
        this.lineWidth = lineWidth;
    }


    public char charAt(int x , int y){
    return characters[y*lineWidth+x];

    }

}

class Viewport{
    private final Buffer buffer;
    private int width;
    private int height;
    private int offsetX;
    private int offsetY;




    public Viewport(Buffer buffer, int width, int height, int offsetX, int offsetY) {


        this.buffer = buffer;
        this.width = width;
        this.height = height;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
    }

    public char charAt(int x , int y){
        return buffer.charAt(x+offsetX,y+offsetY);

    }

}


class Console{



    int width;
    int height;
    private List<Viewport>viewports = new ArrayList<Viewport>();

    public Console(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public static Console newConsole(int width,int height){
        Buffer buffer = new Buffer(width,height);
        Viewport viewport = new Viewport(buffer, width, height, 0, 0);
        Console console = new Console(width, height);
        console.addViewPort(viewport);
        console.render();
        return console;

    }

    public void addViewPort(Viewport viewport){
    viewports.add(viewport);

    }

    public void render(){

        for(int y =0;y<height;y++){

            for(int x =0 ;x<width;x++){

                for(Viewport vp :viewports){

                    System.out.println(vp.charAt(x,y));
                }
                System.out.println();

            }
        }
    }




}