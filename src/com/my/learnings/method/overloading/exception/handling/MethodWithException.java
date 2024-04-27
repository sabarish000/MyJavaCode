package com.my.learnings.method.overloading.exception.handling;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLDataException;

// Java Program to Illustrate Exception Handling
// with Method Overriding
// Where SuperClass declares an exception and
// SubClass declares exceptions other than the child exception
// of the SuperClass declared Exception.
public class MethodWithException {

    public static void main(String[] args) throws IOException {
        ParentClass sp = new ChildClass();
        sp.method2();
        sp.method();
    }
}

    class ParentClass {

        // throws Checked Exception
        void method1() throws IOException {
            System.out.println("SuperClass method With Checked Exception");
        }

        // throws Checked Exception
        void method2() throws IOException {
            System.out.println("SuperClass method With Checked Exception");
        }

        // throws Checked Exception
        void method3() throws IOException {
            System.out.println("SuperClass method With Checked Exception");
        }

        // throws Checked Exception
        void method4() throws IOException {
            System.out.println("SuperClass method With Checked Exception");
        }

        // SuperClass declares an exception
        void method() throws NullPointerException {
            System.out.println("SuperClass");
        }
    }

    // SuperClass inherited by the SubClass
    class ChildClass extends ParentClass {
        // Same checked exception
        void method1()  {
            System.out.println("Sub Class method With out any Exception");
        }
        // No exception
        void method2() throws IOException {
            System.out.println("SubClass method With same Checked Exception");
        }
        // throws sub class of IOException
        void method3() throws FileNotFoundException {
            System.out.println("SuperClass method With Checked Exception");
        }

        // throws another Checked Exception
//        void method4() throws SQLDataException {
//            System.out.println("SuperClass method With Checked Exception");
//        }

        // SubClass declaring exception
        // which are not a child exception of RuntimeException
        // Exception is super class of RuntimeException
        // Hence throws Compile time error

        // The class Exception and its subclasses are a form of Throwable that indicates conditions that a reasonable application might want to catch.
        // The class Exception and any subclasses that are not also subclasses of RuntimeException are checked exceptions.
        // Checked exceptions need to be declared in a method or constructor's throws clause if they can be thrown by the execution of the method or constructor and propagate outside the method or constructor boundary.
//        void method() throws Exception {
//
//            // Exception is not a child exception of the RuntimeException
//            // So the compiler will give an error
//
//            System.out.println("SubClass");
//        }
    }

