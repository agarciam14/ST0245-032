/**
 * This class creates Node type objects
 * @author (Anthony García, Daniel HincapiéA)
 */

import java.util.LinkedList;

public class Node{
  LinkedList<Point3D> bees;
  Point3D max;
  Point3D min;
  Node[] children;
  Node father;

  /**
  * This method build a Node 
  * @param Point3D max
  * @param Point3D min
  * @return a new Node
  */
  public Node(Point3D max, Point3D min){
    this.max=max;
    this.min=min;
    children=new Node[8];
    bees= new LinkedList<Point3D>();
  }
}