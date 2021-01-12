import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
//import java.util.StreamTokenizer;

public class CL {

    //Se declaran las dos variables principales "palT" (palabras totales) "linT" (lineas totales) //////////////////////
    //Estas se declaran fuera de los métodos para poder leerlas fuera de ///////////////////////////////////////////////
    static int palT;
    static int linT;

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Se inicia el método principal, donde solo se llaman otros métodos y el fichero ////////////////////////////////
    public static void main(String[] args) {
        
	// Se establece el primer objeto llamado "doc", el cual indica el path del fichero a leer //////////////// 
        File doc = new File("/Users/titaniummac3/CursoJava/CL/CL.java");
        
        // Se llama al método que cuenta el numero de palabras y lineas del doc seleccionado /////////////////////
        cLineasPalabras(doc);
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}