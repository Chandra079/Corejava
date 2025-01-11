package cheatSheet;

import java.io.Serializable;

public class SingletonClassExample implements Serializable,Cloneable {
    private static final long serialVersionUID = 1L; // Recommended for Serializable classes

    private static  SingletonClassExample instance;

    private SingletonClassExample(){

    }

    public static SingletonClassExample getInstance(){
        if(instance==null){
            return new SingletonClassExample();
        }
        return instance;
    }

    public SingletonClassExample doResolve(){
        return getInstance();
    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return getInstance();
    }
}
