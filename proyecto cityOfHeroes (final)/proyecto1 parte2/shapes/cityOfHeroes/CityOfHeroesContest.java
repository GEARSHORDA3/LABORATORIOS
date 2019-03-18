package cityOfHeroes;
import shapes.*;
import java.util.*;

public class CityOfHeroesContest{

    // Acceleration of gravity.
    final private static double gravedad = 9.80665;

    private static int anchoCiudad,alturaCiudad,anchoEdificios,velocidad;
    private static int[][] matriz;
    public int posY;
    public int posX;
    private String[][] res2;
    public CityOfHeroesContest(){
    }

    public String[][] solve(int[] configuration, int[][]building){
        return lectura(configuration,building);
    }
    
    public String[][] lectura(int[] configuration, int[][]building){
        alturaCiudad = configuration[0];
        anchoCiudad = configuration[1];
        anchoEdificios = configuration[2];
        velocidad = configuration[3];
        int posY = configuration[4]-1;
        int posX = configuration[5]-1;
        matriz = new int[anchoCiudad][alturaCiudad];        
        for (int i=0;i<configuration[1];i++){
            for (int j=0;j<configuration[0];j++){
                matriz[i][j]=building[i][j];
            }
        }
        return imprimeMatriz(posX,posY);
    }    
    
    public String[][] b(){
        for (int j=0; j<anchoCiudad; j++) {
            for (int i=0; i<alturaCiudad; i++) {
            }
        }        
        return res2;
    }
    
    public String[][] imprimeMatriz(int posX, int posY){
        int[][] res;
        res2 = new String[anchoCiudad][alturaCiudad];
        res = bfs(posX, posY);
        for (int i=0; i<anchoCiudad;i++){
            for (int j=0;j<alturaCiudad;j++){
                if (res[i][j]<0){
                    res2[i][j]="X";
                }
                else{
                    String str= Integer.toString(res[i][j]);
                    res2[i][j]=str;
                }
            }
        }        
        return b();
    }

    public static int[][] bfs(int posX, int posY) {

        // Store shortest distances here.
        int[][] matrizAdyacente = new int[anchoCiudad][alturaCiudad];
        for (int i=0; i<anchoCiudad; i++) {
            for (int j = 0; j < alturaCiudad; j++){
                matrizAdyacente[i][j] = -9999;
            }}
        matrizAdyacente[posX][posY] = 0;

        // Set up queue for BFS.
        LinkedList<Integer> q = new LinkedList<Integer>();
        q.offer(posX*alturaCiudad+posY);

        // Run BFS.
        while (q.size() > 0) {

            // Get next entry.
            int cur = q.poll();
            int cx = cur/alturaCiudad;
            int cy = cur%alturaCiudad;

            // Try jumping to all possible places.
            for (int i=0; i<anchoCiudad; i++) {
                for (int j=0; j<alturaCiudad; j++) {

                    // We've been here before.
                    if (matrizAdyacente[i][j] != -9999) continue;

                    // See if we can get there.
                    if (isSafeJump(cx, cy, i, j)) {
                        matrizAdyacente[i][j] = matrizAdyacente[cx][cy] + 1;
                        q.offer(i*alturaCiudad+j);
                    }
                }
            }
        }
        return matrizAdyacente;
    }

    public static boolean isSafeJump(int posX, int posY, int ex, int ey) {

        double distX = Math.sqrt((posX-ex)*(posX-ex)+(posY-ey)*(posY-ey))*anchoEdificios;
        double delta = matriz[ex][ey] - matriz[posX][posY];
        double maxAngle = Math.atan((Math.pow(velocidad,2))/(gravedad*distX));
        double factor = delta/distX;
        if (Math.tan(maxAngle) - (gravedad*distX)/(2*velocidad*velocidad*Math.cos(maxAngle)*Math.cos(maxAngle)) < factor) {
            return false;
        }
        double low = maxAngle, high = Math.PI/2;
        for (int i=0; i<100; i++) {
            double mid = (low+high)/2;
            double rhs = Math.tan(mid) - (gravedad*distX)/(2*velocidad*velocidad*Math.cos(mid)*Math.cos(mid));
            if (rhs > factor)
                low = mid;
            else
                high = mid;
        }
        double theta = low;
        int dx = ex - posX;
        int dy = ey - posY;
        if (dx != 0) {
            int stepx = dx/Math.abs(dx);
            int x = posX + stepx;
            double y = posY +.5 + (ey-posY)/(2.0*Math.abs(dx));
            for (int i=0; i<Math.abs(dx); i++) {
                int thiposY = (int)(y+ Math.pow(10,-9));
                int mustReach = matriz[x][thiposY];
                mustReach = Math.max(mustReach, matriz[x-stepx][thiposY]);
                if (y - thiposY < Math.pow(10,-8)) {
                    mustReach = Math.max(mustReach, matriz[x][thiposY-1]);
                    mustReach = Math.max(mustReach, matriz[x-stepx][thiposY-1]);
                }
                double hmove = anchoEdificios*Math.sqrt( (i+ 0.5)*(i+ 0.5) + (y-posY- 0.5)*(y-posY- 0.5) );
                double t = hmove/(velocidad*Math.cos(theta));
                double myh = velocidad*Math.sin(theta)*t - 0.5*gravedad*t*t;

                if (myh < mustReach-matriz[posX][posY] + Math.pow(10,-10))
                    return false;
                x += stepx;
                y += (ey-posY)/(1.0*Math.abs(dx));
            }
        }

        if (dy != 0) {

            int stepy = dy/Math.abs(dy);
            int y = posY + stepy;
            double x = posX +.5 + (ex-posX)/(2.0*Math.abs(dy));

            for (int i=0; i<Math.abs(dy); i++) {

                int thiposX = (int)(x+ Math.pow(10,-9));
                int mustReach = matriz[thiposX][y];
                mustReach = Math.max(mustReach, matriz[thiposX][y-stepy]);
                if (x - thiposX < Math.pow(10,-8)) {
                    mustReach = Math.max(mustReach, matriz[thiposX-1][y]);
                    mustReach = Math.max(mustReach, matriz[thiposX-1][y-stepy]);
                }
                double hmove = anchoEdificios*Math.sqrt( (i+ 0.5)*(i+ 0.5) + (x-posX- 0.5)*(x-posX- 0.5) );
                double t = hmove/(velocidad*Math.cos(theta));
                double myh = velocidad*Math.sin(theta)*t - 0.5*gravedad*t*t;
                if (myh < mustReach-matriz[posX][posY] + Math.pow(10,-10))
                    return false;
                x += (ex-posX)/(1.0*Math.abs(dy));
                y += stepy;
            }
        }
        return true;
    }
    
    /**
     * Simula el la ciudad si es posible
     * @param buildings
     * @param configuration
     * @param building
     * @return boolean 
     */
    public boolean  simulate(int[] configuration, int[][] buildings, int building)
    {
        if (configuration[1]==1){
            CityOfHeroes ch = new CityOfHeroes(800,600);
            int var=0;
            ch.makeVisible();
            for (int i=0; i<configuration[1];i++){
                for (int j=0; j<configuration[0];j++){
                    ch.addBuilding(var,configuration[2],buildings[0][j],10);
                    var+=configuration[2]+1;
                }
            } 
            
            ch.addHeroe("blue",configuration[5],1);
            String[][] rta = new String[configuration[1]][configuration[0]];
            rta=lectura(configuration,buildings);
            if(rta[0][building-1]=="X"){
                return false;
            } 
            int[] list = new int[100];
            list=ch.jumpPlan("blue",Integer.parseInt(rta[0][building-1]));
            ch.jump("blue",list[0],list[1],false/*,Integer.parseInt(rta[0][building-1])*/);
            ch.makeVisible();
            return true;
        }
        return false;
    }      
    
}