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
    static int mainC;

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Se inicia el método principal, donde solo se llaman otros métodos y el fichero ////////////////////////////////
    public static void main(String[] args) {
        
	// Se establece el primer objeto llamado "doc", el cual indica el path del fichero a leer //////////////// 
        File doc = new File("/Users/titaniummac3/CursoJava/CL/CL.java");
        
        // Se llama al método que cuenta el numero de palabras y lineas del doc seleccionado /////////////////////
        cLineasPalabras(doc);
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // Método contador de lineas y palabras //////////////////////////////////////////////////////////////////////////
    public static void cLineasPalabras(File doc) {

            // Se inician en 0 las variables /////////////////////////////////////////////////////////////////////////
            palT = 0;
            linT = 0;
	    mainC = 0;
                
        try {	
            // Si el path del fichero es correcta y se encuentra el fichero se procede a contar //////////////////////////
            // El metodo ".exists()" da una respuesta booleana (falso o verdadero) sobre la existencia de un fichero /////
		if(doc.exists()) {

                // Con "BufferedReader" se carga el texto del fichero al que previamente se ingreso la ruta /////////////
		// Con "FileReader" se lee el texto obtenido con "BufferedReader" ///////////////////////////////////////
                BufferedReader docLeer = new BufferedReader(new FileReader(doc));
                
                String lineaActual;
                
		// "lineaActual" lee la línea actual y doc.Leer.readLine () devuelve una cadena. ////////////////////////
		// Por lo tanto, el ciclo se repetirá hasta que no sea nulo. ////////////////////////////////////////////
                while((lineaActual = docLeer.readLine()) != null) {
                    //Descomentar para mostrar el código leído al ejecutar *********************************************
                    //System.out.println(lineaActual);
                    
                    // La clase "StringTokenizer" permite separar los *Tokens* (componentes de un string), /////////////
		    // por lo cual, se emplea para contar las palabras 
                    StringTokenizer st = new StringTokenizer(lineaActual);
			
		// Se agrega una condicional en donde se ignoren los comentarios y los import para hacer el conteo ////////
                    StringTokenizer letras = new StringTokenizer(lineaActual); 
		if((letras.countTokens() != 0) && (lineaActual.indexOf("/*") == -1) && (lineaActual.indexOf("//") == -1) && (lineaActual.indexOf("*") == -1) && 
		    (lineaActual.indexOf("import") == -1)){


			if ((lineaActual.indexOf("main")!= -1) && (lineaActual.indexOf("if") == -1) && (lineaActual.indexOf("Main") == -1) && (lineaActual.indexOf("mainC") == -1)){

		    	// Se suman los main
			mainC = mainC + 1;

		    	}

                    // Se suman las lineas
                    linT = linT + 1;
		    // Se suman los tokens (palabras)
                    palT = palT + st.countTokens();
		    
		    }
                }
		// Se muestran los resultados del contador
		System.out.println("Main contados: " + mainC);
                System.out.println("Palabras contadas: " + palT);
                System.out.println("Lineas contadas: " + linT);
                // Cierra el "BufferedReader" para liberar la memoria ///////////////////////////////////////////////////
                docLeer.close();
            } 	
		// Se crea la condición especifica en la que el fichero no existe; ///////////////////////////////////////
		// es decir, el path ingresada en la variable "file" no se pudo encontrar ////////////////////////////////
		else if (!doc.exists()){
                System.out.println("No se encuentra el fichero, ingresar de nuevo el path");
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}