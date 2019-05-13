/**
 *
 * @author (Anthony García, Daniel Hincapié)
 */

import java.util.LinkedList;
import java.lang.Math;

public class Octree{
    Node root;
    double maxSide;

    int data;
    LinkedList<LinkedList<Point3D>> collisionsList;

    public Octree(Node root){
        this.root=root;
    }

    public Node aux(){

        Point3D maxSize=new Point3D(111120*root.max.getX(),111120*root.max.getY(), root.max.getZ());
        Point3D minSize=new Point3D(111120*root.min.getX(), 111120*root.min.getY(), root.min.getZ());
        Point3D space= new Point3D(Math.abs(maxSize.getX()-minSize.getX()),Math.abs(maxSize.getY()-minSize.getY()),Math.abs(maxSize.getZ()-minSize.getZ()));

        maxSide=Math.max(Math.max(space.getX(),space.getY()),space.getZ());

        Point3D maxCoord= new Point3D(maxSize.getX(),maxSize.getY(),maxSize.getZ());
        Point3D minCoord= new Point3D(maxSize.getX()-maxSide,maxSize.getY()-maxSide,maxSize.getZ()-maxSide);
        root=new Node(maxCoord,minCoord);
        return root;
    }

    public void insert(Point3D bee){
        insertAux(root,bee,maxSide);
    }

    private void insertAux(Node root, Point3D bee, double maxS){
        Point3D metersBee= new Point3D(111120*bee.getX(),111120*bee.getY(),bee.getZ());
        double mbx=metersBee.getX();
        double mby=metersBee.getY();
        double mbz=metersBee.getZ();
        double rmX=root.max.getX();
        double rmY=root.max.getY();
        double rmZ=root.max.getZ();
        double rmx=root.min.getX();
        double rmy=root.min.getY();
        double rmz=root.min.getZ();
        double h= Math.sqrt(Math.pow(rmX-rmx,2)+Math.pow(rmY-rmy,2)+Math.pow(rmZ-rmz,2));
        if(h<=100){
            root.bees.add(bee);
        } else {
            Point3D max,min;
            //First child
            if((mbx<=rmX)&&
            (mby<=rmY)&&
            (mbz<=rmZ)&&
            (mbx>=rmx+(maxS/2))&&
            (mby>=rmy+(maxS/2))&&
            (mbz>=rmz+(maxS/2))){
                if(root.children[0]==null) {
                    max = new Point3D(rmX, rmY, rmZ);
                    min = new Point3D(rmx+(maxS/2), rmy+(maxS/2), rmz+(maxS/2));
                    Node space = new Node(max, min);
                    root.children[0] = space;
                    insertAux(space, bee, maxS/2);
                }else{
                    insertAux(root.children[0], bee, maxS/2);
                }
            }
            //Second child
            else if((mbx<=rmX-(maxS/2))&&
            (mby<=rmY)&&
            (mbz<=rmZ)&&
            (mbx>=rmx)&&
            (mby>=rmy+(maxS/2))&&
            (mbz>=rmz+(maxS/2))){
                if(root.children[1]==null) {
                    max = new Point3D(rmX-(maxS/2), rmY, rmZ);
                    min = new Point3D(rmx, rmy+(maxS/2), rmz+(maxS/2));
                    Node space = new Node(max, min);
                    root.children[1] = space;
                    insertAux(space, bee, maxS/2);
                }else{
                    insertAux(root.children[1], bee, maxS/2);
                }
            }
            //Third child
            else if((mbx<=rmX-(maxS/2))&&
            (mby<=rmY)&&
            (mbz<=rmZ-(maxS/2))&&
            (mbx>=rmx)&&
            (mby>=rmy+(maxS/2))&&
            (mbz>=rmz)){
                if(root.children[2]==null) {
                    max = new Point3D(rmX-(maxS/2), rmY, rmZ-(maxS/2));
                    min = new Point3D(rmx, rmy+(maxS/2), rmz);
                    Node space = new Node(max, min);
                    root.children[2] = space;
                    insertAux(space, bee, maxS/2);
                }else{
                    insertAux(root.children[2], bee, maxS/2);
                }
            }
            //Fourth child
            else if((mbx<=rmX)&&
            (mby<=rmY)&&
            (mbz<=rmZ-(maxS/2))&&
            (mbx>=(rmx+(maxS/2)))&&
            (mby>=(rmy+(maxS/2)))&&
            (mbz>=(rmz))){
                if(root.children[3]==null) {
                    max = new Point3D(rmX, rmY, rmZ-(maxS/2));
                    min = new Point3D(rmx+(maxS/2), rmy+(maxS/2), rmz);
                    Node space = new Node(max, min);
                    root.children[3] = space;
                    insertAux(space, bee, maxS/2);
                }else{
                    insertAux(root.children[3], bee, maxS/2);
                }
            }
            //Fifth child
            else if((mbx<=rmX)&&
            (mby<=rmY-(maxS/2))&&
            (mbz<=rmZ)&&
            (mbx>=rmx+(maxS/2))&&
            (mby>=rmy)&&
            (mbz>=rmz+(maxS/2))){
                if(root.children[4]==null) {
                    max = new Point3D(rmX, rmY-(maxS/2), rmZ);
                    min = new Point3D(rmx+(maxS/2), rmy, rmz+(maxS/2));
                    Node space = new Node(max, min);
                    root.children[4] = space;
                    insertAux(space, bee, maxS/2);
                }else{
                    insertAux(root.children[4], bee, maxS/2);
                }
            }
            //Sixth child
            else if((mbx<=rmX-(maxS/2))&&
            (mby<=rmY-(maxS/2))&& 
            (mbz<=rmZ)&&
            (mbx>=rmx)&&
            (mby>=rmy)&&
            (mbz>=rmz+(maxS/2))){
                if(root.children[5]==null) {
                    max = new Point3D(rmX-(maxS/2), rmY-(maxS/2), rmZ);
                    min = new Point3D(rmx, rmy, rmz+(maxS/2));
                    Node space = new Node(max, min);
                    root.children[5] = space;
                    insertAux(space, bee, maxS/2);
                }else{
                    insertAux(root.children[5], bee, maxS/2);
                }
            }
            //Seventh child
            else if((mbx<=rmX-(maxS/2)
            )&&(mby<=rmY-(maxS/2))&&
            (mbz<=rmZ-(maxS/2))&&
            (mbx>=rmx)&&
            (mby>=rmy)&&
            (mbz>=rmz)){
                if(root.children[6]==null) {
                    max = new Point3D(rmX-(maxS/2), rmY-(maxS/2), rmZ-(maxS/2));
                    min = new Point3D(rmx, rmy, rmz);
                    Node space = new Node(max, min);
                    root.children[6] = space;
                    insertAux(space, bee, maxS/2);
                }else{
                    insertAux(root.children[6], bee, maxS/2);
                }
            }
            //Eighth child
            else if((mbx<=rmX)&&
            (mby<=rmY-(maxS/2))&&
            (mbz<=rmZ-(maxS/2))&&
            (mbx>=rmx+(maxS/2))&&
            (mby>=rmy)&&
            (mbz>=rmz)){
                if(root.children[7]==null) {
                    max = new Point3D(rmX, rmY-(maxS/2), rmZ-(maxS/2));
                    min = new Point3D(rmx+(maxS/2), rmy, rmz);
                    Node space = new Node(max, min);
                    root.children[7] = space;
                    insertAux(space, bee, maxS/2);
                }else{
                    insertAux(root.children[7], bee, maxS/2);
                }
            }
        }
    }

    public LinkedList<LinkedList<Point3D>> returning() {
        collisionsList = new LinkedList<LinkedList<Point3D>>();
        returningAux(root);
        return collisionsList;
    }

    private void returningAux(Node root) {

        if(root.bees==null || root.bees.size()==0) {
            for(int i = 0; i < 8; i++) {
                if(root.children[i]!=null) {
                    returningAux(root.children[i]);
                }
            }
        } else if(root.bees.size()>1) {
            collisionsList.add(root.bees);
        }
    } 
}