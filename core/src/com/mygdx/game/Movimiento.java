
package com.mygdx.game;

public interface Movimiento {
    /**
     * Determina si el objeto colisiona con otro GameObject.
     *
     * @param obj El objeto GameObject con el cual verificar la colisión.
     * @return true si hay colisión, false en caso contrario.
     */
    boolean collidesWith(ObjetosJuego obj);
}
