package pers.tavish.jcip.ch8applyingthreadpools;

import java.util.Set;

// 程序清单8-13
public interface Puzzle<P, M> {
    P initialPosition();

    boolean isGoal(P position);

    Set<M> legalMoves(P position);

    P move(P position, M move);
}
