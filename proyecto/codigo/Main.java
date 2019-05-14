/**
 * This class performs the main operations of the process
 * @author (Anthony García, Daniel Hincapié)
/**
 * This class performs the main operations of the process
 * @author (Anthony García, Daniel Hincapié)
 */

import java.util.LinkedList;
import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.Runtime;
import java.lang.Math;
import java.lang.Long;

class Main {

    public static Point3D max,min;

    public static void main(String[] args) {
        resources(1500000);
    }

    private static void resources(int beesNumber){
      long minReadTime=Long.MAX_VALUE;
      long maxReadTime=Long.MIN_VALUE;
      long minInsertTime=Long.MAX_VALUE;
      long maxInsertTime=Long.MIN_VALUE;
      long minDetectTime=Long.MAX_VALUE;
      long maxDetectTime=Long.MIN_VALUE;
      long minWriteTime=Long.MAX_VALUE;
      long maxWriteTime=Long.MIN_VALUE;
      long minMemory=Long.MAX_VALUE;
      long maxMemory=Long.MIN_VALUE;;
      long readTimeSum=0;
      long insertTimeSum=0;
      long detectTimeSum=0;
      long writeTimeSum=0;
      long memorySum=0;
      for(int i=0;i<10;i++){
        System.gc();
        long begin= System.currentTimeMillis();
        LinkedList<Point3D> bees=read(beesNumber);
        long end= System.currentTimeMillis();
        long readTime=end-begin;
        readTimeSum+=readTime;
        minReadTime=Math.min(minReadTime,readTime);
        maxReadTime=Math.max(maxReadTime,readTime);

        begin= System.currentTimeMillis();
        Node root=new Node(max,min);
        Octree tree= new Octree(root);
        tree.root=tree.aux();
        for(Point3D bee: bees){
            tree.insert(bee);
        }
        end= System.currentTimeMillis();
        long insertTime=end-begin;
        insertTimeSum+=insertTime;
        minInsertTime=Math.min(minInsertTime,insertTime);
        maxInsertTime=Math.max(maxInsertTime,insertTime);

        begin= System.currentTimeMillis();
        LinkedList<LinkedList<Point3D>> list=tree.returning();
        end= System.currentTimeMillis();
        long detectTime=end-begin;
        detectTimeSum+=detectTime;
        minDetectTime=Math.min(minDetectTime,detectTime);
        maxDetectTime=Math.max(maxDetectTime,detectTime);

        begin= System.currentTimeMillis();
        write(list,beesNumber);
        end= System.currentTimeMillis();
        long writeTime=end-begin;
        writeTimeSum+=writeTime;
        minWriteTime=Math.min(minWriteTime,writeTime);
        maxWriteTime=Math.max(maxWriteTime,writeTime);
        Runtime m=Runtime.getRuntime();
        long usedMemory=(m.totalMemory()-m.freeMemory());
        memorySum+=usedMemory;
        minMemory=Math.min(minMemory,usedMemory);
        maxMemory=Math.max(maxMemory,usedMemory);
      }
      long averageReadTime= readTimeSum/10;
      long averageInsertTime= insertTimeSum/10;
      long averageDetectTime= detectTimeSum/10;
      long averageWriteTime= writeTimeSum/10;
      long averageMemory= memorySum/10;

      System.out.println("Read min time: "+minReadTime+" ms");
      System.out.println("Read max time: "+maxReadTime+" ms");
      System.out.println("Read average time: "+averageReadTime+" ms");
      System.out.println("Insert min time: "+minInsertTime+" ms");
      System.out.println("Insert max time: "+maxInsertTime+" ms");
      System.out.println("Insert average time: "+averageInsertTime+" ms");
      System.out.println("Detect min time: "+minDetectTime+" ms");
      System.out.println("Detect max time: "+maxDetectTime+" ms");
      System.out.println("Detect average time: "+averageDetectTime+" ms");
      System.out.println("Write min time: "+minWriteTime+" ms");
      System.out.println("Write max time: "+maxWriteTime+" ms");
      System.out.println("Write average time: "+averageWriteTime+" ms");
      System.out.println("Min memory use: "+minMemory+" bytes");
      System.out.println("Max memory use: "+maxMemory+" bytes");
      System.out.println("Average memory use: "+averageMemory+" bytes");
    }

    /**
     * This method read the file and create a LinkedList with the bees
     * @param String fileName
     * @return LinkedList<Bee> bees
     */
    public static LinkedList<Point3D> read(int beesNumber){
        final String fileName="ConjuntoDeDatosCon"+beesNumber+"abejas.txt";
        LinkedList<Point3D> bees = new LinkedList<Point3D>();
        double maxX, maxY, maxZ, minX, minY, minZ;
        try{
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line = br.readLine();
            line = br.readLine();
            String[] str = line.split(",");
            double x= Double.parseDouble(str[0]);
            double y= Double.parseDouble(str[1]);
            double z= Double.parseDouble(str[2]); 
            maxX=minX=x;
            maxY=minY=y;
            maxZ=minZ=z;
            Point3D bee= new Point3D(x,y,z);
            bees.add(bee);
            line=br.readLine();
            while(line!=null){
                str = line.split(",");
                x= Double.parseDouble(str[0]);
                y= Double.parseDouble(str[1]);
                z= Double.parseDouble(str[2]); 
                bee= new Point3D(x,y,z);
                bees.add(bee);
                if(x>maxX) maxX=x;
                if(y>maxY) maxY=y;
                if(z>maxZ) maxZ=z;
                if(x<minX) minX=x;
                if(y<minY) minY=y;
                if(z<minZ) minZ=z;
                line=br.readLine();
            }
            max=new Point3D(maxX,maxY,maxZ);
            min=new Point3D(minX,minY,minZ);
            br.close();
        } catch(IOException ioe){
            System.out.println("The file does not exist");
        }
        return bees;
    }

    public static void write(LinkedList<LinkedList<Point3D>> collisionsList, int beesNumber){
        final String fileName= "CollisionsIn"+beesNumber+"BeesDataset.txt";
        try{
            BufferedWriter wr = new BufferedWriter(new FileWriter(fileName));
            if (collisionsList.size()==0||collisionsList==null){
                wr.write("All the bees are safe");
            }else{
                wr.write("The bees with coordinates:"); wr.newLine();
                for(LinkedList<Point3D> list : collisionsList){
                    for(Point3D bee: list){
                        wr.write(bee.getX()+","+bee.getY()+","+bee.getZ());wr.newLine();
                    }
                }
                wr.write("Are in danger to collision");
            }
            wr.close();
        }catch(IOException ioe){
            System.out.println("The file could not be wrote");
        }
    }
}
