class InterfaceTest{

    interface Cloneable{
        void myClone();
    }
    
    interface Enumeration{}

    class BitSet implements Cloneable{
        public void myClone(){
            System.out.println("BitSet print myClone");
        }
    }

    class Dictionary{}

    class HashTable extends Dictionary implements Cloneable{
        public void myClone(){
            System.out.println("HashTable print myClone");
        }
    }

    class Properties extends HashTable{}


}

