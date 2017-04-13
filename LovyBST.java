package com.lovy.datastructure.binarytree;

import com.lovy.tools.EnglishWord;
import org.omg.CORBA.Any;

import java.awt.*;
import java.io.*;

/**
 * Created by asus on 2017/4/8.
 */
public class LovyBST<T extends Comparable<? super T>> extends LovyTree<T> {

    public LovyBST(){}
    public LovyBST(LovyNode<T> root){
        super(root);
    }
    private LovyNode<T> insert(LovyNode<T> root,LovyNode<T> newNode,boolean duplicated){
        if(root==null)
            return newNode;
        if(newNode==null)
            return root;

        int compareResult=root.val.compareTo(newNode.val);
        if(compareResult<0)
            root.right=insert(root.right,newNode,duplicated);
        else if(compareResult>0)
            root.left=insert(root.left,newNode,duplicated);
        else{
            if(duplicated)
                root.right=insert(root.right,newNode,duplicated);
            else
                ;
        }
        return root;
    }

    public void insert(LovyNode<T> newNode,boolean dupplicated){
        this.root=insert(this.root,newNode,dupplicated);
    }

    public void insert(LovyNode<T> newNode){
        this.root=insert(this.root,newNode,false);
    }


    public static <AnyType extends Comparable<? super AnyType>> LovyBST<AnyType> createLovyBST(AnyType... values){
        if(values==null||values.length==0)
            return null;
        LovyNode<AnyType> root=new LovyNode<AnyType>(values[0]);
        LovyBST<AnyType> lovyBST=new LovyBST(root);
        int k=1;
        while(k<values.length){
            lovyBST.insert(new LovyNode<AnyType>(values[k++]));
        }
        return lovyBST;
    }


    public LovyNode<T> remove(LovyNode<T> root,LovyNode<T> target){
        if(root==null||target==null)
            return null;

        int compareResult=root.val.compareTo(target.val);

        if(compareResult<0)
            root.right=remove(root.right,target);
        else if(compareResult>0)
            root.left=remove(root.left,target);
        else{
            if(root.left==null&&root.right==null)
                root=null;
            else if(root.left!=null){
                T leftSubTreeMaxVal=getRightest(root.left).val;
                root.val=leftSubTreeMaxVal;

                root.left=removeRightest(root.left);
            }else{
                T rightSubTreeMinVal=getLeftest(root.right).val;
                root.val=rightSubTreeMinVal;

                root.right=removeLestest(root.right);
            }
        }
        return root;
    }

    public LovyNode<T> remove(LovyNode<T> root,T target){
        return remove(root,new LovyNode<T>(target));
    }

    public void remove(LovyNode<T> target){
        this.root=remove(this.root,target);
    }

    public void remove(T target){
        this.root=remove(this.root,target);
    }

    public static void main(String[] args){
        LovyBST lovyBST=createLovyBST(1,4,3,6,21,8,5);
        lovyBST.print();
    }
}
