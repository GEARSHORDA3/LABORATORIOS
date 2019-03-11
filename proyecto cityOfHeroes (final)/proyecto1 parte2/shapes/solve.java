 

import java.util.*;

public class solve {

    // Acceleration of gravity.
    final private static double gravedad = 9.80665;

    private static int anchoCiudad,alturaCiudad,anchoEdificios,velocidad;
    private static int[][] matriz;
    private int posY;
    private int posX;
    public solve(int[] configuration, int[][]building){
        alturaCiudad = configuration[0];
        anchoCiudad = configuration[1];
        anchoEdificios = configuration[2];
        velocidad = configuration[3];
        int posY = configuration[4]-1;
        int posX = configuration[5]-1;
        matriz = new int[anchoCiudad][alturaCiudad];        
        // // matriz= building;
        for (int i=0;i<configuration[1];i++){
            for (int j=0;j<configuration[0];j++){
                matriz[i][j]=building[i][j];
            }
        }
        b();
    }
    public int[][] b(){
        int [][] rta= new int[anchoCiudad][alturaCiudad];
        rta=bfs(posX,posY);
        return rta;
    }
 
    private static int[][] bfs(int posX, int posY) {

        int[][] matrizAdyacente = new int[anchoCiudad][alturaCiudad];
        for (int i=0; i<anchoCiudad; i++) {
            for (int j = 0; j < alturaCiudad; j++){
                matrizAdyacente[i][j] = 0;
            }}
        int[][] matrizVistados = new int[anchoCiudad][alturaCiudad];
        for (int i=0; i<anchoCiudad; i++) {
            for (int j = 0; j < alturaCiudad; j++){
                matrizVistados[i][j] = 9999;
            }}
        // 9999 es no visitado, -9999 es visitado
        matrizVistados[posX][posY] = -9999;
        // Hace los saltos desde posX posY dadas por el usuario
        for (int i=posX; i<anchoCiudad; i++) {
            for (int j=posY; j<alturaCiudad; j++) {
                for (int k=0; k<anchoCiudad;k++){
                    for (int l=0;l<alturaCiudad;l++){
                        if (i==j && j==i && k==i && l==k) continue;
                        if (getJump(i,j,k,l) && matrizVistados[k][l]==9999) {
                            matrizAdyacente[k][l] = matrizAdyacente[i][j] + 1;
                        }
                        matrizVistados[k][l]=-9999;
                    }
                }}}


        return matrizAdyacente;
    }

    private static boolean getJump(int posX, int posY, int ex, int ey) {

        // Horizontal distance of jump.
        double distX = Math.sqrt((posX-ex)*(posX-ex)+(posY-ey)*(posY-ey))*anchoEdificios;

        // Vertical distance of jump.
        double delta = matriz[ex][ey] - matriz[posX][posY];
        if (Math.pow(velocidad,2)*Math.pow(Math.sin(90),2)/(2*gravedad)<matriz[ex][ey]){return false;}
        // If you jump at this angle, you'll maximize your height at distance dist.
        double maxAngle = Math.atan((Math.pow(velocidad,2))/(gravedad*distX));

        // This is the LHS. The RHS - tanA - aD/(2v^2cos^2A).
        double factor = delta/distX;

        // The max jump doesn't get there.
        if (Math.tan(maxAngle) - (gravedad*distX)/(2*velocidad*velocidad*Math.cos(maxAngle)*Math.cos(maxAngle)) < factor) {
            return false;
        }

        // Run a binary search to find the jumping angle.
        double low = maxAngle, high = Math.PI/2;
        for (int i=0; i<100; i++) {
            // Try halfway in between.
            double mid = (low+high)/2;
            double rhs = Math.tan(mid) - (gravedad*distX)/(2*velocidad*velocidad*Math.cos(mid)*Math.cos(mid));
            // Adjust low or high.
            if (rhs > factor)
                low = mid;
            else
                high = mid;
        }
        // Assign my jumping angle.
        double theta = low;
        // Here is our overall change.
        int dx = ex - posX;
        int dy = ey - posY;
        // Avoid div by 0.
        if (dx != 0) {
            // Check issues or running into "horizontal cuts" (along the dx change.)
            int stepx = dx/Math.abs(dx);
            int x = posX + stepx;
            double y = posY +.5 + (ey-posY)/(2.0*Math.abs(dx));
            for (int i=0; i<Math.abs(dx); i++) {

                int thiposY = (int)(y+ Math.pow(10,-9));

                // We must reach at least this high, don't forget to look at BOTH buildings!!!
                int mustReach = matriz[x][thiposY];
                mustReach = Math.max(mustReach, matriz[x-stepx][thiposY]);

                // And if this is a borderline case, we must also reach this high.
                if (y - thiposY < Math.pow(10,-8)) {
                    mustReach = Math.max(mustReach, matriz[x][thiposY-1]);
                    mustReach = Math.max(mustReach, matriz[x-stepx][thiposY-1]);
                }

                // Calculate our horizontal movement, and current relative vertical position.
                double hmove = anchoEdificios*Math.sqrt( (i+ 0.5)*(i+ 0.5) + (y-posY- 0.5)*(y-posY- 0.5) );
                double t = hmove/(velocidad*Math.cos(theta));
                double myh = velocidad*Math.sin(theta)*t - 0.5*gravedad*t*t;

                // Didn't make it high enough.
                if (myh < mustReach-matriz[posX][posY] + Math.pow(10,-10))
                    return false;

                // Go to the next one.
                x += stepx;
                y += (ey-posY)/(1.0*Math.abs(dx));
            }
        }

        if (dy != 0) {

            // Check issues or running into "horizontal cuts" (along the dx change.)
            int stepy = dy/Math.abs(dy);
            int y = posY + stepy;
            double x = posX +.5 + (ex-posX)/(2.0*Math.abs(dy));

            for (int i=0; i<Math.abs(dy); i++) {

                int thiposX = (int)(x+ Math.pow(10,-9));

                // We must reach at least this high, again look at both buildings.
                int mustReach = matriz[thiposX][y];
                mustReach = Math.max(mustReach, matriz[thiposX][y-stepy]);

                // And if this is a borderline case, we must also reach this high.
                if (x - thiposX < Math.pow(10,-8)) {
                    mustReach = Math.max(mustReach, matriz[thiposX-1][y]);
                    mustReach = Math.max(mustReach, matriz[thiposX-1][y-stepy]);
                }

                // Calculate our horizontal movement, and current relative vertical position.
                double hmove = anchoEdificios*Math.sqrt( (i+ 0.5)*(i+ 0.5) + (x-posX- 0.5)*(x-posX- 0.5) );
                double t = hmove/(velocidad*Math.cos(theta));
                double myh = velocidad*Math.sin(theta)*t - 0.5*gravedad*t*t;

                // Didn't make it high enough.
                if (myh < mustReach-matriz[posX][posY] + Math.pow(10,-10))
                    return false;

                // Go to the next one.
                x += (ex-posX)/(1.0*Math.abs(dy));
                y += stepy;
            }
        }

        // If we make it here, we are good.
        return true;
    }
}