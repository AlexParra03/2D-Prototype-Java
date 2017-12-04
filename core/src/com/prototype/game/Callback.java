/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prototype.game;

public interface Callback {
    /**
     * function to execute
     * @param level reference to global level to access other instances
     */
    void action(Level level);
}
