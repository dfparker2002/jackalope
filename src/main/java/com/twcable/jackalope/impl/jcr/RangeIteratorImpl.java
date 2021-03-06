/*
 * Copyright 2015 Time Warner Cable, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.twcable.jackalope.impl.jcr;

import javax.jcr.RangeIterator;
import java.util.Collection;
import java.util.Iterator;

/**
 * A simple implementation of RangeIterator that delegates to a single simple Iterator.
 *
 * @param <T> Type of elements in the Collection
 */
class RangeIteratorImpl<T> implements RangeIterator {
    final int size;
    final Iterator<T> iterator;
    int position = 0;


    /**
     * Construct a RangeIteratorImpl.
     *
     * @param source The collection to iterate over.
     */
    public RangeIteratorImpl(Collection<T> source) {
        this.size = source.size();
        this.iterator = source.iterator();
    }


    @Override
    public void skip(long skipNum) {
        while (skipNum-- > 0) next();
    }


    @Override
    public long getSize() {
        return size;
    }


    @Override
    public long getPosition() {
        return position;
    }


    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }


    @Override
    public Object next() {
        position++;
        return iterator.next();
    }


    @Override
    public void remove() {
        iterator.remove();
    }
}
