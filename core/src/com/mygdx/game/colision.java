
package com.mygdx.game;

public interface colision {
    /**
     * Determina si el objeto colisiona con otro GameObject.
     *
     * @param obj El objeto GameObject con el cual verificar la colisión.
     * @return true si hay colisión, false en caso contrario.
     */
    boolean collidesWith(objectos obj);
}
