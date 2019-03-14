
package aplicacion;

import java.awt.Color;

public class Deportista extends Persona implements EnSalon{
    
    private Salon salon;   
    protected String palabras;
    public int paso;
    protected String nombre;
    public int var=0;
    public int algo;
    public Deportista(Salon salon,String nombre,int posicionx, int posiciony,int a){
        super(nombre,posicionx,posiciony);
        this.salon=salon;
        this.nombre = nombre;
        if (a==0){
           color=Color.BLACK;
           paso=0;}
        else{
           color=Color.ORANGE;
           paso=50;}
        palabras="Soy "+nombre;
        salon.adicione(this);
        
    }
    
    private boolean puedeMover(char direccion) {
        boolean puede=false;
        int posX = getPosicionX();
        int posY = getPosicionY();
        switch(direccion){
            case 'N' : puede = (posY+1 < salon.MAXIMO);
            break;
            case 'E' : puede = (posX+1 < salon.MAXIMO);
            break;
            case 'S' : puede = (posY-1 >= 0);
            break;
            case 'O': puede = (posX-1 >= 0);
            break; 
        } 
        return puede;
    }
    
    /**Retorna la palabra del deportista*/
    public String getPalabras(){
        return palabras;
    }
    
    public void pare(){
        muevaBrazo('I','B'); 
        muevaPierna('I','P');
        muevaBrazo('D','B'); 
        muevaPierna('D','P'); 
        
    }
    

    public void inicie(){
        palabras="Soy"+nombre;
        paso++;
        if (nombre=="han" || nombre=="leila"){
            if (PASO!=20){
            muevaBrazo('I','S'); 
            muevaBrazo('D','S');  
            if (var<3){
                muevaPierna('I','S');
                muevaPierna('D','S'); 
            }
            else{
                muevaPierna('I','B');
                muevaPierna('D','B');
                muevaPierna('I','B');
                muevaPierna('D','B');
                var=0;
            }
            var+=1;               
        }}
        else{
        for  (int i=0; i<3;i++){
        if (getPosicionBrazo('I')==ABAJO && getPosicionBrazo('D')==ABAJO){
            muevaBrazo('I','S'); 
            muevaPierna('I','S');
        } else if  (getPosicionBrazo('I')==FRENTE){
            muevaBrazo('I','S'); 
            muevaPierna('I','S');
        } else if (getPosicionBrazo('I')==ARRIBA){
            muevaBrazo('I','B'); 
            muevaPierna('I','B');
            muevaBrazo('I','B'); 
            muevaPierna('I','B');
            muevaBrazo('D','S'); 
            muevaPierna('D','S');
        }else if (getPosicionBrazo('D')==FRENTE){
            muevaBrazo('D','S'); 
            muevaPierna('D','S');
            muevaBrazo('D','S'); 
            muevaPierna('D','S');
            muevaBrazo('I','B'); 
            muevaPierna('I','B');
        }else if (getPosicionBrazo('D')==ARRIBA){
            muevaBrazo('D','B'); 
            muevaPierna('D','B');
            muevaBrazo('D','B'); 
            muevaPierna('D','B');
            muevaBrazo('I','S'); 
            muevaPierna('I','S');
        }            
        } 
        }
        char direccion=( (paso % 2 == 0)  ? 'E':'O');
        if (puedeMover(direccion)){
            muevase(direccion);
        }
    }
    
    
    public String forma(){
        return EnSalon.FORMAS[0];
    }
    
    public String mensaje(){
        return  palabras;
    }

}

