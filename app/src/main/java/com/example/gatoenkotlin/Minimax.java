package com.example.gatoenkotlin;

public class Minimax {
    private int[] pos;
    private int nganador=-1;
    private int compuClick=0;

    public void reiniciar(){
        nganador=-1;
        compuClick=0;
        for(int i=0;i<pos.length;i++){
            pos[i]=-1;
        }

    }
    public Minimax(){
        pos=new int[9];
        for(int x=0;x<pos.length;x++) pos[x]=-1;
    }//llave constructor
    public int[] getTablero(){ return this.pos;}
    public int getGanador(){
        if( this.pos[0]!=-1 && pos[4]==pos[0] && pos[8]==pos[0])
            return pos[0];
        if(this.pos[2]!=-1 && pos[2]==pos[4] && pos[2]==pos[6])
            return  pos[2];
        //vertical 1
        if(this.pos[0]!=-1 && pos[0]==pos[3] && pos[0]==pos[6])
            return  pos[0];
        //vertical 2
        if(this.pos[1]!=-1 && pos[1]==pos[4] && pos[1]==pos[7])
            return  pos[1];
        //vertical 3
        if(this.pos[2]!=-1 && pos[2]==pos[5] && pos[2]==pos[8])
            return  pos[2];
        //horizontal 1
        if(this.pos[0]!=-1 && pos[0]==pos[1] && pos[0]==pos[2])
            return  pos[0];
        //horizontal 2
        if(this.pos[3]!=-1 && pos[3]==pos[4] && pos[3]==pos[5])
            return  pos[3];
        //horizontal 2
        if(this.pos[6]!=-1 && pos[6]==pos[7] && pos[6]==pos[8])
            return  pos[6];
        return -1;
    }
    public void pulsaBoton(int coor){
        if(this.nganador == -1){
            this.pos[coor]=0;//0 es para el usuario 1= COMPU
            ponerFichaOrdenador();
            nganador= getGanador();
            imprimirTablero();
        }
    }
    public void ponerFichaOrdenador(){
        if(!finPartida()){
            int f=0;
            int vMin=Integer.MIN_VALUE;
            int aux=0;
            for(int x=0;x<pos.length;x++){
                if(pos[x] == -1){
                    pos[x] = 1;
                    aux=vMin();//ERROR AQUI
                    if(aux> vMin){ //ERROR AQUI
                        vMin =aux;
                        f=x;
                    }
                    pos[x] =-1;
                }
            }
            pos[f]=1;
            compuClick=f;
            imprimirTablero();

        }//fin partida
    }
    public void  imprimirTablero(){
        for(int x=0;x<pos.length;x++)
            System.out.print(pos[x]+",");
        System.out.println("");
    }
    public int getNGanador(){ return this.nganador; }
    public int getUltimoBoton(){return this.compuClick; }
    public boolean tableroCompleto(){
        for(int x=0;x<pos.length;x++){
            if(pos[x] == -1){ return  false;}
        }
        return true;
    }
    public boolean finPartida(){
        return tableroCompleto() || getGanador() != -1;
    }
    public int vMax(){
        if(finPartida()){
            //ERROR AQUI
            if(getGanador()!=-1)
                return -1;
            else
                return 0;
        }
        int vmin =Integer.MIN_VALUE;
        int aux=0;
        for(int x=0;x<pos.length;x++){
            if(pos[x] == -1){
                pos[x] = 1;
                aux = this.vMin();
                if(aux > vmin){
                    vmin=aux;
                }
                pos[x]=-1;
            }
        }//llave for
        return vmin;
    }
    public int vMin(){
        if(finPartida()){
            if(getGanador() != -1)
                return  1;
            else
                return 0;
        }
        int vMin = Integer.MAX_VALUE;
        int aux=0;
        for(int x=0;x<pos.length;x++){
            if(pos[x] == -1){
                pos[x]=0;
                aux= vMax();
                if(aux < vMin){
                    vMin=aux;
                }
                pos[x]=-1;
            }
        }//llave for
        return vMin;
    }//llave v min

}
