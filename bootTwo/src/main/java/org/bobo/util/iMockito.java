package org.bobo.util;

import java.util.List;

public interface iMockito<Q,R> {
    List<R> selectList(Q query);
}
