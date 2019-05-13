/**
 * This class performs the main operations of the process
 * @author (Anthony García, Daniel Hincapié)
/**
 * This class performs the main operations of the process
 * @author (Anthony García, Daniel Hincapié)
 */

import java.util.LinkedList;
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
        int beesNumber= 150;
        LinkedList<Point3D> bees=read(beesNumber);
        Node root=new Node(max,min);
        Octree tree= new Octree(root);
        tree.root=tree.aux();
        for(Point3D bee: bees){
            tree.insert(bee);
        }
        write(tree.returning(),beesNumber);
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