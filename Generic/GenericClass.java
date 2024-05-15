public class GenericClass<T>{
    private T genericData;

    public GenericClass(T genericData){
        this.genericData = genericData;
    }
    
    public T getGenericData(){
        return this.genericData;
    }
    
    public void setGenericData(T genericData){
        this.genericData = genericData;
    }
}