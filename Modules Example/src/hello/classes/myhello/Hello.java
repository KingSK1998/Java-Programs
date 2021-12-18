/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myhello;

import demo.Demo;
import myWorld.World;
/**
 *
 * @author aaa
 */
public class Hello {

    public void print() {
        World w = new World();
        System.out.println("Hello, " + w.data + "!");
        
        Demo d = new Demo();
        System.out.println("Hello, " + d.data + "!");
    }
}
